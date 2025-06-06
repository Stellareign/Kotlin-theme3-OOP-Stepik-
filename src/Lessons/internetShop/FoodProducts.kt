package Lessons.internetShop

import com.sun.beans.introspect.PropertyInfo
import javax.print.attribute.standard.Destination

class FoodProducts(
    name: String,
    brand: String,
    price: Double,
    type: String,
    destination: String,
    val weightOrVolume: Double
) : ProductCard(name, brand, price, type, destination) {
    override fun printInfo() {
        println("ProductName: ${productName.uppercase()}, \nBrand: $brand, \nPrice: $price, " +
                "\nweightOrVolume: $weightOrVolume, \nType: $type\nDescription: $description");
    }
}