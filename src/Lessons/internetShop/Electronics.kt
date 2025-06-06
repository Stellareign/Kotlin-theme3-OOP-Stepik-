package Lessons.internetShop

class Electronics(
    name: String,
    brand: String,
    price: Double,
    type: String,
    val power: Int,
    val oulet: String = "euro",
    description: String
) : ProductCard(name, brand, price, type) {
    override fun printInfo() {
        println("name: $productName, \nBrand: $brand, \nPrice: $price, " +
                "\ntype: $type, \npower: $power, \noulet: $oulet, " +
                "\ndescription: $description");
    }
}