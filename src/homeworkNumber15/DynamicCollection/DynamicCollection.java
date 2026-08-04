package homeworkNumber15.DynamicCollection;

import java.util.Arrays;
import java.util.Objects;

public class DynamicCollection<E> {
    private Object[] list;
    private int size = 0;
    private final int DEFAULT_CAPACITY = 10;
    public DynamicCollection() {
        this.list = new Object[DEFAULT_CAPACITY];
    }

    public DynamicCollection(int length) {
        if(length < 0 )
            throw new IllegalArgumentException();
        this.list = new Object[length];

    }

    public boolean add(E element) {
        ensureCapacity();
        list[size++] = element;
        return true;
    }

    private void ensureCapacity() {
        if(size == list.length) {
            list = Arrays.copyOf(list, size + 1);
        }
    }

    public void clear() {
        Arrays.fill(list, null);
        size = 0;
    }

    public boolean remove(E element) {
        for (int i = 0; i < size; i++) {
            if (list[i].equals(element)) {
                for (int j = i; j < size - 1; j++) {
                    list[j] = list[j + 1];
                }
                list[--size] = null;
                return true;
            }
        }
        return false;
    }

    public int getSize() {
        return this.size;
    }

    public boolean contains(E element) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(list[i], element)) return true;
        }
        return false;
    }

    public E get(int index) {
        if(index < 0 || index >= size) throw new IndexOutOfBoundsException();
        return (E) list[index];
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(list, size));
    }
}
