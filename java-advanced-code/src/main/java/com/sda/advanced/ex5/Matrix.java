package com.sda.advanced.ex5;

import java.util.ArrayList;
import java.util.List;

public class Matrix {

    private List<List<Character>> matrix;
    private Character symbol;
    private int lineLength;

    public Matrix() {
        matrix = new ArrayList<>();
        symbol = '*';
        lineLength = 10;
    }

    public Matrix(List<List<Character>> matrix) {
        this.matrix = matrix;
        this.symbol = '*';
        lineLength = 10;
    }

    public Matrix(List<List<Character>> matrix, Character symbol) {
        this.matrix = matrix;
        this.symbol = symbol;
        this.lineLength = 10;
    }

    public Matrix(List<List<Character>> matrix, Character symbol, int lineLength) {
        this.matrix = matrix;
        this.symbol = symbol;
        this.lineLength = lineLength;
    }

    /**
     * Add new row
     */
    public void addLine() {
        List<Character> line = new ArrayList<>();
        for (int i = 0; i < this.lineLength; i++) {
            line.add(this.symbol);
        }
        matrix.add(line);
    }


    public void removeLine() {
        // Should check matrix size
        if (matrix.size() > 0) {
            matrix.remove(matrix.size() - 1);
        }
    }

    public void addColumn() {
        // No row has been created
        if (matrix.size() == 0) {
            matrix.add(new ArrayList<>());
        }

        for (int i = 0; i < matrix.size(); i++) {
            matrix.get(i).add(symbol);
        }
        // Line size gets modified when we add a column
        this.lineLength++;
    }

    public void removeColumn() {
        for (int i = 0; i < matrix.size(); i++) {
            matrix.get(i).remove(matrix.get(i).size() - 1);
        }
        // Line size gets modified when we remove a column
        this.lineLength--;
    }

    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < matrix.size(); i++) {
            for (int j = 0; j < matrix.get(i).size(); j++) {
                result += matrix.get(i).get(j) + " ";
            }
            result += "\n";
        }
        return result;
    }
}
