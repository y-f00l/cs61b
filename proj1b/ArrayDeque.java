
public class ArrayDeque<T> implements Deque<T> {

    private T[] itemArray;
    private int size;

    public ArrayDeque() {
        size = 0;
        itemArray = (T []) new Object[8];
    }

    private void resize(int capacity) {
        T[] newArray = (T []) new Object[capacity];
        System.arraycopy(itemArray, 0, newArray, 0, size);
        itemArray = newArray;
    }

    public void addFirst(T item) {
        if (size >= itemArray.length) {
            T[] newArray = (T []) new Object[size * 2];
            System.arraycopy(itemArray, 0, newArray, 1, size);
            newArray[0] = item;
            itemArray = newArray;
            size += 1;
            return;
        }
        System.arraycopy(itemArray, 0, itemArray, 1, size);
        itemArray[0] = item;
        size += 1;
    }

    public void addLast(T item) {
        if (size >= itemArray.length) {
            resize(itemArray.length * 2);
        }
        itemArray[size] = item;
        size += 1;
    }

    public T removeFirst() {
        // make sure the array list is not empty
        if (this.isEmpty()) {
            return null;
        }

        T result = itemArray[0];

        // shrink the space of array to reduce the memory cost
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
        // make sure the array list is not empty
        if (this.isEmpty()) {
            return null;
        }

        T result = itemArray[size - 1];
        if (size - 1 < itemArray.length / 4) {
            resize(itemArray.length / 2);
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
