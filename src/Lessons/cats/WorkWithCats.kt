package Lessons.cats

fun main() {
    val cat = Cat("Sam");
    println(cat.powCount);
    println(cat.name);
    val lion = Lion(15);
    println(lion.lionsCountInPride);
    println(lion.powCount)
    cat.playWithMouse();

}