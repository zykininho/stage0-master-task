package com.epam.loops;

public class Pyramid {

    public void printPyramid(int cathetusLength) {
        StringBuilder pyramid = new StringBuilder();
        for (int i = 1; i <= cathetusLength; i++) {
            for (int j = 1; j <= (cathetusLength - i); j++) {
                pyramid.append(" ");
            }
            for (int n = i; n > 0; n--) {
                pyramid.append(n);
            }
            for (int m = 2; m <= i; m++) {
                pyramid.append(m);
            }
            pyramid.append("\n");
        }
        System.out.print(pyramid);
    }

    public static void main(String[] args) {
        new Pyramid().printPyramid(7);
    }
}
