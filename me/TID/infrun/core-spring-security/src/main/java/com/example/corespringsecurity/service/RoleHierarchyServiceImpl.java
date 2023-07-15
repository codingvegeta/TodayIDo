package com.example.corespringsecurity.service;

import com.example.corespringsecurity.domain.entity.RoleHierarchy;
import com.example.corespringsecurity.repository.RoleHierarchyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

@Service
public class RoleHierarchyServiceImpl implements RoleHierarchyService {
    @Autowired
    private RoleHierarchyRepository roleHierarchyRepository;

    @Override
    public String findAllHierarchy() {

        List<RoleHierarchy> rolesHierarchy = roleHierarchyRepository.findAll();

        Iterator<RoleHierarchy> iterator = rolesHierarchy.iterator();
        StringBuilder concatedRoles = new StringBuilder();
        while (iterator.hasNext()) {
            RoleHierarchy roleHierarchy = iterator.next();
            if (roleHierarchy.getParentName() != null) {
                concatedRoles.append(roleHierarchy.getParentName().getChildName());
                concatedRoles.append(" > ");
                concatedRoles.append(roleHierarchy.getChildName());
                concatedRoles.append("\n");
            }
        }
        return concatedRoles.toString();
    }
}
