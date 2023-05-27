package com.example.platformproject.service;

import com.example.platformproject.domain.Notification;
import com.example.platformproject.domain.Student;
import com.example.platformproject.domain.dto.request.ChangeAddress;
import com.example.platformproject.repository.NotificationRepository;
import com.example.platformproject.util.CustomResponse;
import com.example.platformproject.util.CustomStatus;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Service
@Log4j2
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class NotificationService {

    @Autowired
    NotificationRepository notificationRepository;

    public Notification findNotification(Long id){
        return notificationRepository.findNotificationById(id);
    }
    public List<Notification> findNotificationsForView(){
        return notificationRepository.findAllByViewed(false);
    }
    public void updateNotification(Long id){
        Notification notification = findNotification(id);
        notification.setViewed(true);
        notificationRepository.save(notification);
    }

    public CustomResponse addNotification(ChangeAddress changeAddress){
        Notification notification = new Notification();
        notification.setDate(changeAddress.getDate());
        notification.setId_student(changeAddress.getId_student());
        notification.setMessage(changeAddress.getMessage());
        notification.setViewed(false);
        notificationRepository.save(notification);
        log.info("Изменение адреса зафиксировано");
        return new CustomResponse<>(null, CustomStatus.SUCCESS);
    }
    public CustomResponse addBirthDayNotification(Student student){
        Notification notification = new Notification();
        notification.setDate(Date.valueOf(LocalDate.now()));
        notification.setId_student(student.getId());
        String message = "Ученик " + student.getSecond_name() + " " + student.getFirst_name() + " "
                + student.getPatronymic() + " из группы " + student.getGroup_id() + "празднует день рождения через 2 дня!";
        notification.setMessage(message);
        notification.setViewed(false);
        notificationRepository.save(notification);
        log.info("Уведомление о др отправлено");
        return new CustomResponse<>(null, CustomStatus.SUCCESS);
    }
}
