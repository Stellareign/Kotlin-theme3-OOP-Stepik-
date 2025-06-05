package tasks.task_3_10
//ДРЕЛЬ
class Drill(
    val drillChuckDiameter: Int, // диаметр сверлильного патрона
    val minRotationSpeed: Int, // минимальная скорость вращения
    val maxRotationSpeed: Int, //максимальная скорость вращения
    brand : String,
    model : String,
    power : Int,
    weight: Double,
    cableLength : Int,
    price : Price,
    voltage : Int
) : PowerTool(
    brand = brand,
    model = model,
    power = power,
    weight = weight,
    cableLength = cableLength,
    price = price
)
{
    override fun turnOn() {
        println("Дрель сверлит");
    }
}