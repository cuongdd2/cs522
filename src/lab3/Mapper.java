package lab3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Mapper {


    public List<Pair<String, Integer>> map(List<String> input) {
        List<Pair<String, Integer>> list = new ArrayList<>();
        String pattern = "([\"']?)([a-zA-Z]+)([\"']?)([\\.,!\\?]?)";
        for (String line: input ) {
            String[] arr = line.split("[ \\-]");
            for (String s : arr) {
                Matcher matcher = Pattern.compile(pattern).matcher(s);
                if (matcher.matches()) {
                    list.add(new Pair<>(matcher.group(2).toLowerCase(), 1));
                }
            }
        }
        list.sort(Comparator.naturalOrder());
        return list;
    }
}