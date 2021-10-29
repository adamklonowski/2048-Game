package twoThousandFortyEight;

import java.util.ArrayList;
import java.util.List;

public class Direction
{
    public static final Direction UP = new Direction(new char[] {'w', 'W'}, 0, -1);
    public static final Direction DOWN = new Direction(new char[] {'s', 'S'}, 0, 1);
    public static final Direction LEFT = new Direction(new char[] {'a', 'A'}, -1, 0);
    public static final Direction RIGHT = new Direction(new char[] {'d', 'D'}, 1, 0);
    public static final Direction[] DIRECTIONS = new Direction[] {UP, DOWN, LEFT, RIGHT};

    public static Direction getDirection(char key)
    {
        for (Direction direction : DIRECTIONS)
        {
            for (char characters : direction.characters)
            {
                if (characters == key)
                {
                    return direction;
                }
            }
        }
        return null;
    }

    private final char[] characters;
    private final int width;
    private final int height;

    public Direction(char[] characters, int width, int height) {
        this.characters = characters;
        this.width = width;
        this.height = height;
    }

    public char[] getCharacters() {
        return this.characters;
    }



    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }



}
