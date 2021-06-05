package wordsearch;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.RowConstraints;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;
public class GameController implements Initializable {
    Scene menuScene;

    public Button menuButton;
    public Button solveButton;

    public GridPane gridPane;
    public GridPane wordGrid;

    public Label titleLabel;
    public Label scoreLabel;
    public Label winLabel;

    public void goToMenu() throws IOException {
        GameManager.resetGame();

        Stage window = (Stage) solveButton.getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getResource("menu.fxml"));

        menuScene = new Scene(root, 800, 1000);
        window.setScene(menuScene);
        GameManager.isCustom = false;
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        GameManager.setWinLabel(winLabel);
        GameManager.setScoreLabel(scoreLabel);

        // Set number of rows and cols based on selected difficulty
        int difficulty = GameManager.getDifficulty();
        int numRows = 18;
        int numCols = 12;


        int numWords = 12;

        switch (difficulty)
        {
            case (1):
            {
                numRows = 22;
                numCols = 8;

                numWords = 12;
                break;
            }
            case (2):
            {
                numRows = 18;
                numCols = 12;

                numWords = 20;
                break;
            }
            case (3):
            {
                numRows = 23;
                numCols = 16;

                numWords = 30;
                break;
            }


        }



        // Build and display gridpane of buttons from 2d char array board
        WordSet wordSet = WordSetManager.getRandomWordSet(numWords);

        if (GameManager.isCustom)
        {
            numRows = GameManager.customCols;
            numCols = GameManager.customRows;

            String[] wordArray = new String[GameManager.customWords.size()];
            for (int i = 0; i < GameManager.customWords.size(); i++)
                wordArray[i] = GameManager.customWords.get(i).toUpperCase();

            wordSet = new WordSet(GameManager.customTitle, wordArray);
        }

        titleLabel.setText(wordSet.getTitle());

        WordSearchBoard wsBoard = new WordSearchBoard(numRows, numCols, 1000, wordSet);
        char[][] charBoard = wsBoard.getBoard();

        LetterCell[][] cellBoard = new LetterCell[charBoard.length][charBoard[0].length];
        GameManager.setWordToCoordinates(wsBoard.getWordToCoordinates());

        for (int r = 0; r < charBoard.length; r++)
        {
            for (int c = 0; c < charBoard[0].length; c++)
            {
                Button cellButton = new Button(Character.toString(charBoard[r][c]));
                cellButton.getStyleClass().add("letter-cell");

                cellButton.setMaxWidth(Double.MAX_VALUE);
                cellButton.setMaxHeight(Double.MAX_VALUE);

                Coordinate cellLocation = new Coordinate(r, c);
                LetterCell currentCell = new LetterCell(cellButton, cellLocation);
                cellBoard[r][c] = currentCell;

                currentCell.getButton().setOnAction(event -> currentCell.toggleButton());
                currentCell.getButton().setOnDragDetected(e -> cellButton.startFullDrag());
                currentCell.getButton().setOnMouseDragEntered(e -> currentCell.toggleButton());
                gridPane.add(cellButton, r, c);

            }

        }

        GameManager.setCellBoard(cellBoard);


        // Generate legend of words at bottom of screen
        ArrayList<String> wordList = wsBoard.getPlacedWords();
        Label[] wordLegend = new Label[wordList.size()];

        boolean allWordsPlaced = false;
        int wordInd = 0;

        for (int r = 0; r < wordList.size(); r++)
        {
            for (int c = 0; c < 3; c++)
            {
                if (!allWordsPlaced)
                {
                    Label wordLabel = new Label(wordList.get(wordInd));
                    wordLabel.getStyleClass().add("legend-label");
                    wordGrid.add(wordLabel, r, c);
                    wordLegend[wordInd] = wordLabel;

                    wordInd++;

                    if (wordInd == wordList.size())
                        allWordsPlaced = true;
                }

            }
        }

        GameManager.setWordLegend(wordLegend);
        System.out.println("REACHES");



    }


    public void solveBoard()
    {

        GameManager.solveBoard();

    }





}