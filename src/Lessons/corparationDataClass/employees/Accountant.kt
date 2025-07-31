package Lessons.corparationDataClass.employees

import Lessons.corparationDataClass.enum.OperationCodes
import Lessons.corparationDataClass.enum.ProductTypes
import Lessons.corparationDataClass.enum.Workers
import Lessons.corparationDataClass.parents.Worker
import Lessons.corparationDataClass.reposits.ProductCardsRepository
import Lessons.corparationDataClass.reposits.WorkersRepository


data class Accountant(
    override val id: Int = 0,
    override val name: String = "",
    override val age: Int = 0,
    override val salary: Int = 0
) : Worker(id, name, age, Workers.ACCOUNTANT, salary), Cleaner, Supplier {

    private val productsTypes = ProductTypes.entries;
    private val operation = OperationCodes.entries;
    private val hr = HR();


    override fun delivery() {
        println("${name}: доставляю товары")
    }


    override fun copy(salary: Int, age: Int): Accountant { //метод создания копии объекта - алее сохраняется в коллекцию вместо старого
       return Accountant(this.id, this.name, age, salary)
    }

    override fun work() {
        while (true) {
            print("Введите код операции: \n");
            for ((index, operationName) in operation.withIndex()) {
                print("$index - ${operationName.title}\n")
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
                OperationCodes.CHANGE_AGE -> hr.changeAge();
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
        return "id: $id, name: $name, age: $age, post: $post, salary: $salary"
    }
}