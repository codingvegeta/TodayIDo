package com.fastcam.programming.dmaker.controller;

import com.fastcam.programming.dmaker.dto.CreateDeveloper;
import com.fastcam.programming.dmaker.dto.DeveloperDetailDto;
import com.fastcam.programming.dmaker.dto.DeveloperDto;
import com.fastcam.programming.dmaker.dto.EditDeveloper;
import com.fastcam.programming.dmaker.service.DMarkerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class DMakerController {

    private final DMarkerService dMarkerService;


    @GetMapping("developers")
    public List<DeveloperDto> getAllDevelopers() {
        log.info("GET /developers HTTP/1.1");

        return dMarkerService.getAllEmployedDevelopers();
    }

    @GetMapping("developer/{memberId}")
    public DeveloperDetailDto getDeveloperDetail(
            @PathVariable String memberId
    ) {
        log.info("GET /developer/{} HTTP/1.1", memberId);

        return dMarkerService.getAllDeveloperDetail(memberId);
    }

    @PostMapping("/create-developer")
    public CreateDeveloper.Response createDeveloper(
            @Valid @RequestBody CreateDeveloper.Request request
    ) {

        log.info("request: {}", request);


        return dMarkerService.createDeveloper(request);
    }

    @PutMapping("developer/{memberId}")
    public DeveloperDetailDto editDeveloper(
            @PathVariable String memberId,
            @Valid @RequestBody EditDeveloper.Request request
    ) {
        log.info("PUT /developer/{} HTTP/1.1", memberId);

        return dMarkerService.editDeveloper(memberId, request);
    }

    @DeleteMapping("/developer/{memberId}")
    public DeveloperDetailDto deleteDeveloper(
            @PathVariable String memberId
    ) {

        log.info("DELETE /developer/{} HTTP/1.1", memberId);
        return dMarkerService.deleteDeveloper(memberId);

    }
}
