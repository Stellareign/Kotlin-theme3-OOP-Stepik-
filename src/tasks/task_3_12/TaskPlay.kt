package tasks.task_3_12


fun main (){

    fun task() {
        // создайте здесь коллекцию инструментов и в цикле вызовите у них метод turnOn()
        val drill: Drill = Drill("Bosch", "U890", 16);
        val angleGrinder: AngleGrinder = AngleGrinder("Bosch", "A090", 150);
        val chainSaw: ChainSaw = ChainSaw("Bosch", "CH900", 180);

        val taskPWS: List<TaskPW> = listOf(drill, angleGrinder, chainSaw);

        for (tool in taskPWS) {
            tool.turnOn();
        }
    }
}