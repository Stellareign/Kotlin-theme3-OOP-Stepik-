package Lessons.cats

class Lion (val lionsCountInPride : Int) : CatsFamily() {
    override fun eat() {
        println("I am eating meet")
    }
}