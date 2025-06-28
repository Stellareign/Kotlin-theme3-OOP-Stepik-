package Lessons.corparation.internetShop

import Lessons.corparation.employees.Accountant

fun main() {
//    val electronicsCard = ElectronicsCard("tv", "LG",
//        35000.0, "large", 250, "euro", "52\", плоский");
//    electronicsCard.printInfo();
//    println();
//    val milk = FoodProductsCard("Milk", "Savinov", 30.50,
//        "milk", "1 литр", 1.0, 120);
//    milk.printInfo();
//    println()
//
//    val crossShoes = ShoesCard("кроссовки", "Nike", 3500.0,
//        "run", 35.5, "для бега, прогулок, зала");
//    crossShoes.printInfo();

//    val accountant = Accountant(0,"Df", 32);
//    accountant.work()
    val shoe = ShoesCard("shoe", "Nike", 3500.0, 35.5);
    println(shoe)
    val foodProductsCard = FoodProductsCard("food", "Yar", 45.5,
        1.5, 450,"milk")
    println(foodProductsCard)
    val electronicsCard = ElectronicsCard("tv", "Sony", 45000.0,800)
    println(electronicsCard)

}