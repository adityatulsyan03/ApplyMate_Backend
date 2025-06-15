package com.example.ApplyMate.mapper;

import com.example.ApplyMate.dto.ActivityDTO;
import com.example.ApplyMate.entity.Activity;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ActivityMapper {

    private static final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    public static ActivityDTO toDTO(Activity activity) {
        return ActivityDTO.builder()
                .activity_id(activity.getActivity_id())
                .activity_name(activity.getActivity_name())
                .activity_description(activity.getActivity_description())
                .activity_date(formatter.format(activity.getActivity_date()))
                .build();
    }

    public static Activity toEntity(ActivityDTO dto) {
        Date parsedDate;
        try {
            parsedDate = formatter.parse(dto.getActivity_date());
        } catch (ParseException e) {
            parsedDate = new Date();
        }

        return new Activity(
                dto.getActivity_id(),
                dto.getActivity_name(),
                dto.getActivity_description(),
                parsedDate
        );
    }
}