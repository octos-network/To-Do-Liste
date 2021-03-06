package com.example.android.architecture.blueprints.todoapp.statistics

import com.example.android.architecture.blueprints.todoapp.data.Task
import junit.framework.Assert.assertEquals
import junit.framework.TestCase
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class StatisticsUtilsTest {

    @Test
    fun getActiveAndCompletedStats_noCompleted_returnsHundredZero() {

        // GIVEN a list of tasks with a single, active, tasks
        val tasks = listOf<Task>(
                Task("title", "desc", isCompleted = false)
        )
        // WHEN you call getActiveAndCompleteStats
        val result = getActiveAndCompletedStats(tasks)

        // THEN there are 0% completed tasks and 100% active tasks
        assertThat(result.completedTasksPercent, `is` (0f))
        assertThat(result.activeTasksPercent, `is` (100f))
    }

    @Test
    fun getActiveAndCompletedStats_both_returnsFortySixty() {

        // Create an active tasks (the false makes this active)
        val tasks = listOf<Task>(
                Task("title", "desc", isCompleted = true),
                Task("title", "desc", isCompleted = true),
                Task("title", "desc", isCompleted = false),
                Task("title", "desc", isCompleted = false),
                Task("title", "desc", isCompleted = false)
        )

        // Call our function
        val result = getActiveAndCompletedStats(tasks)

        // Check the result
        assertEquals(result.completedTasksPercent, 40f)
        assertEquals(result.activeTasksPercent, 60f)
    }

    @Test
    fun getActiveAndCompletedStats_both_returnsTenNinety() {

        // GIVEN a list of list of tasks with one completed task
        val tasks = listOf<Task>(
                Task("title", "desc", isCompleted = true),
                Task("title", "desc", isCompleted = false),
                Task("title", "desc", isCompleted = false),
                Task("title", "desc", isCompleted = false),
                Task("title", "desc", isCompleted = false),
                Task("title", "desc", isCompleted = false),
                Task("title", "desc", isCompleted = false),
                Task("title", "desc", isCompleted = false),
                Task("title", "desc", isCompleted = false),
                Task("title", "desc", isCompleted = false)
        )

        // WHEN you call gatActiveAndCompletedStats
        val result = getActiveAndCompletedStats(tasks)

        // THEN there are 10% completed tasks and 90% active tasks
        assertEquals(result.completedTasksPercent, 10f)
        assertEquals(result.activeTasksPercent, 90f)
    }

    @Test
    fun getActiveAndCompletedStats_noActive_returnsZeroHundred() {

        // GIVEN a list of tasks with a single, active, tasks
        val tasks = listOf<Task>(
                Task("title", "desc", isCompleted = true)
        )

        // WHEN you call getActiveAndCompleteStats
        val result = getActiveAndCompletedStats(tasks)

        // THEN there are 100% completed tasks and 0% active tasks
        assertEquals(result.completedTasksPercent, 100f)
        assertEquals(result.activeTasksPercent, 0f)
    }

    @Test
    fun getActiveAndCompletedStats_empty_returnsZeros() {

        // GIVEN an empty list
        val tasks = emptyList<Task>()

        // WHEN you call getActiveAndCompleteStats
        val result = getActiveAndCompletedStats(tasks)

        // THEN there are 0% completed tasks and 0% active tasks
        assertEquals(result.completedTasksPercent, 0f)
        assertEquals(result.activeTasksPercent, 0f)
    }

    @Test
    fun getActiveAndCompletedStats_error_returnsZeros() {

        // GIVEN a list which is null
        val tasks = null

        // WHEN you call getActiveAndCompleteStats
        val result = getActiveAndCompletedStats(tasks)

        // THEN there are 0% completed tasks and 0% active tasks
        assertEquals(result.completedTasksPercent, 0f)
        assertEquals(result.activeTasksPercent, 0f)
    }
}