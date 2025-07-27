package Lessons.corparation.employees

import Lessons.corparation.internetShop.ElectronicsCard
import Lessons.corparation.internetShop.FoodProductsCard
import Lessons.corparation.internetShop.ShoesCard
import Lessons.corparation.enum.OperationCodes
import Lessons.corparation.enum.ProductTypes
import Lessons.corparation.enum.Workers
import Lessons.corparation.parents.ProductCard
import Lessons.corparation.parents.Worker

class Accountant1(
    id: Int,
    name: String,
    age: Int,
    salary: Int
) : Worker(id, name, age, Workers.ACCOUNTANT, salary) {
    val productsTypes = ProductTypes.entries;
    val operation = OperationCodes.entries;
    val productesList = mutableListOf<ProductCard>();

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
//                    productCardFromCode(productType);
                    productesList.add(productCardFromCode(productType));
                    println(productesList.joinToString(","));
                }

                OperationCodes.SHOW_ALL_PRODUCTS -> TODO()
                OperationCodes.DELETE_ITEM -> TODO()
                OperationCodes.NEW_EMPLOYEE -> TODO()
                OperationCodes.FIRE_EMPLOYEE -> TODO()
                OperationCodes.SHOW_ALL_EMPLOYEES -> TODO()
                OperationCodes.CHANGE_SALARY -> TODO()
                OperationCodes.SAFE_CHANGES -> TODO()
                OperationCodes.CHANGE_AGE -> TODO()
            }
        }
    }

    override fun copy(salary: Int, age: Int): Worker {
        TODO("Not yet implemented")
    }

    fun punctuationMarks(index: Int, size: Int) {
        if (index < size) {
            print(", ")
        } else {
            print("): ")
        }
    }

    fun productCardFromCode(type: ProductTypes): ProductCard {
        val productCard = when (type) {
            ProductTypes.FOOD -> safeFoodCard();
            ProductTypes.ELECTRONICS -> safeElectronic();
            ProductTypes.SHOE -> safeShoeCard();
            ProductTypes.NO_TYPE -> TODO()
        }
        println("Добавлен товар: ");
        productCard.printInfo();
        return productCard;

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
        return ShoesCard(name, brand, price, size);
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
        return FoodProductsCard(name, brand, price, weight, calories, "");
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

        return ElectronicsCard(name, brand, price, power, "euro", "");
    }

}