package players;

public class PlayerFactory {
    public static Player createPlayer(String type, String name, char symbol) {
        if ("human".equalsIgnoreCase(type)) {
            return new HumanPlayer(name, symbol);
        } else if ("bot".equalsIgnoreCase(type)) {
            return new BotPlayer(name, symbol);
        }
        throw new IllegalArgumentException("Invalid player type: " + type);
    }
}
