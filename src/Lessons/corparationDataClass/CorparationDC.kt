package Lessons.corparationDataClass

import Lessons.corparationDataClass.employees.Accountant
import Lessons.corparationDataClass.employees.Consultant
import Lessons.corparationDataClass.employees.Director
fun main() {


    val consultant = Consultant(0, "Max", 32, 55_000)
    val director = Director(0, "BigBoss", 45, 150_000);
    val accountant = Accountant(0, "Lisa", 45, 80_000)

    println(accountant);
    accountant.work()

}
