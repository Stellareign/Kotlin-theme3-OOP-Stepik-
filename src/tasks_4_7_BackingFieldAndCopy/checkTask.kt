package tasks_4_7_BackingFieldAndCopy


fun main() {
    val project = Project("My")
    project.addEmployee(Employee(1, "Anna"))
    project.addEmployee(Employee(2, "Maria"))
    project.addEmployee(Employee(3, "Anton"))
    project.printAllTasks()
    project.assignTaskToEmployee(1, Task(1, "T1", "desk", "unknow", "nothing", "super'"))
    project.assignTaskToEmployee(2, Task(2, "T1", "desk2", "2unknow", "nothing2", "2super'"))
    project.assignTaskToEmployee(3, Task(3, "T1", "desk2", "2unknow", "nothing2", "2super'"))
    project.assignTaskToEmployee(2, Task(4, "T1", "desk6", "op_unknow", "nothing_do", "2super'"))

    project.printAllTasks()

}
