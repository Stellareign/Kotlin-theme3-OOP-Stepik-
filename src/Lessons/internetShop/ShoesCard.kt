package Lessons.internetShop

class ShoesCard(
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
        super.printInfo()
        println("Size : $size");
    }

}