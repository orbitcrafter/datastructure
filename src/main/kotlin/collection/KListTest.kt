package collection

fun main() {
    println("=== KArrayList Test Start ===")

    // 1. 생성 및 기본 속성 (Creation & Basic Properties)
    // 중복된 "Kotlin"을 포함하여 리스트 생성
    val list: KList<String> = KArrayList("Java", "Kotlin", "Python", "C++", "Kotlin")
    println("1. Created List: $list")
    println("   Size: ${list.size}") // Expected: 5
    println("   IsEmpty: ${list.isEmpty()}") // Expected: false

    // 2. 조회 및 검색 (Access & Search)
    println("\n2. Access & Search")
    println("   get(1): ${list[1]}") // Expected: Kotlin
    println("   indexOf('Kotlin'): ${list.indexOf("Kotlin")}") // Expected: 1 (앞에서 찾음)
    println("   lastIndexOf('Kotlin'): ${list.lastIndexOf("Kotlin")}") // Expected: 4 (뒤에서 찾음)
    println("   contains('Python'): ${"Python" in list}") // Expected: true (operator fun contains)
    println("   contains('Rust'): ${list.contains("Rust")}") // Expected: false

    // 3. 순회 (Iteration)
    println("\n3. Iteration")
    print("   Forward (for-each): ")
    for (item in list) {
        print("$item ")
    }
    println()

    print("   Backward (using ListIterator): ")
    // 끝에서부터 시작하는 반복자 생성
    val iterator = list.listIterator(list.size)
    while (iterator.hasPrevious()) {
        print("${iterator.previous()} ")
    }
    println()

    // 4. 부분 리스트 (SubList)
    println("\n4. SubList")
    val sub = list.subList(1, 4)
    println("   subList(1, 4): $sub") // Expected: [Kotlin, Python, C++]

    // 5. 동등성 비교 (Equals & HashCode)
    println("\n5. Equals & HashCode")
    val list2 = KArrayList("Java", "Kotlin", "Python", "C++", "Kotlin")
    val list3 = KArrayList("Java", "Kotlin")
    println("   list == list2: ${list == list2}") // Expected: true (내용물이 같으므로)
    println("   list == list3: ${list == list3}") // Expected: false
    println("   list.hashCode() == list2.hashCode(): ${list.hashCode() == list2.hashCode()}") // Expected: true

    // 6. 예외 처리 (Exception Handling)
    println("\n6. Exception Handling")
    try {
        println(list[100]) // 존재하지 않는 인덱스 접근
    } catch (e: IndexOutOfBoundsException) {
        println("   Caught expected exception: ${e.message}")
    }

    println("\n=== KArrayList Test End ===")
}
