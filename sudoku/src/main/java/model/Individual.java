package model;


public class Individual implements Comparable<Individual> {
    private int[][] individual;
    private int fitness;


    public Individual(int[][] individual, int fitness) {
        this.individual = individual;
        this.fitness = fitness;
    }
    public Individual(){}

    public int[][] getIndividual() {
        return individual;
    }

    public void setPopulation(int[][] individual) {
        this.individual = individual;
    }

    public void setFitness(int fitness) {
        this.fitness = fitness;
    }

    public int getFitness() {
        return fitness;
    }

    @Override
    public int compareTo(Individual other) {
        if (this.fitness < other.fitness) {
            return -1;
        }
        else if (this.fitness > other.fitness) {
            return 1;
        }
        else {
            return 0;
        }
    }
}
