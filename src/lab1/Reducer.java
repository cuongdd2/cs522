package lab1;

import java.util.ArrayList;
import java.util.List;

public class Reducer<K extends Comparable, V> {

    private List<Pair<K, V>> list = new ArrayList<>();

    public void add(Pair<K, V> p) {
        list.add(p);
    }

    public void sum() {
        for (Pair<K, V> p : list) {
            List<Integer> v = (List<Integer>) p.value;
            int sum = 0;
            for (int e : v) {
                sum += e;
            }
            System.out.println(new Pair<K, Integer>(p.key, sum));
        }
    }

    public void print() {
        list.forEach(System.out::println);
    }
}
