package strategies;

import board.Board;
import players.Player;

public class RowWinStrategy implements WinStrategy {
    @Override
    public boolean checkWin(Board board, Player player) {
        char[][] grid = board.getBoard();
        char symbol = player.getSymbol();
        int size = board.getSize();

        for (int i = 0; i < size; i++) {
            boolean win = true;
            for (int j = 0; j < size; j++) {
                if (grid[i][j] != symbol) {
                    win = false;
                    break;
                }
            }
            if (win) return true;
        }
        return false;
    }
}
