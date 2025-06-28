package Lessons.corparation

import Lessons.corparation.employees.Accountant
import Lessons.corparation.employees.Cleaner
import Lessons.corparation.employees.Consultant
import Lessons.corparation.employees.Director
import Lessons.corparation.employees.HR
import Lessons.corparation.employees.Secretary
import Lessons.corparation.employees.Supplier
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

    val consultant = Consultant(0, "Max", 32, 35000)
//    val consult2 : Consultant = Consultant("Mark")
//    consult.hello();
//    consult2.hello();
    val director = Director(0, "BigBoss", 45, 250000);
//    val secretary : Secretary = Secretary(name = "Lessy");
//    director.takeCoffee(secretary, 1, "Mocco")
//    consult.clientService()
    val secretary = Secretary(0, "Beatriss", 35, 45000);
//    director.makeConsultantToWork(consult   )
    val accountant = Accountant(0, "Lisa", 45, 50000)
//    val employees  = listOf<Worker>(director, consultant, secretary, accountant);
//    val hr = HR(0, "Alice", 34);
//
////    for(employee in employees) {
////        employee.work();
////    }
////    accountant.work();
//    for(employee in hr.showAllEmployees()) {
//        if(employee is Cleaner){
//            employee.clean();
//        }
//        if(employee is Supplier){
//            employee.delivery();
//        }
//    }
    println(accountant);
    accountant.work()
}
