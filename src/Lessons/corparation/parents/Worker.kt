package Lessons.corparation.parents

import Lessons.corparation.enum.Workers
import com.sun.tools.javac.code.TypeAnnotationPosition.field
import java.lang.reflect.Array.set

abstract class Worker(
    val id: Int,
    val name: String,
    val age: Int = 0,
    val post: Workers,
    var salary : Int = 0
) {
//    var salary: Int = 15_000
//        set(value: Int) {
//            if (value < field) {
//                println("Зарплата не может стать меньше существующей")
//            } else {
//                field = value;
//            }
//        }
//        get() : Int{
//            return field;
//        }
// для корректной работы моего кода необходимо либо внести в первичный конструктор, либо создать вторичный конструктор с полем зарплаты

    abstract fun work()

    override fun toString(): String {
        return "Worker(id: $id, name: $name, age: $age, post: $post, salary: $salary)"
    }

}