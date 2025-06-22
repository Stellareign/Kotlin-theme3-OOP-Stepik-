package tasks.task_3_21_Abstract

class Circle(name: String, val radius: Double) : Shape(name) {

    override fun area(value : Double): Double {
        return roundToTwoDecimals(Math.PI * radius * radius);
    }

    override fun perimeter(): Double {
        return roundToTwoDecimals(2* Math.PI * radius);
    }
}