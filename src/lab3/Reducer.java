package lab3;

import java.util.List;

public class Reducer {

    public Pair<String, Integer> reduce(String key, List<Integer> counts) {
        int sum = 0;
        for (int c : counts) sum += c;
        return new Pair<>(key, sum);
    }
}
