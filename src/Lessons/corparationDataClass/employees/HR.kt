package Lessons.corparationDataClass.employees

import Lessons.corparationDataClass.enum.Workers
import Lessons.corparationDataClass.parents.Worker
import Lessons.corparationDataClass.reposits.WorkersRepository

data class HR(
    override val  id: Int = 0,
    override val  name: String = "",
    override val  age: Int = 0,
    override val  salary: Int = 0
) : Worker(
    id,
    name,
    age,
    Workers.HR,
    salary
), Cleaner, Supplier {


    override fun delivery() {
        println("${name}: доставляю товары")
    }


    override fun work() {
        println("Я принимаю и увольняю сотрудников")
    }

    private val posts = Workers.entries;
    private val postsCodes = Workers.entries;

    override fun copy(salary: Int, age: Int): HR { //метод создания копии объекта - алее сохраняется в коллекцию вместо старого
        return HR(this.id, this.name, age, salary)
    }

    fun changeSalary() {
        print("Введите id сотрудника: ")
        val id = readln().toInt();
        print("Введите новую зарплату сотрудника: ")
        val newSalary = readln().toInt();
        WorkersRepository.changeSalary(id, newSalary);
    }
    fun changeAge() {
        print("Введите id сотрудника: ")
        val id = readln().toInt();
        print("Введите новый возраст сотрудника: ")
        val newAge = readln().toInt();
        WorkersRepository.changeAge(id, newAge);
    }

    fun showAllEmployees() {
        for (worker in WorkersRepository.employeesList) {
            println(worker);
        }
    }

    fun fireEmployee() {
        print("Введите id сотрудника: ")
        val id = readln().toInt();
        WorkersRepository.fireEmployee(id)
    }

    fun addWorker(): List<Worker> {
        print("Введите id нового сотрудника: ")
        val id = readln().toInt();
        print("Введите имя сотрудника: ");
        val name = readln();
        print("Введите возраст сотрудника: ");
        val age = readln().toInt();
        print("Введите код должности сотрудника: ")
        for ((index, postCode) in postsCodes.withIndex()) {
            print("$index - ${postCode.title}")
            punctuationMarks(index, postsCodes.size - 1);
        }
        val post = readln().toInt();
        print("Укажите зарплату: ")
        val salary = readln().toInt();
        val newEmployee = safeWorker(id, name, age, post, salary);
        WorkersRepository.registerNewEmployee(newEmployee);
        return WorkersRepository.employeesList
    }

    private fun punctuationMarks(index: Int, size: Int) {
        if (index < size) {
            print(", ")
        } else {
            print("): ")
        }
    }

    private fun safeWorker(id: Int, name: String, age: Int, post: Int, salary: Int): Worker {
        when (posts[post]) {
            Workers.DIRECTOR -> return Director(id, name, age, salary)
            Workers.HR -> return HR(id, name, age, salary);
            Workers.ACCOUNTANT -> return Accountant(id, name, age, salary);
            Workers.SECRETARY -> return Secretary(id, name, age, salary)
            Workers.CONSULTANT -> return Consultant(id, name, age, salary);
            Workers.NO_POST -> TODO();
        }
    }

    override fun toString(): String {
        return "id: $id, name: $name, age: $age, post: $post, salary: $salary"
    }
}