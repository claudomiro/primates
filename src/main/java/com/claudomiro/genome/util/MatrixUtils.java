package com.claudomiro.genome.util;

import java.util.List;

public class MatrixUtils {

    private List<String> value;

    public MatrixUtils(List<String> matrix) {
        if(matrix == null) {
            throw new NullPointerException("matrix could not be null");
        }
        this.value = matrix;
        if(lines() != col()) {
            throw new IllegalArgumentException("I know how to work only with squared matrices");
        }
    }

    public char[][] toArray() {
        final String firstLine = value.get(0);
        char[][] matrix = new char[value.size()][firstLine.length()];

        int line =0;
        for (String s : value) {
            for(int col =0; col < s.length(); col++) {
                matrix[line][col] = s.charAt(col);
            }
            line++;
        }

        return matrix;
    }

    public int lines() {
        return value.size();
    }

    public int col() {
        final String firstLine = value.get(0);
        return firstLine.length();
    }
}
