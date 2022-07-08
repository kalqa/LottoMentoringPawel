package pl.minigames;

import java.util.Set;

class MessagePrinter {
    private static final String END_OF_PROGRAM = "End of program";
    private static final String WELCOME_MESSAGE_TYPE_1 = "Type 1 to choose a game";
    private static final String WELCOME_MESSAGE_TYPE_2 = "Type 2 to print games in base";
    private static final String WELCOME_MESSAGE_TYPE_3 = "Type 3 to exit";


    public MessagePrinter() {
    }

    void endingMessage() {
        print(END_OF_PROGRAM);
    }

    void welcomeMessege() {
        print(WELCOME_MESSAGE_TYPE_1);
        print(WELCOME_MESSAGE_TYPE_2);
        print(WELCOME_MESSAGE_TYPE_3);
    }
    void printGames(Set<String> availableGames) {
        for (String s : availableGames) {
            print("We have a " + s + " game in database right now");
        }
    }
    void print(String s){
        System.out.println(s);
    }
}
