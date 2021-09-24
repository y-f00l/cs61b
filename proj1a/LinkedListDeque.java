
public class LinkedListDeque<T> {

    private class DataNode {
        private T data;
        private DataNode next;
        private DataNode prev;

        public DataNode() {
            this.next = null;
            this.prev = null;
        }

        public DataNode(T val, DataNode next, DataNode prev) {
            this.data = val;
            this.next = next;
            this.prev = prev;
        }

        public DataNode(DataNode other) {
            this.data = other.data;
            this.prev = null;
            this.next = null;
        }
    }

    private DataNode first;
    private DataNode last;
    private int size;

    public LinkedListDeque() {
        size = 0;
        first = new DataNode();
        first.next = first;
        first.prev = first;
        last = first;
    }

    public LinkedListDeque(LinkedListDeque other) {
        if (other == null) {
            return;
        }
        size = 0;
        first = new DataNode();
        first.next = first;
        first.prev = first;
        last = first;
        for (int i = 0; i < other.size(); i++) {
            addLast((T) other.get(i));
            size += 1;
        }
    }

    public void addFirst(T item) {
        DataNode ptr = new DataNode(item, first.next, first);
        first.next.prev = ptr;
        first.next = ptr;
        if (this.isEmpty()) {
            last = ptr;
        }
        size += 1;
    }

    public void addLast(T item) {
        DataNode ptr = new DataNode(item, first, last);
        last.next = ptr;
        last = ptr;
        first.prev = last;
        size += 1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        DataNode ptr = first.next;
        while (ptr != first) {
            System.out.print(ptr.data + " ");
            ptr = ptr.next;
        }
    }

    public T removeFirst() {
        if (this.isEmpty()) {
            return null;
        }
        T val = first.next.data;
        first.next = first.next.next;
        first.next.prev = first;
        size -= 1;
        if (this.isEmpty()) {
            last = first;
        }
        return val;
    }

    public T removeLast() {
        if (this.isEmpty()) {
            return null;
        }
        T val = last.data;
        last.prev.next = first;
        last = last.prev;
        size -= 1;
        return val;
    }

    public T get(int index) {
        assert !this.isEmpty();
        assert index < size;

        DataNode ptr = first.next;
        while (index != 0) {
            ptr = ptr.next;
            index -= 1;
        }
        return ptr.data;
    }

    private T getRecursiveHelper(int index, DataNode ptr) {
        if (index == 0) {
            return ptr.data;
        }
        return getRecursiveHelper(index - 1, ptr.next);
    }

    public T getRecursive(int index) {
        assert !this.isEmpty();
        assert index < size;

        return getRecursiveHelper(index, first.next);
    }
}
