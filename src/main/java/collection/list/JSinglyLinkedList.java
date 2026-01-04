package collection.list;

public class JSinglyLinkedList<T> {

    private Node<T> head;
    private int size;

    public JSinglyLinkedList() {
        this.head = null;
        this.size = 0;
    }

    // 시간복잡도 : O(N)
    public T search(T target) {
        if (target == null) {
            return null;
        }

        Node<T> currentNode = head;
        while (currentNode != null) {
            T currentItem = currentNode.getItem();

            if (target.equals(currentItem)) {
                return currentItem;
            } else {
                currentNode = currentNode.getNext();
            }
        }

        return null;
    }

    // 시간복잡도 : O(N)
    public Node<T> searchNode(T target) {
        if (target == null) {
            return null;
        }

        Node<T> currentNode = head;
        while (currentNode != null) {
            T currentItem = currentNode.getItem();

            if (target.equals(currentItem)) {
                return currentNode;
            } else {
                currentNode = currentNode.getNext();
            }
        }

        return null;
    }

    // 시간복잡도 : O(1)
    public void insertAfter(T newItem, Node<T> node) {
        if (node == null) return;
        Node<T> newNode = new Node<>(newItem, node.getNext());
        node.setNext(newNode);
        size++;
    }

    // 시간복잡도 : O(1)
    public void insertFront(T newItem) {
        head = new Node<>(newItem, head);
        size++;
    }

    public int size() {
        return size;
    }

    public void print() {
        Node<T> current = head;
        System.out.print("[");
        while (current != null) {
            System.out.print(current.getItem());
            if (current.getNext() != null) {
                System.out.print(", ");
            }
            current = current.getNext();
        }
        System.out.println("]");
    }
}
