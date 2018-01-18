package lab1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lab2 {
    public static void main(String[] args) {
        System.out.print("Enter the file path: ");
        Scanner in = new Scanner(System.in);
        String file = in.nextLine();
        if (file == null || file.equals("")) file = "./src/lab1/testDataForW1D1.txt";
        try {
            FileReader reader = new FileReader(file);
            BufferedReader buffer = new BufferedReader(reader);
            String line;
            String pattern = "(\"?)([a-zA-Z]+)(\"?)([\\.,!\\?]?)";
            Mapper<String, Integer> mapper = new Mapper<>();
            while ((line = buffer.readLine()) != null) {
                String[] arr = line.split("[ \\-]");
                for (String s : arr) {
                    Matcher matcher = Pattern.compile(pattern).matcher(s);
                    if (matcher.matches()) {
                        mapper.add(matcher.group(2).toLowerCase(), 1);
                    }
                }
            }
            mapper.sort();

            List<Pair<String, Integer>> list = mapper.getList();
            String key = "";
            List<Integer> value = null;
            Pair<String, List<Integer>> groupPair = null;
            Reducer<String, List<Integer>> reducer = new Reducer<>();
            for (Pair<String, Integer> p : list) {
                if (!p.key.equals(key)) {
                    key = p.key;
                    if (groupPair != null) {
                        reducer.add(groupPair);
                    }
                    value = new ArrayList<>();
                    groupPair = new Pair<>(key, value);
                }
                value.add(p.value);
            }
            reducer.print();
            reducer.sum();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

