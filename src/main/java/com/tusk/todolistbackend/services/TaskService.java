package com.tusk.todolistbackend.services;

import com.tusk.todolistbackend.models.Task;
import com.tusk.todolistbackend.repositories.TaskRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> findAllTasks() {
        return taskRepository.findAll();
    }

    public List<Task> findCompletedTasks() {
        return taskRepository.findByCompletedTrue();
    }

    public List<Task> findUncompletedTasks() {
        return taskRepository.findByCompletedFalse();
    }
    
    public Optional<Task> findTaskById(UUID id) {
        return taskRepository.findById(id);
    }
    
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    @Transactional
    public void deleteTask(UUID id) {
        taskRepository.deleteTaskById(id);
    }
    
    public Task updateTask(Task task) {
        return taskRepository.save(task);
    }
        
    

}
