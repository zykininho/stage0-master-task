package com.epam.loops;

public class HalfPyramid {

    public void printHalfPyramid(int cathetusLength) {
        StringBuilder pyramid = new StringBuilder();
        for (int i = 1; i <= cathetusLength; i++) {
            for (int j = 1; j <= (cathetusLength - i); j++) {
                pyramid.append(" ");
            }
            for (int n = i; n > 0; n--) {
                pyramid.append("*");
            }
            pyramid.append("\n");
        }
        System.out.print(pyramid);
    }

    public static void main(String[] args) {
        new HalfPyramid().printHalfPyramid(8);
    }
}
