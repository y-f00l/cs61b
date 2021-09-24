
public class ArrayDeque<T> {

    private T[] itemArray;
    private int size;

    public ArrayDeque() {
        size = 0;
        itemArray = (T []) new Object[8];
    }

    public void addFirst(T item) {
        if(size >= itemArray.length) {
            T[] newArray = (T []) new Object[size * 2];
            System.arraycopy(itemArray, 0, newArray, 0, size);
            itemArray = newArray;
        }
        System.arraycopy(itemArray, 0, itemArray, 1, size);
        itemArray[0] = item;
        size += 1;
    }

    public void addLast(T item) {
        if(size >= itemArray.length) {
            T[] newArray = (T []) new Object[size * 2];
            System.arraycopy(itemArray, 0, newArray, 0, size);
            itemArray = newArray;
        }
        itemArray[size] = item;
        size += 1;
    }

    public T removeFirst() {
        assert !this.isEmpty();

        T result = itemArray[0];
        System.arraycopy(itemArray, 1, itemArray, 0, size - 1);
        size -= 1;
        return result;
    }

    public T removeLast() {
        assert !this.isEmpty();

        T result = itemArray[size - 1];
        size -= 1;
        return result;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public T get(int index) {
        assert index < itemArray.length;
        return itemArray[index];
    }

    public void printDeque() {
        for (int i = 0; i < size; i++) {
            System.out.print(itemArray[i] + " ");
        }
    }
}
