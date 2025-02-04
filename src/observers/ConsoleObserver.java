package observers;

public class ConsoleObserver implements GameObserver {
    @Override
    public void update(String message) {
        System.out.println(message);
    }
}
