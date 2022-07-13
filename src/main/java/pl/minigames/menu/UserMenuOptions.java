package pl.minigames.menu;

public enum UserMenuOptions {

    INITIALIZE_GAME(1),
    AVAILABLE_GAMES(2),
    EXIT(3);

    private final Integer option;

    UserMenuOptions(Integer option) {
        this.option = option;
    }

    public Integer getOption() {
        return option;
    }

    public boolean isAvailableGames() {
        return AVAILABLE_GAMES.option.equals(this.option);
    }

    public boolean isExit() {
        return EXIT.option.equals(this.option);
    }

    public boolean isInitialize() {
        return INITIALIZE_GAME.option.equals(this.option);
    }
}
