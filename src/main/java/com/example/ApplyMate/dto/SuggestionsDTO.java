package com.example.ApplyMate.dto;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SuggestionsDTO {

    private String InShort;
    private String ToDo;
    private Boolean isGood;

}
