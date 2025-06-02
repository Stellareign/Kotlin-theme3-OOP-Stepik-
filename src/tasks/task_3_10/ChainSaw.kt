package tasks.task_3_10

class ChainSaw(
    val chainSawTireLength: Int, // длина шины
    val chainLinksCount: Int, // кол-во звеньев цепи
    val chainStep: Double, // шаг цепи
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
}