package com.example.ApplyMate.service;

import com.example.ApplyMate.entity.Activity;
import com.example.ApplyMate.exceptions.ResourceNotFoundException;
import com.example.ApplyMate.repository.ActivityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ActivityService {

    private final ActivityRepository activityRepository;

    public List<Activity> findAll() {
        return activityRepository.findAll();
    }

    public List<Activity> findTopTwoActivities() {
        return activityRepository.findTop2ByOrderByActivityIdDesc();
    }

    public Activity findById(Long id) {
        return activityRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Activity not found with id:" + id));
    }

    public void save(Activity activity) {
        activityRepository.save(activity);
    }

}
