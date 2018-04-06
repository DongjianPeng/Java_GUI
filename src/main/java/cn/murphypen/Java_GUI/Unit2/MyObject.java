/*
 * Copyright (c) 2018. Murphy
 */

package cn.murphypen.Java_GUI.Unit2;

import javax.swing.*;
import java.util.StringTokenizer;

class MyFrame extends JFrame{

}
public class MyObject {
    private class Obj {
        public int a = 9;

        public void i(){

        }
    }
    public class Obj2 extends Obj{
        private  int a = 10;

        public  void print(){
            System.out.println(a);

        }
        public int i(int a){
    return 0;
        }
    }
    public static class A{

    }
    public static void main(String[] args) {
        MyObject my = new MyObject();
        my.print();

        StringTokenizer s = new StringTokenizer("absd rrbgw","b");
        System.out.println(s.countTokens());
        while(s.hasMoreTokens()){
            System.out.println(s.nextToken());
        }

    }
    public  void print(){
        Obj2 o = new Obj2();
        o.print();
    }
}
