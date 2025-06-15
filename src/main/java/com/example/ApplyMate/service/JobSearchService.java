package com.example.ApplyMate.service;

import com.example.ApplyMate.controller.ActivityController;
import com.example.ApplyMate.dto.ActivityDTO;
import com.example.ApplyMate.dto.JobSearchDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class JobSearchService {

    private final ActivityController activityController;

    public String getSearchQuery(JobSearchDTO searchDTO) {

        ActivityDTO activityDTO = new ActivityDTO();
        activityDTO.setActivity_name("Job Search");
        activityDTO.setActivity_date(new Date());
        activityDTO.setActivity_description("");

        activityController.saveActivity(activityDTO);

        return createQueryUsingAI(searchDTO);

    }

    private String createQueryUsingAI(JobSearchDTO searchDTO) {

        return "";

    }

}
