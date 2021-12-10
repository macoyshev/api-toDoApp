package com.macoyshev.toDo.api.contollers;


import com.macoyshev.toDo.api.dto.ProjectDto;
import com.macoyshev.toDo.api.exceptions.BadRequestException;
import com.macoyshev.toDo.api.exceptions.NotFoundException;
import com.macoyshev.toDo.api.factories.ProjectDtoFactory;
import com.macoyshev.toDo.store.entities.ProjectEntity;
import com.macoyshev.toDo.store.repositories.ProjectRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.Objects;

@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Transactional
@RestController
public class ProjectController {

    ProjectRepository projectRepository;

    ProjectDtoFactory projectDtoFactory;

    public static final String FETCH_PROJECT = "/api/projects";
    public static final String CREATE_PROJECT = "/api/projects";
    public static final String EDIT_PROJECT = "/api/projects/{project_id}";

    @PostMapping(CREATE_PROJECT)
    public ProjectDto createProject(@RequestParam String name) {

        projectRepository
                .findByName(name)
                .ifPresent(project -> {
                    throw new BadRequestException(String.format("Project %s already exists", name));
                });

        ProjectEntity project = projectRepository.saveAndFlush(
                ProjectEntity.builder()
                        .name(name)
                        .build()
        );

        return projectDtoFactory.makeProjectDto(project);

        //#TODO: make projectDto return
        //return projectDtoFactory.makeProjectDto()
    }

    @PatchMapping(EDIT_PROJECT)
    public ProjectDto editPatch(
            @PathVariable("project_id") Long id,
            @RequestParam String name) {

        if (name.trim().isEmpty())
            throw new BadRequestException("Name can not be empty");

        ProjectEntity project = projectRepository
                .findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("Project with %s does not exists", id)));

        projectRepository
                .findByName(name)
                .filter(anotherProject -> !Objects.equals(anotherProject.getId(), id))
                .ifPresent(anotherProject -> {
                    throw new BadRequestException(String.format("Project %s already exists", name));
                });

        project.setName(name);

        project = projectRepository.saveAndFlush(project);

        return projectDtoFactory.makeProjectDto(project);
    }

}
