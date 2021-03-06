package cn.murphypen.Java_GUI.Day01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author dongjianpeng
 *
 */
public class Script {

	public static void main(String[] args) {

		String command = "java -version";
		exec(command);
	}

	public static void exec(String command) {
		Process process = null;
		try {
			process = Runtime.getRuntime().exec(command);
			printInputStream(process.getInputStream(), false, "GBK");
			printInputStream(process.getErrorStream(), true, "GBK");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void printInputStream(InputStream is, boolean isError, String encoding) {
		InputStreamReader isr = null;
		BufferedReader br = null;
		try {
			isr = new InputStreamReader(is, encoding);
			br = new BufferedReader(isr);
			String line = null;
			StringBuilder sb = new StringBuilder();
			while ((line = br.readLine()) != null) {
				sb.append(line);
				sb.append("\n");
			}
			if (isError) {
				System.err.println("===========");
				System.err.println(sb);
				System.err.println("===========");
			} else {
				System.out.println("===========");
				System.out.println(sb);
				System.out.println("===========");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (isr != null) {
				try {
					isr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}
}
