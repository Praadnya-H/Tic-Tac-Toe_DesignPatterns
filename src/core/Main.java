package core;

import board.Board;
import observers.ConsoleObserver;
import players.Player;
import players.PlayerFactory;
import strategies.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input board size
        System.out.println("Enter board size (N): ");
        int size = scanner.nextInt();

        // Validate number of players
        int maxPlayers = size - 1;
        int numPlayers;
        do {
            System.out.println("Enter number of players (Max " + maxPlayers + "): ");
            numPlayers = scanner.nextInt();
            if (numPlayers > maxPlayers) {
                System.out.println("Invalid input! Maximum allowed players for a " + size + "x" + size + " board is " + maxPlayers + ".");
            }
        } while (numPlayers > maxPlayers);

        // Create players
        List<Player> players = new ArrayList<>();
        int humanCount = 0;
        for (int i = 1; i <= numPlayers; i++) {
            System.out.println("Enter player " + i + " type (human/bot): ");
            String type = scanner.next().toLowerCase();

            if ("human".equals(type)) {
                System.out.println("Enter player " + i + " name: ");
                String name = scanner.next();

                System.out.println("Enter player " + i + " symbol: ");
                char symbol = scanner.next().charAt(0);

                players.add(PlayerFactory.createPlayer(type, name, symbol));
                humanCount++;
            } else if ("bot".equals(type)) {
                String botName = generateRandomBotName();
                char botSymbol = (char) ('A' + i - 1); // Auto-assign symbols A, B, C...
                System.out.println("Bot created: Name=" + botName + ", Symbol=" + botSymbol);

                players.add(PlayerFactory.createPlayer(type, botName, botSymbol));
            } else {
                System.out.println("Invalid player type. Please enter 'human' or 'bot'.");
                i--; // Retry this player
            }
        }

        // Initialize strategies
        List<WinStrategy> strategies = List.of(
                new RowWinStrategy(),
                new ColumnWinStrategy(),
                new DiagonalWinStrategy(),
                new AntiDiagonalWinStrategy()
        );

        // Initialize observer
        ConsoleObserver observer = new ConsoleObserver();

        // Start game
        Board board = new Board(size);
        TicTacToeGame game = new TicTacToeGame(board, players, strategies);
        game.addObserver(observer);
        game.startGame();
    }

    private static String generateRandomBotName() {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder name = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            name.append(alphabet.charAt((int) (Math.random() * alphabet.length())));
        }
        return name.toString();
    }
}
