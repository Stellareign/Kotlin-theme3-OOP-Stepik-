package Lessons.corparationDataClass.employees

import Lessons.corparationDataClass.enum.Workers
import Lessons.corparationDataClass.parents.Worker
import kotlin.random.Random

/**
 * Класс в дополнение к корпорации
 */
data class Consultant(
    override val  id: Int,
    override val  name: String,
    override val   age: Int,
    override val salary : Int
// если поле необязательное, ему надо присвоить значение
) : Worker(id, name, age, Workers.CONSULTANT, salary = salary) {


    override fun copy(salary: Int, age: Int): Consultant { //метод создания копии объекта - алее сохраняется в коллекцию вместо старого
        return Consultant(this.id, this.name, age, salary)
    }

     override fun work() {
        println("I'm make consultation")
    }

    override fun printInfo()  {
        println(toString())
    }

    override fun toString(): String {
       return "Консультант: id: $id, name: $name, age: $age, post: $post, salary: $salary"
    }
}