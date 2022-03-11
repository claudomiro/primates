package com.claudomiro.genome.util;

public class StringUtils {

    final String value;

    public StringUtils(String value) {
        if(value == null) {
            throw new NullPointerException("String should not be null");
        }
        this.value = value;
    }

    public int repetitionSize(int begin) {
        if(value.length() <= begin ) {
            throw new UnsupportedOperationException("'" + value + "' has only " + value.length() + " characters");
        }

        final char firstChar = value.charAt(begin);
        int index = begin;
        while (index < value.length() && value.charAt(index) == firstChar) {
            index++;
        }

        return index - begin;
    }
}
