package strategies;

import board.Board;
import players.Player;

public interface WinStrategy {
    boolean checkWin(Board board, Player player);
}
