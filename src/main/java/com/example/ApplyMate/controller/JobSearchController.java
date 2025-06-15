package com.example.ApplyMate.controller;

import com.example.ApplyMate.dto.CustomResponse;
import com.example.ApplyMate.dto.JobSearchDTO;
import com.example.ApplyMate.service.JobSearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/job_search")
public class JobSearchController {

    private final JobSearchService jobSearchService;

    @PostMapping
    public CustomResponse<String> getJobQuery(@RequestBody JobSearchDTO searchDto){
        return new CustomResponse<>(
                HttpStatus.OK,
                "Job Search Query Fetched",
                jobSearchService.getSearchQuery(searchDto)
        );
    }

}
