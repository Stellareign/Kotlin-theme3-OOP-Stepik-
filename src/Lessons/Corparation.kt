package Lessons

import com.sun.beans.introspect.PropertyInfo

fun main() {
    print("Enter name: ");
    val productName = readln();
    print("Enter brand: ");
    val productBrand = readln();
    print("Enter size: ");
    val size = readln().toFloat();
    print("Enter price: ");
    val productPrice = readln().toDouble();
    val productCard = ProductCard(productName= productName, brand = productBrand, size, productPrice);
    // можно (нужно) использовать именованные
    //параметры для параметров одного типаЮ идущих подряд - это облегчает читаемость кода, понятно акому полю что присваивается

    productCard.pintInfo();
}
