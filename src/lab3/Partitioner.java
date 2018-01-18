package lab3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Partitioner {

    private List<Pair<String, Integer>> list = new ArrayList<>();

    public void add(Pair<String, Integer> p) {
        list.add(p);
    }

    public List<Pair<String, List<Integer>>> groupedPairs() {
        list.sort(Comparator.naturalOrder());
        List<Pair<String, List<Integer>>> gp = new ArrayList<>();
        String key = "";
        List<Integer> value = null;
        Pair<String, List<Integer>> groupPair = null;
        for (Pair<String, Integer> p : list) {
            if (!p.key.equals(key)) {
                key = p.key;
                if (groupPair != null) {
                    gp.add(groupPair);
                }
                value = new ArrayList<>();
                groupPair = new Pair<>(key, value);
            }
            value.add(p.value);
        }
        if (groupPair != null) {
            gp.add(groupPair);
        }
        return gp;
    }
}
