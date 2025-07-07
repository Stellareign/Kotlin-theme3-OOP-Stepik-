package tasks.task_4_2_Get_Set

class Config {
    var timeout = 30
        set(value) {
            if (value < 1 || value > 300) {
                println("Ошибка: Время ожидания должно быть в диапазоне от 1 до 300 секунд. Установлено значение по умолчанию.")
                field = timeout
            } else {
                field = value
            }
        }
    var maxRetries = 3
        set(value) {
            if (value < 0) {
                println("Ошибка: Максимальное количество повторных попыток не может быть отрицательным. Установлено значение по умолчанию.")
                field = maxRetries
            } else {
                field = value
            }
        }

    var loggingLevel: LogLevel = LogLevel.INFO
        set(value) {
            if (value == LogLevel.TRACE || value == LogLevel.FATAL) {
                println("Ошибка: Уровень $value недоступен.")
            } else {
                field = value
            }
        }

    val isDebugMode: Boolean
        get() = loggingLevel == LogLevel.DEBUG

    val isProductionMode: Boolean
        get() = loggingLevel == LogLevel.ERROR

    fun printConfig() {
        println(
            "Время ожидания: $timeout секунд\n" +
                    "Максимальное количество повторных попыток: $maxRetries\n" +
                    "Уровень логирования: $loggingLevel\n" +
                    "Режим отладки: $isDebugMode\n" +
                    "Режим продакшн: $isProductionMode"
        )
    }

}