package wordsearch;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller {
    Scene difficultyScene;

    public Button playButton;
    public Button customButton;
    public Button exitButton;

    public void goToDifficulty() throws IOException {
        Stage window = (Stage) playButton.getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getResource("difficulty.fxml"));

        difficultyScene = new Scene(root, 800, 1000);
        window.setScene(difficultyScene);
    }

    public void playCustom()
    {

    }

    public void exit()
    {
        Stage window = (Stage) exitButton.getScene().getWindow();
        window.close();
    }
}
