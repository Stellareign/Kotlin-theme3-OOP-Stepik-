package Lessons.corparation.internetShop

import Lessons.corparation.enum.ProductTypes
import Lessons.corparation.parents.ProductCard

class ShoesCard(
    productName: String,
    brand: String,
    price: Double,
    val size: Double,
//    val description : String
) : ProductCard(
    productName = productName,
    brand = brand,
    price = price,
    type = ProductTypes.SHOE
) {
    override fun printInfo() {
        super.printInfo();
        println("\nSize : $size");
    }

}