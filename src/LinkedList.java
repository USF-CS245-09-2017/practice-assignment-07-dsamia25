public class LinkedList<T> implements List<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size;

    /**
     * Constructor initializes a null head and the size as 0
     */
    public LinkedList() {
        head = new Node();
        size = 0;
    }

    /**
     * Adds a Node to the list at the specified position
     *
     * @param pos  the position to place the node
     * @param item the item to add
     */
    public void add(int pos, T item) {
        Node<T> n = head;
        int i = 0;
        while (i < pos) {
            n = n.getPointer();
            i++;
        }
        n.changePointer(new Node<T>(item, n.getPointer()));
        size++;
    }

    /**
     * Adds a node to the list at the end
     *
     * @param item the item to add
     */
    public void add(T item) {
        if (size == 0) {
            head.changePointer(new Node<T>(item, head));
            tail = head.getPointer();
        } else {
            Node<T> temp = new Node<T>(item, head);
            tail.changePointer(temp);
            tail = temp;
        }
        size++;
    }

    /**
     * Removes an item from the list at the specified location and returns its data
     *
     * @param pos the position to remove the item
     * @return the data from the removed node
     */
    public T remove(int pos) {
        if (pos >= size || pos < 0) {
            throw new IndexOutOfBoundsException("Out of bounds of list");
        } else {
            Node<T> n = head.getPointer();
            Node<T> prev = head;
            int i = 0;
            while (i < pos) {
                n = n.getPointer();
                prev = prev.getPointer();
                i++;
            }
            prev.changePointer(n.getPointer());
            size--;
            return n.getData();
        }
    }

    /**
     * returns the data from the specified node
     *
     * @param pos the position to get data from
     * @return the data from that node
     */
    public T get(int pos) {
        if (pos >= size) {
            throw new IndexOutOfBoundsException("Out of bounds of list");
        } else {
            Node<T> n = head.getPointer();
            for (int i = 0; i < pos; i++) {
                n = n.getPointer();
            }
            return n.getData();
        }
    }

    /**
     * the size of the array
     *
     * @return the size of the array
     */
    public int size() {
        return size;
    }
}
