package tasks.task_3_23_AnyAndToString

enum class UserAction {
    LOGIN,
    LOGOUT,
    CLICK_BUTTON,
    VIEW_PAGE;

    override fun toString(): String {
        return "UserAction: $name";
    }
}