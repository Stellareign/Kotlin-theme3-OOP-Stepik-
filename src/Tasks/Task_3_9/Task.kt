package Tasks.Task_3_9

fun main() {
    val param = readln().split(" ");
    val warehouse = Warehouse();
    val deliveryObject = DeliveryObject(
        length = param[0].toInt(),
        width = param[1].toInt(),
        height = param[2].toInt(),
        weight = param[3].toDouble()
    );
    warehouse.packCargo(deliveryObject).printInfo();

}