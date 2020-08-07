package com.bucur.ex5;

public class DemoEx5 {

    public static void main(String[] args) {
        Matrix matrix = new Matrix();
        matrix.addLine();
        matrix.removeLine();
        matrix.removeLine();

        System.out.println("Add remove remove line: \n" + matrix.toString());

        matrix.addLine();
        matrix.addLine();
        matrix.addLine();

        matrix.addColumn();
        matrix.addColumn();
        matrix.addColumn();

        System.out.println("3 x 3 matrix: \n" + matrix);

        matrix.removeColumn();

        System.out.println("After removing 1 column: \n" + matrix.toString());

        matrix.removeLine();

        System.out.println("After removing 1 line: \n" + matrix.toString());
    }

}
