package Lessons.corparation.parents

import Lessons.corparation.employees.Accountant
import Lessons.corparation.enum.Workers
import com.sun.tools.javac.code.TypeAnnotationPosition.field
import java.lang.reflect.Array.set

abstract class Worker(
    val id: Int,
    val name: String,
    val age: Int = 0,
    val post: Workers,
    private val salary: Int = 0
) {

    abstract fun work()

    abstract fun copy(salary: Int = this.salary, age: Int = this.age) : Worker
    //при указании значения поля в методе
    // (this.age, this.salary, например), оно становится необязательным для передачи в методе

    fun getSalary ()=this.salary;

//    fun setSalary (salary: Int) {
//            if (salary < this.salary) {
//                println("Зарплата не может стать меньше существующей")
//            } else {
//                this.salary = salary;
//                println("Сотрудник ${this.name} теперь получает зарплату $salary")
//            }
//    }

    override fun toString(): String {
        return "Worker(id: $id, name: $name, age: $age, post: $post, salary: $salary)"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Worker

        if (id != other.id) return false
        if (age != other.age) return false
        if (salary != other.salary) return false
        if (name != other.name) return false
        if (post != other.post) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id
        result = 31 * result + age
        result = 31 * result + salary
        result = 31 * result + name.hashCode()
        result = 31 * result + post.hashCode()
        return result
    }

}