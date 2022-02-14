package com.example.aplikacjaprojekty.project;

import com.example.aplikacjaprojekty.projectStatus.ProjectStatus;
import com.example.aplikacjaprojekty.projectType.ProjectType;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class ProjectDtoForEdit {
    private Long id;
    private String projectNumber;
    private String topic;
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date startProjectDate;
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date endProjectDate;
    private Float amount;
    private String comments;
    private Long projectStatusId;
    private Long projectTypeId;

    public ProjectDtoForEdit(){}

    public ProjectDtoForEdit(Long id, String projectNumber, String topic, Date startProjectDate, Date endProjectDate,
                            Float amount, String comments, Long projectStatusId, Long projectTypeId) {
        this.id = id;
        this.projectNumber = projectNumber;
        this.topic = topic;
        this.startProjectDate = startProjectDate;
        this.endProjectDate = endProjectDate;
        this.amount = amount;
        this.comments = comments;
        this.projectStatusId = projectStatusId;
        this.projectTypeId = projectTypeId;
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

    public Long getProjectStatusId() {
        return projectStatusId;
    }

    public void setProjectStatusId(Long projectStatusId) {
        this.projectStatusId = projectStatusId;
    }

    public Long getProjectTypeId() {
        return projectTypeId;
    }

    public void setProjectTypeId(Long projectTypeId) {
        this.projectTypeId = projectTypeId;
    }
}