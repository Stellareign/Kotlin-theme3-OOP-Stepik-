import Tasks.Car

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
//    val car : Car = Car(brand = readln(), model = readln(), enginePower = readln().toInt(), bodyColor = readln())
//    car.init(brand = readln(), model = readln(), enginePower = readln().toInt(), bodyColor = readln());
//    car.drive();
    val param = readln().split(" ");
    val car : Car = Car(param[0], param[1], param[2].toInt(), param[3])
    car.printInfo()


}