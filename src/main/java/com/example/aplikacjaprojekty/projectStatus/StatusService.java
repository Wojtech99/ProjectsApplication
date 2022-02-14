package com.example.aplikacjaprojekty.projectStatus;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class StatusService {
    private final ProjectStatusRepository projectStatusRepo;

    public StatusService(ProjectStatusRepository projectStatusRepo) {
        this.projectStatusRepo = projectStatusRepo;
    }

    @Transactional
    public void add(String newStatus){
        ProjectStatus projectStatus = new ProjectStatus(newStatus);
        projectStatusRepo.save(projectStatus);
    }

    @Transactional
    public List<ProjectStatus> findAllStatuses(){
        List<ProjectStatus> listOfStatuses = new ArrayList<>();
        projectStatusRepo.findAll().forEach(listOfStatuses::add);
        return listOfStatuses;
    }

    @Transactional
    public void deleteStatus(String statusName){
        projectStatusRepo.deleteStatusById(statusName);
    }

    @Transactional
    public void updateStatusName(String statusName, Long id){
        projectStatusRepo.updateProjectStatus(statusName, id);
    }

    @Transactional
    public ProjectStatus takeProjectStatusById(Long id){
        return projectStatusRepo.findProjectStatusById(id);
    }
}
