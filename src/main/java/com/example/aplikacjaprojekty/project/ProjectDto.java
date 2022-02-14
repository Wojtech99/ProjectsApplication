package com.example.aplikacjaprojekty.project;

import com.example.aplikacjaprojekty.projectStatus.ProjectStatus;
import com.example.aplikacjaprojekty.projectType.ProjectType;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class ProjectDto {
    private String projectNumber;
    private String topic;
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date startProjectDate;
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date endProjectDate;
    private Float amount;
    private String comments;
    private ProjectStatus projectStatus;
    private ProjectType projectType;

    public ProjectDto(){}

    public ProjectDto(String projectNumber, String topic, Date startProjectDate, Date endProjectDate, Float amount, String comments,
                      ProjectStatus projectStatus,ProjectType projectType) {
        this.projectNumber = projectNumber;
        this.topic = topic;
        this.startProjectDate = startProjectDate;
        this.endProjectDate = endProjectDate;
        this.amount = amount;
        this.comments = comments;
        this.projectStatus = projectStatus;
        this.projectType = projectType;
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

    public ProjectStatus getProjectStatus() {
        return projectStatus;
    }

    public void setProjectStatus(ProjectStatus projectStatus) {
        this.projectStatus = projectStatus;
    }

    public ProjectType getProjectType() {
        return projectType;
    }

    public void setProjectType(ProjectType projectType) {
        this.projectType = projectType;
    }
}
