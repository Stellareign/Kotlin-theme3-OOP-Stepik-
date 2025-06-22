package Lessons.cats

class Cat (val name : String): CatsFamily() {

    fun playWithMouse() {
        println("I can play with mouse")
    }
    override fun eat() {
        println("I am eating Royal Canin")
    }
}