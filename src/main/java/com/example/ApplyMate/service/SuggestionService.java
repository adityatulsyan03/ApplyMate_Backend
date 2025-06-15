package com.example.ApplyMate.service;

import com.example.ApplyMate.dto.SuggestionsDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SuggestionService {


    public List<SuggestionsDTO> getSuggestions(MultipartFile resume) {

        String resumeText = extractTextFromResume(resume);
        return getSuggestionsAI(resumeText);

    }

    private String extractTextFromResume(MultipartFile resume) {
        try (InputStream inputStream = resume.getInputStream();
             PDDocument document = PDDocument.load(inputStream)) {

            PDFTextStripper pdfStripper = new PDFTextStripper();
            return pdfStripper.getText(document);

        } catch (IOException e) {
            e.printStackTrace(); // Log properly in production
            throw new RuntimeException("Failed to extract text from resume");
        }
    }

    private List<SuggestionsDTO> getSuggestionsAI(String resumeText) {

        return new ArrayList<>() {};

    }

}
