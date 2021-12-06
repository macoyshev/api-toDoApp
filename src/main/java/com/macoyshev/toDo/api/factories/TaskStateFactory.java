package com.macoyshev.toDo.api.factories;

import com.macoyshev.toDo.api.dto.TaskStateDto;
import com.macoyshev.toDo.store.entities.TaskStateEntity;
import org.springframework.stereotype.Component;

@Component
public class TaskStateFactory {
    public TaskStateDto makeTaskStateDto(TaskStateEntity entity) {
        return TaskStateDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .createAt(entity.getCreatedAt())
                .build();
    }
}
