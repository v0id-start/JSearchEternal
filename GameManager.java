package wordsearch;

import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Random;

public class GameManager {

    public static int difficulty;
    public static boolean won = false;

    public static HashMap<String, Coordinate[]> wordToCoordinates;
    static ArrayList<Coordinate> selectedCoordinates = new ArrayList<Coordinate>();


    public static HashMap<String, Label> wordLegend = new HashMap<>();

    public static LetterCell[][] cellBoard;

    public static Label scoreLabel;
    public static Label winLabel;

    static int score = 0;

    public static String customTitle = "";
    public static boolean isCustom = false;
    public static int customRows = 0;
    public static int customCols = 0;
    public static ArrayList<String> customWords = new ArrayList<>();

    public static void resetGame()
    {
        won = false;

        wordToCoordinates = new HashMap<>();
        selectedCoordinates = new ArrayList<Coordinate>();


        wordLegend = new HashMap<>();

        score = 0;

        customTitle = "";
        isCustom = false;
        customRows = 0;
        customCols = 0;
        customWords = new ArrayList<>();
    }

    public static void setIsCustom(boolean newIsCustomValue)
    {
        isCustom = newIsCustomValue;
    }

    public static void setCellBoard(LetterCell[][] cells)
    {
        cellBoard = cells;
    }

    public static void setScoreLabel(Label scoreL)
    {
        scoreLabel = scoreL;
        scoreLabel.setText("score: " + score);
    }


    public static void setWinLabel(Label winL)
    {
        winLabel = winL;
    }

    public static void setDifficulty(int newDifficulty)
    {
        difficulty = newDifficulty;
    }

    public static int getDifficulty()
    {
        return difficulty;
    }

    public static void setWordToCoordinates(HashMap<String, Coordinate[]> wordToCoordinatesMap)
    {
        wordToCoordinates = wordToCoordinatesMap;
    }

    public static void setWordLegend(Label[] labelArray)
    {
        for (Label wordLabel : labelArray)
        {
            wordLegend.put(wordLabel.getText(), wordLabel);
        }
    }


    public static String addSelectedCoordinate(Coordinate c)
    {
        selectedCoordinates.add(c);
        return getWordFound(c);

    }

    public static void removeSelectedCoordinate(Coordinate c)
    {
        selectedCoordinates.remove(c);
    }


    public static String getWordFound(Coordinate lastSelectedCoordinate)
    {
        boolean wordFound = false;
        String wordText = "";
        // using keySet() for iteration over keys
        for (String word : wordToCoordinates.keySet())
        {
            if (!wordFound)
            {
                wordFound = true;
                Coordinate[] correctCoordinateArray = wordToCoordinates.get(word);
                for (Coordinate correctCoordinate : correctCoordinateArray)
                {
                    if (!selectedCoordinates.contains(correctCoordinate))
                    {
                        wordFound = false;
                    }

                }

                if (wordFound)
                {
                    wordText = word;
                    setCoordinateButtonsFound(wordText);
                }

            }

        }

        if (wordFound)
        {
            // Add to score and set label
            score += 10;
            scoreLabel.setText("score: " + score);

            // Cross out word
            wordLegend.get(wordText).setStyle("-fx-text-fill: #5af72a;");

            System.out.println(wordText + " WAS FOUND!");
            wordToCoordinates.remove(wordText);

            if (wordToCoordinates.size() == 0)
            {
                winGame();
                System.out.println("Won");
            }
        }


        if (wordToCoordinates.size() == 0)
            wordText = "0";

        return wordText;
    }

    public static void setCoordinateButtonsFound(String word)
    {
        Coordinate[] foundCoordinates = wordToCoordinates.get(word);
        for (Coordinate correctCoordinate : foundCoordinates)
        {
            cellBoard[correctCoordinate.getX()][correctCoordinate.getY()].setFound();
        }
        System.out.println(wordToCoordinates.size());

    }

    public static void solveBoard()
    {
        for (LetterCell[] cellArr : cellBoard)
        {
            for (LetterCell cell : cellArr)
            {
                if (!won && !cell.getIsToggled())
                    cell.toggleButton();

            }
        }
    }

    public static void winGame()
    {
        won = true;
        winLabel.setOpacity(1);
        for (LetterCell[] cellArr : cellBoard)
        {
            for (LetterCell cell : cellArr)
            {
                if (!cell.getIsToggleable())
                {
                    String[] colors = {"#ff1929", "#29ff4c", "#f2ff00", "#2185ff", "#00d5ff", "#ffbf00", "#9e1ad6"};
                    int rnd = new Random().nextInt(colors.length);
                    String randomColor = colors[rnd];
                    //cell.getButton().setStyle("-fx-background-color: " + randomColor + ";");
                }
                else
                    cell.getButton().setStyle("-fx-background-color:black;");

            }
        }

    }


}