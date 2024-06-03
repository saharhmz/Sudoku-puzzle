package model;

import java.util.ArrayList;
import java.util.List;
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

    public int[][] solve(){
        List<Individual> population= initializePopulation(initialIndividual);
        
    }

    private void setGeneration(int generation){
        this.generation=generation;
    }
    public int getGeneration(){
        return this.generation;
    }

    public List<Individual> initializePopulation(int[][] initialIndividual) {
        List<Individual> population = new ArrayList<>();
        for (int i = 0; i < populationSize; i++) {
            int[][] individual = new int[9][9];
            for (int row = 0; row < 9; row++) {
                for (int col = 0; col < 9; col++) {
                    if (initialIndividual[row][col] != 0) {
                        individual[row][col] = initialIndividual[row][col];
                    } else {
                        individual[row][col] = random.nextInt(9) + 1;
                    }
                }
            }
            population.add(new Individual(individual,fitness(individual)));
        }
        return population;
    }

    private  int fitness(int[][] individual) {
        int conflicts = 0;

        for (int i = 0; i < 9; i++) {
            conflicts += countConflicts(individual[i]);
        }

        for (int j = 0; j < 9; j++) {
            int[] column = new int[9];
            for (int i = 0; i < 9; i++) {
                column[i] = individual[i][j];
            }
            conflicts += countConflicts(column);
        }

        for (int row = 0; row < 9; row += 3) {
            for (int col = 0; col < 9; col += 3) {
                int[] subgrid = new int[9];
                int index = 0;
                for (int i = row; i < row + 3; i++) {
                    for (int j = col; j < col + 3; j++) {
                        subgrid[index] = individual[i][j];
                        index+=1;
                    }
                }
                conflicts += countConflicts(subgrid);
            }
        }

        return conflicts;
    }

    private  int countConflicts(int[] array) {
        int[] frequency = new int[10];
        for (int num : array) {
            frequency[num]++;
        }
        int conflicts = 0;
        for (int i = 1; i <= 9; i++) {
            conflicts += Math.max(0, frequency[i] - 1);
        }
        return conflicts;
    }

    private List<int[][]> crossover(int[][] parent1, int[][] parent2) {
        int[][] child1 = new int[9][9];
        int[][] child2 = new int[9][9];


        int crossoverPoint = random.nextInt(8) + 1;

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (col < crossoverPoint) {
                    child1[row][col] = parent1[row][col];
                    child2[row][col] = parent2[row][col];
                } else {
                    child1[row][col] = parent2[row][col];
                    child2[row][col] = parent1[row][col];
                }
            }
        }

        List<int[][]> child = new ArrayList<>();
        child.add(child1);
        child.add(child2);

        return child;
    }


}
