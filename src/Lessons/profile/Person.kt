package Lessons.profile

class Person(
    private var name: String,
    private var height: Int,
    private var weight: Int
) {

 constructor (name : String, height: Int, weight: Int, age : Int) : this (name, height,  weight ){
     this.age = age
 }

    fun init(name: String, age: Int, height: Int, weight: Int) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.weight = weight;
    }

   var age = 0
    set(value: Int)  {
        if (value < field) {
            println("Возраст не может стать меньше существующего")
        } else {
            field = value;
            println("Возраст стал $field")
        }
    }
    get(): Int {
        println("Спрашивать о возрасте неприлично. Возраст $field ")
        return field
    }

    fun printInfo() {
        println("Name: $name, \nAge: $age, \nHeight: $height, \nWeight: $weight");
    }

    fun sayHello() {
        println("Hello, my name is ${this.name}");
    }

    fun ran() {
        repeat(10) {
            println("I'm run")
        }
    }
}