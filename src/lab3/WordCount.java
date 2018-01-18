package lab3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WordCount {
    public static void main(String[] args) {
        WordCount me = new WordCount();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Number of Input-Splits: ");
        me.mapperNo = scanner.nextInt();
        System.out.print("Number of Reducers: ");
        me.reducerNo = scanner.nextInt();

        List<Pair<String, Integer>> inputs = new ArrayList<>();

        for (int i = 0; i < me.mapperNo; i++) {
            List<String> lines = read("./src/lab3/" + i + ".txt");
            Mapper mapper = new Mapper();
            List<Pair<String, Integer>> pairs = mapper.map(lines);
            System.out.println("Mapper " + i + " output");
            for (Pair p : pairs) System.out.println(p);
            inputs.addAll(pairs);
        }

        List<Reducer> reducers = new ArrayList<>();
        List<Partitioner> ps = new ArrayList<>();

        for (int j = 0; j < me.reducerNo; j++) {
            reducers.add(new Reducer());
            ps.add(new Partitioner());
        }

        for (Pair<String, Integer> p : inputs) {
            ps.get(me.getPartition(p.key)).add(p);
        }

        for (int i = 0; i < me.reducerNo; i++) {
            Reducer reducer = reducers.get(i);
            System.out.println("Reducer " + i + " output");
            for (Pair<String, List<Integer>> p : ps.get(i).groupedPairs()) {
                System.out.println(reducer.reduce(p.key, p.value));
            }
        }
    }

    private int mapperNo;
    private int reducerNo;


    public int getPartition(String key) {
        return key.hashCode() % reducerNo;
    }

    public static List<String> read(String file) {
        List<String> lines = new ArrayList<>();
        try {
            FileReader reader = new FileReader(file);
            BufferedReader buffer = new BufferedReader(reader);
            String line;
            while ((line = buffer.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }
}
