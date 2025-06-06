package Lessons.internetShop

fun main() {
    val electronicsCard = ElectronicsCard("tv", "LG", 35000.0, "large", 250, "euro", "52\", плоский");
    electronicsCard.printInfo();
    println();
    val milk = FoodProductsCard("Milk", "Savinov", 30.50, "milk", "1 литр", 1.0, 120);
    milk.printInfo();

}