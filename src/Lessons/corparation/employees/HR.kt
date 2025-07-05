package Lessons.corparation.employees

import Lessons.corparation.enum.Workers
import Lessons.corparation.parents.Worker
import java.io.File
import kotlin.text.split

class HR(
    id: Int,
    name: String,
    age: Int,
    salary : Int
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

    override fun clean() {
        super.clean()
    }

    override fun work() {
        println("Я принимаю и увольняю сотрудников")
    }

    private val posts = Workers.entries;
    private val staffFile = File("StaffFile.txt");
    private val postsCodes = Workers.entries;

    fun changeSalary() {
        val employeesList = readFileToList(staffFile);
        print("Введите id сотрудника: ")
        val id = readln().toInt();
        val worker = employeesList.find { it.id == id }
        if (worker == null) {
            println("Сотрудник не найден.")
        } else {
            print("Укажите новый размер зарплаты: ")
            val newSalary = readln().toInt();
            worker.setSalary(newSalary);
            rewriteEmployeesListToFile(employeesList)
        }
    }

    fun showAllEmployees(): MutableList<Worker> {
        val employeesList = readFileToList(staffFile)
        for (worker in employeesList) {
            println(worker);
        }
        return employeesList;
    }

    fun fireEmployee() {
        val employeesList = readFileToList(staffFile);
        print("Введите id сотрудника: ")
        val id = readln().toInt();
        val woker = employeesList.find { it.id == id }
        if (woker == null) {
            println("Сотрудник не найден.")
        } else {
            print("Сотрудник $woker уволен \n")
            employeesList.remove(woker)
            rewriteEmployeesListToFile(employeesList)
        }
    }

    private fun writeEmployeeToFile(worker: Worker) {
        staffFile.appendText("\n${worker.id}%${worker.name}%${worker.age}%${worker.getSalary()}%${worker.post}");
    }

    private fun rewriteEmployeesListToFile(employees: List<Worker>) {
        val fileContent = employees.joinToString("\n") { worker ->
            "${worker.id}%${worker.name}%${worker.age}%${worker.getSalary()}%${worker.post}"
        }
        staffFile.writeText(fileContent)
    }

    private fun readFileToList(file: File): MutableList<Worker> {
        val employeesList = mutableListOf<Worker>()
        if (!file.exists()) {
            println("File does not exist");
            return employeesList;
        }
        val staffString = file.readText().trim();
        if (staffString.isEmpty()) {
            println("File is empty");
        }
        val staffListFromFile = staffString.split("\n");
        val staffStringList = mutableListOf<List<String>>();

        for (stringWorker in staffListFromFile) {
            val s = stringWorker.split("%");
            staffStringList.add(s)
        }

        for (worker in staffStringList) {
            val post = worker.last();

            when (post) {
                "${Workers.DIRECTOR}" ->
                    employeesList.add(Director(worker[0].toInt(), worker[1],
                        worker[2].toInt(), worker[3].toInt()));
                "${Workers.HR}" ->
                    employeesList.add(HR(worker[0].toInt(), worker[1],
                        worker[2].toInt(), worker[3].toInt()));
                "${Workers.ACCOUNTANT}" ->
                    employeesList.add(Accountant(worker[0].toInt(), worker[1],
                        worker[2].toInt(), worker[3].toInt()));
                "${Workers.SECRETARY}" ->
                    employeesList.add(Secretary(worker[0].toInt(), worker[1],
                        worker[2].toInt(), worker[3].toInt()));
                "${Workers.CONSULTANT}" ->
                    employeesList.add(Consultant(worker[0].toInt(), worker[1],
                        worker[2].toInt(), worker[3].toInt()));
            }
        }
        return employeesList;
    }

    fun addWorker(): List<Worker> {
        val employeesList = readFileToList(staffFile)
        print("Введите id сотрудника равное: ")
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
        employeesList.add(newEmployee);
        println("Добавлен сотрудник ${newEmployee}");
        writeEmployeeToFile(newEmployee);
        return employeesList;
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
        return "id: $id, name: $name, age: $age, post: $post, salary: ${getSalary()}()}"
    }
}