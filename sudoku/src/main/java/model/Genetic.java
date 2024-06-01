package model;

import java.util.Random;

public class Genetic {

    private final int populationSize =360;
    private final double mutationRate = 0.05;
    private final int[][] initialIndividual;
    private int generation;
    private Random random = new Random();

    public Genetic(int[][] initialIndividual) {
        this.initialIndividual = initialIndividual;
    }

    private void setGeneration(int generation){
        this.generation=generation;
    }
    public int getGeneration(){
        return this.generation;
    }

    
}
