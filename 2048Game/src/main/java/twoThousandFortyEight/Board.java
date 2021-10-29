package twoThousandFortyEight;

import java.util.Random;

public class Board
    {
    private static final Random RANDOM = new Random();
    private final int width;
    private  final int height;
    private final int[][] blocks;
    private int points;
    private int moves;

    public Board(int width, int height)
    {
        this.width = width;
        this.height = height;
        this.blocks = new int[width][height];
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int[][] getBlocks() {
        return blocks;
    }

    public int getPoints() {
        return points;
    }

    public int getMoves() {
        return moves;
    }

    public void clearScreen()
    {
        for (int i = 0; i < 80; i++) {
            System.out.println();
        }
    }

    public void addDefaultBlock()
    {
        this.blocks[0][this.height - 1] = 2;
    }

    public void addRandomBlock ()
    {
        for (int i = 0; i < this.width * this.height; i++)
        {
            int x = RANDOM.nextInt(this.width);
            int y = RANDOM.nextInt(this.height);
            if (this.blocks[x][y] == 0)
            {
                this.blocks[x][y] = 2;
                return;
            }
        }
    }
    public void renderBoard()
    {
        this.clearScreen();
        System.out.println("Punkty: " + this.points);
        System.out.println("Ruchy: " + this.moves);
        System.out.println();

        for (int y = 0; y < this.height; y++)
        {
            for (int x = 0; x < this.width; x++)
            {
                String toPrint = this.blocks[x][y] + (x != this.width - 1 ? " | " : "");
                System.out.printf("%-4s", toPrint);
            }
            System.out.println();
        }
        System.out.println();
    }

    public void makeMove(Direction direction)
    {
        if (direction.equals(Direction.UP))
        {
            System.out.println("UP");
        } else if (direction.equals(Direction.DOWN))
        {
            System.out.println("DOWN");
        } else if (direction.equals(Direction.LEFT))
        {
            System.out.println("LEFT");
        } else if (direction.equals(Direction.RIGHT))
        {
            System.out.println("RIGHT");
        }

        }

}
