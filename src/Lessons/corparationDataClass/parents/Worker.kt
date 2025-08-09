package Lessons.corparationDataClass.parents

import Lessons.corparationDataClass.enum.Workers

abstract class Worker(
    open val id: Int,
    open val name: String,
    open val age: Int = 0,
    val post: Workers,
    open val salary: Int = 0
) {

    abstract fun work()

    abstract fun copy(salary: Int = this.salary, age: Int = this.age): Worker

    abstract fun printInfo()


// методы иквалс, сеттеры, геттеры, тустринг и хэш-код можно удалить, т.к. они автоматически под капотом генерируются
// в наследных дата-классах, при необходимости их можно переопределить там
}