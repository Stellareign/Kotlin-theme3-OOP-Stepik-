package Tasks

import kotlin.random.Random

/**
 * Класс в дополнение к корпорации
 */
class Consultant(
    val name: String,
    val age: Int = 0 // если поле необязательное, ему надо присвоить значение
) {


    fun hello() {
        if (age > 0) {
            println("Hello! My name is $name! I'm $age years old")
        } else {
            println("Hello! My name is $name.")
        }
    }

    fun clientService(clientCount: Int = Random.nextInt(1, 10)): Int {
        repeat(clientCount) {
            println("Client service")
        }
        return clientCount;
    }
}