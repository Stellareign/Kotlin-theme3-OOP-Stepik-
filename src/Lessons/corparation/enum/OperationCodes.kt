package Lessons.corparation.enum

enum class OperationCodes (val title: String) {
    EXIT ("Выход"),
    REGISTER_ITEM ("Добавить товар"),
    SHOW_ALL_PRODUCTS ("Показать все товары"),
    DELETE_ITEM ("Удалить карточку"),
    NEW_EMPLOYEE ("Добавить сотрудника"),
    FIRE_EMPLOYEE ("Уволить сотрудника"),
    SHOW_ALL_EMPLOYEES ("Список сотрудников"),
    CHANGE_SALARY ("Изменить зарплату")

}