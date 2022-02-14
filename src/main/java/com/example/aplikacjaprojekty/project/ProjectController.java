package com.example.aplikacjaprojekty.project;

import com.example.aplikacjaprojekty.projectStatus.ProjectStatus;
import com.example.aplikacjaprojekty.projectStatus.StatusService;
import com.example.aplikacjaprojekty.projectType.ProjectType;
import com.example.aplikacjaprojekty.projectType.TypeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.List;

@Controller
public class ProjectController {
    private final ProjectService projectService;
    private final StatusService statusService;
    private final TypeService typeService;

    public ProjectController(ProjectService projectService, StatusService statusService,
                             TypeService typeService) {
        this.projectService = projectService;
        this.statusService = statusService;
        this.typeService = typeService;
    }

    //add project
    @GetMapping("/add_project")
    String getSite(Model model){
        List<ProjectStatus> projectStatusList = statusService.findAllStatuses();
        List<ProjectType> projectTypeList = typeService.findAllTypes();

        model.addAttribute("listOfStatuses", projectStatusList);
        model.addAttribute("listOfTypes", projectTypeList);
        model.addAttribute("projectDto", new ProjectDto());
        return "add_project";
    }

    @PostMapping("/addNewProject")
    String addNewProject(ProjectDto projectDto){
        projectService.add(projectDto);
        return "add_project";
    }

    //all projects
    @GetMapping("/all_projects")
    String showAllProjects(Model model){
        List<ProjectDto> projectDtoList = projectService.takeAllProjects();
        model.addAttribute("list", projectDtoList);
        return "/all_projects";
    }

    //take by status projects
    @GetMapping("/status_projects")
    String takeStatusProjects(Model model){
        List<ProjectStatus> projectStatusList = statusService.findAllStatuses();
        model.addAttribute("listOfStatuses", projectStatusList);
        return "/status_projects";
    }

    @PostMapping("/takeProjectWithStatuses")
    String showStatusProjects(@RequestParam Long id, Model model){
        List<ProjectDto> projectDtoList = projectService.takeProjectsWithStatus(id);
        model.addAttribute("listDto", projectDtoList);
        return "/status_projects";
    }

    //take by type projects
    @GetMapping("/types_projects")
    String takeTypesProjects(Model model){
        List<ProjectType> projectTypeList = typeService.findAllTypes();
        model.addAttribute("list", projectTypeList);
        return "/types_projects";
    }

    @PostMapping("/takeProjectWithTypes")
    String showTypesProjects(@RequestParam Long id, Model model){
        List<ProjectDto> projectDtoList = projectService.takeProjectsByType(id);
        model.addAttribute("listDto", projectDtoList);
        return "/types_projects";
    }

    //take by project number
    @GetMapping("/number_projects")
    String takeNumberProjects(){
        return "/number_projects";
    }

    @PostMapping("/takeProjectWithProjectNumber")
    String showProjectWithNumber(@RequestParam String projectNumber, Model model){
        List<ProjectDto> projectDtoList = projectService.takeProjectByNumberProject(projectNumber);
        model.addAttribute("listDto", projectDtoList);
        return "/number_projects";
    }

    //take by project topic
    @GetMapping("/topic_projects")
    String takeProjectsWithTopic(){
        return "/topic_projects";
    }

    @PostMapping("/takeProjectWithTopic")
    String showProjectsWithTopic(@RequestParam String projectTopic, Model model){
        List<ProjectDto> projectDtoList = projectService.takeProjectByTopic(projectTopic);
        model.addAttribute("listDto", projectDtoList);
        return "/topic_projects";
    }

    //take by project dates
    @GetMapping("/dates_projects")
    String takeProjectsWithDates(){
        return "/dates_projects";
    }

    @PostMapping("/takeProjectWithDates")
    String showProjectsWithDates(@RequestParam java.sql.Date startSearchDate, @RequestParam java.sql.Date endSearchDate, Model model){
        List<ProjectDto> projectDtoList = projectService.takeProjectByDates(startSearchDate, endSearchDate);
        model.addAttribute("listDto", projectDtoList);
        return "/dates_projects";
    }

    //take by project dates
    @GetMapping("/amounts_projects")
    String takeProjectsWithAmounts(){
        return "/amounts_projects";
    }

    @PostMapping("/takeProjectWithAmounts")
    String showProjectsWithAmounts(@RequestParam Float startSearchAmount, @RequestParam Float endSearchAmount, Model model){
        List<ProjectDto> projectDtoList = projectService.takeProjectByAmount(startSearchAmount, endSearchAmount);
        model.addAttribute("listDto", projectDtoList);
        return "/amounts_projects";
    }

    //take project by statistics
    @GetMapping("/statistics_projects")
    String takeAndShowStatisticProjects(Model model) {

        int projectsCount = projectService.takeCountOfProjects();
        float projectsMinAmount = projectService.takeMinProjectAmount();
        float projectsMaxAmount = projectService.takeMaxProjectAmount();
        float projectsAverageAmount = projectService.takeAverageProjectAmount();

        model.addAttribute("countOfProjects", projectsCount);
        model.addAttribute("minAmount", projectsMinAmount);
        model.addAttribute("maxAmount", projectsMaxAmount);
        model.addAttribute("avgAmount", projectsAverageAmount);
        return "/statistics_projects";
    }

    //take projects to edit
    @GetMapping("/edit_project")
    String showAllProjectsInTable(Model model){
        includeToEditProjectPage(model);
        model.addAttribute("ProjectDtoForEdit", new ProjectDtoForEdit());
        return "/edit_project";
    }

    @PostMapping("/deleteProject")
    String deleteProjectType(@RequestParam Long id, Model model){
        projectService.deleteProject(id);

        includeToEditProjectPage(model);
        model.addAttribute("ProjectDtoForEdit", new ProjectDtoForEdit());
        return "/edit_project";
    }

    @PostMapping("/insertToEditProject")
    String insertToEditProject(@RequestParam Long id, Model model){
        ProjectDtoForEdit projectDtoForEdit = projectService.findProjectDtoForEdit(id);

        includeToEditProjectPage(model);
        model.addAttribute("ProjectDtoForEdit", projectDtoForEdit);
        return "/edit_project";
    }

    @PostMapping("/editProjectForm")
    String editProject(ProjectDtoForEdit projectDtoForEdit, Model model){
        ProjectDtoWithId projectDtoWithId = projectService.convertToProjectWithId(projectDtoForEdit);
        projectService.updateProject(projectDtoWithId, projectDtoWithId.getId());

        includeToEditProjectPage(model);
        model.addAttribute("ProjectDtoForEdit", new ProjectDtoForEdit());
        return "/edit_project";
    }

    private void includeToEditProjectPage(Model model){
        List<ProjectDtoWithId> ProjectDtoWithIdList = projectService.takeAllProjectsWithId();
        List<ProjectStatus> projectStatusList = statusService.findAllStatuses();
        List<ProjectType> projectTypeList = typeService.findAllTypes();

        model.addAttribute("list", ProjectDtoWithIdList);
        model.addAttribute("listOfStatuses", projectStatusList);
        model.addAttribute("listOfTypes", projectTypeList);

    }
}
