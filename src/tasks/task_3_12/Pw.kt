package tasks.task_3_12

class Pw {
    open  class TaskPW(
        val brand: String,
        val model: String,
    ) {
        open fun turnOn() {
            println("Электроинструмент включен")
        }
    }

     class Drill(
        brand: String,
        model: String,
        val drillChuckDiameter: Int,
    ) : TaskPW(brand, model) {

        override fun turnOn() {
            println("Дрель сверлит");
        }

    }

      class AngleGrinder(
        brand: String,
        model: String,
        val discDiameter: Int,
    ) : TaskPW(brand, model) {

        override fun turnOn() {
            println("УШМ режет");
        }

    }

     class ChainSaw(
        brand: String,
        model: String,
        val chainSawTireLength: Int,
    ) : TaskPW(brand, model) {

        override fun turnOn() {
            println("Цепная пила пилит");
        }
        //переопределить метод turnOn()
    }

}