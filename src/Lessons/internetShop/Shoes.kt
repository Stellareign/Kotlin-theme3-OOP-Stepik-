package Lessons.internetShop

class Shoes(
    productName: String,
    brand: String,
    price: Double,
    val size: Double
) : ProductCard (
    productName = productName,
    brand = brand,
    price = price
) {
    override fun printInfo() {
        println("Product Name: $productName, Brand: $brand, Price:  $price, Size : $size");
    }

}