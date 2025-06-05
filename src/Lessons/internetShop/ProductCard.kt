package Lessons.internetShop

open class ProductCard(
    var productName: String,
    var brand: String,
    var price: Double
) {
    var description: String = ""; // а вот в первичном конструкторе можно присвоить значения по умолчанию

    //при создании конструктора не надо присваивать значения полям


    fun init (name: String, brand : String, size: Float, price: Double) { // аналог конструктора
        this.productName = name;
        this.brand = brand;

        this.price = price;
    }

    open fun printInfo (){
        println("productName: $productName, \nbrand: $brand,  \nprice: $price, \ndescription: $description");// аналог тустринг
    }

    override fun toString(): String {
        return "ProductCard(productName='$productName', \nbrand='$brand', \\nprice=$price, \ndescription='$description')"
    }


}