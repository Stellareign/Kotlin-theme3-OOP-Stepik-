package Lessons.corparationDataClass.parents

import Lessons.corparationDataClass.enum.ProductTypes

abstract class ProductCard(
    open val productName: String,
    open val brand: String,
    open val price: Double,
    val type: ProductTypes
) {


    constructor() : this(
        productName = "",
        brand = "",
        price = 0.0,
        type = ProductTypes.NO_TYPE
    )

    override fun toString(): String {
        return "Карточка товара. Тип продукта: $type, название: $productName, бренд: $brand, цена = $price."
    }


}