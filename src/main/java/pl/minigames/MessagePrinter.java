package pl.minigames;

import java.util.Map;

class MessagePrinter {
    private GameChooser gameChooser;
    private IInputReciver inputReciver;
    private static final String END_OF_PROGRAM = "End of program";
    private static final String WELCOME_MESSAGE_TYPE_1 = "Type 1 to choose a game";
    private static final String WELCOME_MESSAGE_TYPE_2 = "Type 2 to print games in base";
    private static final String WELCOME_MESSAGE_TYPE_3 = "Type 3 to exit";


    public MessagePrinter(IInputReciver inputReciver) {
        this.inputReciver=inputReciver;
        this.gameChooser=new GameChooser(inputReciver);
    }

    void endingMessage() {
        print(END_OF_PROGRAM);
    }

    void welcomeMessege() {
        print(WELCOME_MESSAGE_TYPE_1);
        print(WELCOME_MESSAGE_TYPE_2);
        print(WELCOME_MESSAGE_TYPE_3);
    }
    void printGames() {
        Map<String,IGame> availableGames = gameChooser.getAvailableGames();
        for (String s : availableGames.keySet()) {
            print("We have a " + s + " game in database right now");
        }
    }
    void print(String s){
        System.out.println(s);
    }
}
