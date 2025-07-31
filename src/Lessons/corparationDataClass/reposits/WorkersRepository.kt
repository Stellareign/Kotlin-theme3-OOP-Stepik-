package Lessons.corparationDataClass.reposits

import Lessons.corparationDataClass.employees.Accountant
import Lessons.corparationDataClass.employees.Consultant
import Lessons.corparationDataClass.employees.Director
import Lessons.corparationDataClass.employees.HR
import Lessons.corparationDataClass.employees.Secretary
import Lessons.corparationDataClass.enum.Workers
import Lessons.corparationDataClass.parents.Worker
import java.io.File

object WorkersRepository {

    private val staffFile = File("StaffFile.txt")
    private val _employeesSet: MutableSet<Worker> =
        readFileToList() // backing field (внутреннее поле для работы с оригинальной коллекцией)

    val employeesList: List<Worker> // наружу принято отдавать неизменяемую коллекцию
        get() = _employeesSet.toList().sortedBy { it.id } // .toMutableList() - создаём копию коллекции, с котрой работаем в оперативной памяти


    fun registerNewEmployee(worker: Worker) {
        for (employee in _employeesSet) {
            if (worker == employee) {
                print("Работник  ${employee.id} уже есть в базе. Нельзя создавать дубликат\n")
                return
            }
            _employeesSet.add(worker);
            print("Работник  ${employee.id} добавлен")

        }
    }


    private fun rewriteEmployeesListToFile() {
        val fileContent = _employeesSet.joinToString("\n") { worker ->
            "${worker.id}%${worker.name}%${worker.age}%${worker.salary}%${worker.post}"
        }
        staffFile.writeText(fileContent)
    }

    private fun readFileToList(): MutableSet<Worker> {
        val employees = mutableSetOf<Worker>();
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
        val worker = _employeesSet.find { it.id == id }
        if (worker == null) {
            println("Сотрудник не найден.")
        } else {
            print("Сотрудник $worker уволен \n")
            _employeesSet.remove(worker)
        }
    }

    fun changeSalary(id: Int, newSalary: Int) {
        val worker = _employeesSet.find { it.id == id }
        if (worker == null) {
            println("Сотрудник не найден.")
        } else {
            val workerWithNewSalary = worker.copy(salary = newSalary)
            print("Зарплата сотрудника ${worker.id} изменена на ${workerWithNewSalary.salary}\n")
            _employeesSet.remove(worker)
            _employeesSet.add(workerWithNewSalary)


        }
    }

    fun changeAge(id: Int, newAge: Int) {
        val worker = _employeesSet.find { it.id == id }
        if (worker == null) {
            println("Сотрудник не найден.")
        } else {
            val workerWithNewAge = worker.copy(age = newAge)
            print("Возраст сотрудника ${worker.id} изменён на ${workerWithNewAge.age}\n")
            _employeesSet.remove(worker)
            _employeesSet.add(workerWithNewAge)
        }
    }

    fun saveChanges() {
        rewriteEmployeesListToFile()
    }
}