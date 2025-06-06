package Lessons.internetShop

class ElectronicsCard(
    name: String,
    brand: String,
    price: Double,
    type: String,
    val power: Int,
    val oulet: String = "euro",
    description: String
) : ProductCard(name, brand, price, type, description) {
    override fun printInfo() {
        super.printInfo()
        println("\npower: $power, \noulet: $oulet");
    }
}