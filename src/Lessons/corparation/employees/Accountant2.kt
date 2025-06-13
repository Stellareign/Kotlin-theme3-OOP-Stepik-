package Lessons.corparation.employees

import Lessons.corparation.internetShop.ElectronicsCard
import Lessons.corparation.internetShop.FoodProductsCard
import Lessons.corparation.internetShop.ShoesCard
import Lessons.corparation.enum.OperationCodes
import Lessons.corparation.enum.ProductTypes
import Lessons.corparation.parents.ProductCard
import Lessons.corparation.parents.Worker
import java.io.File


class Accountant2(name: String, age: Int) : Worker(name, age) {
    val productsTypes = ProductTypes.entries;
    val operation = OperationCodes.entries;
    val productsFile = File("${name}_products_file.txt")


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
                    print("Укажите код типа товара: (");
                    for ((index, type) in productsTypes.withIndex()) { // вывод индекса и названия - объявляем две переменные
                        print("$index - ${type.title}");
                        punctuationMarks(index, productsTypes.size - 1);
                    }
                    val productCode = readln().toInt();
                    val productType = productsTypes[productCode];
                    safeProductCardToFile(productType);
                }

                OperationCodes.SHOW_ALL -> readTextFromFile(cardFile = productsFile);
            }
        }
    }

    fun readTextFromFile(cardFile: File) {
        val newProductsList = mutableListOf<ProductCard>();
        val stringCard = cardFile.readText().trim();
        val cardsListFromFile = stringCard.split("\n");
        val cardsList = mutableListOf<List<String>>();
        for (string in cardsListFromFile) {
            val s = string.split("%");
            cardsList.add(s);
        }
        var productCar = ProductCard("", "", 0.0, "")
        for (card in cardsList) {
            if (card.contains("${ProductTypes.FOOD}")) {
                productCar = readFoodCard(card)

            } else if (card.contains("${ProductTypes.SHOE}")) {
                productCar = readShoeCard(card)

            } else if (card.contains("${ProductTypes.ELECTRONICS}")) {
                productCar = readElectronicCard(card)
            }
            productCar.printInfo();
            println()
            newProductsList.add(productCar);
        }
        for (c in newProductsList) {
            println("\n$c")
        }
    }

    private fun punctuationMarks(index: Int, size: Int) {
        if (index < size) {
            print(", ")
        } else {
            print("): ")
        }
    }

    private fun safeProductCardToFile(type: ProductTypes) {
        when (type) {
            ProductTypes.FOOD -> {
                print("Введите название продукта: ");
                productsFile.appendText("${readln()}%");
                print("Введите марку продукта: ");
                productsFile.appendText("${readln()}%");
                print("Введите цену: ");
                productsFile.appendText("${readln()}%");
                print("Введите вес / объём: ")
                productsFile.appendText("${readln()}%");
                print("Введите калорийность: ")
                productsFile.appendText("${readln()}%");
                productsFile.appendText("FOOD")
                productsFile.appendText("\n");
            }

            ProductTypes.SHOE -> {
                print("Введите название обуви: ");
                productsFile.appendText("${readln()}%");
                print("Введите марку товара: ");
                productsFile.appendText("${readln()}%");
                print("Введите цену: ");
                productsFile.appendText("${readln()}%");
                print("Введите размер: ")
                productsFile.appendText("${readln()}%");
                productsFile.appendText("SHOE")
                productsFile.appendText("\n");
            }

            ProductTypes.ELECTRONICS -> {
                print("Введите название техники: ");
                productsFile.appendText("${readln()}%");
                print("Введите марку техники: ");
                productsFile.appendText("${readln()}%");
                print("Введите цену: ");
                productsFile.appendText("${readln()}%");
                print("Введите мощность: ")
                productsFile.appendText("${readln()}%");
                productsFile.appendText("ELECTRONICS")
                productsFile.appendText("\n");
            }
        }
    }


    private fun readShoeCard(list: List<String>): ShoesCard {
        val name = list[0];
        val brand = list[1];
        val price = list[2].toDouble()
        val size = list[3].toDouble();
        val desc = list[4];
        val type = list.last()
        return ShoesCard(name, brand, price, type, size, desc)

    }

    private fun readFoodCard(list: List<String>): FoodProductsCard {
        val name = list[0]
        val brand = list[1]
        val price = list[2].toDouble()
        val weightOrVolume = list[3].toDouble();
        val calories = list[4].toInt();
        val desc = list[5];
        val type = list.last()
        return FoodProductsCard(name, brand, price, type, weightOrVolume, calories, desc);
    }

    private fun readElectronicCard(list: List<String>): ElectronicsCard {
        val name = list[0];
        val brand = list[1];
        val price = list[2].toDouble();
        val power = list[3].toInt();
        val rosette = list[4];
        val desc = list[5];
        val type = list.last()
        return ElectronicsCard(name, brand, price, type, power, rosette, desc)
    }

}