package pl.minigames;

import java.util.Scanner;

class ScannerInputReciver implements IInputReciver {
    public static final String NOT_A_NUMBER_NUMBER_PLEASE = "Not a number!!, number please!!";
    private Scanner scanner = new Scanner(System.in);

    private ScannerInputReciver() {
    }

    public static ScannerInputReciver getInstance() {
        return new ScannerInputReciver();
    }

    @Override
    public String getString() {
        return scanner.nextLine().toUpperCase();
    }

    @Override
    public Integer getInt() {
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
