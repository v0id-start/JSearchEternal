package wordsearch;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class CustomController implements Initializable {
    Scene menuScene;
    Scene gameScene;

    public Button menuButton;

    public Button createBoardButton;

    public ChoiceBox numRowsChoice;
    public ChoiceBox numColsChoice;

    public TextArea textArea;
    public TextField titleInput;

    public void goToMenu() throws IOException {
        Stage window = (Stage) menuButton.getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getResource("menu.fxml"));

        menuScene = new Scene(root, 800, 1000);
        window.setScene(menuScene);
    }

    public void createBoard() throws IOException {


        GameManager.setIsCustom(true);
        GameManager.customRows = (int) numRowsChoice.getValue();
        GameManager.customCols = (int) numColsChoice.getValue();
        GameManager.customTitle = titleInput.getText();

        String customListText = textArea.getText();

        ArrayList<String> customWords = new ArrayList<>();
        String words[] = customListText.split("\\n");

        for(String line: words)
            customWords.add(line);

        GameManager.customWords = customWords;


        Stage window = (Stage) createBoardButton.getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getResource("game.fxml"));

        gameScene = new Scene(root, 800, 1000);
        window.setScene(gameScene);


    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        for (int i = 1; i < 21; i++)
            numRowsChoice.getItems().add(i);

        for (int i = 1; i < 31; i++)
            numColsChoice.getItems().add(i);


        numRowsChoice.setValue(8);
        numColsChoice.setValue(8);

        createBoardButton.setOnAction(event -> {
            try {
                createBoard();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

}