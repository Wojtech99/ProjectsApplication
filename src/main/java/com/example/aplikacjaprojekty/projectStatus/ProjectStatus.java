package com.example.aplikacjaprojekty.projectStatus;

import com.example.aplikacjaprojekty.project.Project;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "status")
public class ProjectStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_status")
    private Long id;
    @Column(name = "nazwa_status", nullable = false)
    private String statusName;
    @OneToMany(mappedBy = "projectStatus")
    private List<Project> projects = new ArrayList<>();

    public ProjectStatus(){}

    public ProjectStatus(String statusName) {
        this.statusName = statusName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    @Override
    public String toString() {
        return "Status{" +
                "id=" + id +
                ", statusName='" + statusName + '\'' +
                '}';
    }
}
