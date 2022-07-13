package pl.minigames.utils;

import pl.minigames.InputReceivable;

import java.util.Scanner;

public class ScannerInputReceiver implements InputReceivable {
    public static final String NOT_A_NUMBER_NUMBER_PLEASE = "Not a number!!, number please!!";
    private final Scanner scanner = new Scanner(System.in);

    public ScannerInputReceiver() {
    }

    @Override
    public String receiveSignFromUser() {
        return scanner.nextLine().toUpperCase();
    }

    @Override
    public Integer receiveNumberFromUser() {
        int a = -1;
        try {
            if (scanner.hasNextInt()) a = scanner.nextInt();
            scanner.nextLine();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(NOT_A_NUMBER_NUMBER_PLEASE);
        }
        return a;
    }
}
