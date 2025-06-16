package com.example.ApplyMate.service;

import com.example.ApplyMate.controller.ActivityController;
import com.example.ApplyMate.dto.ActivityDTO;
import com.example.ApplyMate.dto.ChatDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ChatService {

    private final AIService aiService;
    private final ActivityController activityController;

    public String getReply(ChatDTO chatDTO) {

        ActivityDTO activityDTO = new ActivityDTO();
        activityDTO.setActivity_name("Chat");
        activityDTO.setActivity_date(new Date());
        activityDTO.setActivity_description("");

        activityController.saveActivity(activityDTO);

        List<String> chats = chatDTO.getMessages();
        return aiService.getReply(chats);

    }
}
