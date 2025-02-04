package core;

import board.Board;
import observers.GameObserver;
import observers.Observable;
import players.Player;
import strategies.DrawStrategy;
import strategies.WinStrategy;

import java.util.ArrayList;
import java.util.List;

public class TicTacToeGame implements Observable {
    private final Board board;
    private final List<Player> players;
    private final List<WinStrategy> winStrategies;
    private final DrawStrategy drawStrategy;
    private final List<GameObserver> observers;
    private GameState gameState;

    public TicTacToeGame(Board board, List<Player> players, List<WinStrategy> winStrategies) {
        this.board = board;
        this.players = players;
        this.winStrategies = winStrategies;
        this.drawStrategy = new DrawStrategy();
        this.observers = new ArrayList<>();
        this.gameState = GameState.ONGOING;
    }

    public void startGame() {
        int turn = 0;
        while (gameState == GameState.ONGOING) {
            board.displayBoard();
            Player currentPlayer = players.get(turn % players.size());
            notifyObservers(currentPlayer.getName() + "'s turn.");

            int[] move;
            do {
                move = currentPlayer.makeMove(board);
                if (!board.isValidCell(move[0], move[1])) {
                    System.out.println("Invalid move! Please choose a valid cell within the board.");
                } else if (!board.isCellEmpty(move[0], move[1])) {
                    System.out.println("Cell already occupied! Choose another cell.");
                }
            } while (!board.isValidCell(move[0], move[1]) || !board.isCellEmpty(move[0], move[1]));

            board.placeSymbol(move[0], move[1], currentPlayer.getSymbol());

            for (WinStrategy strategy : winStrategies) {
                if (strategy.checkWin(board, currentPlayer)) {
                    gameState = GameState.WIN;
                    notifyObservers("Congratulations, " + currentPlayer.getName() + "! You win!");
                    board.displayBoard();
                    return;
                }
            }

            if (drawStrategy.isDraw(board)) {
                gameState = GameState.DRAW;
                notifyObservers("It's a draw!");
                board.displayBoard();
                return;
            }

            turn++;
        }
    }

    @Override
    public void addObserver(GameObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(GameObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String message) {
        for (GameObserver observer : observers) {
            observer.update(message);
        }
    }
}
