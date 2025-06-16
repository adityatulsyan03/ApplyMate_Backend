package com.example.ApplyMate.service;

import com.example.ApplyMate.controller.ActivityController;
import com.example.ApplyMate.dto.ActivityDTO;
import com.example.ApplyMate.dto.ReferralDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@AllArgsConstructor
public class ReferralService {

    private final AIService aiService;
    private final ActivityController activityController;

    public String getReferralMsg(ReferralDTO referralDTO) {

        ActivityDTO activityDTO = new ActivityDTO();
        activityDTO.setActivity_name("Referral Generated");
        activityDTO.setActivity_date(new Date());
        activityDTO.setActivity_description("");

        activityController.saveActivity(activityDTO);

        return aiService.getReferralMsg(referralDTO);

    }
}
