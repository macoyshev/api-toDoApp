package com.macoyshev.toDo.store.repositories;

import com.macoyshev.toDo.store.entities.TaskStateEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskStateRepository extends JpaRepository<TaskStateEntity, Long> {
}
