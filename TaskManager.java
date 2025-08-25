package service;

import model.Task;
import java.util.*;

/**
 * Implementation of ITaskManager using Java's PriorityQueue for efficient
 * priority-based task management. Tasks are automatically sorted by priority.
 */
public class TaskManager implements ITaskManager {
    
    private PriorityQueue<Task> taskQueue;
    private Map<Integer, Task> taskMap; // For quick ID-based lookups
    private int nextId;
    
    /**
     * Constructor initializes the task manager with a priority queue
     * and a map for efficient ID-based operations.
     */
    public TaskManager() {
        // PriorityQueue with custom comparator for descending priority order
        this.taskQueue = new PriorityQueue<>();
        this.taskMap = new HashMap<>();
        this.nextId = 1;
    }
    
    @Override
    public int addTask(String name, String description, int priority) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Task name cannot be null or empty");
        }
        if (description == null) {
            description = "";
        }
        
        Task newTask = new Task(nextId, name.trim(), description, priority);
        taskQueue.offer(newTask);
        taskMap.put(nextId, newTask);
        
        return nextId++;
    }
    
    @Override
    public List<Task> getAllTasks() {
        List<Task> sortedTasks = new ArrayList<>();
        
        // Create a temporary queue to preserve the original
        PriorityQueue<Task> tempQueue = new PriorityQueue<>(taskQueue);
        
        while (!tempQueue.isEmpty()) {
            sortedTasks.add(tempQueue.poll());
        }
        
        return sortedTasks;
    }
    
    @Override
    public boolean updateTask(int id, String newDescription, int newPriority) {
        Task task = taskMap.get(id);
        if (task == null) {
            return false;
        }
        
        // Remove from queue to update
        taskQueue.remove(task);
        
        // Update the task
        if (newDescription != null) {
            task.setDescription(newDescription);
        }
        if (newPriority >= 0) {
            task.setPriority(newPriority);
        }
        
        // Add back to queue (will be re-sorted)
        taskQueue.offer(task);
        
        return true;
    }
    
    @Override
    public boolean deleteTask(int id) {
        Task task = taskMap.remove(id);
        if (task == null) {
            return false;
        }
        
        taskQueue.remove(task);
        return true;
    }
    
    @Override
    public Task getTaskById(int id) {
        return taskMap.get(id);
    }
    
    @Override
    public int getTaskCount() {
        return taskMap.size();
    }
    
    @Override
    public boolean isEmpty() {
        return taskMap.isEmpty();
    }
    
    /**
     * Gets the highest priority task without removing it.
     * @return The highest priority task, or null if no tasks exist
     */
    public Task peekHighestPriorityTask() {
        return taskQueue.peek();
    }
    
    /**
     * Removes and returns the highest priority task.
     * @return The highest priority task, or null if no tasks exist
     */
    public Task removeHighestPriorityTask() {
        Task task = taskQueue.poll();
        if (task != null) {
            taskMap.remove(task.getId());
        }
        return task;
    }
}
