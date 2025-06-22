package tasks.task_3_21_Abstract


class Rectangle(
    val width: Double,
    val height: Double
) : Shape(name = "rectangle") {

    override fun area(): Double {
        return roundToTwoDecimals(width * height)
    }

    override fun perimeter(): Double {
        return roundToTwoDecimals(2 * (width + height))
    }
}