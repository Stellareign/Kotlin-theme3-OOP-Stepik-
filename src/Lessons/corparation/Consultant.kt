package Lessons.corparation

import kotlin.random.Random

/**
 * Класс в дополнение к корпорации
 */
class Consultant(
    name: String,
    age: Int // если поле необязательное, ему надо присвоить значение
) : Worker(name, age) {


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
}