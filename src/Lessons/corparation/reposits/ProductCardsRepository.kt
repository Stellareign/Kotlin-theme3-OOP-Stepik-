package Lessons.corparation.reposits

import Lessons.corparation.employees.HR
import Lessons.corparation.enum.ProductTypes
import Lessons.corparation.internetShop.ElectronicsCard
import Lessons.corparation.internetShop.FoodProductsCard
import Lessons.corparation.internetShop.ShoesCard
import Lessons.corparation.parents.ProductCard
import java.io.File

object ProductCardsRepository {

    private val productsFile = File("products_file.txt")
   val productCardsList = readTextFromFile();


    fun readAllProductCards () : MutableList<ProductCard> {
        return readTextFromFile()
    }
    fun safeProductCards (type: ProductTypes) {
        safeProductCardToFile(type)
    }

    private fun readTextFromFile(): MutableList<ProductCard> {
        val newProductsList = mutableListOf<ProductCard>();
        if (!productsFile.exists()) {
            println("File does not exist");
            productsFile.createNewFile()
            return newProductsList;
        }
        val stringCard = productsFile.readText().trim();
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

    fun removeCard(list: MutableList<ProductCard>, name: String) {
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
        rewriteFile(list, productsFile);
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