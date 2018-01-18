package lab1;

public class Pair<K extends Comparable, V> implements Comparable {
    public K key;
    public V value;

    public Pair(K k, V v) {
        key = k;
        value = v;
    }

    @Override
    public int compareTo(Object o) {
        if (this == o) return 0;
        if (o == null) return 1;
        return this.key.compareTo(((Pair) o).key);
    }

    @Override
    public String toString() {
        return "(" + key + ", " + value + ")";
    }
}
