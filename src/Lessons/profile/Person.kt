package Lessons.profile

class Person() {
    var name = "";
    var age = 0;
    var height = 0;
    var weight = 0;

    fun init (name:String,age:Int, height:Int, weight:Int) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.weight = weight;
    }

    fun printInfo() {
        println("Name: $name, \nAge: $age, \nHeight: $height, \nWeight: $weight");
    }

    fun sayHello(){
        println("Hello, my name is ${this.name}");
    }

    fun ran(){
       repeat (10){
            println("I'm run")
        }
    }
}