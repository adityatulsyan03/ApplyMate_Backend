package com.example.ApplyMate.dto;

import com.example.ApplyMate.enums.ExperienceLevel;
import com.example.ApplyMate.enums.TimeUnit;
import com.example.ApplyMate.enums.WorkType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JobSearchDTO {

    private String search_text;
    private String time_value;
    private TimeUnit time_unit;
    private WorkType work_type;
    private ExperienceLevel experience_level;
    private Boolean easy_apply;
    private Boolean verified;
    private Boolean your_network;
    private Boolean no_of_applications;

}
