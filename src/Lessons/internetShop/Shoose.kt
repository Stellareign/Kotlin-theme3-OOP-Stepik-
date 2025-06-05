package Lessons.internetShop

class Shoose(
    productName: String,
    brand: String,
    price: Double,
    val size: Double
) : ProductCard (
    productName = productName,
    brand = brand,
    price = price
) {
    override fun pintInfo() {
        super.pintInfo("Product Name: $productName, Brand: $brand, Price:  $price, Size : $size")
    }

}