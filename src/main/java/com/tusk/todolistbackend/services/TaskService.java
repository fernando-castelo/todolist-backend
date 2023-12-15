package com.tusk.todolistbackend.services;

import com.tusk.todolistbackend.models.Task;
import com.tusk.todolistbackend.repositories.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> findCompletedTasks() {
        return taskRepository.findByCompletedTrue();
    }

    public List<Task> findUncompletedTasks() {
        return taskRepository.findByCompletedFalse();
    }

    public Task findTaskById(UUID id) {
        return taskRepository.findByTaskId(id);
    }

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public void deleteTask(Task task) {
        taskRepository.delete(task);
    }

    public Task updateTask(Task task) {
        return taskRepository.save(task);
    }
    
}
