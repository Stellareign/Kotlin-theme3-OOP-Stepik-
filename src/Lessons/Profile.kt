package Lessons

fun main() {
    val first: Person = Person();
//    val second: Person = Person();
//    print("Enter your name: ")
//    first.name = readln();
//    print("Enter your age: ")
//    first.age = readln().toInt();
//    print("Enter your height: ")
//    first.height = readln().toInt();
//    print("Enter your weight: ")
//    first.weight = readln().toInt();


//    print("Enter your name: ")
//    second.name = readln();
//    print("Enter your age: ")
//    second.age = readln().toInt();
//    print("Enter your height: ")
//    second.height = readln().toInt();
//    print("Enter your weight: ")
//    second.weight = readln().toInt();


//    println("1 name ${first.name}, \nage ${first.age}, \nheight ${first.height}, \nweight ${first.weight}");
//    println("2 name ${second.name}, \nage ${second.age}, \nheight ${second.height}, \nweight ${second.weight}");

//    first.sayHello();
//    second.sayHello();
//    first.ran();
//    val secretary : Secretary = Secretary();

//    secretary.yourCoffee(5,"Cappuccino");
    first.init(name =readln(), age = readln().toInt(), height = readln().toInt(), weight = readln().toInt() );
    first.printInfo();
    first.sayHello();
}
