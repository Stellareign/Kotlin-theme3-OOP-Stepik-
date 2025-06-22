package Lessons.corparation.internetShop

import Lessons.corparation.enum.ProductTypes
import Lessons.corparation.parents.ProductCard


class FoodProductsCard(
    name: String,
    brand: String,
    price: Double,
    val weightOrVolume: Double,
    val caloriesCount: Int,
    val description : String=""
) : ProductCard(name, brand, price, ProductTypes.FOOD) {
    override fun printInfo() {
        print("productName: $productName, \nbrand: $brand,  " +
                "\nprice: $price, \ntype: $type ");// аналог тустринг
        println("\nweightOrVolume: $weightOrVolume, \nCalories Count: $caloriesCount");
    }
}