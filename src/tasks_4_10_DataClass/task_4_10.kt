package tasks_4_10_DataClass


// Базовый абстрактный класс для сотрудников
abstract class TeamMember(
    open val id: Int,
    open val name: String,
    open val role: String
) {
}

// Класс разработчика
data class Developer(
    override val id: Int,
    override val name: String,
    override val role: String,
    val primaryLanguage: String
) : TeamMember(id, name, role) {

}

// Класс менеджера проекта
data class ProjectManager(
    override val id: Int,
    override val name: String,
    override val role: String,
    val projectsHandled: Int
) : TeamMember(id, name, role) {

}

// Класс проекта
data class Project(
    val projectId: Int,
    val projectName: String,
    val client: String,
    val budget: Double,
    val durationMonths: Int
) {
}

// Класс задачи
data class Task(
    val taskId: Int,
    val title: String,
    val description: String,
    val assignee: TeamMember,
    val priority: Int,
    val deadline: String
) {
    }


