package Lessons.internetShop

class Shoes(
    productName: String,
    brand: String,
    price: Double,
    type: String,
    val size: Double
) : ProductCard (
    productName = productName,
    brand = brand,
    price = price,
    type = type,
) {
    override fun printInfo() {
        println("Product Name: $productName, Brand: $brand, Price:  $price, Size : $size");
    }

}