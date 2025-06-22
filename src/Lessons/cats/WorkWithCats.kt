package Lessons.cats

fun main() {
    val cat = Cat("Sam");
    val lion = Lion(15);
//    println(cat.powCount);
//    println(cat.name);
//    println(lion.lionsCountInPride);
//    println(lion.powCount)
//    cat.playWithMouse();
//    cat.eat()
//    lion.eat()
val catsFamilyList = listOf(cat, lion);
    for (cat in catsFamilyList) {
        cat.eat();
    }
}