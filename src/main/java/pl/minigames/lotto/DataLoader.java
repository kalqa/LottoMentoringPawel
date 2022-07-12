package pl.minigames.lotto;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class DataLoader {
    private Map<Integer, Set<Integer>> numbersDrawn;
    private static DataLoader dataLoader = new DataLoader();

    public static DataLoader getInstance() {
        return dataLoader;
    }

    private DataLoader() {
        initialize();
    }

    private void initialize() {
        load();
    }


    private void load() {
        numbersDrawn = new HashMap<>();
        try (Scanner scanner = new Scanner(new FileReader("src/main/java/pl/minigames/lotto/lotto.txt"))) {
            scanner.useDelimiter(",");
            while (scanner.hasNextLine()) {
                int index = scanner.nextInt();
                scanner.skip(scanner.delimiter());
                String values = scanner.nextLine();
                Set<Integer> set = Stream.of(values.split(";")).collect(Collectors.toSet()).stream().map(i -> Integer.parseInt(i)).collect(Collectors.toSet());
                numbersDrawn.put(index, set);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Set<Integer> getWithDrawalSet(Integer i) {
        try {
            return numbersDrawn.containsKey(i) ? numbersDrawn.get(i) : new HashSet<>();
        } catch (Exception e) {
            e.getMessage();
        }
        return new HashSet<>();
    }

    public Map<Integer, Set<Integer>> getNumbersDrawn() {
        return numbersDrawn;
    }
}
