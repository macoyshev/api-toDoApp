package com.macoyshev.toDo.api.factories;

import com.macoyshev.toDo.api.dto.TaskDto;
import com.macoyshev.toDo.store.entities.TaskEntity;
import org.springframework.stereotype.Component;

@Component
public class TaskFactory {
    public TaskDto makeTaskDto(TaskEntity taskEntity) {
        return TaskDto.builder()
                .id(taskEntity.getId())
                .name(taskEntity.getName())
                .createdAt(taskEntity.getCreatedAt())
                .build();
    }
}
