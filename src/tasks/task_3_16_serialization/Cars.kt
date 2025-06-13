package tasks.task_3_16_serialization

import java.io.File

class Car(
    val make: String,
    val model: String,
    val year: Int,
    val vin: String,
    val color: String,
)

fun serialize(car: Car): String {
    return "${car.make}%${car.model}%${car.year}%${car.vin}%${car.color}"

}

fun deserialize(carAsString: String): Car {
    val properties = carAsString.split("%")
    return Car(properties[0], properties[1], properties[2].toInt(), properties[3], properties[4])

}