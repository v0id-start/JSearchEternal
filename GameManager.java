package wordsearch;

import javafx.scene.control.Button;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class GameManager {

    public static int difficulty;

    public static HashMap<String, Coordinate[]> wordToCoordinates;
    static ArrayList<Coordinate> selectedCoordinates = new ArrayList<Coordinate>();

    public static LetterCell[][] cellBoard;

    public static void setCellBoard(LetterCell[][] cells)
    {
        System.out.println(wordToCoordinates.get("APPLE")[0].getX() + " " + wordToCoordinates.get("APPLE")[0].getY());
        System.out.println(wordToCoordinates.get("ORANGE")[0].getX() + " " + wordToCoordinates.get("ORANGE")[0].getY());
        System.out.println(wordToCoordinates.get("STRAW")[0].getX() + " " + wordToCoordinates.get("STRAW")[0].getY());
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
            removeSelectedCoordinate(correctCoordinate);
        }
        System.out.println(wordToCoordinates.size());

    }


}