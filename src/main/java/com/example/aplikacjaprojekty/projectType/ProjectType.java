package com.example.aplikacjaprojekty.projectType;

import com.example.aplikacjaprojekty.project.Project;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "rodzaj")
public class ProjectType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rodzaj")
    private Long id;
    @Column(name = "nazwa_rodzaj", nullable = false)
    private String typeName;
    @OneToMany(mappedBy = "projectType")
    private List<Project> projects = new ArrayList<>();

    public ProjectType(){}

    public ProjectType(String typeName) {
        this.typeName = typeName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    @Override
    public String toString() {
        return "ProjectType{" +
                "id=" + id +
                ", typeName='" + typeName + '\'' +
                '}';
    }
}
