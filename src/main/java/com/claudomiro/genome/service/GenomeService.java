package com.claudomiro.genome.service;

import com.claudomiro.genome.dto.SimianRequestDTO;
import com.claudomiro.genome.dto.SimianResponseDTO;
import com.claudomiro.genome.util.MatrixUtils;
import com.claudomiro.genome.util.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenomeService {

    public SimianResponseDTO isSimiam(SimianRequestDTO dna) {
        int totalRepetitions =
                horizontalRepetitions(dna, 4) +
                verticalRepetitions(dna, 4) +
                diagonalRepetitions(dna, 4);
        return new SimianResponseDTO(totalRepetitions >= 2);
    }

    public int verticalRepetitions(SimianRequestDTO request, int minimal) {
        int repetitions = 0;
        final List<String> dnaList = request.getDna();
        final MatrixUtils utils = new MatrixUtils(dnaList);
        final char[][] charSequence = utils.toArray();

        for(int j =0; j < utils.col(); j++) {
            int currentSequence = 0;
            char lastChar = charSequence[0][j];
            for(int i = 1; i <= utils.lines(); i++) {
                if(charSequence[i-1][j] == lastChar) {
                    currentSequence++;
                } else {
                    currentSequence =1;
                }
                if(currentSequence >= minimal) {
                    repetitions++;
                }
                lastChar = charSequence[i-1][j];
            }
        }
        return repetitions;
    }

    public int horizontalRepetitions(SimianRequestDTO request, int minimal) {
        int repetitions = 0;
        final List<String> dnaList = request.getDna();
        final MatrixUtils utils = new MatrixUtils(dnaList);
        final char[][] charSequence = utils.toArray();

        for(int i =0; i < utils.lines(); i++) {
            int currentSequence =0;
            char lastChar = charSequence[i][0];
            for(int j =1; j <= utils.col(); j++) {
                if(charSequence[i][j-1] == lastChar) {
                    currentSequence++;
                } else {
                    currentSequence =1;
                }
                if(currentSequence >= minimal) {
                    repetitions ++;
                }
                lastChar = charSequence[i][j-1];
            }
        }
        return repetitions;
    }

    public int diagonalRepetitions(SimianRequestDTO request, int minimal) {
        int repetitions = -1;
        final List<String> dnaList = request.getDna();
        final MatrixUtils utils = new MatrixUtils(dnaList);
        final char[][] charSequence = utils.toArray();
        int lastI = -1;
        int lastJ = -1;
        for(int z=0; z < utils.lines(); z++) {
            int currentSequence =0;
            for(int i =0; i <= z; i++){
                for(int j =z; j >= 0; j--) {
                    if(z> 0 && lastI != -1 && lastJ != -1) {
                        if(charSequence[i][j] == charSequence[lastI][lastJ]) {
                            currentSequence ++;
                        }
                    }
                    lastJ = j;
                }
                lastI = i;
            }
            if(currentSequence >= minimal) {
                repetitions++;
            }
        }
        return repetitions;
    }
}
