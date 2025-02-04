package strategies;

import board.Board;
import players.Player;

public class DiagonalWinStrategy implements WinStrategy {
    @Override
    public boolean checkWin(Board board, Player player) {
        char[][] grid = board.getBoard();
        char symbol = player.getSymbol();
        int size = board.getSize();

        boolean win = true;
        for (int i = 0; i < size; i++) {
            if (grid[i][i] != symbol) {
                win = false;
                break;
            }
        }
        return win;
    }
}
