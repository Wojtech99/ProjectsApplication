package com.example.aplikacjaprojekty.projectStatus;

import com.example.aplikacjaprojekty.projectType.ProjectType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class StatusController {
    private final StatusService statusService;

    public StatusController(StatusService statusService) {
        this.statusService = statusService;
    }

    @GetMapping("add_status")
    String getSite(){
        return "add_status";
    }

    @PostMapping("/addNewStatus")
    String getStatus(String newProjectStatus){
        statusService.add(newProjectStatus);
        return "add_status";
    }


    //take all projects type to edit
    @GetMapping("/edit_status")
    String takeProjectsToEditOrRemove(Model model){
        List<ProjectStatus> projectDtoList = statusService.findAllStatuses();
        model.addAttribute("list", projectDtoList);
        return "/edit_status";
    }

    @PostMapping("/deleteStatus")
    String deleteProjectType(@RequestParam String statusName, Model model){
        statusService.deleteStatus(statusName);

        List<ProjectStatus> projectDtoList = statusService.findAllStatuses();
        model.addAttribute("list", projectDtoList);
        return "/edit_status";
    }

    @PostMapping("/updateStatus")
    String updateProjectType(@RequestParam String newProjectStatusName, @RequestParam Long id, Model model){
        statusService.updateStatusName(newProjectStatusName, id);

        List<ProjectStatus> projectDtoList = statusService.findAllStatuses();
        model.addAttribute("list", projectDtoList);
        return "/edit_status";
    }
}
