package com.macoyshev.toDo.store.repositories;

import com.macoyshev.toDo.store.entities.ProjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<ProjectEntity, Long> {
}
