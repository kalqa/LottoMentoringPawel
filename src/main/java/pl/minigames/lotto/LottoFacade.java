package pl.minigames.lotto;

import pl.minigames.IGame;
import pl.minigames.IInputReciver;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class LottoFacade implements IGame {
    private final IInputReciver INPUT_RECIVER;
    public LottoFacade(IInputReciver inputReciver) {
        this.INPUT_RECIVER = inputReciver;
    }

    public Set<Integer> getNumbersFromUser() {
        System.out.println("Starting your lotto game");
        System.out.println("Type in number from 1-99");
        Set<Integer> array = new HashSet<>();
        try {
            int typedNumbers = 0;
            while (typedNumbers < 6) {
                Scanner scanner = new Scanner(System.in);
                int number = 0;
                if (scanner.hasNextInt()) number = scanner.nextInt();
                scanner.nextLine();
                if (array.contains(number)) {
                    System.out.println("You've already typed that number");
                }
                if (numberCanBeAddedChecker(number) && !array.contains(number)) {
                    array.add(number);
                    typedNumbers++;
                    System.out.println("Great!! I've added: " + number);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return array;
    }

    boolean numberCanBeAddedChecker(int number) {
        if (number < 100 && number > 0) return true;
        System.out.println("wrong number typed");
        return false;
    }

    @Override
    public void start() {
        System.out.println("Type 1 to start game, Type 2 to check numbers by drawing number");
        try (Scanner scanner = new Scanner(System.in)) {
            String command = scanner.nextLine();
            switch (command) {
                case "1":
                    play();
                    break;
                case "2":
                    checkScore();
                    break;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("End of start method throws exception");
        }
    }

    private void play() {
        Set<Integer> array = getNumbersFromUser();
        System.out.println("Generating random numbers");
        Set<Integer> drawnNumbers = getDrawnNumbers();
        printNumbers(drawnNumbers);
        for (int i = 0; i < 5; i++) {
            System.out.println("checking if you won....");
        }
        System.out.println(drawnNumbers.equals(array) ? "You won!!!" : "Sorry it's a loosing game;)");
    }

    private void checkScore() {
        System.out.println("Type withdraw number");
        try (Scanner sc = new Scanner(System.in)) {
            Integer i = sc.nextInt();
            sc.nextLine();
            System.out.println("Numbers in withdrawal: " + i);
            printNumbers(LottoData.getInstance().getWithDrawalSet(i));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error in checking numbers?");
        }
    }

    private Set<Integer> getDrawnNumbers() {
        LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator(); //
        return lottoNumberGenerator.drawingNumbers();
    }

    private void printNumbers(Set<Integer> set) {
        StringBuilder stringBuilder = new StringBuilder("Numbers are: ");
        for (Integer i : set) {
            stringBuilder.append(i);
            stringBuilder.append(";");
        }
        System.out.println(stringBuilder);
    }
}
