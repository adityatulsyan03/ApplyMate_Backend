package com.example.ApplyMate.controller;

import com.example.ApplyMate.dto.ActivityDTO;
import com.example.ApplyMate.dto.CustomResponse;
import com.example.ApplyMate.entity.Activity;
import com.example.ApplyMate.mapper.ActivityMapper;
import com.example.ApplyMate.service.ActivityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/recent_activity")
public class ActivityController {

    private final ActivityService activityService;

    @GetMapping("/all")
    public CustomResponse<List<ActivityDTO>> getAllRecentActivities() {
        List<Activity> activities = activityService.findAll();
        List<ActivityDTO> dtoList = activities.stream()
                .map(ActivityMapper::toDTO)
                .toList();

        return new CustomResponse<>(
                HttpStatus.OK,
                "All Activities Fetched",
                dtoList
        );

    }

    @GetMapping("/{id}")
    public CustomResponse<ActivityDTO> getRecentActivityById(@PathVariable Long id) {
        Activity activity = activityService.findById(id);
        ActivityDTO dto = ActivityMapper.toDTO(activity);

        return new CustomResponse<>(
                HttpStatus.OK,
                "Activity with ID " + id + " fetched",
                dto
        );
    }

    @GetMapping("/top2")
    public CustomResponse<List<ActivityDTO>> getTop2Activity() {
        List<Activity> activities = activityService.findTopTwoActivities();
        List<ActivityDTO> dtoList = activities.stream()
                .map(ActivityMapper::toDTO)
                .toList();

        return new CustomResponse<>(
                HttpStatus.OK,
                "Top 2 Activity Fetched",
                dtoList
        );
    }

    @PostMapping
    public CustomResponse<ActivityDTO> saveActivity(@RequestBody ActivityDTO dto) {
        Activity activity = ActivityMapper.toEntity(dto);
        activityService.save(activity);

        return new CustomResponse<>(
                HttpStatus.CREATED,
                "Activity Created",
                dto
        );
    }
}