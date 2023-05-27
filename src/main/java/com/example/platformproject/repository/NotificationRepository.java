package com.example.platformproject.repository;

import com.example.platformproject.domain.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
    Notification findNotificationById(Long id);
    List <Notification> findAllByViewed(Boolean viewed);
}
