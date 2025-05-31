package Lessons

class Secretary {
    var name = "";


    fun yourCoffee(count: Int, coffeeName: String) {
        repeat(count) {
            println("Stand up")
            println("Go at coffee machine")
            println("Make coffee $coffeeName for you")
            println("Your coffee")
        }
    }

}