package tasks.task_3_10

/**
 * родительский класс
 */
open class PowerTool(
    val brand: String, // марка
    val model: String, // модель
    val power: Int, // мощность
    val weight: Double, //вес
    val cableLength: Int, //длина кабеля
    val price: Price, //цена
    val voltage: Int = 220 //напряжение, со значением по умолчанию 220
) {
}