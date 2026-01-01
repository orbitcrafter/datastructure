package covariant

interface Food
class Pizza : Food

interface Restaurant<out T>
class PizzaRestaurant : Restaurant<Pizza>

interface Critic<in T> {
    fun evaluate(item: T) // T를 받아서 '평가'함 (소비)
}

class FoodCritic : Critic<Food> {
    override fun evaluate(item: Food) = println("맛 평가 중: $item")
}

fun main() {
    // [out: 공급자] 피자 맛집은 '맛집(Food)'이라고 불러도 된다.
    val foodRestaurant: Restaurant<Food> = PizzaRestaurant()

    // [in: 소비자] 미식가(Food)는 '피자 평가단(Pizza)'에 들어가도 된다.
    val foodCritic: Critic<Food> = FoodCritic()
    val pizzaCritic: Critic<Pizza> = foodCritic
    pizzaCritic.evaluate(Pizza())
}

/*

### 공변성, 반공변성 사용 목적
상속 관계를 가진 클래스들(T1, T2, T3 ...)을 Generic 으로 다루는 클래스들의 포함관계를 유연하게 다루기 위함.
기본적으로 제네릭은 **무공변(Invariant)**이라 서로 관계가 없다. (Pizza는 Food이지만, Restaurant<Pizza>는 Restaurant<Food>가 아님).

**이를 해결하기 위해, 상속 관계를 가진 클래스들을 제네릭으로 다룰 때 **포함 관계(Subtyping)를 유연하고 안전하게 확장**하는 것이 목적.**

### 기술적 제약 사항 (Technical Constraints)
- **out T (공변성)**:
    - `T`는 함수의 **반환 타입(Return Type)**으로만 사용 가능하다. (읽기 전용)
    - `T`를 파라미터(Input)로 받는 함수는 만들 수 없다. (**소비 금지**)
    - 이유: `Restaurant<Food>`로 업캐스팅된 상태에서 `Burger`를 입력받으면, 실제 객체인 `Restaurant<Pizza>`가 처리할 수 없기 때문.

- **in T (반공변성)**:
    - `T`는 함수의 **파라미터(Parameter)**로만 사용 가능하다. (쓰기 전용)
    - `T`를 반환(Return)하는 함수는 만들 수 없다. (**생산 금지**)
    - 이유: `Critic<Pizza>`로 취급될 때 `Pizza`를 반환해야 하는데, 실제 객체인 `Critic<Food>`가 `Burger`를 반환해버리면 타입 안전성이 깨지기 때문.

### 핵심 질문: 왜 '반환(out)'만 해야 상속 관계(공변성)가 성립하는가?
**"사용자(Caller)의 기대"**와 **"실제 반환값"**의 관계 때문입니다.

1. **계약(Contract)**: `Restaurant<Food>`를 가진 사람은 "이 식당은 최소한 **Food**를 준다"고 믿습니다.
2. **실행(Execution)**: `Restaurant<Pizza>`는 **Pizza**를 줍니다.
3. **검증(Verification)**: Pizza는 Food인가요? **네.**
   - **결론**: 반환(out) 위치에서는 **자식(Pizza)**이 **부모(Food)**를 완벽히 대체할 수 있습니다. (key)
   - 그렇기 때문에 `out T`라고 선언하면, `Gen<Pizza>`가 `Gen<Food>`의 자식처럼 행동할 수 있게 허용(공변)하는 것입니다.

### 핵심 질문: 왜 '입력(in)'만 해야 역방향 상속 관계(반공변성)가 성립하는가?
**"사용자(Caller)의 제공값"**과 **"실제 객체의 수용 능력"**의 관계 때문입니다.

1. **계약(Contract)**: `Critic<Pizza>`를 가진 사람은 "내가 **Pizza**를 주면 이 평론가가 받아줄 거야"라고 믿습니다.
2. **실행(Execution)**: 실제 객체인 `Critic<Food>`는 **모든 Food**를 받을 수 있는 능력이 있습니다.
3. **검증(Verification)**: `Critic<Food>`는 Pizza를 받을 수 있나요? **네.** (Pizza는 Food의 일종이니까요)
   - **결론**: 입력(in) 위치에서는 **부모(Food) 소비자**가 **자식(Pizza) 소비자**를 완벽히 대체할 수 있습니다. (key)
   - 그렇기 때문에 `in T`라고 선언하면, `Gen<Food>`가 `Gen<Pizza>`의 자식(하위 타입)처럼 행동할 수 있게 허용(반공변)하는 것입니다.

*/
