package Lessons.corparation.employees

import Lessons.corparation.parents.Worker

class Director  (
    name: String, // здесь уже ключевое слово val не нужно, так как у
    // наследника это не поле, а свойство, наследуемое родителя
    age: Int
) : Worker(name, age){

    fun takeCoffee(secretary: Secretary, cupCount : Int, coffeeNme : String) {
        var coffeeName  = secretary.yourCoffee(cupCount);
        println("Thank Yuo, ${secretary.name}. $coffeeName is very good. :)")
    }

    fun makeConsultantToWork(consultant: Consultant){
       val clientCount =  consultant.clientService();
        println("Consultant ${consultant.name} service for ${clientCount} clients")
    }
    override fun work() {
        println("I'm drink coffee")
    }


}