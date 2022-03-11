package com.claudomiro.genome.util;

import com.claudomiro.genome.dto.SimianRequestDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MatrixUtilsTest {

    private List<String> dna;
    private MatrixUtils utils;

    @BeforeEach
    void setUp() {
        dna = new ArrayList<>();
        dna.add("CTGAGA");
        dna.add("CTATGC");
        dna.add("TATTGT");
        dna.add("AGAGGG");
        dna.add("CCCCTA");
        dna.add("TCACTG");
        utils = new MatrixUtils(dna);
    }

    @Test // API is null-safe
    void dontAllowNull(){
        assertThrows(NullPointerException.class, () -> {
           new MatrixUtils(null);
        });
    }

    @Test
    void squaredMatrices() {
        dna.add("ACTG");

        assertThrows(IllegalArgumentException.class, () -> {
            final MatrixUtils utils = new MatrixUtils(dna);
        });
    }

    @Test
    void toArrayRepresentation() {
        final MatrixUtils utils = new MatrixUtils(dna);
        assertEquals('C', utils.toArray()[0][0]);
        assertEquals('A', utils.toArray()[1][2]);
    }

    @Test
    void lines() {
        assertEquals(6, utils.lines());
    }

    @Test
    void columns() {
        assertEquals(6, utils.col());
    }

}
