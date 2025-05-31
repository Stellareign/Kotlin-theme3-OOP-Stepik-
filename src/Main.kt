import Tasks.Car

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val car : Car = Car()
    car.init(brand = readln(), model = readln(), enginePower = readln().toInt(), bodyColor = readln());
    car.drive();

}