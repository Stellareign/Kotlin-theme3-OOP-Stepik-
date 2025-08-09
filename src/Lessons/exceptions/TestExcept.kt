package Lessons.exceptions

fun main() {

//    try {
//        val a = readLine()!!.toInt()
//        val b = readLine()!!.toInt()
//        println(a / b)
//    } catch (e: Exception) {
//        println(e)
//    }
//    println("Программа продолжила работу")
    val numberList = listOf(1, 2, 3, 4, 5)
    try {
        println(numberList[-5])
    } catch (e: ArrayIndexOutOfBoundsException) {
        println(e.message)

    }
}