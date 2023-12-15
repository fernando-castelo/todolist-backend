package com.tusk.todolistbackend.repositories;

import com.tusk.todolistbackend.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface TaskRepository extends JpaRepository<Task, UUID> {

    public Task findByTaskId(UUID id);

    public List<Task> findByCompletedTrue();

    public List<Task> findByCompletedFalse();

}


