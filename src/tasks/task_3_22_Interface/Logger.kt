package tasks.task_3_22_Interface

class Logger : DataProcessor() {
    override fun process(data: String): String {
        return "Обработчик: Logger обработал данные";
    }
}