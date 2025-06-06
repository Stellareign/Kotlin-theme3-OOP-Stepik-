package Lessons.internetShop

open class ProductCard(
    var productName: String,
    var brand: String,
    var price: Double,
    var type : String,
    var description: String = ""// а вот в первичном конструкторе можно присвоить значения по умолчанию
)
    {

    fun init (name: String, brand : String, size: Float, price: Double, type: String, description: String) { // аналог конструктора
        this.productName = name;   //при создании конструктора не надо присваивать значения полям
        this.brand = brand;
        this.price = price;
        this.type = type;
        this.description = description;
    }

    open fun printInfo (){
        println("productName: $productName, \nbrand: $brand,  \nprice: $price, \ndescription: $description, \tupe: $type");// аналог тустринг
    }

    override fun toString(): String {
        return "ProductCard(productName='$productName', \nbrand='$brand', \\nprice=$price, \ndescription='$description')"
    }


}