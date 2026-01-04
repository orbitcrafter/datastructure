package collection.list;

public class SingleLinkedNode<T> {

    private T item;
    private SingleLinkedNode<T> next;

    public SingleLinkedNode(T item, SingleLinkedNode<T> next) {
        this.item = item;
        this.next = next;
    }

    public T getItem() {
        return this.item;
    }

    public SingleLinkedNode<T> getNext() {
        return next;
    }

    public void setNext(SingleLinkedNode<T> nextSingleLinkedNode) {
        next = nextSingleLinkedNode;
    }
}
