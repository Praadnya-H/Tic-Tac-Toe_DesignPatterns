package players;

import board.Board;

import java.util.Scanner;

public class HumanPlayer extends Player {
    private final Scanner scanner = new Scanner(System.in);

    public HumanPlayer(String name, char symbol) {
        super(name, symbol);
    }

    @Override
    public int[] makeMove(Board board) {
        System.out.println(name + ", enter your move (row and column): ");
        int row = scanner.nextInt();
        int col = scanner.nextInt();
        return new int[]{row, col};
    }
}
