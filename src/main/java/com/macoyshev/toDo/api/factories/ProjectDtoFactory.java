package com.macoyshev.toDo.api.factories;

import com.macoyshev.toDo.api.dto.ProjectDto;
import com.macoyshev.toDo.store.entities.ProjectEntity;
import org.springframework.stereotype.Component;

@Component
public class ProjectDtoFactory {
    public ProjectDto makeProjectDto(ProjectEntity projectEntity) {
        return ProjectDto.builder()
                .id(projectEntity.getId())
                .name(projectEntity.getName())
                .createdAt(projectEntity.getCreatedAt())
                .build();
    }
}
