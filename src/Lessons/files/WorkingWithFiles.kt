package Lessons.files

import Lessons.corparation.enum.OperationCodes
import jdk.javadoc.internal.doclets.formats.html.markup.HtmlStyle
import java.io.File
import kotlin.system.exitProcess

fun main() {
//    val file = File("lessons.txt");
//    file.writeText("Hello"); // перезаписывает содержимое файла
//    file.appendText(", World!"); // добавляет текст в файл
//    val file = File("to-do_list.txt");
//    while (true) {
//        print("Введите задачу: ");
//        val task = readln();
//        if (task != "0") {
//            file.appendText("\n$task;");
//        } else {
//            break;
//        }
//    }
//    println(file.readText());


    val wwnlf = WorkWithNotesListFile();
    wwnlf.workWithNotesList();

}