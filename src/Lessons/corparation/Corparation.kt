package Lessons.corparation

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

    val consult : Consultant = Consultant("Max", 32)
//    val consult2 : Consultant = Consultant("Mark")
//    consult.hello();
//    consult2.hello();
    val director = Director("BigBoss", 45);
//    val secretary : Secretary = Secretary(name = "Lessy");
//    director.takeCoffee(secretary, 1, "Mocco")
//    consult.clientService()
    director.makeConsultantToWork(consult   )

}
