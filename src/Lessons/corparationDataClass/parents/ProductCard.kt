package Lessons.corparationDataClass.parents

import Lessons.corparationDataClass.enum.ProductTypes

abstract class ProductCard(
    var productName: String,
    var brand: String,
    var price: Double,
    var type: ProductTypes = ProductTypes.NO_TYPE
) {


    abstract fun printInfo()

    override fun toString(): String {
        return "ProductCard: \nproductName: $productName, n\nbrand:$brand, \nprice = $price, \ntype = $type"
    }


}