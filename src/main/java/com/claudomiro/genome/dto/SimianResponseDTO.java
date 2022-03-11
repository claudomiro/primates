package com.claudomiro.genome.dto;

public class SimianResponseDTO {

    private final boolean is_simian ;

    public SimianResponseDTO(boolean isSimian) {
        this.is_simian = isSimian;
    }

    @Override
    public String toString() {
        return "SimianResponseDTO{" +
                "is_simian=" + is_simian +
                '}';
    }

    public boolean isIs_simian() {
        return is_simian;
    }

}
