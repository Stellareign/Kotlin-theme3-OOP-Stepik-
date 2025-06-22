package tasks.task_3_21_Abstract


class Rectangle(name: String, val width: Double, val height: Double) : Shape(name) {

    override fun area(): Double {
        return roundToTwoDecimals(width * height)
    }

    override fun perimeter(): Double {
        return roundToTwoDecimals(2 * (height + width))
    }
}