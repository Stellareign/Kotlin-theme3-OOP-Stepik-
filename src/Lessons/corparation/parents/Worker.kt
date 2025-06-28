package Lessons.corparation.parents

import Lessons.corparation.enum.Workers
import com.sun.tools.javac.code.TypeAnnotationPosition.field
import java.lang.reflect.Array.set

abstract class Worker(
    val id: Int,
    val name: String,
    val age: Int = 0,
    val post: Workers,
) {
   private var salary: Int = 15_000;
    fun setSalary(value : Int){
        salary = value;
    }
    fun getSalary() : Int{
        return this.salary;
    }

    abstract fun work()

    override fun toString(): String {
        return "Worker(id: $id, name: $name, aga: $age, post: $post, salary: ${getSalary()})"
    }

}