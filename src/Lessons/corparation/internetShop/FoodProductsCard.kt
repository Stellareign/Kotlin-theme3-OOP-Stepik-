package Lessons.corparation.internetShop

import Lessons.corparation.parents.ProductCard


class FoodProductsCard(
    name: String,
    brand: String,
    price: Double,
    type: String,
    description : String,
    val weightOrVolume: Double,
    val caloriesCount: Int
) : ProductCard(name, brand, price, type, description) {
    override fun printInfo() {
        super.printInfo()
        println("\nweightOrVolume: $weightOrVolume, \nType: $type, \nCalories Count: $caloriesCount");
    }
}