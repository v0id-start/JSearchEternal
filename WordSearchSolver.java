package com.company;

import java.util.*;

public class WordSearchSolver {

    public static char[][] solveWordSearchBoard(WordSearchBoard wsBoard)
    {
        char[][] board = wsBoard.getBoard();
        ArrayList<String> words = wsBoard.getPlacedWords();

        char[][] solvedBoard = solveCharWordSearch(board, words);
        return solvedBoard;
    }

    public static char[][] solveCharWordSearch(char[][] board, ArrayList<String> words)
    {
        char[][] answerBoard;

        String[] directions = {"n","ne","e","se","s","sw","w","nw"};

        // Brute Force
        for (String word : words)
        {
            boolean found = false;

                for (int r = 0; r < board.length && !found; r++)
                {
                    for (int c = 0; c < board[0].length && !found; c++)
                    {

                        for (String dir : directions)
                        {
                            if (checkWord(board, c, r, dir, word))
                            {
                                System.out.println(word + " FOUND AT " + r + " " + c + " " + " GOING " + dir.toUpperCase());
                                found = true;
                            }

                            if (found)
                                break;
                        }

                    }
                }
            }

            return new char[][] {{'.','.'},{'.','.'}};

        }


/*
. . . .
. . . .
. . . .


 */

    public static boolean checkWord(char[][] board, int x, int y, String dir, String word)
    {
        HashMap<String, int[]> DIRS = WordFunc.getDIRS();

        // N E S W directional board bounds
        if (dir.equals("n") && y+1 - word.length() < 0) {return false;}
        else if (dir.equals("e") && x + word.length() > board[0].length) { return false; }
        else if (dir.equals("s") && y + word.length() > board.length) {return false;}
        else if (dir.equals("w") && x+1 - word.length() < 0) { return false; }

        // NE SE SW NW directional board bounds
        else if (dir.equals("ne") && (y+1 - word.length() < 0 || x + word.length() > board[0].length)) { return false; }
        else if (dir.equals("se") && (y + word.length() > board.length || x + word.length() > board[0].length)) { return false; }
        else if (dir.equals("sw") && (y + word.length() > board.length || x+1 - word.length() < 0)) { return false; }
        else if (dir.equals("nw") && (y+1 - word.length() < 0 || x+1 - word.length() < 0)) { return false; }

        // Since word fits within bounds, now step through each letter to ensure each space is either blank
        // or the same letter as a different word's letter at that location
        for (int i = 0; i < word.length(); i++)
        {
            if (board[y][x] != word.charAt(i))
            {
                return false;
            }
            x += DIRS.get(dir)[0];
            y += DIRS.get(dir)[1];
        }

        // Passed checks
        return true;
    }
}

