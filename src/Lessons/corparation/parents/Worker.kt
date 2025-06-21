package Lessons.corparation.parents

import Lessons.corparation.enum.Workers

open class Worker(
    val id: Int,
    val name: String,
    val age: Int = 0,
    val post: Workers
) {
    open fun work() {
        println("I'm working")
    }


    override fun toString(): String {
        return "id: $id, имя: $name, возраст: $age, должность: $post"
    }


}