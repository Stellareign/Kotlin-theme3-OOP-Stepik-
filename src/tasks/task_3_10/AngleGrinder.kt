package tasks.task_3_10
// УШМ
class AngleGrinder(
    val discDiameter: Int, // диаметр диска
    val isSmoothStart: Boolean, // наличие системы плавного пуска
    val isDustProtection: Boolean, //наличие защиты от пыли
    brand: String,
    model: String,
    power: Int,
    weight: Double,
    cableLength: Int,
    price: Price,
    voltage : Int
) : PowerTool(
    brand = brand,
    model = model,
    power = power,
    weight = weight,
    cableLength = cableLength,
    price = price
) {
    override fun turnOn() {
        println("УШМ режет");
    }
}