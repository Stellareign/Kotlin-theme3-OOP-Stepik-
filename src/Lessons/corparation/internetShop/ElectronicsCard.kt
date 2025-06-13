package Lessons.corparation.internetShop

import Lessons.corparation.parents.ProductCard

class ElectronicsCard(
    name: String,
    brand: String,
    price: Double,
    type: String,
    val power: Int,
    val powerSocket: String = "euro",
    val description: String = ""
) : ProductCard(name, brand, price, type) {

    override fun printInfo() {
        super.printInfo()
        println("\npower: $power, \npowerSocket: $powerSocket");
    }
}