package com.tusk.todolistbackend.controllers;

import com.sun.source.util.TaskListener;
import com.tusk.todolistbackend.models.Task;
import com.tusk.todolistbackend.services.TaskService;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }
    @GetMapping("/")
    public ResponseEntity<List<Task>> getTasks(@RequestParam(name = "completed", required = false) Boolean completed) {
        if (completed != null && completed) {
            return ResponseEntity.ok(taskService.findCompletedTasks());
        } else {
            return ResponseEntity.ok(taskService.findUncompletedTasks());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Task>> getTask(@PathVariable UUID id) {
        return ResponseEntity.ok(taskService.findTaskById(id));
    }

    @PostMapping("/")
    public ResponseEntity<Task> postTask(@RequestBody Task task) {
        return ResponseEntity.ok(taskService.createTask(task));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable UUID id, @RequestBody Task task) {
        task.setId(id);
        return ResponseEntity.ok(taskService.updateTask(task));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable UUID id) {
        taskService.deleteTask(id);
        return ResponseEntity.ok("TASK DELETED");
    }


}
