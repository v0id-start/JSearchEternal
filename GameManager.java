package wordsearch;

import java.util.HashMap;

public class GameManager {

    public static int difficulty;

    //public static int[][] correctIndices;

    public static HashMap<String, int[]> wordToIndices;


    public static void setDifficulty(int newDifficulty)
    {
        difficulty = newDifficulty;
    }

    public static int getDifficulty()
    {
        return difficulty;
    }

    public static void setCorrectIndices()
    {

    }

    public static void addSelectedIndex(int c, int r)
    {

    }

    public static void removeSelectedIndex(int c, int r)
    {

    }
}
