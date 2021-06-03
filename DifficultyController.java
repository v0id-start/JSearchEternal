package wordsearch;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class DifficultyController {
    Scene menuScene;
    Scene gameScene;

    public Button easyButton;
    public Button normalButton;
    public Button hardButton;
    public Button menuButton;

    public void setDifficultyEasy()
    {
        play("easy");
    }

    public void setDifficultyNormal()
    {
        play("normal");
    }

    public void setDifficultyHard()
    {
        play("hard");
    }

    public void play(String difficulty) {
        Stage window = (Stage) easyButton.getScene().getWindow();

        try
        {
            Parent root = FXMLLoader.load(getClass().getResource("game.fxml"));

            gameScene = new Scene(root, 800, 1000);
            window.setScene(gameScene);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }

    }



    public void goToMenu() throws IOException {
        Stage window = (Stage) menuButton.getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getResource("menu.fxml"));

        menuScene = new Scene(root, 800, 1000);
        window.setScene(menuScene);
    }
}
