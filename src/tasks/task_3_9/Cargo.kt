package tasks.task_3_9

class Cargo(
    val length: Int,
    val width: Int,
    val height: Int,
    val typePackaging: String,
    val netWeight: Double,
    val grossWeight: Double
) {

    fun printInfo() {
        print(
            """Длина: ${length}
Ширина: ${width}
Высота: ${height}
Тип упаковки: ${typePackaging}
Вес нетто: ${netWeight}
Вес брутто: ${grossWeight}"""
        )
    }
}