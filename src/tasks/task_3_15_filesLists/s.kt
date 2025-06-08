package tasks.task_3_15_filesLists

/**
 * решение для тестера степика (без енумов и классов)
 */
fun main() {

    fun task(listUser: List<String>): List<String> {
        val users = mutableListOf<String>();
        users.addAll(listUser);
        val userCommand = readln();

        if (userCommand == "ADD") {
            val item = readln();
            users.add(item);
            for (item in users){
                println(item);
            }
        } else if (userCommand == "REMOVE") {
            val item = readln();
            if(users.contains(item)) {
                users.remove(item);
                for (item in users){
                    println(item);
                }
            } else {
                for (item in users){
                    println(item);
                }
            }
        } else if (userCommand == "SHOW") {
            for (item in users){
                println(item);
            }
        } else if (userCommand == "REMOVE_AT"){
            val index = readln().toInt();
            users.removeAt(index);
            for (item in users){
                println(item);
            }
        } else {
            print("Некорректное значение");
        }
        return users;
    }
}