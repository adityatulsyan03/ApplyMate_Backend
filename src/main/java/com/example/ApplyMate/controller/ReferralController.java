package com.example.ApplyMate.controller;

import com.example.ApplyMate.dto.CustomResponse;
import com.example.ApplyMate.dto.ReferralDTO;
import com.example.ApplyMate.service.ReferralService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/referral")
public class ReferralController {

    private final ReferralService referralService;

    public CustomResponse<String> getReferralMsg(@RequestBody ReferralDTO referralDTO) {

        return new CustomResponse<>(
                HttpStatus.OK,
                "Referral Message Created",
                referralService.getReferralMsg(referralDTO)
        );

    }

}
