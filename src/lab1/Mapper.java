package lab1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Mapper<K extends Comparable, V> {

    private List<Pair<K, V>> list = new ArrayList<>();

    public void add(K k, V v) {
        list.add(new Pair<>(k, v));
    }

    public List<Pair<K, V>> getList() {
        return list;
    }

    public void sort() {
        list.sort(Comparator.naturalOrder());
    }

    public void print() {
        list.forEach(System.out::println);
    }
}