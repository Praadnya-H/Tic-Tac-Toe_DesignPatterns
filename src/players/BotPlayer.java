package players;

import board.Board;

import java.util.Random;

public class BotPlayer extends Player {
    private final Random random = new Random();

    public BotPlayer(String name, char symbol) {
        super(name, symbol);
    }

    @Override
    public int[] makeMove(Board board) {
        int size = board.getSize();
        int row, col;
        do {
            row = random.nextInt(size);
            col = random.nextInt(size);
        } while (!board.isCellEmpty(row, col));

        System.out.println(name + " (Bot) played at: " + row + ", " + col);
        return new int[]{row, col};
    }
}
