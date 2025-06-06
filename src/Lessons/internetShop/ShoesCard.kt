package Lessons.internetShop

import jdk.jfr.Description

class ShoesCard(
    productName: String,
    brand: String,
    price: Double,
    type: String,
    val size: Double,
    description : String
) : ProductCard (
    productName = productName,
    brand = brand,
    price = price,
    type = type,
    description = description
) {
    override fun printInfo() {
        super.printInfo();
        println("\nSize : $size");
    }

}