package Lessons.corparationDataClass.employees

import Lessons.corparationDataClass.employees.Secretary
import Lessons.corparationDataClass.enum.Workers
import Lessons.corparationDataClass.parents.Worker

data class Director (
    override val id: Int,
    override val name: String, // здесь уже ключевое слово val не нужно, так как у наследника это не поле, а свойство, наследуемое родителя
    override val  age: Int,
    override val salary: Int
) : Worker(id, name, age, Workers.DIRECTOR, salary), Cleaner, Supplier {

    override fun delivery() {
        println("${name}: доставляю товары")
    }
    fun takeCoffee(secretary: Secretary, cupCount : Int, coffeeName : String) {
        secretary.yourCoffee(cupCount, coffeeName);
        println("Thank Yuo, ${secretary.name}. $coffeeName is very good. :)")
    }
    override fun equals(other: Any?): Boolean {
        return super.equals(other)
    }


    override fun work() {
        println("I'm drink coffee")
    }
    override fun copy(salary: Int, age: Int): Director { //метод создания копии объекта - алее сохраняется в коллекцию вместо старого
        return Director(this.id, this.name, age, salary)
    }


    override fun toString(): String {
        return "Директор: id: $id, name: $name, age: $age, post: $post, salary: $salary"
    }

    override fun printInfo(){
       println(toString())
    }
}