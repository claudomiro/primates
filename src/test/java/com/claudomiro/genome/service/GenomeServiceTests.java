package com.claudomiro.genome.service;

import com.claudomiro.genome.dto.SimianRequestDTO;
import com.claudomiro.genome.util.MatrixUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class GenomeServiceTests {

    private GenomeService service;
    private SimianRequestDTO fixtureOriginal;
    private SimianRequestDTO fixtureLittle;
    private SimianRequestDTO fixtureVertical;
    private SimianRequestDTO fixtureDiagonal;

    @BeforeEach
    void setUp() {
        service = new GenomeService();
        String[] arOriginal = new String[]{
                "CTGAGA",
                "CTATGC",
                "TATTGT",
                "AGAGGG",
                "CCCCTA",
                "TCACTG"
        };
        String[] arLittle = new String[]{
                "CGGG",
                "TTTA",
                "CAAA",
                "ACTG"
        };
        String[] arVertical = new String[]{
                "CGAG",
                "CTTA",
                "CTAA",
                "ATTG"
        };
        String[] arDiagonal = new String[]{
                "ACGT",
                "CAGT",
                "AGGT",
                "ACGT"
        };

        fixtureLittle = SimianRequestDTO.fromStringArray(arLittle);
        fixtureVertical = SimianRequestDTO.fromStringArray(arVertical);
        fixtureOriginal = SimianRequestDTO.fromStringArray(arOriginal);
        fixtureDiagonal = SimianRequestDTO.fromStringArray(arDiagonal);
    }

    @Test
    void horizontalRepetitions() {

        assertEquals(3, service.horizontalRepetitions(fixtureLittle, 3));
        //assertEquals(1, service.horizontalRepetitions(fixtureOriginal, 4));
    }

    @Test
    void verticalRepetitions() {
        assertEquals(2, service.verticalRepetitions(fixtureVertical, 3));
    }

    @Test
    void diagonalRepetitions() {
        assertEquals(2, service.diagonalRepetitions(fixtureDiagonal, 2));
    }

}
