package tasks.task_4_3_SRP

import kotlin.io.path.Path

/**
 * Задача: Разделение обязанностей в классе с применением принципа SRP
 * Дан класс UserRegistrationService, который занимается регистрацией пользователей. Этот класс выполняет несколько
 * обязанностей: валидацию данных пользователя, хеширование пароля и сохранение информации в базу данных. Ваша задача —
 * применить принцип SRP и выделить хеширование пароля в отдельный класс PasswordHasher.
 * Описание задачи
 * Создайте новый класс PasswordHasher, который будет ответственен за хеширование паролей.
 * Переместите метод hashPassword из класса UserRegistrationService в новый класс PasswordHasher.
 * Обновите UserRegistrationService, чтобы он использовал PasswordHasher для хеширования паролей.
 */
class UserRegistrationService {
    private val registeredUsers = mutableListOf<String>()
    private val passwordHasher = PasswordHasher()

    // Метод для валидации данных пользователя
    fun validateUserData(username: String, password: String): Boolean {
        return username.isNotBlank() && password.length >= 8
    }

    // Метод для сохранения данных пользователя
    fun saveUser(username: String, passwordHash: String) {
        registeredUsers.add("$username:$passwordHash")
    }

    // Метод для регистрации пользователя
    fun registerUser(username: String, password: String): Boolean {
        if (!validateUserData(username, password)) {
            println("Invalid user data")
            return false
        }

        val passwordHash = passwordHasher.hashPassword(password)
        saveUser(username, passwordHash)
        println("User registered successfully")
        return true
    }
}
