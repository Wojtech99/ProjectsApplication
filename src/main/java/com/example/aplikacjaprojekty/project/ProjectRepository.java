package com.example.aplikacjaprojekty.project;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.sql.Date;
import java.util.List;

public interface ProjectRepository extends CrudRepository<Project, Long> {

    //Find all projects
    @Query("select new com.example.aplikacjaprojekty.project.ProjectDto( p.projectNumber, p.topic, p.startProjectDate, p.endProjectDate," +
            "p.amount, p.comments, ps, pt) from Project p " +
            "left join ProjectType pt on p.projectType.id = pt.id " +
            "left join ProjectStatus ps on p.projectStatus.id = ps.id")
    List<ProjectDto> findAllProjects();

    //find project by status
    @Query("select new com.example.aplikacjaprojekty.project.ProjectDto( p.projectNumber, p.topic, p.startProjectDate, p.endProjectDate," +
            "p.amount, p.comments, ps, pt) from Project p " +
            "left join ProjectType pt on p.projectType.id = pt.id " +
            "left join ProjectStatus ps on p.projectStatus.id = ps.id " +
            "where ps.id = :id")
    List<ProjectDto> findAllProjectsWithStatus(Long id);

    //find project by type
    @Query("select new com.example.aplikacjaprojekty.project.ProjectDto( p.projectNumber, p.topic, p.startProjectDate, p.endProjectDate," +
            "p.amount, p.comments, ps, pt) from Project p " +
            "left join ProjectType pt on p.projectType.id = pt.id " +
            "left join ProjectStatus ps on p.projectStatus.id = ps.id " +
            "where pt.id = :id")
    List<ProjectDto> findAllProjectsByType(Long id);

    //find project by project number
    @Query("select new com.example.aplikacjaprojekty.project.ProjectDto( p.projectNumber, p.topic, p.startProjectDate, p.endProjectDate," +
            "p.amount, p.comments, ps, pt) from Project p " +
            "left join ProjectType pt on p.projectType.id = pt.id " +
            "left join ProjectStatus ps on p.projectStatus.id = ps.id " +
            "where p.projectNumber = :projectNumber")
    List<ProjectDto> findAllByProjectNumber(String projectNumber);

    //find project by topic
    @Query("select new com.example.aplikacjaprojekty.project.ProjectDto( p.projectNumber, p.topic, p.startProjectDate, p.endProjectDate," +
            "p.amount, p.comments, ps, pt) from Project p " +
            "left join ProjectType pt on p.projectType.id = pt.id " +
            "left join ProjectStatus ps on p.projectStatus.id = ps.id " +
            "where p.topic = :topic")
    List<ProjectDto> findAllByTopic(String topic);

    //find projects between start date
    @Query("select new com.example.aplikacjaprojekty.project.ProjectDto( p.projectNumber, p.topic, p.startProjectDate, p.endProjectDate," +
            "p.amount, p.comments, ps, pt) from Project p " +
            "left join ProjectType pt on p.projectType.id = pt.id " +
            "left join ProjectStatus ps on p.projectStatus.id = ps.id " +
            "where p.startProjectDate between :minDate and :maxDate ")
    List<ProjectDto> findAllByDates(Date minDate, Date maxDate);

    //find projects between amount
    @Query("select new com.example.aplikacjaprojekty.project.ProjectDto( p.projectNumber, p.topic, p.startProjectDate, p.endProjectDate," +
            "p.amount, p.comments, ps, pt) from Project p " +
            "left join ProjectType pt on p.projectType.id = pt.id " +
            "left join ProjectStatus ps on p.projectStatus.id = ps.id " +
            "where p.amount between :minAmount and :maxAmount ")
    List<ProjectDto> findAllByAmount(Float minAmount, Float maxAmount);


    //take Count of projects
    @Query("select count(p.projectNumber) from Project p")
    int countAllProjects();

    //take min amount project
    @Query("select min(p.amount) from Project p")
    float minProjectAmount();

    //take max amount project
    @Query("select max(p.amount) from Project p")
    float maxProjectAmount();

    //take average amount project
    @Query("select avg(p.amount) from Project p")
    float averageProjectAmount();


    //take all projects with project id
    @Query("select new com.example.aplikacjaprojekty.project.ProjectDtoWithId(p.id, p.projectNumber, p.topic," +
            " p.startProjectDate, p.endProjectDate," +
            "p.amount, p.comments, ps, pt) from Project p " +
            "left join ProjectType pt on p.projectType.id = pt.id " +
            "left join ProjectStatus ps on p.projectStatus.id = ps.id")
    List<ProjectDtoWithId> findAllProjectsDtoWithId();

    //delete project by id
    @Modifying
    @Query("delete from Project p where p.id = :id")
    void deleteProjectById(Long id);

    //take project with project id
    @Query("select new com.example.aplikacjaprojekty.project.ProjectDtoWithId(p.id, p.projectNumber, p.topic," +
            " p.startProjectDate, p.endProjectDate," +
            "p.amount, p.comments, ps, pt) from Project p " +
            "left join ProjectType pt on p.projectType.id = pt.id " +
            "left join ProjectStatus ps on p.projectStatus.id = ps.id " +
            "where p.id = :id")
    ProjectDtoWithId findProjectDtoWithIdById(Long id);

    //take project
    @Query("select new com.example.aplikacjaprojekty.project.Project(p.projectNumber, p.topic," +
            " p.startProjectDate, p.endProjectDate," +
            "p.amount, p.comments, ps, pt) from Project p " +
            "left join ProjectType pt on p.projectType.id = pt.id " +
            "left join ProjectStatus ps on p.projectStatus.id = ps.id " +
            "where p.id = :id")
    Project findProjectById(Long id);

    //update project
    @Modifying
    @Query("update Project p set p = :project" +
            " where p.id = :id")
    void updateProject(Project project, Long id);


}
