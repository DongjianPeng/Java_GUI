/*
 * Copyright (c) 2018. Murphy
 */

package cn.murphypen.Java_GUI.Unit1;

import java.io.Serializable;

public class BasicOfJava implements Serializable {

    public static void main(String[] args) {
        int cock1 = 5;
        int biddy1 = 3;
        int poult3 = 1;
        for (int c1 = 0; c1 < 100 / cock1; c1++) {
            for (int b1 = 0; b1 < 100 / biddy1; b1++) {
                for (int p1 = 0; p1 < 100 / poult3; p1 += 3) {
                    int count = c1 + b1 + p1 * 3;
                    int sum = c1 * cock1 + b1 * biddy1 + (p1 / 3);
                    if (sum == 100 && count == 100) {
                        System.out.println("cock:" + c1 + " biddy:" + b1 + " poult:" + p1);
                    }
                }
            }
        }
    }
}
