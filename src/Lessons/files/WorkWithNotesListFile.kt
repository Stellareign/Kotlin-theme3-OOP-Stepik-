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
                punctuationMarks(index, noteCommand.size -1);
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

    fun punctuationMarks(index: Int, size: Int) {
        if (index < size) {
            print(", ")
        } else {
            print("): ")
        }
    }

    fun readAdnSaveNotesListInCollection(){
        val notesList = notesListFile.readText().trim() // trim - удаляется все лишние пробелы и переносы строки
        for ((index, note) in notesList.split("\n") .withIndex()) {
            println("${index+1} - ${note}");
        }

    }


}