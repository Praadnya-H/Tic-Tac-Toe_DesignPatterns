package board;

public class Board {
    private final char[][] grid;

    public Board(int size) {
        grid = new char[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                grid[i][j] = ' ';
            }
        }
    }

    public int getSize() {
        return grid.length;
    }

    public boolean isCellEmpty(int row, int col) {
        if (!isValidCell(row, col)) return false;
        return grid[row][col] == ' ';
    }

    public boolean isValidCell(int row, int col) {
        return row >= 0 && row < grid.length && col >= 0 && col < grid.length;
    }

    public void placeSymbol(int row, int col, char symbol) {
        if (isValidCell(row, col)) {
            grid[row][col] = symbol;
        }
    }

    public void displayBoard() {
        for (char[] row : grid) {
            for (char cell : row) {
                System.out.print("| " + cell + " ");
            }
            System.out.println("|");
        }
    }

    public char[][] getBoard() {
        return grid;
    }
}
