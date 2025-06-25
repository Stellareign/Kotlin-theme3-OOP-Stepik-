package tasks.task_3_22_Interface

class Compressor : DataProcessor(), Transformable {

    override fun transform(data: String): String {
        return "Compressor преобразовал данные: compressed_$data";
    }

    override fun process(data: String): String {
        return "Обработчик: Compressor обработал данные";
    }
}