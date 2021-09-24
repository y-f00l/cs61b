
public class ArrayDeque<T> {

    private T[] itemArray;
    private int size;

    public ArrayDeque() {
        size = 0;
        itemArray = (T []) new Object[8];
    }

    public void addFirst(T item) {
        if (size >= itemArray.length) {
            T[] newArray = (T []) new Object[size * 2];
            System.arraycopy(itemArray, 0, newArray, 0, size);
            itemArray = newArray;
        }
        System.arraycopy(itemArray, 0, itemArray, 1, size);
        itemArray[0] = item;
        size += 1;
    }

    public void addLast(T item) {
        if (size >= itemArray.length) {
            T[] newArray = (T []) new Object[size * 2];
            System.arraycopy(itemArray, 0, newArray, 0, size);
            itemArray = newArray;
        }
        itemArray[size] = item;
        size += 1;
    }

    public T removeFirst() {
        if (this.isEmpty()) {
            return null;
        }

        T result = itemArray[0];

        if (size - 1 < itemArray.length / 4) {
            T[] newArray = (T []) new Object[itemArray.length / 2];
            System.arraycopy(itemArray, 1, newArray, 0, size);
            itemArray = newArray;
            size -= 1;
            return result;
        }
        System.arraycopy(itemArray, 1, itemArray, 0, size - 1);
        size -= 1;
        return result;
    }

    public T removeLast() {
        if (this.isEmpty()) {
            return null;
        }

        T result = itemArray[size - 1];
        if(size - 1 < itemArray.length / 4) {
            T[] newArray = (T []) new Object[itemArray.length / 2];
            System.arraycopy(itemArray, 0, newArray, 0, size - 1);
            itemArray = newArray;
            size -= 1;
            return result;
        }
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
