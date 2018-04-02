/*
 * Copyright (c) 2018. Murphy
 */

package cn.murphypen.Java_GUI.Unit2;

import javax.swing.*;

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
    }
    public  void print(){
        Obj2 o = new Obj2();
        o.print();
    }
}
