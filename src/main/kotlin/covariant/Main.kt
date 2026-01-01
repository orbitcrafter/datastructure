package covariant

open class Food
class Pizza : Food()
class Burger : Food()

// 1. Covariance (공변성, out): 생산자 역할
// T를 반환(get)만 할 수 있고, 입력(set)받을 수 없음.
interface Restaurant<out T> {
    fun serve(): T
}

class PizzaRestaurant : Restaurant<Pizza> {
    override fun serve(): Pizza = Pizza()
}

// 2. Contravariance (반공변성, in): 소비자 역할
// T를 입력(set)으로만 받을 수 있고, 반환(get)할 수 없음.
interface TrashCan<in T> {
    fun dispose(item: T)
}

class GeneralTrashCan : TrashCan<Food> {
    override fun dispose(item: Food) {
        println("Disposing: ${item::class.simpleName}")
    }
}

fun main() {
    // --- 공변성 (out) 예시 ---
    // Pizza는 Food이므로, Pizza 식당은 Food 식당으로 취급될 수 있다.
    val pizzaRestaurant: Restaurant<Pizza> = PizzaRestaurant()
    val foodRestaurant: Restaurant<Food> = pizzaRestaurant // out 덕분에 가능!
    
    val myFood: Food = foodRestaurant.serve()
    println("Served: ${myFood::class.simpleName}")


    // --- 반공변성 (in) 예시 ---
    // Food를 버릴 수 있는 쓰레기통은 Pizza도 당연히 버릴 수 있다.
    val generalTrashCan: TrashCan<Food> = GeneralTrashCan()
    val pizzaTrashCan: TrashCan<Pizza> = generalTrashCan // in 덕분에 가능! (방향 반대)
    
    pizzaTrashCan.dispose(Pizza())
}