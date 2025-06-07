package Lessons.corparation.employees

import Lessons.corparation.internetShop.ElectronicsCard
import Lessons.corparation.internetShop.FoodProductsCard
import Lessons.corparation.internetShop.ShoesCard
import Lessons.corparation.enam.OperationCodes
import Lessons.corparation.enam.ProductTypes
import Lessons.corparation.parents.Worker

class Accountant(name: String, age: Int) : Worker(name, age) {
    val productsTypes = ProductTypes.entries;
    val operation = OperationCodes.entries;
    override fun work() {

        while (true) {
            print("Введите код операции (");
            for ((index, operationName) in operation.withIndex()) {
                print("$index - ${operationName.title}")
                punctuationMarks(index, operation.size - 1);
            }
            val operationCode = readln().toInt();
            when (operation[operationCode]) {
                OperationCodes.EXIT -> break;
                OperationCodes.REGISTER_ITEM -> {
//                    print("Укажите код типа товара. \"0\" - ${productsTypes[0].title}, \"1\" - ${productsTypes[1].title}, \"2\" - ${productsTypes[2].title}: ");
                    print("Укажите код типа товара: (");
                    for ((index, type) in productsTypes.withIndex()) { // вывод индекса и названия - объявляем две переменные
                        print("$index - ${type.title}");
                        punctuationMarks(index, productsTypes.size - 1);
                    }
                    val productCode = readln().toInt();
                    val productType = productsTypes[productCode];
                    productCardFromCode(productType)
                }
            }
        }
    }

    fun punctuationMarks(index: Int, size: Int) {
        if (index < size) {
            print(", ")
        } else {
            print("): ")
        }
    }

    fun productCardFromCode(type: ProductTypes) {
        val productCard = when (type) {
            ProductTypes.FOOD -> safeFoodCard();
            ProductTypes.ELECTRONICS -> safeElectronic();
            ProductTypes.SHOE -> safeShoeCard();
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