package pl.minigames;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import pl.minigames.lotto.LottoFacade;

class GameChooser {

    private final Map<String, String> availableGames = new HashMap<>();

    public GameChooser() {
        initialize();
    }

    private void initialize() {
        availableGames.put("Lotto", "Loading, please wait");
        availableGames.put("Batlleships", "Sorry not ready yet..");
        availableGames.put("Solitare", "Ups, not ready!");
    }

    public void choose() {
        String game = chooseGame();
        initializeGame(game);
    }

    private String chooseGame() {
        String game = "";
        while (!game.equals("Lotto")) {
            game = choosingGame();
        }
        return game;
    }

    private void initializeGame(String s) {
        switch (s) {
            case "Lotto":
                startLotto();
        }
    }

    private String choosingGame() {
        System.out.println("Please choose a game");
        try {
            Scanner sc = new Scanner(System.in);
            boolean chooseGame = true;
            while (chooseGame) {
                String choosenGame = sc.nextLine();
                if (validateGame(choosenGame)) {
                    printGameReadyState(choosenGame);
                    return choosenGame;
                } else System.out.println("Sorry no such game in base");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "Probably an error of some kind occured";
    }

    public void printGames() {
        for (String s : availableGames.keySet()) {
            System.out.println("We have a " + s + " game in database right now");
        }
    }

    private boolean validateGame(String s) {
        return availableGames.containsKey(s) ? true : false;
    }

    private void printGameReadyState(String s) {
        System.out.println(availableGames.get(s));
    }

    private void startLotto() {
        LottoFacade clientLotto = new LottoFacade();
        clientLotto.start();
    }


}
