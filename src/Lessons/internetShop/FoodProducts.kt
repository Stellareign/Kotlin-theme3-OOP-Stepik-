package Lessons.internetShop

class FoodProducts(
    name: String,
    brand: String,
    price: Double,
    val weightOrVolume: Double
) : ProductCard(name, brand, price) {
    override fun printInfo() {
        println("ProductName: ${productName.uppercase()}, \nBrand: $brand, \nPrice: $price, \nweightOrVolume: $weightOrVolume");
    }
}