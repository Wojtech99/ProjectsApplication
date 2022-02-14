package com.example.aplikacjaprojekty.project;

import com.example.aplikacjaprojekty.projectStatus.ProjectStatus;
import com.example.aplikacjaprojekty.projectStatus.StatusService;
import com.example.aplikacjaprojekty.projectType.ProjectType;
import com.example.aplikacjaprojekty.projectType.TypeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectService {
    private final ProjectRepository projectRepository;
    private final StatusService statusService;
    private final TypeService typeService;

    public ProjectService(ProjectRepository projectRepository, StatusService statusService, TypeService typeService) {
        this.projectRepository = projectRepository;
        this.statusService = statusService;
        this.typeService = typeService;
    }

    @Transactional
    void add(ProjectDto projectDto){
        Project project = new Project(
                projectDto.getProjectNumber(),
                projectDto.getTopic(),
                projectDto.getStartProjectDate(),
                projectDto.getEndProjectDate(),
                projectDto.getAmount(),
                projectDto.getComments(),
                projectDto.getProjectStatus(),
                projectDto.getProjectType()
                );
        projectRepository.save(project);
    }

    @Transactional
    public List<ProjectDto> takeAllProjects(){
        List<ProjectDto> listOfProjects = new ArrayList<>();
        projectRepository.findAllProjects().forEach(project -> {
            listOfProjects.add(new ProjectDto(
                    project.getProjectNumber(),
                    project.getTopic(),
                    project.getStartProjectDate(),
                    project.getEndProjectDate(),
                    project.getAmount(),
                    project.getComments(),
                    project.getProjectStatus(),
                    project.getProjectType()
            ));
        });
        return listOfProjects;
    }

    @Transactional
    public List<ProjectDto> takeProjectsWithStatus(Long id){
        List<ProjectDto> listOfProjects = new ArrayList<>();
        projectRepository.findAllProjectsWithStatus(id).forEach(project -> {
            listOfProjects.add(new ProjectDto(
                    project.getProjectNumber(),
                    project.getTopic(),
                    project.getStartProjectDate(),
                    project.getEndProjectDate(),
                    project.getAmount(),
                    project.getComments(),
                    project.getProjectStatus(),
                    project.getProjectType()
            ));
        });
        return listOfProjects;
    }

    @Transactional
    public List<ProjectDto> takeProjectsByType(Long id){
        List<ProjectDto> projectDtoList = new ArrayList<>();
        projectRepository.findAllProjectsByType(id).forEach(project -> {
            projectDtoList.add(new ProjectDto(
                    project.getProjectNumber(),
                    project.getTopic(),
                    project.getStartProjectDate(),
                    project.getEndProjectDate(),
                    project.getAmount(),
                    project.getComments(),
                    project.getProjectStatus(),
                    project.getProjectType()
            ));
        });
        return projectDtoList;
    }

    @Transactional
    public List<ProjectDto> takeProjectByNumberProject(String projectNumber){
        List<ProjectDto> projectDtoList = new ArrayList<>();
        projectRepository.findAllByProjectNumber(projectNumber).forEach(project -> {
            projectDtoList.add(new ProjectDto(
                    project.getProjectNumber(),
                    project.getTopic(),
                    project.getStartProjectDate(),
                    project.getEndProjectDate(),
                    project.getAmount(),
                    project.getComments(),
                    project.getProjectStatus(),
                    project.getProjectType()
            ));
        });
        return projectDtoList;
    }

    @Transactional
    public List<ProjectDto> takeProjectByTopic(String topic){
        List<ProjectDto> projectDtoList = new ArrayList<>();
        projectRepository.findAllByTopic(topic).forEach(project -> {
            projectDtoList.add(new ProjectDto(
                    project.getProjectNumber(),
                    project.getTopic(),
                    project.getStartProjectDate(),
                    project.getEndProjectDate(),
                    project.getAmount(),
                    project.getComments(),
                    project.getProjectStatus(),
                    project.getProjectType()
            ));
        });
        return projectDtoList;
    }

    @Transactional
    public List<ProjectDto> takeProjectByDates(Date minDate, Date maxDate){
        List<ProjectDto> projectDtoList = new ArrayList<>();
        projectRepository.findAllByDates(minDate, maxDate).forEach(project -> {
            projectDtoList.add(new ProjectDto(
                    project.getProjectNumber(),
                    project.getTopic(),
                    project.getStartProjectDate(),
                    project.getEndProjectDate(),
                    project.getAmount(),
                    project.getComments(),
                    project.getProjectStatus(),
                    project.getProjectType()
            ));
        });
        return projectDtoList;
    }

    @Transactional
    public List<ProjectDto> takeProjectByAmount(Float minAmount, Float maxAmount){
        List<ProjectDto> projectDtoList = new ArrayList<>();
        projectRepository.findAllByAmount(minAmount, maxAmount).forEach(project -> {
            projectDtoList.add(new ProjectDto(
                    project.getProjectNumber(),
                    project.getTopic(),
                    project.getStartProjectDate(),
                    project.getEndProjectDate(),
                    project.getAmount(),
                    project.getComments(),
                    project.getProjectStatus(),
                    project.getProjectType()
            ));
        });
        return projectDtoList;
    }

    @Transactional
    public int takeCountOfProjects(){
       return projectRepository.countAllProjects();
    }

    @Transactional
    public float takeMinProjectAmount(){
        return projectRepository.minProjectAmount();
    }

    @Transactional
    public float takeMaxProjectAmount(){
        return projectRepository.maxProjectAmount();
    }

    @Transactional
    public float takeAverageProjectAmount(){
        return projectRepository.averageProjectAmount();
    }

    @Transactional
    public List<ProjectDtoWithId> takeAllProjectsWithId(){
        List<ProjectDtoWithId> listOfProjects = new ArrayList<>();
        projectRepository.findAllProjectsDtoWithId().forEach(project -> {
            listOfProjects.add(new ProjectDtoWithId(
                    project.getId(),
                    project.getProjectNumber(),
                    project.getTopic(),
                    project.getStartProjectDate(),
                    project.getEndProjectDate(),
                    project.getAmount(),
                    project.getComments(),
                    project.getProjectStatus(),
                    project.getProjectType()
            ));
        });
        return listOfProjects;
    }

    @Transactional
    public void deleteProject(Long id){
        projectRepository.deleteProjectById(id);
    }

    @Transactional
    public ProjectDtoForEdit findProjectDtoForEdit(Long id){
        ProjectDtoWithId projectDtoWithId = projectRepository.findProjectDtoWithIdById(id);
        return new ProjectDtoForEdit(
                projectDtoWithId.getId(),
                projectDtoWithId.getProjectNumber(),
                projectDtoWithId.getTopic(),
                projectDtoWithId.getStartProjectDate(),
                projectDtoWithId.getEndProjectDate(),
                projectDtoWithId.getAmount(),
                projectDtoWithId.getComments(),
                projectDtoWithId.getProjectStatus().getId(),
                projectDtoWithId.getProjectType().getId()
        );
    }

    public ProjectDtoWithId convertToProjectWithId(ProjectDtoForEdit projectDtoForEdit){
        ProjectStatus projectStatus = statusService.takeProjectStatusById(projectDtoForEdit.getProjectStatusId());
        ProjectType projectType = typeService.findProjectTypeById(projectDtoForEdit.getProjectTypeId());

        return new ProjectDtoWithId(
                projectDtoForEdit.getId(),
                projectDtoForEdit.getProjectNumber(),
                projectDtoForEdit.getTopic(),
                projectDtoForEdit.getStartProjectDate(),
                projectDtoForEdit.getEndProjectDate(),
                projectDtoForEdit.getAmount(),
                projectDtoForEdit.getComments(),
                projectStatus,
                projectType
        );
    }

    @Transactional
    public void updateProject(ProjectDtoWithId projectWithId, Long id){
        setNewProjectDetails(projectWithId, id);
    }

    public Project setNewProjectDetails (ProjectDtoWithId projectWithId, Long id){
        Project project = projectRepository.findProjectById(id);

        project.setProjectNumber(projectWithId.getProjectNumber());
        project.setTopic(projectWithId.getTopic());
        project.setStartProjectDate(projectWithId.getStartProjectDate());
        project.setEndProjectDate(projectWithId.getEndProjectDate());
        project.setAmount(projectWithId.getAmount());
        project.setComments(projectWithId.getComments());

        return project;
    }
}
