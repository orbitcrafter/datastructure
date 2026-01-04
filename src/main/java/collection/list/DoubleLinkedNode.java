package collection.list;

public class DoubleLinkedNode<T> {

    private T item;
    private DoubleLinkedNode<T> previousNode;
    private DoubleLinkedNode<T> nextNode;

    public DoubleLinkedNode() {
    }

    public DoubleLinkedNode(T item, DoubleLinkedNode<T> previousNode, DoubleLinkedNode<T> nextNode) {
        this.item = item;
        this.previousNode = previousNode;
        this.nextNode = nextNode;
    }

    public DoubleLinkedNode<T> getNextNode() {
        return nextNode;
    }

    public DoubleLinkedNode<T> getPreviousNode() {
        return previousNode;
    }

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }

    public void setNextNode(DoubleLinkedNode<T> nextNode) {
        this.nextNode = nextNode;
    }

    public void setPreviousNode(DoubleLinkedNode<T> previousNode) {
        this.previousNode = previousNode;
    }
}
