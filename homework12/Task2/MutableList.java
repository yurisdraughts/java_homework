package Task2;

import java.util.ArrayList;

public class MutableList<T> extends CustomList<T> {
    private int size;
    private ArrayList<T> list;

    public MutableList(int size, ArrayList<T> list) {
        super(size);
        this.list = list;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public T get(int i) {
        return this.list.get(i);
    }

    public void set(int i, T newValue) {
        this.list.set(i, newValue);
    }

    public void add(T newValue) {
        this.list.add(newValue);
    }

    public void remove(T value) {
        this.list.remove(value);
    }
}
