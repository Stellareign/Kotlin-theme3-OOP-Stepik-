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
    age: Int // если поле необязательное, ему надо присвоить значение
) : Worker(id, name, age, Workers.CONSULTANT) {


    fun hello() {
        if (age > 0) {
            println("Hello! My name is $name! I'm $age years old")
        } else {
            println("Hello! My name is $name.")
        }
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
}