package tasks.task_3_9

class Car {
    val brand : String;
    val model :String;
    val enginePower : Int;
    val bodyColor :String;

    constructor(brand: String, model: String, enginePower: Int, bodyColor: String) {
        this.brand = brand;
        this.model = model;
        this.enginePower = enginePower;
        this.bodyColor = bodyColor;
    }

    fun printInfo(){
        println("$brand $model $enginePower л.с. $bodyColor")
    }


//    fun init (brand: String, model: String, enginePower: Int, bodyColor: String){
//        this.brand = brand;
//        this.model = model;
//        this.enginePower = enginePower;
//        this.bodyColor = bodyColor;
//    }
    fun drive () {
        if(enginePower<120) {
            println("Еду далеко, но небыстро на $brand $model")
        } else{
            println("Еду быстро, но недалеко на $brand $model")
        }
    }
    fun  refuel1(
        stationNAme: String,
        petrolBrand: String,
        petrolCount: Int
    ) {
        println("Произведена заправка на АЗС \"$stationNAme\"" );
        println ("Марка бензина: $petrolBrand");
        println ("Кол-во литров: $petrolCount");
    }

    fun  refuel(parameters : String = readln()) {
        val param =parameters.split(" ");
        println("Произведена заправка на АЗС \'${param[0]}\"" );
        println ("Марка бензина: ${param[1]}");
        println ("Кол-во литров: ${param[2].toInt()}");
    }

}