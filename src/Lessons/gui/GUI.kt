package Lessons.gui

import Lessons.gui.Rectangle

fun main() {
    val rect = Rectangle(10, 5)
    val square = Rectangle(12);
//    rect.draw();
//    square.draw()
    println(rect.area)
    rect.width = 10
    println(rect.area)
}