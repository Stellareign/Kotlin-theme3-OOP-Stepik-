package Lessons.corparation

class Secretary(
    name: String,
    age: Int
) : Worker (name, age) {



    fun yourCoffee(count: Int, coffeeName: String = "Cappuccino") : String {
        repeat(count) {
            println("Stand up")
            println("Go at coffee machine")
            println("Make coffee $coffeeName for you")
            println("Your coffee")
        }
//        return coffeeName;
        return "Espresso";
    }
    override fun work() {
        println("I'm make coffee")
    }

}