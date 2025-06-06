package Lessons.internetShop


class FoodProductsCard(
    name: String,
    brand: String,
    price: Double,
    type: String,
    description : String,
    val weightOrVolume: Double,
    val caloriesCount: Int
) : ProductCard(name, brand, price, type, description) {
    override fun printInfo() {
        super.printInfo()
        println("\nweightOrVolume: $weightOrVolume, \nType: $type, Calories Count: $caloriesCount");
    }
}