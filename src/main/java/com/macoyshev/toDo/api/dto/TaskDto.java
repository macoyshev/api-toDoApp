package com.macoyshev.toDo.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.Instant;

@Data
@Builder
@NoArgsConstructor
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TaskDto {

    @NotNull
    Long id;

    @NotNull
    String name;

    @NotNull
    @JsonProperty("created_at")
    Instant createdAt;
}
