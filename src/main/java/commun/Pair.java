package commun;

public class Pair<T, V> {
    private T key;
    private V value;

    public Pair() {

    }

    public Pair(T key, V value) {
        this.key = key;
        this.value = value;
    }

    public T getKey() {
        return key;
    }

    public void setKeyAndValue(T key, V value) {
        this.value = value;
        this.key = key;
    }

    public V getValue() {
        return value;
    }
}

