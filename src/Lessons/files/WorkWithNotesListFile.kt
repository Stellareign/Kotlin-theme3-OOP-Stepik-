package Lessons.files

import java.io.File

class WorkWithNotesListFile {
    val notesListFile = File("notes.txt");
    val noteCommand = DaryOperationCodes.entries;

    fun workWithNotesList() {
        while (true) {
            print("Введите команду: ");
            for ((index, command) in noteCommand.withIndex()) {
                print("$index - ${command.title}: ")
            }
            val operationCode = readln().toInt();

            when (noteCommand[operationCode]) {
                DaryOperationCodes.EXIT -> break;
                DaryOperationCodes.WRIGHT_NOTE -> {
                    print("Введите задачу: ")
                    val task = readln()
                    notesListFile.appendText("$task\n");
                }

                DaryOperationCodes.READ_NOTES_LIST -> {
                    print(notesListFile.readText());
                    break;
                }
            }
        }
    }
}