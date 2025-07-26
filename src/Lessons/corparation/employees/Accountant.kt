package Lessons.corparation.employees

import Lessons.corparation.enum.OperationCodes
import Lessons.corparation.enum.ProductTypes
import Lessons.corparation.enum.Workers
import Lessons.corparation.parents.Worker
import Lessons.corparation.reposits.ProductCardsRepository
import Lessons.corparation.reposits.WorkersRepository


class Accountant(
    id: Int,
    name: String,
    age: Int,
    salary: Int
) : Worker(id, name, age, Workers.ACCOUNTANT, salary), Cleaner, Supplier {

    private val productsTypes = ProductTypes.entries;
    private val operation = OperationCodes.entries;

    //    private val productCardsRepository = ProductCardsRepository()
    private val hr = HR();
//    private val workersRepository = WorkersRepository()

    override fun delivery() {
        println("${name}: доставляю товары")
    }

    override fun clean() {
        super.clean()
    }

    override fun work() {
        while (true) {
            print("Введите код операции: \n");
            for ((index, operationName) in operation.withIndex()) {
                print("$index - ${operationName.title}\n")
//                punctuationMarks(index, operation.size - 1);
            }
            val operationCode = readln().toInt();
            when (operation[operationCode]) {
                OperationCodes.EXIT -> {
                    WorkersRepository.saveChanges()
                    ProductCardsRepository.saveChanges()
                    break;
                }

                OperationCodes.REGISTER_ITEM -> {
                    print("Укажите код типа товара: (");
                    for ((index, type) in productsTypes.withIndex()) { // вывод индекса и названия - объявляем две переменные
                        print("$index - ${type.title}");
                        punctuationMarks(index, productsTypes.size - 1);
                    }
                    val productCode = readln().toInt();
                    val productType = productsTypes[productCode];
                    ProductCardsRepository.safeProductCards(productType);
                }

                OperationCodes.SHOW_ALL_PRODUCTS -> {
                    ProductCardsRepository.saveChanges()
                    ProductCardsRepository.showAllProductCards()
                }

                OperationCodes.DELETE_ITEM -> {
                    val list = ProductCardsRepository.productCardsList
                    print("Введите наименование товара для удаления: ");
                    val name = readln();
                    ProductCardsRepository.removeCardFromList(name);
                    print("Товар удалён, на складе осталось: \n");
                    ProductCardsRepository.showAllProductCards()
                }

                OperationCodes.NEW_EMPLOYEE -> hr.addWorker();
                OperationCodes.FIRE_EMPLOYEE -> hr.fireEmployee();
                OperationCodes.SHOW_ALL_EMPLOYEES -> hr.showAllEmployees();
                OperationCodes.CHANGE_SALARY -> hr.changeSalary();
                OperationCodes.SAFE_CHANGES -> {
                    WorkersRepository.saveChanges()
                    ProductCardsRepository.saveChanges()
                }
            }
        }
    }


    private fun punctuationMarks(index: Int, size: Int) {
        if (index < size) {
            print(", ")
        } else {
            print("): ")
        }
    }

    override fun toString(): String {
        return "id: $id, name: $name, age: $age, post: $post, salary: ${this.getSalary()}"
    }
}