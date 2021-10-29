package twoThousandFortyEight;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Witaj w grze 2048!");
        System.out.print("Podaj szerokość planszy: ");
        int width = scanner.nextInt();

        while (width < 3) {
            System.out.println("Minimalna szerość musi wynosić conajmniej 3.");
            System.out.print("Podaj szerokość planszy: ");
            width = scanner.nextInt();
        }

        System.out.print("Podaj wysokość planszy: ");
        int height = scanner.nextInt();

        while (height < 3) {
            System.out.println("Wysokość planszy musi wynosic conajmniej 3.");
            System.out.print("Podaj wysokość planszy: ");
            height = scanner.nextInt();
        }
        System.out.println("Twoja plansza ma wymiary: " + width + "x" + height);

        Board board = new Board(width, height);
        board.addDefaultBlock();
        board.renderBoard();
    }



}
