package Lessons

class ProductCard {
    var productName: String;
    var brand: String;
    var size: Float;
    var price: Double;
    var description: String;

    constructor(name: String, brand: String, size: Float, price: Double, description: String) { //при создании конструктора не надо присваивать значения полям
        this.productName = name;
        this.brand = brand;
        this.size = size;
        this.price = price;
        this.description = name;
    }

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