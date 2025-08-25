package service;

import model.Task;
import java.util.List;

/**
 * Interface defining the contract for task management operations.
 * This demonstrates abstraction and allows for different implementations.
 */
public interface ITaskManager {
    
    /**
     * Adds a new task to the task manager.
     * @param name The name/title of the task
     * @param description The detailed description of the task
     * @param priority The priority level (higher number = higher priority)
     * @return The ID of the newly created task
     */
    int addTask(String name, String description, int priority);
    
    /**
     * Retrieves all tasks sorted by priority (highest priority first).
     * @return List of tasks in descending order of priority
     */
    List<Task> getAllTasks();
    
    /**
     * Updates an existing task's description and/or priority.
     * @param id The ID of the task to update
     * @param newDescription The new description (null to keep existing)
     * @param newPriority The new priority (negative value to keep existing)
     * @return true if the task was found and updated, false otherwise
     */
    boolean updateTask(int id, String newDescription, int newPriority);
    
    /**
     * Deletes a task by its ID.
     * @param id The ID of the task to delete
     * @return true if the task was found and deleted, false otherwise
     */
    boolean deleteTask(int id);
    
    /**
     * Finds a task by its ID.
     * @param id The ID of the task to find
     * @return The task if found, null otherwise
     */
    Task getTaskById(int id);
    
    /**
     * Gets the total number of tasks.
     * @return The number of tasks currently managed
     */
    int getTaskCount();
    
    /**
     * Checks if the task manager is empty.
     * @return true if no tasks exist, false otherwise
     */
    boolean isEmpty();
}
