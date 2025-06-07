package Lessons.corparation.employees

import Lessons.corparation.internetShop.ElectronicsCard
import Lessons.corparation.internetShop.FoodProductsCard
import Lessons.corparation.internetShop.ShoesCard
import Lessons.corparation.parents.ProductCard
import Lessons.corparation.parents.Worker

class Accountant(name: String, age: Int) : Worker(name, age) {
    override fun work() {
        while (true) {
            print("Введите код операции. \"0\" - выход, \"1\" - зарегистрировать товар: ");
            val operationCode = readln().toInt();
            when (operationCode) {
                0 -> break;
                1 -> {
                    print("Укажите код типа товара. \"0\" - продукты питания, \"1\" - бытовая техника, \"2\" - обувь: ");
                    val productCode = readln().toInt();
                    productCardFromCode(productCode)
                }
            }
        }
    }


    fun productCardFromCode(code: Int) {
        var productCard = ProductCard("no", "no", 0.0, "no");
        when (code) {
            0 -> productCard = safeFoodCard();
            1 -> productCard = safeElectronic();
            2 -> productCard = safeShoeCard();
        }
        println("Добавлен товар: ");
        productCard.printInfo();

    }

    fun safeShoeCard(): ShoesCard {
        print("Введите название обуви: ");
        val name = readln();
        print("Введите марку товара: ");
        val brand = readln();
        print("Введите цену: ");
        val price = readln().toDouble();
        print("Введите размер: ")
        val size = readln().toDouble();
        return ShoesCard(name, brand, price, "shoe", size, "");
    }

    fun safeFoodCard(): FoodProductsCard {
        print("Введите название продукта: ");
        val name = readln();
        print("Введите марку продукта: ");
        val brand = readln();
        print("Введите цену: ");
        val price = readln().toDouble();
        print("Введите вес / объём: ")
        val weight = readln().toDouble();
        print("Введите калорийность: ")
        val calories = readln().toInt();
        return FoodProductsCard(name, brand, price, "food", "", weight, calories);
    }

    fun safeElectronic(): ElectronicsCard {
        print("Введите название техники: ");
        val name = readln();
        print("Введите марку техники: ");
        val brand = readln();
        print("Введите цену: ");
        val price = readln().toDouble();
        print("Введите мощность: ")
        val power = readln().toInt();

        return ElectronicsCard(name, brand, price, "technic", power, "euro", "");
    }
}