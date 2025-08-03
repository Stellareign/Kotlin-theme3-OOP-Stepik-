package Lessons.corparationDataClass.internetShop

import Lessons.corparationDataClass.enum.ProductTypes
import Lessons.corparationDataClass.parents.ProductCard


data class FoodCard(
    override val productName: String,
    override val brand: String,
    override val price: Double,
    val weightOrVolume: Double,
    val caloriesCount: Int,
    var description: String = "",

) : ProductCard(
    productName = productName,
    brand = brand,
    price = price,
    type = ProductTypes.FOOD,
) {

    constructor() : this(
        productName = "",
        brand = "",
        price = 0.0,
        weightOrVolume = 0.0,
        caloriesCount = 0,
        description = ""
    )
}