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
    val productesList = mutableListOf<ProductCard>();

    fun readCardFromFile() {


    }
    val newProductsList = mutableListOf<ProductCard>();
    fun readTextFromFile(cardFile: File): List<List<String>> {
        val stringCard = cardFile.readText().trim();
        val cardsListFromFile= listOf(stringCard.split("\n"));
        val newCard = ProductCard("", "", 0.0, "");

        for (card in cardsListFromFile) {
            newCard == if (card.contains("${ProductTypes.FOOD}")) {

            } else if (card.contains("${ProductTypes.SHOE}")) {
                safeShoeCard(card)
            }
        }
        return cardsListFromFile;

    }

    fun punctuationMarks(index: Int, size: Int) {
        if (index < size) {
            print(", ")
        } else {
            print("): ")
        }
    }


    fun safeShoeCard(list: List<String>): ShoesCard {
        val name = list[0];
        val brand = list[1];
        val price = list[2].toDouble()
        val size = list[3].toDouble();
        val type = list[4];
        newProductsList.add(ShoesCard(name, brand, price, type, size, ""));
    }

    fun safeFoodCard(list: List<String>): FoodProductsCard {
        val name = list[0];
        val brand = list[1];
        val price = list[2].toDouble()

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