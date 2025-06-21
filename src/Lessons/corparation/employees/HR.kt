package Lessons.corparation.employees

import Lessons.corparation.enum.Workers
import Lessons.corparation.parents.Worker
import java.io.File
import kotlin.text.split

class HR(id: Int, name: String, age: Int) : Worker(id, name, age, Workers.HR) {

    override fun work() {
    }

    private val posts = Workers.entries;
    private val staffFile = File("StaffFile.txt");
    private val postsCodes = Workers.entries;

    fun showAllEmployees() {
        val employeesList = readFileToList(staffFile)
        for (worker in employeesList) {
            println(worker);
        }
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
        staffFile.appendText("\n${worker.id}%${worker.name}%${worker.age}%${worker.post}");
    }

    private fun rewriteEmployeesListToFile(employees: List<Worker>) {
        val fileContent = employees.joinToString("\n") { worker ->
            "${worker.id}%${worker.name}%${worker.age}%${worker.post}"
        }
        staffFile.writeText(fileContent)
    }

    private fun readFileToList(file: File): MutableList<Worker> {
        val employeesList = mutableListOf<Worker>()
        if (!file.exists()) {
            println("File does not exist");
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
        var employee = Worker(0, "", 0, Workers.NO_POST);
        for (worker in staffStringList) {
            val post = worker.last();
            when (post) {
                "${Workers.DIRECTOR}" -> employee =
                    Worker(worker[0].toInt(), worker[1], worker[2].toInt(), Workers.DIRECTOR);
                "${Workers.HR}" -> employee =
                    Worker(worker[0].toInt(), worker[1], worker[2].toInt(), Workers.HR);
                "${Workers.ACCOUNTANT}" -> employee =
                    Worker(worker[0].toInt(), worker[1], worker[2].toInt(), Workers.ACCOUNTANT);
                "${Workers.SECRETARY}" -> employee =
                    Worker(worker[0].toInt(), worker[1], worker[2].toInt(), Workers.SECRETARY);
                "${Workers.CONSULTANT}" ->
                    employee = Worker(worker[0].toInt(), worker[1], worker[2].toInt(), Workers.CONSULTANT);
            }
            employeesList.add(employee)
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
        val newEmployee = safeWorker(id, name, age, post);
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

    private fun safeWorker(id: Int, name: String, age: Int, post: Int): Worker {
        val newWorker = Worker(id, name, age, Workers.NO_POST)
        when (posts[post]) {
            Workers.DIRECTOR -> return Director(id, name, age)
            Workers.HR -> return HR(id, name, age)
            Workers.ACCOUNTANT -> return Accountant(id, name, age)
            Workers.SECRETARY -> return Secretary(id, name, age)
            Workers.CONSULTANT -> return Consultant(id, name, age)
            Workers.NO_POST -> return newWorker;
        }
    }
}