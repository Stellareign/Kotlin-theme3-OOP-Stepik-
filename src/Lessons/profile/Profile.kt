package Lessons.profile

fun main() {
//    val first: Person = Person();
//    val first2: Person = Person();
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
//    first.run();
//    val secretary : Secretary = Secretary();

//    secretary.yourCoffee(5,"Cappuccino");
//    first.init(name =readln(), surname = readln(), age = readln().toInt(), height = readln().toInt(), weight = readln().toInt() );
//    first.printInfo();
//    first.sayHello();
//    first.age
//    first.age = 38
//    first.age
//    print(first.fullName)
    val pers1 =Person ("Asd", "SDf", 175, 75, 35)
    val pers2 =Person ("Ann", "Sox", 156, 55, 30)
    val pers3 =Person ("Nancy", "Druy", 165, 58, 28)
    val pers4 =Person ("Cate", "Mitty", 160, 48, 43)
    val pers5 =Person ("Cate", "Mitty", 160, 48, 43)
    val pers6 = pers3.copy()
    val persSet = setOf( pers1, pers2, pers3, pers4, pers5, pers6)
    persSet.forEach {person -> println(person)}
}
