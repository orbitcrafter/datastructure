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
        
        System.out.print("Current List: ");
        list.print(); // 예상: [A, B, C]
        System.out.println("Size: " + list.size()); // 예상: 3

        // 2. searchNode 테스트
        System.out.println("\n[2] searchNode('B')");
        Node<String> nodeB = list.searchNode("B");
        if (nodeB != null) {
            System.out.println("Found Node with item: " + nodeB.getItem());
        } else {
            System.out.println("Node not found!");
        }

        // 3. insertAfter 테스트 (B 뒤에 삽입)
        System.out.println("\n[3] insertAfter('InsertedItem', Node('B'))");
        if (nodeB != null) {
            list.insertAfter("InsertedItem", nodeB);
            list.print(); // 예상: [A, B, InsertedItem, C]
            System.out.println("Size: " + list.size()); // 예상: 4
        } else {
            System.out.println("Cannot test insertAfter: Node 'B' not found.");
        }

        // 4. 없는 값 검색
        System.out.println("\n[4] search('Z') (Not exists)");
        String notFound = list.search("Z");
        System.out.println("Result: " + notFound); // 예상: null

        System.out.println("\n========== JSinglyLinkedList Test End ==========");
    }
}