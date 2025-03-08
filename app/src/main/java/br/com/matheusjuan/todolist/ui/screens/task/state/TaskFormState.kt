package br.com.matheusjuan.todolist.ui.screens.task.state

data class TaskFormState(
    val title: String,
    val onTitleChange: (String) -> Unit,
    val description: String,
    val onDescriptionChange: (String) -> Unit,
    val priority: Int,
    val onPriorityChange: (Int) -> Unit
)