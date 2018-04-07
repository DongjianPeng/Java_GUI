/*
 * Copyright (c) 2018. Murphy
 */

package cn.murphypen.Java_GUI.Unit10;

import java.io.*;
import java.net.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class MyServer extends Thread {
    ServerSocket ss = null;

    @Override
    public void run() {
        try {
            System.out.println("Server start");
            ss = new ServerSocket(4321);
            sleep(2000L);
            Socket socket = ss.accept();
            InputStreamReader isr = new InputStreamReader(socket.getInputStream(), "UTF-8");
            BufferedReader br = new BufferedReader(isr);
            while (br.ready()) {
                System.out.println(br.readLine());
            }
            br.close();
            isr.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

class MyClient extends Thread {
    @Override
    public synchronized void start() {

    }

    @Override
    public void run() {
        try {
            sleep(1000L);
            System.out.println("Client start");
            Socket socket = new Socket("localhost", 4321);
            OutputStreamWriter osw = new OutputStreamWriter(socket.getOutputStream());
            BufferedWriter bw = new BufferedWriter(osw);
            bw.write("Hello Server!");
            bw.flush();
            osw.flush();
            //socket.close();
            bw.close();
            osw.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class MyInetAddress {
    public static void main(String[] args) {
        //testMyInetAddress();
        //TestUrlConnection();
        ExecutorService es = Executors.newFixedThreadPool(2);
        es.submit(new MyServer());
        es.submit(new MyClient());
        es.shutdown();
    }

    public static void TestUrlConnection() {
        try {
            URL url = new URL("http://www.qq.com");
            URLConnection connection = url.openConnection();
            connection.connect();
            InputStream is = connection.getInputStream();
            InputStreamReader isr = new InputStreamReader(is, "GB2312");
            BufferedReader br = new BufferedReader(isr);
            while (br.ready()) {
                System.out.println(br.readLine());
            }
            br.close();
            isr.close();
            is.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void testMyInetAddress() {
        try {
            InetAddress ia = InetAddress.getByName("www.bing.com");
            System.out.println(ia.getHostName());
            System.out.println(ia.getHostAddress());

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
