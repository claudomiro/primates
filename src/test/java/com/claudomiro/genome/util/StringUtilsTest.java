package com.claudomiro.genome.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StringUtilsTest {

    @Test // this class is null-safe
    void dontAllowNull() {
        assertThrows(NullPointerException.class, () -> {
           new StringUtils(null);
        });
    }
}
