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

    // 시간복잡도 : O(N) (prev를 찾기 위해 탐색해야 함)
    public boolean removeNode(Node<T> nodeToRemove) {
        if (nodeToRemove == null || head == null) {
            return false;
        }

        // 삭제하려는 노드가 head인 경우 (O(1))
        if (nodeToRemove == head) {
            head = head.getNext();
            size--;
            return true;
        }

        // 그 외의 경우: prev 노드를 찾아야 함 (O(N))
        Node<T> current = head;
        while (current != null) {
            if (current.getNext() == nodeToRemove) {
                // current가 prev 노드임. 연결 건너뛰기 수행
                current.setNext(nodeToRemove.getNext());
                size--;
                return true;
            }
            current = current.getNext();
        }

        return false; // 리스트에 없는 노드인 경우
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
