package com.macoyshev.toDo.api.contollers;

import com.macoyshev.toDo.api.dto.ProjectDto;
import com.macoyshev.toDo.api.factories.ProjectDtoFactory;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;

@FieldDefaults(level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
@RestController
@Transactional
public class ProjectController {

    ProjectDtoFactory projectDtoFactory;

    public static final String FETCH_PROJECT = "api/projects/";
}
