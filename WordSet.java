package wordsearch;

public class WordSet {
    private String title;
    private String[] wordList;

    public WordSet(String wordSetTitle, String[] wordSetList)
    {
        this.title = wordSetTitle;
        this.wordList = wordSetList;
    }


    public String getTitle()
    {
        return this.title;
    }

    public String[] getWordList()
    {
        return this.wordList;
    }
}
