package tasks.`3_22_Interface`

class Encryptor : DataProcessor(), Transformable {
    val cl = Encryptor :: class.java
    override fun transform(data: String): String {
       return "${cl.simpleName} преобразовал данные: encoded_$data";
    }
    override fun process(data: String): String {
       return "Обработчик: ${cl.simpleName} обработал данные";
    }
}