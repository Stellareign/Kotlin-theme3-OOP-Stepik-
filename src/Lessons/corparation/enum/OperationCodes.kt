package Lessons.corparation.enum

enum class OperationCodes (val title: String) {
    EXIT ("Выход и сохранить изменения"),
    REGISTER_ITEM ("Добавить товар"),
    SHOW_ALL_PRODUCTS ("Показать все товары"),
    DELETE_ITEM ("Удалить товар"),
    NEW_EMPLOYEE ("Добавить сотрудника"),
    FIRE_EMPLOYEE ("Уволить сотрудника"),
    SHOW_ALL_EMPLOYEES ("Список сотрудников"),
    CHANGE_SALARY ("Изменить зарплату"),
    SAFE_CHANGES ("Сохранить изменения в БД")

}