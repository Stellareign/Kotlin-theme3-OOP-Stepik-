package Lessons.corparation.internetShop

import Lessons.corparation.parents.ProductCard

class ShoesCard(
    productName: String,
    brand: String,
    price: Double,
    type: String,
    val size: Double,
    val description : String
) : ProductCard(
    productName = productName,
    brand = brand,
    price = price,
    type = type
) {
    override fun printInfo() {
        super.printInfo();
        println("\nSize : $size");
    }

}