package tasks_4_8_equals

// Класс с переопределенным методом equals по id
class Person(val id: Int, val name: String) {

    override fun hashCode(): Int {
        return id
    }
    override fun equals(other: Any?): Boolean {
        //if (this === other) return true
        if (other !is Person) return false
        return id == other.id
    }
}

// Класс с переопределенным методом equals по uniqueCode
class Product(val uniqueCode: String, val name: String) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Product) return false
        return this.uniqueCode == other.uniqueCode
    }

    override fun hashCode(): Int {
        return uniqueCode.hashCode()
    }
}

// Класс без переопределенного метода equals, сравнение происходит по ссылке
class Order(val orderId: Int, val description: String)
