package Lessons.corparationDataClass.employees

import Lessons.corparationDataClass.enum.Workers
import Lessons.corparationDataClass.parents.Worker

data class Secretary(
    override val id: Int,
    override val name: String,
    override val age: Int,
    override val salary: Int
) : Worker(id, name, age, Workers.SECRETARY, salary) {

    // вторичный конструктор для создания пустых объектов:
    constructor() : this(
        id = 0,
        name = "",
        age = 0,
        salary = 0
    )

    fun yourCoffee(count: Int, coffeeName: String = "Cappuccino"): String {
        repeat(count) {
            println("Stand up")
            println("Go at coffee machine")
            println("Make coffee $coffeeName for you")
            println("Your coffee")
        }
        return coffeeName;
//        return "Espresso";
    }

    override fun work() {
        println("I'm make coffee")
    }


    override fun copy(
        salary: Int,
        age: Int
    ): Secretary { //метод создания копии объекта - алее сохраняется в коллекцию вместо старого
        return Secretary(this.id, this.name, this.age, salary)
    }

    override fun toString(): String {
        return "Секретарь: id: $id, name: $name, age: $age, post: $post, salary: $salary"
    }

    override fun printInfo() {
        println(toString())
    }
}