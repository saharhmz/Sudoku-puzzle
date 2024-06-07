package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CSP {

    public int[][] solve(int[][] initialBoard) {
        int[][] board = copyBoard(initialBoard);
        if (backtrack(board)) {
            return board;
        } else {
            return null;
        }
    }

    private boolean backtrack(int[][] board) {
        int[] emptyCell = selectUnassignedVariable(board);
        if (emptyCell == null) {
            return true;
        }
        int row = emptyCell[0];
        int col = emptyCell[1];
        List<Integer> orderedValues = orderValues(board, row, col);
        for (int value : orderedValues) {
            if (!thereIsConflict(board, row, col, value)) {
                board[row][col] = value;
                if (backtrack(board)) {
                    return true;
                }
                board[row][col] = 0;
            }
        }
        return false;
    }

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

    //Least Constraining Value
    private List<Integer> orderValues(int[][] board, int row, int col) {
        List<Integer> possibleValues = possibleValues(board, row, col);
        possibleValues.sort((val1, val2) -> {
            int conflicts1 = countNeighborConflicts(board, row, col, val1);
            int conflicts2 = countNeighborConflicts(board, row, col, val2);
            return Integer.compare(conflicts1, conflicts2);
        });
        return possibleValues;
    }

    private int countNeighborConflicts(int[][] board, int row, int col, int value) {
        int conflicts = 0;
        for (int i = 0; i < 9; i++) {
            if (i != col && board[row][i] == 0 && thereIsConflict(board, row, i, value)) {
                conflicts++;
            }
            if (i != row && board[i][col] == 0 && thereIsConflict(board, i, col, value)) {
                conflicts++;
            }
        }
        int boxRow = 3 * (row / 3);
        int boxCol = 3 * (col / 3);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if ((boxRow + i != row || boxCol + j != col) && board[boxRow + i][boxCol + j] == 0 && thereIsConflict(board, boxRow + i, boxCol + j, value)) {
                    conflicts++;
                }
            }
        }
        return conflicts;
    }

    private boolean thereIsConflict(int[][] board, int row, int col, int value) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == value || board[i][col] == value) {
                return true;
            }
        }
        int boxRow = 3 * (row / 3);
        int boxCol = 3 * (col / 3);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[boxRow + i][boxCol + j] == value) {
                    return true;
                }
            }
        }
        return false;
    }

    private int[][] copyBoard(int[][] board) {
        int[][] copy = new int[board.length][];
        for (int i = 0; i < board.length; i++) {
            copy[i] = board[i].clone();
        }
        return copy;
    }
}
