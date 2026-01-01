package covariant

open class Food()
class Pizza : Food()

interface Restaurant<out T> {
    fun serve(): T
}

class PizzaRestaurant : Restaurant<Pizza> {
    override fun serve(): Pizza = Pizza()
}

interface Critic<in T> {
    fun evaluate(item: T) // T를 안으로(in) 받습니다.
}

class FoodCritic : Critic<Food> {
    override fun evaluate(item: Food) {
        println("음 훌륭한 음식이군: $item")
    }
}

fun main() {
    // [공변성 테스트]
    // 피자 식당은 음식 식당으로 취급될 수 있습니다.
    val pizzaRestaurant: Restaurant<Pizza> = PizzaRestaurant()
    val foodRestaurant: Restaurant<Food> = pizzaRestaurant
    val food = foodRestaurant.serve()
    println(food::class.java)

    // [반공변성 테스트]
    // 음식 평론가는 피자 평론가 자리에 대신 갈 수 있습니다.
    val foodCritic: Critic<Food> = FoodCritic()
    val pizzaCritic: Critic<Pizza> = foodCritic
    pizzaCritic.evaluate(Pizza())
}

/*

- out : 해당 인터페이스에서는 T 를 입력 받지 않고 출력만 하겠다고 컴파일러에게 약속하는 행위. 그러므로 T에 T1, T2, T3.. 이 와도 최상위 부모인 T로 취급해도 된다.
    * 왜 안전한가? (Why Safe?):
      만약 T를 입력(소비)할 수 있다면, `Restaurant<Food>` 타입 변수에 `PizzaRestaurant`가 할당되었을 때,
      `restock(Burger())` 같은 호출이 가능해집니다. (Burger는 Food이므로).
      하지만 실제 객체는 `PizzaRestaurant`이므로 Burger를 저장할 수 없어 런타임 오류가 발생합니다.
      `out`은 입력 메서드 자체를 컴파일 단계에서 금지함으로써, 잘못된 타입이 들어가는 상황을 원천 봉쇄하여 안전성을 보장합니다.

- in : 해당 인터페이스에서는 T 를 출력 하지 않고 입력만 하겠다고 컴파일러에게 약속하는 행위.
    * 왜 안전한가? (Why Safe?):
      `Food`를 평가할 수 있는 평론가(`Critic<Food>`)는 당연히 `Pizza`도 평가할 수 있습니다. (Pizza는 Food이므로).
      따라서 `Critic<Pizza>`(피자 평론가)가 필요한 자리에 `Critic<Food>`(음식 평론가)를 배치해도 논리적으로 안전합니다.
      이 때문에 컴파일러는 `Critic<Food>`를 `Critic<Pizza>`의 **하위 타입**으로 간주합니다.
      하위 타입을 상위 타입 변수에 대입하는 것(Upcasting)이므로, **명시적 캐스팅이 필요 없습니다.**

*/
