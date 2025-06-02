package Lessons.gui

class Rectangle(val long: Int, val width: Int) {

    //    constructor(size : Int) { // перегрузка конструктора - создание квадрата
//        this.long = size;
//        this.width = size;
//    }
constructor(size : Int) : this(size, size) {} // вторй вариант квадрата (меньше дублирующегося кода)
constructor() : this(0, 0) {}// пустой конструктор (без дублирования)
 //   constructor() : this(0) - пустой конструктор можно вызывать через любой непустой


    fun draw () {
        repeat(width) {
            repeat(long) {
                print("*  ");
            }
            println();
        }
    }
}