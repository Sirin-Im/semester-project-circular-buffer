package ru.kpfu.itis.group101.komissarov.course1.term2.ASD;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * This queue implementation does not support the presence of a null element, because when a new element is added,
 * it will be unclear whether there is free space or not (overwrite the old element with a new one or just add
 * a new element). If the number of elements is equal to the maximum capacity of the queue, then when a new element
 * is added, the element under the index firstElemIndex is overwritten, and the element with the next index becomes
 * firstElemIndex.
 * @author Vitaliy Komissarov
 * @see AbstractQueue
 * @see java.util.Queue
 * @param <T> the type of elements held in this collection
 */
public class CircularBuffer<T> extends AbstractQueue<T> {
    private static final int DEFAULT_LONG_QUEUE = 16;

    private int size;
    private final int capacity;
    private final T[] queue;
    private int head;
    private int tail;

    /**
     * Default constructor
     */
    public CircularBuffer() {
        this.queue = (T[])(new Object[DEFAULT_LONG_QUEUE]);
        this.size = 0;
        this.capacity = DEFAULT_LONG_QUEUE;
        head = 0;
        tail = -1;
    }

    /**
     *
     * @param collection is a collection that is been needed to add into a new collection
     */
    public CircularBuffer(Collection<? extends T> collection) {
        this();
        for (T elem: collection) {
            if (elem != null) {
                offer(elem);
            }
        }
    }

    /**
     * Compares the value of size and capacity
     * @return true if size = capacity, otherwise returns false
     */
    public boolean sizeEqualsCapacity() {
        return Stream.of(size).allMatch(x -> x.equals(capacity));
    }

    /**
     * Returns a list iterator over the elements in this list
     * (from the element with the index - firstElemIndex, to the element with the index - lastElemIndex).
     *
     * @return A list iterator over the elements in this list
     *      * (from the element with the index - firstElemIndex, to the element with the index - lastElemIndex).
     */
    @Override
    public Iterator iterator() {
        return new MyDequeueIterator();
    }

    /**
     * The method which returns a quantity of queue.
     * @return a quantity of queue.
     */
    @Override
    public int size() {
        return this.size;
    }

    /**
     * Returns false because the class does not support an empty queue.
     * @return false because the class does not support an empty queue.
     */
    public boolean isEmpty() {
        return false;
    }

    /**
     * The method which checks that the queue has space, appends element and return true.
     * If the element is not been appended this method returns false.
     * @param o - The object which appends into a queue if it has space.
     * @return True if the element was appended into the queue else returns false.
     */
    @Override
    public boolean offer(T o) {
        if (o == null) {
            throw new NullPointerException("Unsupported element");
        }
        if (size == capacity) {
            head++;
            tail++;
            if (tail == capacity) {
                tail = 0;
            }
            if (head == capacity) {
                head = 0;
            }
            queue[tail] = o;
        } else {
            if (tail == capacity-1) {
                tail = 0;
            } else {
                tail++;
            }
            queue[tail] = o;
            size++;
        }
        return true;
    }

    /**
     * The method which returns the head element of the queue and delete it from the queue.
     * @return The head element of the queue and delete it from the queue.
     */
    @Override
    public T poll() {
        if (size == 0) {
            return null;
        } else {
            T pollElement = queue[head];
            if ((head < tail)|(size == 1)) {
                queue[head] = null;
                size--;
                head++;
                return pollElement;
            } else {
                queue[head] = null;
                size--;
                if (head == capacity-1) {
                    head = 0;
                } else {
                    head++;
                }
                return pollElement;
            }
        }
    }

    /**
     * The method which returns the head of the queue and not delete it.
     * @return the head of the queue and not delete it.
     */
    @Override
    public T peek() {
        if (size == 0) {
            return null;
        } else {
            return queue[head];
        }
    }

    /**
     * The method which uses poll() to delete it if the queue is not empty.
     * Else it throws {@link NoSuchElementException}.
     * @return The head of the queue which the method delete
     * @throws NoSuchElementException
     * @see #poll()
     */
    @Override
    public T remove() {
        if (size != 0) {
            return poll();
        } else {
            throw new NoSuchElementException();
        }
    }

    /**
     * A nested class that interacts until the last element of the queue with the lastElemIndex index is passed
     * @see Iterator
     */
    private class MyDequeueIterator implements Iterator<T> {
        /**
         * Indicates the next iterable element.
         */
        private int cursor = head;
        private int countDeletedElements;
        private boolean lastElementPassed = false;

        @Override
        public boolean hasNext() {
            return !lastElementPassed;
        }

        @Override
        public T next() {
            if (cursor == size + countDeletedElements) {
                cursor = countDeletedElements;
            }
            if (cursor == tail) {
                lastElementPassed = true;
            }
            int index = cursor;
            cursor++;
            return queue[index];
        }

        /**
         * Remove the head element of queue.
         */
        @Override
        public void remove() {
            queue[head] = null;
            if (head == capacity) {
                head = 0;
            } else {
                head++;
            }
            size--;
            countDeletedElements++;
        }
    }

    /**
     * The method which, the first, checks that object o is not compares with object o, the second,
     * checks that o != null then compares classes of two objects, the third, the method does a downward transformation
     * and compare objects by all the necessary attributes.
     * @param o The object which is been comparing with another object
     * @return true if objects is equal. Else return false;
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if ((this == null)||(this.getClass() != o.getClass())) {
            return false;
        }
        CircularBuffer d = (CircularBuffer) o;
        if (this.getCapacity() != d.getCapacity()) {
            return false;
        }
        if (this.size() != d.size()) {
            return false;
        }
        for (int i = 0; i < this.size(); i++) {
            if (this.getQueue()[i] != d.getQueue()[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * The method which returns int value. That value calculates by properties of class.
     * @return int value.
     */
    @Override
    public int hashCode() {
        return Arrays.stream(queue).filter(x -> x!= null).mapToInt((x) -> x.hashCode()).map(x -> x*31).sum()
                + Integer.hashCode(size)*31 + Integer.hashCode(capacity)*31 + Integer.hashCode(head)*31
                + Integer.hashCode(tail)*31;
    }

    /**
     * Converts each queue item into a string and concatenates.
     * @return array elements in the form of a string.
     */
    @Override
    public String toString() {
        T[] normalisedQueue = (T[])(new Object[size]);
        boolean flag = true;
        for (int i = head, indexNormalisedQueue = 0; flag == true; i++, indexNormalisedQueue++) {
            normalisedQueue[indexNormalisedQueue] = queue[i];
            if (i == tail) {
                flag = false;
            }
            if (i == capacity-1) {
                i = -1;
            }
        }
        return Arrays.stream(Arrays.stream(normalisedQueue).filter(x -> x != null).map(T::toString).toArray(String[]::new))
                .collect(Collectors.joining(", "));
    }

    /**
     * Returns number of items in the queue.
     * @return number of items in the queue.
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Returns a queue.
     * @return a queue.
     */
    public T[] getQueue() {
        return queue;
    }
}
