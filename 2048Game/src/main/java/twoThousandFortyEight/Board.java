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
        boolean anythingChanged = false;
        if (direction.equals(Direction.UP) || direction.equals(Direction.LEFT))
        {
            for (int y = 0; y < this.height; y++)
            {
                for (int x = 0; x < this.width; x++)
                {
                    int value = this.blocks[x][y];
                    if (value == 0)
                    {
                        continue;
                    }
                    if ((direction.equals(Direction.UP) && y == 0) || (direction.equals(Direction.LEFT) && x == 0))
                    {
                        continue;
                    }
                    int directionedValue = this.blocks[x + direction.getWidth()][y + direction.getHeight()];
                    if (directionedValue != 0 && value / directionedValue != 1)
                    {
                        continue;
                    }
                    this.blocks[x][y] = 0;
                    this.blocks[x + direction.getWidth()][y + direction.getHeight()] = value + directionedValue;
                    anythingChanged = true;
                }
            }
        }
        else if ( direction.equals(Direction.DOWN) || direction.equals(Direction.RIGHT))
        {
           for (int y = this.height - 1; y >= 0; y--)
           {
               for (int x = this.width - 1; x >= 0; x--)
               {
                   int value = this.blocks[x][y];
                   if (value == 0)
                   {
                       continue;
                   }
                   if ((direction.equals(Direction.DOWN) && y == this.height - 1) || (direction.equals(Direction.RIGHT) && x == this.width - 1))
                   {
                       continue;
                   }
                   int directionedValue = this.blocks[x + direction.getWidth()][y + direction.getHeight()];
                   if (directionedValue != 0 && value / directionedValue != 1)
                   {
                       continue;
                   }
                   this.blocks[x][y] = 0;
                   this.blocks[x + direction.getWidth()][y + direction.getHeight()] = value + directionedValue;
                   anythingChanged = true;
               }
           }
        }
        if (anythingChanged)
        {
            this.addRandomBlock();
        }
        }

}
