package com.example.ApplyMate.controller;

import com.example.ApplyMate.dto.CustomResponse;
import com.example.ApplyMate.dto.ResumeDTO;
import com.example.ApplyMate.dto.SuggestionsDTO;
import com.example.ApplyMate.service.ResumeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Locale;

@RestController
@RequiredArgsConstructor
@RequestMapping("/resume")
public class ResumeController {

    private final ResumeService resumeService;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public CustomResponse<ResumeDTO> getResumeText(
            @RequestParam("resume") MultipartFile resume
    ) {

        String resumeText = resumeService.getResumeText();

        ResumeDTO resumeDTO = new ResumeDTO();
        resumeDTO.setResumeText(resumeText);

        return new CustomResponse<>(
                HttpStatus.OK,
                "Suggestions of resume fetched",
                resumeDTO
        );

    }

    @PostMapping("/improve")
    public CustomResponse<List<SuggestionsDTO>> improveResume(@RequestBody ResumeDTO resumeDTO) {

        return new CustomResponse<>(
                HttpStatus.OK,
                "",
                resumeService.getSuggestions(resumeDTO)
        );

    }

}
