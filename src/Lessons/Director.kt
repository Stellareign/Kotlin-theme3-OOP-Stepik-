package Lessons

import Tasks.Consultant

class Director(
    val name: String,
    val age: Int
) {

    fun takeCoffee(secretary: Secretary, cupCount : Int, coffeeNme : String) {
        var coffeeName  = secretary.yourCoffee(cupCount);
        println("Thank Yuo, ${secretary.name}. $coffeeName is very good. :)")
    }

    fun makeConsultantToWork(consultant: Consultant){
       val clientCount =  consultant.clientService();
        println("Consultant ${consultant.name} service for ${clientCount} clients")
    }

}