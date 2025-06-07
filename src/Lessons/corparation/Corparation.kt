package Lessons.corparation

import Lessons.corparation.employees.Accountant
import Lessons.corparation.employees.Consultant
import Lessons.corparation.employees.Director
import Lessons.corparation.employees.Secretary
import Lessons.corparation.parents.Worker

fun main() {
//    print("Enter name: ");
//    val productName = readln();
//    print("Enter brand: ");
//    val productBrand = readln();
//    print("Enter size: ");
//    val size = readln().toFloat();
//    print("Enter price: ");
//    val productPrice = readln().toDouble();
//    val productCard = ProductCard(productName= productName, brand = productBrand, size, productPrice);
//    // можно (нужно) использовать именованные
//    //параметры для параметров одного типа, идущих подряд - это облегчает читаемость кода, понятно какому полю что присваивается
//
//    productCard.pintInfo();

    val consultant = Consultant("Max", 32)
//    val consult2 : Consultant = Consultant("Mark")
//    consult.hello();
//    consult2.hello();
    val director = Director("BigBoss", 45);
//    val secretary : Secretary = Secretary(name = "Lessy");
//    director.takeCoffee(secretary, 1, "Mocco")
//    consult.clientService()
    val secretary = Secretary("Beatriss", 35);
//    director.makeConsultantToWork(consult   )
    val accountant = Accountant("Lisa", 45)
    val employees  = listOf<Worker>(director, consultant, secretary, accountant);

    for(employee in employees) {
        employee.work();
    }

}
