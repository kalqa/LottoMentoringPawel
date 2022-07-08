package pl.minigames;

public class UserInterface {
    private final IInputReciver INPUT_RECEIVER;
    private final GameChooser gameChooser;

    private final MessagePrinter messagePrinter = new MessagePrinter();

    public UserInterface(IInputReciver inputReciver) {
       this.INPUT_RECEIVER=inputReciver;
       this.gameChooser=new GameChooser(inputReciver);
    }

    public static void main(String[] args) {
        UserInterface UI = new UserInterface(ScannerInputReciver.getInstance());
        UI.start();
    }

    private void start() {
        boolean loop = true;
        while (loop) {
            messagePrinter.welcomeMessege();
            loop = pickMenuOptions(loop, INPUT_RECEIVER.getString());
        }
        messagePrinter.endingMessage();
    }

    private boolean pickMenuOptions(boolean loop, String command) {
        switch (command) {
            case "1":
                gameChooser.InitializeChoosenGame();
                loop = false;
                break;
            case "2":
                messagePrinter.printGames(gameChooser.getAvailableGames());
                break;
            case "3":
                loop = false;
                break;
        }
        return loop;
    }
}

