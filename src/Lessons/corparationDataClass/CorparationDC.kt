package Lessons.corparationDataClass

import Lessons.corparationDataClass.employees.Accountant
import Lessons.corparationDataClass.employees.Consultant
import Lessons.corparationDataClass.employees.Director
import Lessons.corparationDataClass.employees.Secretary
import Lessons.corparationDataClass.reposits.WorkersRepository

fun main() {

//
//    val consultant = Consultant(0, "Max", 32, 55_000)
//    val director = Director(0, "BigBoss", 45, 150_000);
    val accountant = Accountant(0, "Lisa", 45, 80_000)
//    accountant.work()

    val secretary: Secretary? = WorkersRepository.findSecretary()
    val director: Director? = WorkersRepository.findDirector()
    secretary?.printInfo()
    director?.printInfo()

    if (secretary != null) {
        director?.takeCoffee(secretary, 2, "moquiato")
    }

    val directorSalary = director?.salary ?: 0 // elvis-оператор
}
