package com.example.ApplyMate.service;

import com.example.ApplyMate.controller.ActivityController;
import com.example.ApplyMate.dto.ActivityDTO;
import com.example.ApplyMate.dto.ResumeDTO;
import com.example.ApplyMate.dto.SuggestionsDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ResumeService {

    private final AIService aiService;
    private final ActivityController activityController;

    public String getResumeText(){
        return "";
    }

    public List<SuggestionsDTO> getSuggestions(ResumeDTO resumeDTO) {

        ActivityDTO activityDTO = new ActivityDTO();
        activityDTO.setActivity_name("Resume Optimized");
        activityDTO.setActivity_date(new Date());
        activityDTO.setActivity_description("");

        activityController.saveActivity(activityDTO);

        String resumeText = resumeDTO.getResumeText();

        return aiService.getSuggestions(resumeText);

    }

}
