package Lessons.corparation.employees

import Lessons.corparation.internetShop.ElectronicsCard
import Lessons.corparation.internetShop.FoodProductsCard
import Lessons.corparation.internetShop.ShoesCard
import Lessons.corparation.enum.OperationCodes
import Lessons.corparation.enum.ProductTypes
import Lessons.corparation.enum.Workers
import Lessons.corparation.parents.ProductCard
import Lessons.corparation.parents.Worker
import java.io.File


class Accountant(
    id: Int,
    name: String,
    age: Int
) : Worker(id, name, age, Workers.ACCOUNTANT), Cleaner, Supplier {
    private val productsTypes = ProductTypes.entries;
    private val operation = OperationCodes.entries;
    private val productsFile = File("${name}_products_file.txt")
    private val hr = HR(0, " ", 0);

    override fun delivery() {
        println("${name}: доставляю товары")
    }

    override fun clean() {
        super.clean()
    }

    override fun work() {
        while (true) {
            print("Введите код операции (");
            for ((index, operationName) in operation.withIndex()) {
                print("$index - ${operationName.title}\n")
//                punctuationMarks(index, operation.size - 1);
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

                OperationCodes.SHOW_ALL_PRODUCTS -> readTextFromFile(cardFile = productsFile);
                OperationCodes.DELETE_ITEM -> {
                    val list = readTextFromFile(productsFile);
                    print("Введите наименование товара для удаления: ");
                    val name = readln();
                    removeCard(list, name, productsFile);
                    print("Товар удалён, на складе осталось: \n");

                    readTextFromFile(cardFile = productsFile);

                }

                OperationCodes.NEW_EMPLOYEE -> hr.addWorker();
                OperationCodes.FIRE_EMPLOYEE -> hr.fireEmployee();
                OperationCodes.SHOW_ALL_EMPLOYEES -> hr.showAllEmployees();
            }
        }
    }

    private fun removeCard(list: MutableList<ProductCard>, name: String, file: File) {
        //*****************способ 3 *********************
        list.removeAll { it.productName == name } // наиболее надёжный способ для нашего варианта + лаконичность (внутри предикат)
        //****************способ 2**********************
//        val iterator = list.iterator()
//        while (iterator.hasNext()) {
//            val productCard = iterator.next()
//            if (productCard.productName == name) {
//                iterator.remove()  // Безопасное удаление через итератор
//            }
//        } // итератор подойдёт для более сложных условий удаления
        //*****************способ 1***************************** самый небезопасный
//        for(card in list) {
//            if(card.productName == name) {
//                list.remove(card);
//                break // без break не работает, ошибка
//            }
//        }
        rewriteFile(list, file);
    }

    private fun rewriteFile(list: MutableList<ProductCard>, file: File) {
        file.writeText("");
        for (card in list) {
            file.appendText("${card.productName}%${card.brand}%${card.price}%")
            when (card) {

                is FoodProductsCard -> {
                    file.appendText("${card.weightOrVolume}%${card.caloriesCount}%${card.type}\n")
                }

                is ShoesCard -> {
                    file.appendText("${card.size}%${card.type}\n")
                }

                is ElectronicsCard -> {
                    file.appendText("${card.power}%${card.powerSocket}%${card.type}\n")
                }
            }
        }
    }


    fun readTextFromFile(cardFile: File): MutableList<ProductCard> {
        val newProductsList = mutableListOf<ProductCard>();
        if (!cardFile.exists()) {
            println("File does not exist");
            return newProductsList;
        }
        val stringCard = cardFile.readText().trim();
        if (stringCard.isEmpty()) {
            println("File is empty");
            return newProductsList;
        }
        val cardsListFromFile = stringCard.split("\n");
        val cardsList = mutableListOf<List<String>>();


        for (string in cardsListFromFile) {
            val s = string.split("%");
            cardsList.add(s);
        }

        for (card in cardsList) {
            if (card.contains("${ProductTypes.FOOD}")) {
                newProductsList.add(readFoodCard(card));

            } else if (card.contains("${ProductTypes.SHOE}")) {
                newProductsList.add(readShoeCard(card));

            } else if (card.contains("${ProductTypes.ELECTRONICS}")) {
                newProductsList.add(readElectronicCard(card));
            }
        }
        for (c in newProductsList) {
            c.printInfo();
            println();
        }
        return newProductsList;
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

            ProductTypes.NO_TYPE -> TODO()
        }
    }


    private fun readShoeCard(list: List<String>): ShoesCard {
        val name = list[0];
        val brand = list[1];
        val price = list[2].toDouble()
        val size = list[3].toDouble();
        val type = list.last()
        return ShoesCard(name, brand, price, size);

    }

    private fun readFoodCard(list: List<String>): FoodProductsCard {
        val name = list[0]
        val brand = list[1]
        val price = list[2].toDouble()
        val weightOrVolume = list[3].toDouble();
        val calories = list[4].toInt();
        val type = list.last()
        return FoodProductsCard(name, brand, price, weightOrVolume, calories, "");
    }

    private fun readElectronicCard(list: List<String>): ElectronicsCard {
        val name = list[0];
        val brand = list[1];
        val price = list[2].toDouble();
        val power = list[3].toInt();
        val rosette = list[4];
        val type = list.last()
        return ElectronicsCard(name, brand, price, power, rosette, "")
    }
}