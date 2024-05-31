import controller.PuzzleController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader= new FXMLLoader(getClass().getResource("/puzzle.fxml"));
        loader.load();
        PuzzleController controller = loader.getController();
        primaryStage.setScene(new Scene((Parent) loader.getRoot()));
        primaryStage.setTitle("Sudoku");
        primaryStage.setResizable(false);
        controller.initFunction(primaryStage);
        primaryStage.show();
    }
}
