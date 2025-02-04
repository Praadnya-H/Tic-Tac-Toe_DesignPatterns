package strategies;

import board.Board;

public class DrawStrategy {
    public boolean isDraw(Board board) {
        for (int i = 0; i < board.getSize(); i++) {
            for (int j = 0; j < board.getSize(); j++) {
                if (board.isCellEmpty(i, j)) {
                    return false;
                }
            }
        }
        return true;
    }
}
