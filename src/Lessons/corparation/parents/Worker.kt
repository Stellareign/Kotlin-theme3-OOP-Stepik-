package Lessons.corparation.parents

import Lessons.corparation.enum.Workers

abstract class Worker(
    val id: Int,
    val name: String,
    val age: Int = 0,
    val post: Workers
) {
    abstract fun work()


    override fun toString(): String {
        return "id: $id, имя: $name, возраст: $age, должность: $post"
    }


}