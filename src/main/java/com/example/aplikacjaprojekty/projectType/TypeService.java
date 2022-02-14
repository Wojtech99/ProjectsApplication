package com.example.aplikacjaprojekty.projectType;

import com.example.aplikacjaprojekty.projectStatus.ProjectStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class TypeService {
    private final ProjectTypeRepository projectTypeRepo;

    public TypeService(ProjectTypeRepository projectTypeRepo) {
        this.projectTypeRepo = projectTypeRepo;
    }

    @Transactional
    public void add(String newProjectType){
        ProjectType projectType = new ProjectType(newProjectType);
        projectTypeRepo.save(projectType);
    }

    @Transactional
    public List<ProjectType> findAllTypes(){
        List<ProjectType> listOfTypes = new ArrayList<>();
        projectTypeRepo.findAll().forEach(listOfTypes::add);
        return listOfTypes;
    }

    @Transactional
    public void deleteType(String typeName){
        projectTypeRepo.deleteTypeById(typeName);
    }

    @Transactional
    public void updateTypeName(String typeName, Long id){
        projectTypeRepo.updateProjectType(typeName, id);
    }

    @Transactional
    public ProjectType findProjectTypeById(Long id){
        return projectTypeRepo.findProjectTypeById(id);
    }
}
