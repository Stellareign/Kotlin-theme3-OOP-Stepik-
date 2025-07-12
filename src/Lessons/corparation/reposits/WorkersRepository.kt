package Lessons.corparation.reposits

import Lessons.corparation.employees.Accountant
import Lessons.corparation.employees.Consultant
import Lessons.corparation.employees.Director
import Lessons.corparation.employees.HR
import Lessons.corparation.employees.Secretary
import Lessons.corparation.enum.Workers
import Lessons.corparation.parents.Worker
import java.io.File

class WorkersRepository {

    private val staffFile = File("StaffFile.txt")
    val employeesList = readFileToList() // держим список в оперативной памяти для сокращения обращений в оперативной памяти

    private fun writeEmployeeToFile(worker: Worker) {
        staffFile.appendText("\n${worker.id}%${worker.name}%${worker.age}%${worker.getSalary()}%${worker.post}");
    } // теперь метод не нужен

    fun registerNewEmployee(worker: Worker) {
//        writeEmployeeToFile(worker)
        employeesList.add(worker);
    }


    private fun rewriteEmployeesListToFile() {
        val fileContent = employeesList.joinToString("\n") { worker ->
            "${worker.id}%${worker.name}%${worker.age}%${worker.getSalary()}%${worker.post}"
        }
//        val content = StringBuilder()
//        for(worker in employeesList) {
//            content.append("${worker.id}%${worker.name}%${worker.age}%${worker.getSalary()}%${worker.post}\n")
//        }
        staffFile.writeText(fileContent)
    }

    private fun readFileToList(): MutableList<Worker> {
        val employees = mutableListOf<Worker>();
        if (!staffFile.exists()) {
            println("File does not exist");
            staffFile.createNewFile()
        }
        val staffString = staffFile.readText().trim();
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
                    employees.add(
                        Director(
                            worker[0].toInt(), worker[1],
                            worker[2].toInt(), worker[3].toInt()
                        )
                    );
                "${Workers.HR}" ->
                    employees.add(
                        HR(
                            worker[0].toInt(), worker[1],
                            worker[2].toInt(), worker[3].toInt()
                        )
                    );
                "${Workers.ACCOUNTANT}" ->
                    employees.add(
                        Accountant(
                            worker[0].toInt(), worker[1],
                            worker[2].toInt(), worker[3].toInt()
                        )
                    );
                "${Workers.SECRETARY}" ->
                    employees.add(
                        Secretary(
                            worker[0].toInt(), worker[1],
                            worker[2].toInt(), worker[3].toInt()
                        )
                    );
                "${Workers.CONSULTANT}" ->
                    employees.add(
                        Consultant(
                            worker[0].toInt(), worker[1],
                            worker[2].toInt(), worker[3].toInt()
                        )
                    );
            }
        }
        return employees;
    }

    fun fireEmployee(id: Int) {
        val worker = employeesList.find { it.id == id }
        if (worker == null) {
            println("Сотрудник не найден.")
        } else {
            print("Сотрудник $worker уволен \n")
            employeesList.remove(worker)
//            rewriteEmployeesListToFile(employeesList)
        }
    }

    fun changeSalary(id: Int, newSalary: Int) {
        val worker = employeesList.find { it.id == id }
        if (worker == null) {
            println("Сотрудник не найден.")
        } else {
            worker.setSalary(newSalary);
//            rewriteEmployeesListToFile(employeesList)
        }
    }

    fun saveChanges() {
        employeesList.sortedBy{it.id}
        rewriteEmployeesListToFile()
    }
}