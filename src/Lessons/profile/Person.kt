package Lessons.profile

class Person(
    val name: String,
    val surname: String,
    val height: Int,
    val weight: Int,
    val age : Int
) {

//    constructor (name: String, surname: String, height: Int, weight: Int, age: Int) : this(
//        name = "",
//        surname = "",
//        height = 0,
//        weight = 0
//    ) {
//        this.age = age
//    }


    val fullName
        get() = "$name $surname"


//    fun init(name: String, surname: String, age: Int, height: Int, weight: Int) {
//        this.name = name;
//        this.surname = surname;
//        this.age = age;
//        this.height = height;
//        this.weight = weight;
//    }

//    var age = 0
//        set(value: Int) {
//            if (value < field) {
//                println("Возраст не может стать меньше существующего")
//            } else {
//                field = value;
//                println("Возраст стал $field")
//            }
//        }
//        get(): Int {
//            println("Спрашивать о возрасте неприлично. Возраст $field ")
//            return field
//        }

    fun printInfo() {
        println("Name: $name, \nAge: $age, \nHeight: $height, \nWeight: $weight");
    }

    fun sayHello() {
        println("Hello, my name is ${this.name}");
    }

    fun run() {
        repeat(10) {
            println("I'm run")
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
       if( other == null || this.javaClass != other.javaClass) return false

        other as Person

        if (height != other.height) return false
        if (weight != other.weight) return false
        if (name != other.name) return false
        if (surname != other.surname) return false
        if(age != other.age) return false

        return true
    }


    fun copy(): Person {
        return Person(name, surname, height, weight, age)
    }

    override fun hashCode(): Int {
        var result = height
        result = 31 * result + weight
        result = 31 * result + age
        result = 31 * result + name.hashCode()
        result = 31 * result + surname.hashCode()
        return result
    }

    override fun toString(): String {
        return "Person(name = ${this.fullName}, height = $height, weight = $weight, age = $age)"
    }

}