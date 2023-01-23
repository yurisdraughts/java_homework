package Task2;

abstract class CustomList<T> {
    private int size;

    public CustomList(int size) {
        this.size = size;
    }

    abstract public int getSize();

    abstract public T get(int i);
}