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

### 용어의 뜻 (Etymology)
- **공변성 (Covariance)**: 공(共, 함께) + 변(變, 변한다).
    - 타입(`T`)의 상속 방향과 제네릭(`List<T>`)의 상속 방향이 **함께(같은 방향으로)** 유지된다.
- **반공변성 (Contravariance)**: 반(反, 반대로) + 공변.
    - 타입(`T`)의 상속 방향과 제네릭(`List<T>`)의 상속 방향이 **반대로(역방향으로)** 뒤집힌다.

### 공변성[out]
핵심은 **"더 구체적인 것(자식)을 주는 것은, 추상적인 것(부모)을 원하는 사람의 기대를 100% 충족시킨다"** 라는 것이다.
ex: "버튼을 누르면 뭐가 나오든 간에, 최소한 **먹을 수 있는 것(Food)**이 나오겠지?"

### 반공변성[in]
핵심은 **"추상적인 것(부모)을 처리할 수 있는 능력은, 구체적인 것(자식)을 처리해야 하는 상황을 100% 커버한다"** 라는 것이다.
ex: "나는 **피자(Pizza)**를 가지고 있는데, 너 **음식(Food)**이면 다 평가할 수 있지? 그럼 내 피자도 평가해줘."

*/
