package com.macoyshev.toDo.api.factories;

import com.macoyshev.toDo.api.dto.ProjectDto;
import com.macoyshev.toDo.store.entities.ProjectEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProjectDtoFactory {
    public ProjectDto makeProjectDto(ProjectEntity projectEntity) {
        return ProjectDto.builder()
                .id(projectEntity.getId())
                .name(projectEntity.getName())
                .createdAt(projectEntity.getCreatedAt())
                .build();
    }

    public List<ProjectDto> makeProjectDto(List<ProjectEntity> list) {
        return list.stream()
                .map(this::makeProjectDto)
                .collect(Collectors.toList());
    }
}
