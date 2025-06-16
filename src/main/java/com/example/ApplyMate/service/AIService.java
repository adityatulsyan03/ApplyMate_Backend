package com.example.ApplyMate.service;

import com.example.ApplyMate.dto.ReferralDTO;
import com.example.ApplyMate.dto.SuggestionsDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class AIService {

    public List<SuggestionsDTO> getSuggestions(String resumeText) {

        return new ArrayList<>() {};

    }

    public String getReply(List<String> chats) {

        return "";

    }

    public String getReferralMsg(ReferralDTO referralDTO) {

        return "";

    }
}
