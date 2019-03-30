public class ArrayList<T> implements List<T> {
    private T[] array;
    int tail;

    /**
     * Constructor initializes the array at size 10
     */
    public ArrayList() {
        array = (T[]) (new Object[10]);
        tail = 0;
    }

    /**
     * adds an item to the array at the end
     *
     * @param item the item to add
     */
    public void add(T item) {
        if (tail == array.length) {
            growArray();
        }
        array[tail] = item;
        tail++;
        // System.out.println("Tail = " + list.tail);
    }

    /**
     * adds an item to a specific position in the array
     *
     * @param pos  the position to add the item to
     * @param item the item to add to the array
     */
    public void add(int pos, T item) {
        if (pos > tail || pos < 0) {
            //throw new IndexOutOfBoundsException("Out of bounds of array");
        } else {
            if (tail == array.length) {
                growArray();
            }
            shiftArrayRight(pos);
            array[pos] = item;
            tail++;
        }
    }

    /**
     * removes an item from the array at the specified position
     *
     * @param pos the position to remove an item from
     * @return the info from that pos
     */
    public T remove(int pos) {
        if (pos > tail || pos < 0) {
            throw new IndexOutOfBoundsException("Out of bounds of array");
        } else {
            T temp = array[pos];
            shiftArrayLeft(pos);
            tail--;
            return temp;
        }
    }

    /**
     * gets data from the specified position
     *
     * @param pos the position to get data from
     * @return data from that position
     */
    public T get(int pos) {
        if (pos >= tail || pos < 0) {
            throw new IndexOutOfBoundsException("Out of bounds of array");
        } else {
            return array[pos];
        }
    }

    /**
     * gets the size
     *
     * @return the size of the array
     */
    public int size() {
        return tail;
    }

    /**
     * Shifts the entire array to the left from the right to a specific position
     * to fill in a gap from a removed item
     *
     * @param pos the position to stop shifting stuff over at
     */
    public void shiftArrayLeft(int pos) {
        if (tail == 1) {
            array[0] = null;
        } else {
            for (int i = pos; i < tail; i++) {
                array[i] = array[i + 1];
            }
        }
    }

    /**
     * Shifts the array to the right starting at a position
     *
     * @param pos the position to start shifting to the right from
     */
    public void shiftArrayRight(int pos) {
        for (int i = tail; i > pos; i--) {
            array[i] = array[i - 1];
        }
    }

    /**
     * doubles the size of the array
     */
    public void growArray() {
        T[] temp = (T[]) (new Object[2 * array.length]);
        for (int i = 0; i < array.length; i++) {
            temp[i] = array[i];
        }
        array = temp;
    }
}
