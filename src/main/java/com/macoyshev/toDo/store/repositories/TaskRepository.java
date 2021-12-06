package com.macoyshev.toDo.store.repositories;

import com.macoyshev.toDo.store.entities.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<TaskEntity, Long> {
}
