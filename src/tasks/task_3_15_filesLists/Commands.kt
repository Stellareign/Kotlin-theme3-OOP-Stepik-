package tasks.task_3_15_filesLists

enum class Commands(val title : String) {
    SHOW ("Показать список"),
    ADD ("Добавить в список"),
    REMOVE ("Удалить по имени"),
    REMOVE_AT ("Удалить по номеру")
}