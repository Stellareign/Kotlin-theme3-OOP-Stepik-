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

    private fun writeEmployeeToFile(worker: Worker) {
        staffFile.appendText("\n${worker.id}%${worker.name}%${worker.age}%${worker.getSalary()}%${worker.post}");
    }

    fun registerNewEmployee(worker: Worker) {
        writeEmployeeToFile(worker)
    }

    fun rewriteEmployeesListToFile(employees: List<Worker>) {
        val fileContent = employees.joinToString("\n") { worker ->
            "${worker.id}%${worker.name}%${worker.age}%${worker.getSalary()}%${worker.post}"
        }
        staffFile.writeText(fileContent)
    }

   private fun readFileToList(): MutableList<Worker> {
        val employeesList = mutableListOf<Worker>()
        if (!staffFile.exists()) {
            println("File does not exist");
            return employeesList;
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
                    employeesList.add(
                        Director(
                            worker[0].toInt(), worker[1],
                            worker[2].toInt(), worker[3].toInt()
                        )
                    );
                "${Workers.HR}" ->
                    employeesList.add(
                        HR(
                            worker[0].toInt(), worker[1],
                            worker[2].toInt(), worker[3].toInt()
                        )
                    );
                "${Workers.ACCOUNTANT}" ->
                    employeesList.add(
                        Accountant(
                            worker[0].toInt(), worker[1],
                            worker[2].toInt(), worker[3].toInt()
                        )
                    );
                "${Workers.SECRETARY}" ->
                    employeesList.add(
                        Secretary(
                            worker[0].toInt(), worker[1],
                            worker[2].toInt(), worker[3].toInt()
                        )
                    );
                "${Workers.CONSULTANT}" ->
                    employeesList.add(
                        Consultant(
                            worker[0].toInt(), worker[1],
                            worker[2].toInt(), worker[3].toInt()
                        )
                    );
            }
        }
        return employeesList;
    }
    fun readEmployeeList ()  : MutableList<Worker> {
        return readFileToList()
    }


    fun fireEmployee(id: Int) {
        val employeesList = readFileToList();
        val woker = employeesList.find { it.id == id }
        if (woker == null) {
            println("Сотрудник не найден.")
        } else {
            print("Сотрудник $woker уволен \n")
            employeesList.remove(woker)
          rewriteEmployeesListToFile(employeesList)
        }
    }

    fun changeSalary(id: Int, newSalary: Int) {
        val employeesList = readFileToList();
        val worker = employeesList.find { it.id == id }
        if (worker == null) {
            println("Сотрудник не найден.")
        } else {
            worker.setSalary(newSalary);
            rewriteEmployeesListToFile(employeesList)
            println("Сотрудник ${worker.name} теперь получает зарплату $newSalary")
        }
    }
}