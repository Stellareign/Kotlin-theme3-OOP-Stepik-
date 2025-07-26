package Lessons.corparation.internetShop

import Lessons.corparation.enum.ProductTypes
import Lessons.corparation.parents.ProductCard

class ElectronicsCard(
    name: String = "",
    brand: String = "",
    price: Double = 0.0,
    var power: Int = 0,
    var powerSocket: String = "euro",
    var description: String = ""
) : ProductCard(name, brand, price, ProductTypes.ELECTRONICS) {

    override fun printInfo() {
        print(
            "productName: $productName, \nbrand: $brand,  " +
                    "\nprice: $price, \ntype: $type "
        );// аналог тустринг
        println("\npower: $power, \npowerSocket: $powerSocket");
    }

    override fun toString(): String {
        return "\nproductName: $productName, " +
                "\nbrand: $brand', \nprice = $price, \ntype = $type, \npower: $power, " +
                "\npowerSocket = $powerSocket";
    }
}