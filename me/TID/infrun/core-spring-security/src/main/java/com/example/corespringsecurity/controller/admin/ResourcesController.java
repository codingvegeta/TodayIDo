package com.example.corespringsecurity.controller.admin;

import com.example.corespringsecurity.domain.entity.Resources;
import com.example.corespringsecurity.repository.RoleRepository;
import com.example.corespringsecurity.service.ResourcesService;
import com.example.corespringsecurity.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ResourcesController {

    @Autowired
    private ResourcesService resourcesService;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private RoleService roleService;

    @GetMapping(value = "/adimn/resources")
    public String getResources(Model model) {

        List<Resources> resources = resourcesService.getResources();
        model.addAttribute("resources", resources);

        return "admin/resources/list";
    }
}
