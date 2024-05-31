package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class PuzzleController {

    @FXML
    private Button btn1_1;

    @FXML
    private Button btn1_2;

    @FXML
    private Button btn1_3;

    @FXML
    private Button btn1_4;

    @FXML
    private Button btn1_5;

    @FXML
    private Button btn1_6;

    @FXML
    private Button btn1_7;

    @FXML
    private Button btn1_8;

    @FXML
    private Button btn1_9;

    @FXML
    private Button btn2_1;

    @FXML
    private Button btn2_2;

    @FXML
    private Button btn2_3;

    @FXML
    private Button btn2_4;

    @FXML
    private Button btn2_5;

    @FXML
    private Button btn2_6;

    @FXML
    private Button btn2_7;

    @FXML
    private Button btn2_8;

    @FXML
    private Button btn2_9;

    @FXML
    private Button btn3_1;

    @FXML
    private Button btn3_2;

    @FXML
    private Button btn3_3;

    @FXML
    private Button btn3_4;

    @FXML
    private Button btn3_5;

    @FXML
    private Button btn3_6;

    @FXML
    private Button btn3_7;

    @FXML
    private Button btn3_8;

    @FXML
    private Button btn3_9;

    @FXML
    private Button btn4_1;

    @FXML
    private Button btn4_2;

    @FXML
    private Button btn4_3;

    @FXML
    private Button btn4_4;

    @FXML
    private Button btn4_5;

    @FXML
    private Button btn4_6;

    @FXML
    private Button btn4_7;

    @FXML
    private Button btn4_8;

    @FXML
    private Button btn4_9;

    @FXML
    private Button btn5_1;

    @FXML
    private Button btn5_2;

    @FXML
    private Button btn5_3;

    @FXML
    private Button btn5_4;

    @FXML
    private Button btn5_5;

    @FXML
    private Button btn5_6;

    @FXML
    private Button btn5_7;

    @FXML
    private Button btn5_8;

    @FXML
    private Button btn5_9;

    @FXML
    private Button btn6_1;

    @FXML
    private Button btn6_2;

    @FXML
    private Button btn6_3;

    @FXML
    private Button btn6_4;

    @FXML
    private Button btn6_5;

    @FXML
    private Button btn6_6;

    @FXML
    private Button btn6_7;

    @FXML
    private Button btn6_8;

    @FXML
    private Button btn6_9;

    @FXML
    private Button btn7_1;

    @FXML
    private Button btn7_2;

    @FXML
    private Button btn7_3;

    @FXML
    private Button btn7_4;

    @FXML
    private Button btn7_5;

    @FXML
    private Button btn7_6;

    @FXML
    private Button btn7_7;

    @FXML
    private Button btn7_8;

    @FXML
    private Button btn7_9;

    @FXML
    private Button btn8_1;

    @FXML
    private Button btn8_2;

    @FXML
    private Button btn8_3;

    @FXML
    private Button btn8_4;

    @FXML
    private Button btn8_5;

    @FXML
    private Button btn8_6;

    @FXML
    private Button btn8_7;

    @FXML
    private Button btn8_8;

    @FXML
    private Button btn8_9;

    @FXML
    private Button btn9_1;

    @FXML
    private Button btn9_2;

    @FXML
    private Button btn9_3;

    @FXML
    private Button btn9_4;

    @FXML
    private Button btn9_5;

    @FXML
    private Button btn9_6;

    @FXML
    private Button btn9_7;

    @FXML
    private Button btn9_8;

    @FXML
    private Button btn9_9;

    private Stage puzzleStage;


    public void initFunction(Stage puzzleStage){
        this.puzzleStage=puzzleStage;
        updatePuzzle(getInitialIndividual());

    }


    public void updatePuzzle(int[][] individual) {
        Button[][] buttons = {
                {btn1_1, btn1_2, btn1_3, btn1_4, btn1_5, btn1_6, btn1_7, btn1_8, btn1_9},
                {btn2_1, btn2_2, btn2_3, btn2_4, btn2_5, btn2_6, btn2_7, btn2_8, btn2_9},
                {btn3_1, btn3_2, btn3_3, btn3_4, btn3_5, btn3_6, btn3_7, btn3_8, btn3_9},
                {btn4_1, btn4_2, btn4_3, btn4_4, btn4_5, btn4_6, btn4_7, btn4_8, btn4_9},
                {btn5_1, btn5_2, btn5_3, btn5_4, btn5_5, btn5_6, btn5_7, btn5_8, btn5_9},
                {btn6_1, btn6_2, btn6_3, btn6_4, btn6_5, btn6_6, btn6_7, btn6_8, btn6_9},
                {btn7_1, btn7_2, btn7_3, btn7_4, btn7_5, btn7_6, btn7_7, btn7_8, btn7_9},
                {btn8_1, btn8_2, btn8_3, btn8_4, btn8_5, btn8_6, btn8_7, btn8_8, btn8_9},
                {btn9_1, btn9_2, btn9_3, btn9_4, btn9_5, btn9_6, btn9_7, btn9_8, btn9_9}
        };

        for (int i = 0; i < individual.length; i++) {
            for (int j = 0; j < individual[i].length; j++) {
                if (individual[i][j] == 0) {
                    buttons[i][j].setText(" ");
                } else {
                    buttons[i][j].setText(String.valueOf(individual[i][j]));
                }
            }
        }
    }


    public int[][] getInitialIndividual(){
//            int initialIndividual[][]={{0, 7, 2, 0, 0, 0, 0, 4, 9},
//            {8, 3, 1, 6, 0, 0, 5, 0, 0},
//            {0, 4, 9, 8, 7, 0, 1, 0, 6},
//            {0, 0, 6, 2, 0, 1, 4, 0, 0},
//            {0, 0, 0, 4, 6, 0, 3, 2, 0},
//            {0, 0, 0, 0, 3, 0, 0, 0, 1},
//            {0, 1, 5, 9, 2, 0, 0, 0, 3},
//            {7, 6, 0, 0, 5, 8, 2, 0, 0},
//            {0, 2, 0, 3, 0, 0, 6, 0, 0}};
        int initialIndividual[][]={{5, 3, 0, 0, 7, 0, 0, 0, 0},
                {6, 0, 0, 1, 9, 5, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},
                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},
                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 8, 0, 0, 7, 9}};

        return initialIndividual;
    }

    @FXML
    void geneticSolverHandler(ActionEvent event) {

    }

    @FXML
    void cspSolverHandler(ActionEvent event) {

    }
    @FXML
    void resetHandler(ActionEvent event) {
    }


}
