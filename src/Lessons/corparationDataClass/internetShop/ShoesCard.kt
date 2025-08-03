package Lessons.corparationDataClass.internetShop

import Lessons.corparationDataClass.enum.ProductTypes
import Lessons.corparationDataClass.parents.ProductCard

data class ShoesCard(
    override val productName: String = "",
    override val brand: String = "",
    override val price: Double = 0.0,
    val size: Double,
//    val description : String
) : ProductCard(
    productName = productName,
    brand = brand,
    price = price,
    type = ProductTypes.SHOE
) {

}