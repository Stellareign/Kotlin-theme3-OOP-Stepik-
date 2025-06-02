package Lessons

class Secretary(val name : String) {



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

}