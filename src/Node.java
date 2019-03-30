public class Node<T> {

    private T data;
    private Node<T> pointer;

    /**
     * Creates an empty node with no pointer
     */
    public Node() {
        this.data = null;
        this.pointer = null;
    }

    /**
     * Creates a node without data but with a pointer
     *
     * @param pointer the pointer
     */
    public Node(Node<T> pointer) {
        this.data = null;
        this.pointer = pointer;
    }

    /**
     * Constructor creates a new node with a pointer
     *
     * @param data    data
     * @param pointer the pointer
     */
    public Node(T data, Node<T> pointer) {
        this.data = data;
        this.pointer = pointer;
    }

    /**
     * Returns the pointer from the node
     *
     * @return the node's pointer
     */
    public Node<T> getPointer() {
        return pointer;
    }

    /**
     * Changes the node's pointer
     *
     * @param pointer
     */
    public void changePointer(Node<T> pointer) {
        this.pointer = pointer;
    }

    /**
     * @return the data from the node
     */
    public T getData() {
        return data;
    }
}
