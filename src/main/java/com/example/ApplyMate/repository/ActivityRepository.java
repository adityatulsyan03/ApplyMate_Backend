package com.example.ApplyMate.repository;

import com.example.ApplyMate.entity.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ActivityRepository extends JpaRepository<Activity, Long> {

    List<Activity> findTop2ByOrderByActivityIdDesc();

}