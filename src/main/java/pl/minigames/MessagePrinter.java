package pl.minigames;

import java.util.Map;

class MessagePrinter {
    private static final String END_OF_PROGRAM = "End of program";
    private static final String WELCOME_MESSAGE_TYPE_1 = "Type 1 to choose a game";
    private static final String WELCOME_MESSAGE_TYPE_2 = "Type 2 to print games in base";
    private static final String WELCOME_MESSAGE_TYPE_3 = "Type 3 to exit";


    public MessagePrinter() {
    }

    void endingMessage() {
        System.out.println(END_OF_PROGRAM);
    }

    void welcomeMessege() {
        System.out.println(WELCOME_MESSAGE_TYPE_1);
        System.out.println(WELCOME_MESSAGE_TYPE_2);
        System.out.println(WELCOME_MESSAGE_TYPE_3);
    }
    void printGames(Map<String,String> availableGames) {
        for (String s : availableGames.keySet()) {
            System.out.println("We have a " + s + " game in database right now");
        }
    }
}
