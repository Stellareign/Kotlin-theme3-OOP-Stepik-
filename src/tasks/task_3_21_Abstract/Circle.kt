package tasks.task_3_21_Abstract

class Circle(
    val radius: Double
) : Shape(name = "circle") {

    override fun area(): Double {
        val area= Math.PI * radius * radius;
        return roundToTwoDecimals(area);
    }

    override fun perimeter(): Double {
        val circleLong = 2* Math.PI * radius;
        return roundToTwoDecimals(circleLong);
    }
}