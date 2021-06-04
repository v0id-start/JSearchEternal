package wordsearch;

import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class GameManager {

    public static int difficulty;

    public static HashMap<String, Coordinate[]> wordToCoordinates;
    static ArrayList<Coordinate> selectedCoordinates = new ArrayList<Coordinate>();


    public static HashMap<String, Label> wordLegend = new HashMap<>();

    public static LetterCell[][] cellBoard;


    public static void setCellBoard(LetterCell[][] cells)
    {

        cellBoard = cells;
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
            // Cross out word
            wordLegend.get(wordText).setStyle("-fx-text-fill: #5af72a;");

            System.out.println(wordText + " WAS FOUND!");
            wordToCoordinates.remove(wordText);

            if (wordToCoordinates.size() == 0)
            {
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


}