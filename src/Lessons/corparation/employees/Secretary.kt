package Lessons.corparation.employees

import Lessons.corparation.enum.Workers
import Lessons.corparation.parents.Worker

class Secretary(
    id : Int,
    name: String,
    age: Int,
    salary: Int
) : Worker(id, name, age, Workers.SECRETARY, salary) {

    // вторичный конструктор для создания пустых объектов:
    constructor() : this(
        id = 0,
        name = "",
        age = 0,
        salary = 0
    )

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

    override fun copy(salary: Int): Secretary { //метод создания копии объекта - алее сохраняется в коллекцию вместо старого
        return Secretary(this.id, this.name, this.age, salary)
    }
    override fun toString(): String {
        return "id: $id, name: $name, age: $age, post: $post, salary: ${this.getSalary()}"
    }
}