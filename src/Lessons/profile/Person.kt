package Lessons.profile

class Person(
    private var name: String = "",
    private var surname: String = "",
    private var height: Int = 0,
    private var weight: Int = 0
) {

    constructor (name: String, surname: String, height: Int, weight: Int, age: Int) : this(
        name,
        surname,
        height,
        weight
    ) {
        this.age = age
    }

    val fullName
        get() = "$name $surname"


fun init(name: String, surname: String, age: Int, height: Int, weight: Int) {
    this.name = name;
    this.surname = surname;
    this.age = age;
    this.height = height;
    this.weight = weight;
}

var age = 0
    set(value: Int) {
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