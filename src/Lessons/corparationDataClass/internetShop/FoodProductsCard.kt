package Lessons.corparationDataClass.internetShop

import Lessons.corparationDataClass.enum.ProductTypes
import Lessons.corparationDataClass.parents.ProductCard


class FoodProductsCard(
    name: String="",
    brand: String = "",
    price: Double =0.0,
    var weightOrVolume: Double = 0.0,
    var caloriesCount: Int = 0,
    description : String=""
) : ProductCard(name, brand, price, ProductTypes.FOOD) {

    override fun printInfo() {
        print("productName: $productName, \nbrand: $brand,  " +
                "\nprice: $price, \ntype: $type ");// аналог тустринг
        println("\nweightOrVolume: $weightOrVolume, \nCalories Count: $caloriesCount");
    }
    override fun toString(): String {
        return "productName: $productName, \nbrand: $brand,  " +
                "\nprice: $price, \ntype: $type, \nweightOrVolume: $weightOrVolume, \ncaloriesCount: $caloriesCount";
    }
}