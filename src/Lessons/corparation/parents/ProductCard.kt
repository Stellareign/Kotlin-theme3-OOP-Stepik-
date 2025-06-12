package Lessons.corparation.parents

import com.sun.beans.introspect.PropertyInfo

open class ProductCard(
    var productName: String,
    var brand: String,
    var price: Double,
    var type : String,
//    var description: String = ""// а вот в первичном конструкторе можно присвоить значения по умолчанию
)
    {


    fun init(
        name: String,
        brand: String,
        price: Double,
        type: String,
        description: String
    ) { // аналог конструктора
        this.productName = name;   //при создании конструктора не надо присваивать значения полям
        this.brand = brand;
        this.price = price;
        this.type = type;
//        this.description = description;
    }

    open fun printInfo (){
        print("productName: $productName, \nbrand: $brand,  " +
                "\nprice: $price, \ntype: $type ");// аналог тустринг
    }

    override fun toString(): String {
        return "ProductCard: \nproductName = '$productName', " +
                "\nbrand = '$brand', \nprice = $price, \ntype = $type"}


}