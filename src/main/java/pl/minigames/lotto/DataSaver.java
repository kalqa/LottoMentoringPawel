package pl.minigames.lotto;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

class DataSaver {
    private Map<Integer, Set<Integer>> numbersDrawn;
    private static final DataSaver dataSaver = new DataSaver();

    public static final DataSaver getInstance() {
        return dataSaver;
    }

    private DataSaver() {
        numbersDrawn = DataLoader.getInstance().getNumbersDrawn();
    }

    public void saveData(Set<Integer> set) {
        addSetToMap(set);
        try (FileWriter locFile = new FileWriter("src/main/java/pl/minigames/lotto/lotto.txt")) {
            for (Integer i : numbersDrawn.keySet()) {
                locFile.write(i + "," + convertSetToString(numbersDrawn.get(i)) + "\n");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.out.println("Something went wrong when saving data");
        }
    }

    private void addSetToMap(Set<Integer> set) {
        int nextIndex = numbersDrawn.keySet().size();
        numbersDrawn.put(nextIndex, set);
    }

    private String convertSetToString(Set<Integer> set) {
        StringBuilder sb = new StringBuilder();
        for (Integer i : set) {
            sb.append(i);
            sb.append(";");
        }
        return sb.toString();
    }
}
