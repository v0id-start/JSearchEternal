package wordsearch;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class GameController {
    Scene menuScene;

    public Button menuButton;




    public void goToMenu() throws IOException {
        Stage window = (Stage) menuButton.getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getResource("menu.fxml"));

        menuScene = new Scene(root, 800, 1000);
        window.setScene(menuScene);
    }
}
