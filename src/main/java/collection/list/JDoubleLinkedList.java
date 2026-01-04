package collection.list;

public class JDoubleLinkedList<T> {

    private DoubleLinkedNode<T> head;
    private DoubleLinkedNode<T> tail;
    private int size;

    public JDoubleLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    // 시간복잡도 : O(1)
    public void insertLast(T newItem) {
        DoubleLinkedNode<T> newNode = new DoubleLinkedNode<>(newItem, tail, null);

        if (size == 0) {
            head = newNode;
        } else {
            tail.setNextNode(newNode);
        }

        tail = newNode;
        size++;
    }

    // 시간복잡도 : O(1) (단방향에서는 앞 노드를 알기 위해서 O(N) 으로 탐색이 필요하지만 양방향에서는 이미 앞 노드 참조값이 있어서 O(1)로 가능)
    public void insertBefore(DoubleLinkedNode<T> targetNode, T newItem) {
        DoubleLinkedNode<T> prevNode = targetNode.getPreviousNode();
        DoubleLinkedNode<T> newNode = new DoubleLinkedNode<>(newItem, prevNode, targetNode);

        if (prevNode != null) {
            prevNode.setNextNode(newNode);
        } else {
            head = newNode;
        }

        targetNode.setPreviousNode(newNode);
        size++;
    }

    public void print() {
        DoubleLinkedNode<T> current = head;
        System.out.print("[");
        while (current != null) {
            System.out.print(current.getItem());
            if (current.getNextNode() != null) {
                System.out.print(", ");
            }
            current = current.getNextNode();
        }
        System.out.println("]");
    }

    public DoubleLinkedNode<T> searchNode(T target) {
        DoubleLinkedNode<T> current = head;
        while (current != null) {
            if (current.getItem().equals(target)) {
                return current;
            }
            current = current.getNextNode();
        }
        return null;
    }

}
