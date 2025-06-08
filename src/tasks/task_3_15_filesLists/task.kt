package tasks.task_3_15_filesLists

/**
 * Реализуйте функцию task(listUser: List<String>): List<String>, которая принимает
 * неизменяемую коллекцию строк (список пользователей) в качестве аргумента.
 * Функция должна внутри себя преобразовать эту коллекцию в мутабельную, обработать действие,
 * введенное пользователем, и вернуть результат в виде неизменяемой коллекции.
 */
fun main() {
    val listUser = listOf<String>("user1", "user2", "user3", "user4", "user5", "user6")

    val commands = Commands.entries;
    fun task(listUser: List<String>): List<String> {
        val users = mutableListOf<String>();
        users.addAll(listUser);
        print("Введите команду: ");
        for ((index, command) in commands.withIndex()) {
            print("${index} - ${command.title}");
            punctuationMarks(index, commands.size - 1)
        }
        val commandCode = readln().toInt();
        val userCommand = commands[commandCode];
        if (userCommand ==  Commands.ADD) {
                print("Введите имя элемента: ");
                val item = readln();
                users.add(item);
                printUsers(users);
            } else if (userCommand ==  Commands.REMOVE) {
                print("Введите название элемента для удаления: ");
                val item = readln();
                if(users.contains(item)) {
                    users.remove(item);
                    printUsers(users);
                } else {
                    printUsers(users);
                }
            } else if (userCommand ==  Commands.SHOW) {
                printUsers(users);
            } else if (userCommand == Commands.REMOVE_AT){
                print("Введите индекс элемента для удаления: ");
                val index = readln().toInt();
                users.removeAt(index);
                printUsers(users);
            } else {
                print("Некорректное значение");
            }
        return users;
    }
    task(listUser);
}
fun punctuationMarks(index: Int, size: Int) {
    if (index < size) {
        print(", ")
    } else {
        print(": ")
    }
}

fun printUsers(users: List<String>) {
    for (item in users){
        println(item);
    }
}