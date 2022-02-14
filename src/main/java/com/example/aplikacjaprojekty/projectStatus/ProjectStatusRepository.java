package com.example.aplikacjaprojekty.projectStatus;

import com.example.aplikacjaprojekty.projectStatus.ProjectStatus;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ProjectStatusRepository extends CrudRepository<ProjectStatus, Long> {
    @Modifying
    @Query("delete from ProjectStatus ps where ps.statusName = :statusName")
    void deleteStatusById(String statusName);

    @Modifying
    @Query("update ProjectStatus ps set ps.statusName = :statusName where ps.id = :id")
    void updateProjectStatus(String statusName, Long id);

    @Query("select ps from ProjectStatus ps where ps.id = :id ")
    ProjectStatus findProjectStatusById(Long id);
}
