package pl.minigames.lotto;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class LottoData {
    private Map<Integer,Set<Integer>> numbersDrawn;
    private static LottoData lottoData = new LottoData();

    public static LottoData getInstance(){
        return lottoData;
    }
    private LottoData() {
        initialize();
    }
    private void initialize(){
        load();
    }

    public void saveData(Set<Integer> set){
        addSetToMap(set);
        try (FileWriter locFile = new FileWriter("src/main/java/pl/minigames/lotto/lotto.txt")){
            for(Integer i: numbersDrawn.keySet()){
            locFile.write(i+","+convertSetToString(numbersDrawn.get(i))+ "\n");}
        } catch (IOException e){
            System.out.println(e.getMessage());
            System.out.println("Something went wrong when saving data");
        }
    }
    private void addSetToMap(Set<Integer> set){
        int nextIndex = numbersDrawn.keySet().size();
        numbersDrawn.put(nextIndex,set);
    }
    private String convertSetToString(Set<Integer> set){
        StringBuilder sb = new StringBuilder();
        for(Integer i : set){
            sb.append(i);
            sb.append(";");
        }
        return sb.toString();
    }
    private void load() {
        numbersDrawn = new HashMap<>();
        try (Scanner scanner = new Scanner(new FileReader("src/main/java/pl/minigames/lotto/lotto.txt"))) {
            scanner.useDelimiter(",");
            while (scanner.hasNextLine()) {
                int index = scanner.nextInt();
                scanner.skip(scanner.delimiter());
                String values = scanner.nextLine();
                Set<Integer> set = Stream.of(values.split(";"))
                        .collect(Collectors.toSet())
                        .stream()
                        .map(i -> Integer.parseInt(i))
                        .collect(Collectors.toSet());
                numbersDrawn.put(index, set);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
        public Set<Integer> getWithDrawalSet(Integer i){
        try {
            return numbersDrawn.containsKey(i) ? numbersDrawn.get(i): new HashSet<>();
        } catch (Exception e){
            e.getMessage();
        }
        return new HashSet<>();
    }
}
