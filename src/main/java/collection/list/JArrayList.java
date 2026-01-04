package collection.list;

public class JArrayList<E> {

    private E[] array; // 첫번재 원소에 대한 주소값이 곧 배열에 대한 주소값
    private int size;

    public JArrayList() {
        array = (E[]) new Object[10]; // 0 이 아닌 이유는 어차피 발생할 리사이즈 비용을 피하기 위해
        size = 0;
    }

    // 시간복잡도 : O(1)
    public E get(int index) {
        if (index < 0 || size <= index) {
            throw new IndexOutOfBoundsException();
        }

        return array[index];
    }

    // 시간복잡도 : Amortized O(1) (최악의 경우 O(N))
    public void insertLast(E newItem) {
        if (size == array.length) {
            resize(size * 2);
        }

        array[size++] = newItem;
    }

    // 시간복잡도 : O(N)
    public void insert(E newItem, int index) {
        if (index < 0 || size < index) {
            throw new IndexOutOfBoundsException();
        }

        if (size == array.length) {
            resize(size * 2);
        }

        for (int i = size; i > index; i--) {
            array[i] = array[i - 1];
        }

        array[index] = newItem;

        size++;
    }

    // 시간복잡도 : O(N)
    public void remove(int index) {
        if (index < 0 || size <= index) {
            throw new IndexOutOfBoundsException();
        }

        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }

        array[size - 1] = null;
        size--;
    }

    // 시간복잡도 : O(N)
    private void resize(int newSize) {
        Object[] tempArray = new Object[newSize];
        for (int i = 0; i < size; i++) {
            tempArray[i] = array[i];
        }
        array = (E[]) tempArray;
    }

    public int size() {
        return size;
    }
}
