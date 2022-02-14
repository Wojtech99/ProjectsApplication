package com.example.aplikacjaprojekty.project;

import com.example.aplikacjaprojekty.projectStatus.ProjectStatus;
import com.example.aplikacjaprojekty.projectType.ProjectType;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "project")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rodzaj")
    private Long id;

    @Column(name = "nr_projekt", nullable = false)
    private String projectNumber;

    @Column(name = "temat_projekt", nullable = false)
    private String topic;

    @DateTimeFormat(pattern = "yyyy-mm-dd")
    @Column(name = "data_rozpoczecia", nullable = false)
    private Date startProjectDate;

    @DateTimeFormat(pattern = "yyyy-mm-dd")
    @Column(name = "data_zakonczenia")
    private Date endProjectDate;

    @Column(name = "kwota", nullable = false)
    private Float amount;

    @Column(name = "uwagi")
    private String comments;

    @ManyToOne
    @JoinColumn(name = "project_status_id")
    private ProjectStatus projectStatus;

    @ManyToOne
    @JoinColumn(name = "project_type_id")
    private ProjectType projectType;

    public Project(){}

    public Project(String projectNumber, String topic, Date startProjectDate, Date endProjectDate,
                   Float amount, String comments, ProjectStatus projectStatus, ProjectType projectType) {
        this.projectNumber = projectNumber;
        this.topic = topic;
        this.startProjectDate = startProjectDate;
        this.endProjectDate = endProjectDate;
        this.amount = amount;
        this.comments = comments;
        this.projectStatus = projectStatus;
        this.projectType = projectType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProjectNumber() {
        return projectNumber;
    }

    public void setProjectNumber(String projectNumber) {
        this.projectNumber = projectNumber;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public Date getStartProjectDate() {
        return startProjectDate;
    }

    public void setStartProjectDate(Date startProjectDate) {
        this.startProjectDate = startProjectDate;
    }

    public Date getEndProjectDate() {
        return endProjectDate;
    }

    public void setEndProjectDate(Date endProjectDate) {
        this.endProjectDate = endProjectDate;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", projectNumber=" + projectNumber +
                ", topic='" + topic + '\'' +
                ", startProjectDate=" + startProjectDate +
                ", endProjectDate=" + endProjectDate +
                ", amount=" + amount +
                ", comments='" + comments + '\'' +
                '}';
    }
}
