package tasks.task_3_12

fun main (){
        // создайте здесь коллекцию инструментов и в цикле вызовите у них метод turnOn()
        val drill = Pw.Drill("Bosch", "U890", 16);
        val angleGrinder: Pw.AngleGrinder = Pw.AngleGrinder("Bosch", "A090", 150);
        val chainSaw: Pw.ChainSaw = Pw.ChainSaw("Bosch", "CH900", 180);

        val taskPWS: List<Pw.TaskPW> = listOf(drill, angleGrinder, chainSaw);

        for (tool in taskPWS) {
            tool.turnOn();
        }

}