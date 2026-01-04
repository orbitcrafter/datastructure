package collection.list;

public class JDoubleLinkedListTest {

    public static void main(String[] args) {
        System.out.println("========== JDoubleLinkedList Test Start ==========");
        JDoubleLinkedList<String> list = new JDoubleLinkedList<>();

        // 1. insertLast 테스트 (기본 리스트 구성)
        System.out.println("\n[1] insertLast: A, B, C");
        list.insertLast("A");
        list.insertLast("B");
        list.insertLast("C");
        list.print(); // 예상: [A, B, C]

        // 2. insertBefore 테스트 (중간 삽입)
        System.out.println("\n[2] insertBefore(Node('B'), 'BeforeB')");
        DoubleLinkedNode<String> nodeB = list.searchNode("B");
        if (nodeB != null) {
            list.insertBefore(nodeB, "BeforeB");
            list.print(); // 예상: [A, BeforeB, B, C]
        } else {
            System.out.println("Node B not found!");
        }

        // 3. insertBefore 테스트 (맨 앞 삽입 - Head 갱신 확인)
        System.out.println("\n[3] insertBefore(Node('A'), 'NewHead')");
        DoubleLinkedNode<String> nodeA = list.searchNode("A"); // 현재 Head는 아닐 수 있지만 맨 앞쪽 데이터
        // 'A'가 현재 맨 앞인지 확인: 지금 리스트는 [A, BeforeB, B, C]이므로 A가 맨 앞 맞음.
        
        if (nodeA != null) {
            list.insertBefore(nodeA, "NewHead");
            list.print(); // 예상: [NewHead, A, BeforeB, B, C]
        }

        // 4. insertBefore 테스트 (리스트 끝 부분 테스트는 insertLast와 유사하므로 생략하거나, C 앞에 넣어서 확인 가능)
        System.out.println("\n[4] insertBefore(Node('C'), 'BeforeC')");
        DoubleLinkedNode<String> nodeC = list.searchNode("C");
        if (nodeC != null) {
            list.insertBefore(nodeC, "BeforeC");
            list.print(); // 예상: [NewHead, A, BeforeB, B, BeforeC, C]
        }

        System.out.println("\n========== JDoubleLinkedList Test End ==========");
    }
}