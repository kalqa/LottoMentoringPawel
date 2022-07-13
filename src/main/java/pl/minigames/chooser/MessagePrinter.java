package pl.minigames.chooser;

class MessagePrinter {

    private final String CHOOSE_GAME_MESSAGE = "Please choose a game";
    private final String NO_GAME_IN_BASE_MESSAGE = "Sorry no such game in base";

    public MessagePrinter() {
    }


    void printChooseGame() {
        System.out.println(CHOOSE_GAME_MESSAGE);
    }

    void printNoGameInBase() {
        System.out.println(NO_GAME_IN_BASE_MESSAGE);
    }
}
