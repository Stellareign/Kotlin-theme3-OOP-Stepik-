package Lessons

import com.sun.beans.introspect.PropertyInfo

class ProductCard {
    var productName: String;
    var brand: String;
    var size: Float;
    var price: Double;
    var description: String = "";

    constructor(productName: String, brand: String, size: Float, price: Double) {
        this.productName = productName
        this.brand = brand
        this.size = size
        this.price = price

    }

    //при создании конструктора не надо присваивать значения полям


    fun init (name: String, brand : String, size: Float, price: Double) { // аналог конструктора
        this.productName = name;
        this.brand = brand;
        this.size = size;
        this.price = price;
    }

    fun pintInfo (){
        println("productName: $productName, \nbrand: $brand, \nsize: $size, \nprice: $price, \ndescription: $description");// аналог тустринг
    }

    override fun toString(): String {
        return "ProductCard(productName='$productName', \nbrand='$brand', \nsize=$size, \nprice=$price, \ndescription='$description')"
    }


}