package Task2;

public class ImmutableList<T> extends CustomList<T> {
    private int size;
    private T[] list;

    public ImmutableList(int size, T[] list) {
        super(size);
        this.list = list;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public T get(int i) {
        return this.list[i];
    }
}
