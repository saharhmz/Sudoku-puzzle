package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CSP {


    // Minimum Remaining Values (MRV)
    private int[] selectUnassignedVariable(int[][] board) {
        int minRemainingValues = Integer.MAX_VALUE;
        int[] selectedVariable = null;
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == 0) {
                    int remainingValues = possibleValues(board, row, col).size();
                    if (remainingValues < minRemainingValues) {
                        minRemainingValues = remainingValues;
                        selectedVariable = new int[]{row, col};
                    }
                }
            }
        }
        return selectedVariable;
    }

    private List<Integer> possibleValues(int[][] board, int row, int col) {
        Set<Integer> possibleValues = new HashSet<>();
        for (int val = 1; val <= 9; val++) {
            possibleValues.add(val);
        }
        for (int i = 0; i < 9; i++) {
            possibleValues.remove(board[row][i]);
            possibleValues.remove(board[i][col]);
        }
        int boxRow = 3 * (row / 3);// start row in box
        int boxCol = 3 * (col / 3);// start column in box
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                possibleValues.remove(board[boxRow + i][boxCol + j]);
            }
        }
        return new ArrayList<>(possibleValues);
    }
}
