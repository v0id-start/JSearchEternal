package wordsearch;

import java.util.Objects;

// Manages single set of x,y coordinates for 2d plane
public class Coordinate {

    private int x;
    private int y;

    public Coordinate(int xPos, int yPos)
    {
        this.x = xPos;
        this.y = yPos;
    }


    // 2 coordinates are equal if both x's and y's are equal
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate that = (Coordinate) o;
        return x == that.x && y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Coordinate{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
