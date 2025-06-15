package com.example.ApplyMate.controller;

import com.example.ApplyMate.dto.CustomResponse;
import com.example.ApplyMate.dto.SuggestionsDTO;
import com.example.ApplyMate.service.SuggestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/suggestion")
public class SuggestionController {

    private final SuggestionService suggestionService;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public CustomResponse<List<SuggestionsDTO>> getSuggestions(
            @RequestParam("resume") MultipartFile resume
    ) {

        return new CustomResponse<>(
                HttpStatus.OK,
                "Suggestions of resume fetched",
                suggestionService.getSuggestions(resume)
        );

    }

}
