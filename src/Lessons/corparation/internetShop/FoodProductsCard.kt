package Lessons.corparation.internetShop

import Lessons.corparation.parents.ProductCard


class FoodProductsCard(
    name: String,
    brand: String,
    price: Double,
    type: String,
    val weightOrVolume: Double,
    val caloriesCount: Int,
    val description : String=""
) : ProductCard(name, brand, price, type) {
    override fun printInfo() {
        super.printInfo()
        println("\nweightOrVolume: $weightOrVolume, \nType: $type, \nCalories Count: $caloriesCount");
    }
}