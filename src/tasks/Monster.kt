package tasks

import kotlin.random.Random

class Monster(
    val pawsCount: Int, // лапы // это первичный конструктор - та принято делать в Kotlin
    val eyesCount: Int, // глаза // объявление конструктора в полях класса -> можно не создавать конструктор со всем полями - меньше кода
    val fangsCount: Int, // клыки // в нём можно установить значения по умолчанию, которые будут передаваться во вторичный конструктор, который без параметров
    val clawsCount: Int, // когти
    val tentaclesCount: Int // щупальца
) {

    constructor(count: Int) : this(
        count,
        count,
        count,
        count,
        count
    )

    constructor() : this(
        Random.nextInt(1, 10),
        Random.nextInt(1, 10),
        Random.nextInt(1, 10),
        Random.nextInt(1, 10),
        Random.nextInt(1, 10)
     );

    fun printInfo() {
        println("Кол-во лап: $pawsCount\nКол-во глаз: $eyesCount\nКол-во клыков: $fangsCount\nКол-во когтей: $clawsCount\nКол-во щупалец: $tentaclesCount")
    }

}


