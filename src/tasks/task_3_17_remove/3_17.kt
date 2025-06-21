package tasks.task_3_17_remove

data class Order(
    val id: Int,
    val status: String,
    val type: String
) {

    fun removeCompletedOrders(orders: List<Order>, typeToRemove: String): List<Order> {
//        val newList = mutableListOf<Order>();
//        newList.addAll(orders)
//        newList.removeAll() { it.type == typeToRemove && it.status == "completed" }
//        return newList;

        return orders.filterNot { it.status == "completed" && it.type == typeToRemove } // другой вариант

    }
}