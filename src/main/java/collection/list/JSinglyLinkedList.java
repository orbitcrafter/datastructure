package collection.list;

public class JSinglyLinkedList<T> {

    private SingleLinkedNode<T> head;
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

        SingleLinkedNode<T> currentSingleLinkedNode = head;
        while (currentSingleLinkedNode != null) {
            T currentItem = currentSingleLinkedNode.getItem();

            if (target.equals(currentItem)) {
                return currentItem;
            } else {
                currentSingleLinkedNode = currentSingleLinkedNode.getNext();
            }
        }

        return null;
    }

    // 시간복잡도 : O(N) (prev를 찾기 위해 탐색해야 함)
    public boolean removeNode(SingleLinkedNode<T> singleLinkedNodeToRemove) {
        if (singleLinkedNodeToRemove == null || head == null) {
            return false;
        }

        // 삭제하려는 노드가 head인 경우 (O(1))
        if (singleLinkedNodeToRemove == head) {
            head = head.getNext();
            size--;
            return true;
        }

        // 그 외의 경우: prev 노드를 찾아야 함 (O(N))
        SingleLinkedNode<T> current = head;
        while (current != null) {
            if (current.getNext() == singleLinkedNodeToRemove) {
                // current가 prev 노드임. 연결 건너뛰기 수행
                current.setNext(singleLinkedNodeToRemove.getNext());
                size--;
                return true;
            }
            current = current.getNext();
        }

        return false; // 리스트에 없는 노드인 경우
    }

    // 시간복잡도 : O(N)
    public SingleLinkedNode<T> searchNode(T target) {
        if (target == null) {
            return null;
        }

        SingleLinkedNode<T> currentSingleLinkedNode = head;
        while (currentSingleLinkedNode != null) {
            T currentItem = currentSingleLinkedNode.getItem();

            if (target.equals(currentItem)) {
                return currentSingleLinkedNode;
            } else {
                currentSingleLinkedNode = currentSingleLinkedNode.getNext();
            }
        }

        return null;
    }

    // 시간복잡도 : O(1)
    public void insertAfter(T newItem, SingleLinkedNode<T> singleLinkedNode) {
        if (singleLinkedNode == null) return;
        SingleLinkedNode<T> newSingleLinkedNode = new SingleLinkedNode<>(newItem, singleLinkedNode.getNext());
        singleLinkedNode.setNext(newSingleLinkedNode);
        size++;
    }

    // 시간복잡도 : O(1)
    public void insertFront(T newItem) {
        head = new SingleLinkedNode<>(newItem, head);
        size++;
    }

    public int size() {
        return size;
    }

    public void print() {
        SingleLinkedNode<T> current = head;
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
