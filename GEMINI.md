# Kotlin Collection Framework 직접 구현 프로젝트

## 프로젝트 개요 (Project Overview)
이 프로젝트는 **Kotlin Standard Library**의 컬렉션 프레임워크를 언어 차원에서 직접 재구현(Re-implementation)하는 것을 목표로 합니다.
단순히 자바의 JCF를 감싸는 것이 아니라, 코틀린 특유의 철학인 **불변(Immutable)과 가변(Mutable)의 분리**, **제네릭 공변성(Variance)** 등을 고려하여 밑바닥부터 자료구조를 설계하고 구현합니다.

## 핵심 목표 (Core Objectives)
1.  **자료구조의 심층적 이해**: 데이터가 메모리에 저장되는 원리와 용량 관리, 포인터 조작 등을 직접 구현하며 학습합니다.
2.  **Kotlin 언어 심화 학습**:
    *   **Read-only vs Mutable**: 인터페이스 분리 설계를 이해합니다.
    *   **Generics & Variance**: `out`(공변), `in`(반공변) 키워드를 활용한 타입 안전성 확보를 익힙니다.
    *   **Extension Functions**: `map`, `filter` 등의 고차 함수 구현을 통해 함수형 프로그래밍 패턴을 익힙니다.
3.  **알고리즘 구현**: 정렬, 탐색, 해싱 등의 표준 알고리즘을 구현하고 시간 복잡도를 분석합니다.

## 구현 로드맵 (Implementation Roadmap)
프로젝트는 코틀린의 컬렉션 계층 구조를 따릅니다:

### 1단계: 핵심 인터페이스 (Core Interfaces)
- **Iterable 계층**: `KIterable<out T>` vs `KMutableIterable<T>`
- **Collection 계층**: `KCollection<out T>` vs `KMutableCollection<T>`
- **List 계층**: `KList<out T>` vs `KMutableList<T>`

### 2단계: 선형 자료구조 (Linear Data Structures)
- **리스트 구현**: `KArrayList` (동적 배열), `KLinkedList` (이중 연결 리스트)
- **스택/큐**: `KStack`, `KQueue`, `KDeque`

### 3단계: 비선형 자료구조 (Non-linear Data Structures)
- **맵 (Maps)**: `KMap<K, out V>` vs `KMutableMap<K, V>` (해시 테이블, 트리 기반)
- **셋 (Sets)**: `KSet<out T>` vs `KMutableSet<T>`

## 개발 환경 (Environment)
- **Language**: Kotlin 2.2.0 (JVM Target 21)
- **Build Tool**: Gradle (Kotlin DSL)
- **IDE**: IntelliJ IDEA / VS Code
