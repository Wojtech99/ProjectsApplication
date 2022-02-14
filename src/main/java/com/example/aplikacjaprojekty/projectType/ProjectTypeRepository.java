package com.example.aplikacjaprojekty.projectType;

import com.example.aplikacjaprojekty.projectStatus.ProjectStatus;
import com.example.aplikacjaprojekty.projectType.ProjectType;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ProjectTypeRepository extends CrudRepository<ProjectType, Long> {
    @Modifying
    @Query("delete from ProjectType pt where pt.typeName = :typeName")
    void deleteTypeById(String typeName);

    @Modifying
    @Query("update ProjectType pt set pt.typeName = :typeName where pt.id = :id")
    void updateProjectType(String typeName, Long id);

    @Query("select pt from ProjectType pt where pt.id = :id ")
    ProjectType findProjectTypeById(Long id);
}
