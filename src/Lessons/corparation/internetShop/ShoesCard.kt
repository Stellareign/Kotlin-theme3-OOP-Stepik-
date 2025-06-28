package Lessons.corparation.internetShop

import Lessons.corparation.enum.ProductTypes
import Lessons.corparation.parents.ProductCard

class ShoesCard(
    productName: String,
    brand: String,
    price: Double,
    val size: Double
//    val description : String
) : ProductCard(
    productName = productName,
    brand = brand,
    price = price,
    type = ProductTypes.SHOE
) {
    override fun printInfo() {
        print("productName: $productName, \nbrand: $brand,  " +
                "\nprice: $price, \ntype: $type ");// аналог тустринг
        println("\nSize : $size");
    }

    override fun toString(): String {
       return "productName: $productName, \nbrand: $brand,  " +
                "\nprice: $price, \ntype: $type, \nSize : $size"
    }

}