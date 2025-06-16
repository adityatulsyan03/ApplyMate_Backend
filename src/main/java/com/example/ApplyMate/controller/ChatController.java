package com.example.ApplyMate.controller;

import com.example.ApplyMate.dto.ChatDTO;
import com.example.ApplyMate.dto.CustomResponse;
import com.example.ApplyMate.service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/chat")
public class ChatController {

    private final ChatService chatService;

    @PostMapping
    public CustomResponse<String> getReply(@RequestBody ChatDTO chatDTO) {
        return new CustomResponse<>(
                HttpStatus.OK,
                "Got the reply",
                chatService.getReply(chatDTO)
        );
    }

}
