package collection.list;

public class JArrayListTest {

    public static void main(String[] args) {
        System.out.println("========== JArrayList Test Start ==========");
        JArrayList<String> list = new JArrayList<>();

        // 1. insertLast 테스트
        System.out.println("\n[1] insertLast: A, B, C");
        list.insertLast("A");
        list.insertLast("B");
        list.insertLast("C");
        printList(list);

        // 2. insert (중간 삽입) 테스트
        System.out.println("\n[2] insert('INSERTED', 1)");
        list.insert("INSERTED", 1);
        printList(list); // 예상: [A, INSERTED, B, C]

        // 3. get 테스트
        System.out.println("\n[3] get(2)");
        System.out.println("Value at index 2: " + list.get(2)); // 예상: B

        // 4. remove 테스트
        System.out.println("\n[4] remove(2) (Value 'B' should be removed)");
        list.remove(2);
        printList(list); // 예상: [A, INSERTED, C]

        // 5. Resize 테스트 (초기 용량 10을 초과해보기)
        System.out.println("\n[5] Resize Test (Adding 15 items to new list)");
        JArrayList<Integer> intList = new JArrayList<>();
        for (int i = 0; i < 15; i++) {
            intList.insertLast(i);
        }
        printList(intList);
        System.out.println("Resize successful! Size: " + intList.size());

        // 6. 예외 처리 테스트
        System.out.println("\n[6] Exception Test");
        try {
            System.out.println("Try removing at invalid index 100...");
            list.remove(100);
        } catch (Exception e) {
            System.out.println("Caught Expected Exception: " + e);
        }

        System.out.println("\n========== JArrayList Test End ==========");
    }

    // 리스트 출력 헬퍼 함수
    private static <E> void printList(JArrayList<E> list) {
        System.out.print("List (Size " + list.size() + "): [");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
            if (i < list.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}
