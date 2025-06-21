package Lessons.corparation.parents

import Lessons.corparation.enum.Workers

open class Worker(
    protected val id: Int,
    protected val name: String,
    protected val age: Int = 0,
    protected val post: Workers
) {
    open fun work() {
        println("I'm working")
    }

    override fun toString(): String {
        return "id: $id, имя: $name, возраст: $age, должность: $post"
    }

}