package collection.list;

public class JSinglyLinkedListTest {

    public static void main(String[] args) {
        System.out.println("========== JSinglyLinkedList Test Start ==========");
        JSinglyLinkedList<String> list = new JSinglyLinkedList<>();

        // 1. insertFront 테스트
        System.out.println("\n[1] insertFront: C -> B -> A");
        list.insertFront("C");
        list.insertFront("B");
        list.insertFront("A");
        list.print(); // 예상: [A, B, C]

        // 2. searchNode & insertAfter 테스트
        System.out.println("\n[2] searchNode('B') & insertAfter('Inserted', Node('B'))");
        Node<String> nodeB = list.searchNode("B");
        if (nodeB != null) {
            list.insertAfter("Inserted", nodeB);
            list.print(); // 예상: [A, B, Inserted, C]
        }

        // 3. removeNode 테스트 (O(N) 삭제)
        System.out.println("\n[3] removeNode(Node('B')) - O(N)");
        // 아까 찾은 nodeB를 그대로 사용해서 삭제 시도
        boolean removed = list.removeNode(nodeB);
        System.out.println("Removed successfully? " + removed);
        list.print(); // 예상: [A, Inserted, C] (B가 사라져야 함)
        System.out.println("Size: " + list.size()); // 예상: 3

        // 4. 없는 노드 삭제 시도
        System.out.println("\n[4] removeNode(new Node('Z')) (Not in list)");
        Node<String> fakeNode = new Node<>("Z", null);
        boolean removedFake = list.removeNode(fakeNode);
        System.out.println("Removed fake node? " + removedFake); // 예상: false

        System.out.println("\n========== JSinglyLinkedList Test End ==========");
    }
}
