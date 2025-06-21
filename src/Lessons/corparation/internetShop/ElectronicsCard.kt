package Lessons.corparation.internetShop

import Lessons.corparation.enum.ProductTypes
import Lessons.corparation.parents.ProductCard

class ElectronicsCard(
    name: String,
    brand: String,
    price: Double,
    val power: Int,
    val powerSocket: String = "euro",
    val description: String = ""
) : ProductCard(name, brand, price, ProductTypes.ELECTRONICS) {

    override fun printInfo() {
        super.printInfo()
        println("\npower: $power, \npowerSocket: $powerSocket");
    }
}