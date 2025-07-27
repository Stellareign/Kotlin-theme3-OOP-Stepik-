package Lessons.corparation.employees

import Lessons.corparation.enum.Workers
import Lessons.corparation.parents.Worker
import kotlin.random.Random

/**
 * Класс в дополнение к корпорации
 */
class Consultant(
    id: Int,
    name: String,
    age: Int,
   salary : Int
// если поле необязательное, ему надо присвоить значение
) : Worker(id, name, age, Workers.CONSULTANT, salary = salary) {

    // вторичный конструктор для создания пустых объектов:
    constructor() : this(
        id = 0,
        name = "",
        age = 0,
        salary = 0
    )
    fun hello() {
        if (age > 0) {
            println("Hello! My name is $name! I'm $age years old")
        } else {
            println("Hello! My name is $name.")
        }
    }

    override fun copy(salary: Int, age: Int): Consultant { //метод создания копии объекта - алее сохраняется в коллекцию вместо старого
        return Consultant(this.id, this.name, age, salary)
    }

    fun clientService(clientCount: Int = Random.Default.nextInt(1, 10)): Int {
        repeat(clientCount) {
            println("Client service")
        }
        return clientCount;
    }
    override fun work() {
        println("I'm make consultation")
    }

   override fun toString(): String {
       return "id: $id, name: $name, age: $age, post: $post, salary: ${getSalary()}"
    }
}