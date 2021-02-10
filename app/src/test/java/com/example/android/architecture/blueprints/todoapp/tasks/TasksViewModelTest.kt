package com.example.android.architecture.blueprints.todoapp.tasks

import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import junit.framework.TestCase
import org.junit.Test
import org.junit.runner.RunWith

class TasksViewModelTest {

    @RunWith(AndroidJUnit4::class)
    class TasksViewModelTest {

        @Test
        fun addNewTask_setsNewTaskEvent() {

            // Given a fresh ViewModel
            val tasksViewModel = TasksViewModel(ApplicationProvider.getApplicationContext())

            // When adding a new task
            tasksViewModel.addNewTask()

            // Then the new task event is triggered
            // TODO test LiveData
        }
    }
}