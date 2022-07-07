package pl.minigames;

import java.util.Scanner;

public class UserInterface {
    private static GameChooser gameChooser;

    static void initialize() {
        gameChooser = new GameChooser();
    }

    public static void main(String[] args) {
        initialize();
        try (Scanner scanner = new Scanner(System.in)) {
            boolean loop = true;
            while (loop) {
                System.out.println("Type 1 to choose a game");
                System.out.println("Type 2 to print games in base");
                System.out.println("Type 3 to exit");
                String command = scanner.nextLine();
                switch (command) {
                    case "1":
                        gameChooser.choose();
                        loop = false;
                        break;
                    case "2":
                        gameChooser.printGames();
                        break;
                    case "3":
                        loop = false;
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            System.out.println("Exception in User interface");
        }
        System.out.println("End of program");
    }
}

