package Lessons.files

import java.io.File
import kotlin.system.exitProcess

fun main() {
//    val file = File("lessons.txt");
//    file.writeText("Hello"); // перезаписывает содержимое файла
//    file.appendText(", World!"); // добавляет текст в файл
    val file = File("to-do_list.txt");
    while (true) {
        print("Введите задачу: ");
        val task = readln();
        if (task != "0") {
            file.appendText("\n$task;");
        } else {
            break;
        }
    }
}