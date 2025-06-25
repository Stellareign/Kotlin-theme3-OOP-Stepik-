package tasks.task_3_22_Interface

class Encryptor : DataProcessor(), Transformable {
    val cl = (Encryptor :: class.java).simpleName

    override fun transform(data: String): String {
       return "$cl преобразовал данные: encoded_$data";
    }
    override fun process(data: String): String {
       return "Обработчик: $cl обработал данные";
    }
}