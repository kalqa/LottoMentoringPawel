package pl.minigames.menu;

class MessagePrinter {
    private static final String END_OF_PROGRAM = "End of program";
    private static final String WELCOME_MESSAGE_TYPE_1 = "Type 0 to choose a game";
    private static final String WELCOME_MESSAGE_TYPE_2 = "Type 1 to print games in base";
    private static final String WELCOME_MESSAGE_TYPE_3 = "Type other to exit";


    public MessagePrinter() {
    }

    void welcomeMessage() {
        print(WELCOME_MESSAGE_TYPE_1);
        print(WELCOME_MESSAGE_TYPE_2);
        print(WELCOME_MESSAGE_TYPE_3);
    }

    void print(String s) {
        System.out.println(s);
    }
}
