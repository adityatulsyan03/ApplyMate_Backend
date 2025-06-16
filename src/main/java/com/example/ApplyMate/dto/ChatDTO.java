package com.example.ApplyMate.dto;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ChatDTO {

    private List<String> messages;

}
