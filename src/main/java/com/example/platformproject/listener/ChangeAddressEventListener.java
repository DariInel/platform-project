package com.example.platformproject.listener;

import com.example.platformproject.event.ChangeAddressEvent;
import com.example.platformproject.service.NotificationService;
import com.example.platformproject.util.CustomResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ChangeAddressEventListener implements ApplicationListener<ChangeAddressEvent> {

    @Autowired
    NotificationService notificationService;

    @Override
    public void onApplicationEvent(ChangeAddressEvent event) {
        CustomResponse response = notificationService.addNotification(event.getChange());
        if(response.getCode() == 2)
            log.error(response.getMessage());
    }
}
