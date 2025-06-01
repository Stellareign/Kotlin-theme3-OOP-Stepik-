import Tasks.Car
import Tasks.Monster

fun main() {
//    val car : Car = Car(brand = readln(), model = readln(), enginePower = readln().toInt(), bodyColor = readln())
//    car.init(brand = readln(), model = readln(), enginePower = readln().toInt(), bodyColor = readln());
//    car.drive();
//    val param = readln().split(" ");
//    val car : Car = Car(param[0], param[1], param[2].toInt(), param[3])
//    car.printInfo()
    val monsterParam = readln().split(" ");

    val monster: Monster = Monster(
        monsterParam[0].toInt(), monsterParam[1].toInt(),
        monsterParam[2].toInt(), monsterParam[3].toInt(), monsterParam[4].toInt()
    );

    monster.printInfo()
}