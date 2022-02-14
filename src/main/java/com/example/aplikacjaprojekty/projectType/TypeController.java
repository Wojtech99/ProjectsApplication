package com.example.aplikacjaprojekty.projectType;

import com.example.aplikacjaprojekty.project.ProjectDto;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class TypeController {
    private final TypeService typeService;

    public TypeController(TypeService typeService) {
        this.typeService = typeService;
    }

    @GetMapping("/add_type")
    String get(){
        return "add_type";
    }

    @PostMapping("/addNewType")
    String getType(String newProjectType){
        typeService.add(newProjectType);
        return "add_type";
    }


    //take all projects type to edit
    @GetMapping("/edit_type")
    String takeProjectsToEditOrRemove(Model model){
        List<ProjectType> projectDtoList = typeService.findAllTypes();
        model.addAttribute("list", projectDtoList);
        return "/edit_type";
    }

    @PostMapping("/deleteType")
    String deleteProjectType(@RequestParam String typeName, Model model){
        typeService.deleteType(typeName);

        List<ProjectType> projectDtoList = typeService.findAllTypes();
        model.addAttribute("list", projectDtoList);
        return "/edit_type";
    }

    @PostMapping("/updateType")
    String updateProjectType(@RequestParam String newProjectTypeName, @RequestParam Long id, Model model){
        typeService.updateTypeName(newProjectTypeName, id);

        List<ProjectType> projectDtoList = typeService.findAllTypes();
        model.addAttribute("list", projectDtoList);
        return "/edit_type";
    }
}
