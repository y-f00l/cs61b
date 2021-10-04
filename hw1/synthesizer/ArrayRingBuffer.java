package es.datastructur.synthesizer;
import java.util.Iterator;

public class ArrayRingBuffer<T> implements BoundedQueue<T> {
    /* Index for the next dequeue or peek. */
    private int first;
    /* Index for the next enqueue. */
    private int last;
    /* Variable for the fillCount. */
    private int fillCount;
    /* Array for storing the buffer data. */
    private T[] rb;

    /**
     * Create a new ArrayRingBuffer with the given capacity.
     */
    public ArrayRingBuffer(int capacity) {
        rb = (T[]) new Object[capacity];

        /* init the first and last variable to point the position */
        first = 0;
        last = 0;
    }

    /**
     * Adds x to the end of the ring buffer. If there is no room, then
     * throw new RuntimeException("Ring buffer overflow").
     */
    public void enqueue(T x) {

        /* Don't insert the null to the RingBuffer */
        if (x == null) {
            return;
        }
        /* Don't insert to the full RingBuffer */
        if (fillCount == rb.length) {
            throw new RuntimeException("Ring Buffer overflow");
        }

        /* insert the element */
        rb[last] = x;
        fillCount += 1;

        /* make sure the RingBuffer */
        last = (last + 1) % (rb.length);
    }

    /**
     * Dequeue oldest item in the ring buffer. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow").
     */
    public T dequeue() {

        /* Can't remove a element from a empty RingBuffer */
        if (fillCount == 0) {
           throw new RuntimeException("Ring Buffer underflow");
        }

        /* keep the count correct */
        fillCount -= 1;
        T result = rb[first];
        /* the circle */
        first = (first + 1) % (rb.length);
        return result;
    }

    /**
     * Return oldest item, but don't remove it. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow").
     */
    public T peek() {
        if (fillCount == 0) {
            throw new RuntimeException("Ring Buffer underflow");
        }
        return this.rb[first];
    }

    public int capacity() {
        return this.rb.length;
    }

    public int fillCount() {
        return this.fillCount;
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public T next() {
        return null;
    }

    // TODO: When you get to part 4, implement the needed code to support
    //       iteration and equals.

    private class ArrayRingBufferIterator implements Iterator<T> {
        private int pos;
        private int width;

        public ArrayRingBufferIterator() {
            pos = 0;
            width = capacity();
        }

        @Override
        public boolean hasNext() {
            return pos == first;
        }

        public T next() {
            T result = rb[pos];
            pos = (pos + 1) % width;
            return result;
        }
    }

    public Iterator<T> iterator() {
        return new ArrayRingBufferIterator();
    }

    /* For the equals to two ArrayRingBuffer */

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }
        ArrayRingBuffer<T> o = (ArrayRingBuffer<T>) obj;
        if (o.capacity() != this.capacity() || o.fillCount() != this.fillCount()) {
            return false;
        }

        Iterator<T>it = this.iterator();
        Iterator<T>other = o.iterator();

        while (it.hasNext() && other.hasNext()) {
            T item1 = it.next();
            T item2 = other.next();
            if (item1.equals(item2)){
                return false;
            }
        }

        return true;
    }
}
