package com.tusk.todolistbackend.repositories;

import com.tusk.todolistbackend.models.Task;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TaskRepository extends JpaRepository<Task, UUID> {

    public Optional<Task> findById(UUID id);
    public List<Task> findByCompletedTrue();

    public List<Task> findByCompletedFalse();

    public void deleteTaskById(UUID id);

}


