package Lessons.corparationDataClass.reposits

import Lessons.corparationDataClass.enum.ProductTypes
import Lessons.corparationDataClass.internetShop.ElectronicsCard
import Lessons.corparationDataClass.internetShop.FoodCard
import Lessons.corparationDataClass.internetShop.ShoesCard
import Lessons.corparationDataClass.parents.ProductCard

import java.io.File

object ProductCardsRepository {

    private val productsFile = File("products_file.txt")

    private val _productCardsSet: MutableSet<ProductCard> = readTextFromFile() //внутренняя переменная

    val productCardsList: List<ProductCard>
        get() = _productCardsSet.toList() // оперативная переменная - копия основной

    fun saveChanges() {
        rewriteFile(productsFile)
    }

    fun showAllProductCards() {
        _productCardsSet.forEach { productCard -> println(productCard.toString()) }
    }

    fun safeProductCards(type: ProductTypes) {
        safeProductCardToList(type)
    }

    fun removeCardFromList(name: String) {
        removeCard(name)
    }

    private fun readTextFromFile(): MutableSet<ProductCard> {
        val newProductsList = mutableSetOf<ProductCard>();
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
        return newProductsList;
    }

    private fun safeProductCardToList(type: ProductTypes) {
        print("Введите название продукта: ");
        val productName = readln()
        print("Введите марку продукта: ");
        val brand = readln()
        print("Введите цену: ");
        val price = readln().toDouble()
        when (type) {
            ProductTypes.FOOD -> {
                print("Введите вес / объём: ")
                val weightOrVolume = readln().toDouble()
                print("Введите калорийность: ")
                val caloriesCount = readln().toInt()

                _productCardsSet.add(FoodCard(productName, brand, price, weightOrVolume, caloriesCount))
            }

            ProductTypes.SHOE -> {
                print("Введите размер: ")
                val size = readln().toDouble()
                _productCardsSet.add(ShoesCard(productName, brand, price, size))
            }

            ProductTypes.ELECTRONICS -> {
                print("Введите мощность: ")
                val power = readln().toInt()
                _productCardsSet.add(
                    ElectronicsCard(
                        productName,
                        brand,
                        price,
                        power,
                        powerSocket = "euro"
                    )
                )
            }

            ProductTypes.NO_TYPE -> TODO()
        }
    }


    private fun removeCard(name: String) {
        _productCardsSet.removeAll { it.productName == name } // наиболее надёжный способ для нашего варианта + лаконичность (внутри предикат)
    }

    private fun rewriteFile(file: File) {
        file.writeText("");
        for (card in _productCardsSet) {
            file.appendText("${card.productName}%${card.brand}%${card.price}%")
            when (card) {

                is FoodCard -> {
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
        return ShoesCard(name, brand = brand, price = price, size = size);

    }

    private fun readFoodCard(list: List<String>): FoodCard {
        val name = list[0]
        val brand = list[1]
        val price = list[2].toDouble()
        val weightOrVolume = list[3].toDouble();
        val calories = list[4].toInt();
        val type = list.last()
        return FoodCard(
            productName = name,
            brand = brand,
            price = price,
            weightOrVolume = weightOrVolume,
            caloriesCount = calories
        );
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