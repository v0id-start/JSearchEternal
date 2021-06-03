package wordsearch;

import javafx.scene.control.Button;

public class LetterCell {

    private Button button;
    private int row;
    private int col;

    private boolean isToggled;


    public LetterCell(Button b, int r, int c)
    {
        this.button = b;
        this.row = r;
        this.col = c;
        this.isToggled = false;
    }

    public Button getButton()
    {
        return this.button;
    }

    public void setIsToggled(boolean newValue)
    {
        this.isToggled = newValue;
    }

    void toggleButton()
    {
        if (!this.isToggled)
        {
            this.button.setStyle("-fx-background-color: #421c7a;");
            GameManager.addSelectedIndex(this.col, this.row);
            this.setIsToggled(true);
           }
        else if (this.isToggled)
        {
            this.button.setStyle("-fx-background-color: #121212;");
            GameManager.removeSelectedIndex(this.col, this.row);
            this.setIsToggled(false);
        }
    }


}
