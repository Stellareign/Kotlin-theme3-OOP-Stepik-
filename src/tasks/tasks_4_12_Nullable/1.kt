package tasks.tasks_4_12_Nullable


/**
 * Разработайте метод для класса ViewModel, который получает данные из репозитория и подготавливает их для отображения в UI.
 * Репозиторий возвращает список объектов UserData?, где каждое поле объекта может быть null. Ваша задача:
 * Получить данные из репозитория с помощью функции Repository.getUsers().
 * Удалить все null элементы списка.
 * Заменить null значения полей в UserData на следующие дефолтные значения:
 * name: String? → "Unknown Name"
 * email: String? → "Unknown Email"
 * age: Int? → 0
 * Вернуть отформатированный список строк, где каждая строка имеет формат:  Name: <name>, Email: <email>, Age: <age>.
 */
data class UserData(
    val name: String?,
    val email: String?,
    val age: Int?

) {
    override fun toString(): String {
        return "Name: $name, Email: $email, Age: $age"
    }
}

interface Repository {
    /**
     * Возвращает список пользователей, некоторые элементы или их поля могут быть null.
     */
    fun getUsers(): List<UserData?>
}

class UserViewModel(private val repository: Repository) {

    /**
     * Реализуйте метод getUserDescriptions, который:
     * 1. Получает данные из репозитория.
     * 2. Удаляет null элементы списка.
     * 3. Заменяет null значения в полях name, email и age на дефолтные.
     * 4. Формирует строки в формате: "Name: [name], Email: [email], Age: [age]".
     *
     * @return Список строк с описаниями пользователей.
     */
    fun getUserDescriptions(): List<String> {
        // Реализуйте логику здесь
        val userList = mutableListOf<String>()
        val nullUserList = mutableListOf<String>()
        val noName = "Name: Unknown Name"
        val noEmail = "Email: Unknown Email"
        val noAge = "Age: 0"
        for (userData in repository.getUsers().filterNotNull()) {
            userList.add(userData.toString())
        }
        userList.forEach { stringData ->
            val firstStep = stringData.replace("Name: null", noName)
            val secondStep = firstStep.replace("Email: null", noEmail)
            val thirdStep = secondStep.replace("Age: null", noAge)
            nullUserList.add(thirdStep)
        }
        return nullUserList
    }

}

fun main() {
    val repository = object : Repository {
        override fun getUsers(): List<UserData?> {
            // Здесь можно вернуть тестовые данные
            return listOf(
                UserData("Alice", "alice@example.com", 30),
                null,
                UserData(null, "guest@example.com", 25),
                UserData("Bob", null, null),
                UserData(null, null, null),
                UserData("Charlie", "charlie@example.com", 40),
                UserData(null, "no-email@example.com", 10),
                UserData("Diana", "diana@example.com", 0),
                UserData("Eve", null, 35),
                null
            )
        }
    }

    // Создаем ViewModel и передаем ей репозиторий
    val userViewModel = UserViewModel(repository)

    // Вызываем метод и получаем результат
    val descriptions = userViewModel.getUserDescriptions()

    // Выводим результат
    descriptions.forEach { println(it) }
}

