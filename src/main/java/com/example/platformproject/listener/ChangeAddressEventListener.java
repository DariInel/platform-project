package com.example.platformproject.listener;

import com.example.platformproject.event.ChangeAddressEvent;
import com.example.platformproject.service.ChangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class ChangeAddressEventListener implements ApplicationListener<ChangeAddressEvent> {

    @Autowired
    ChangeService changeService;

    @Override
    public void onApplicationEvent(ChangeAddressEvent event) {
        changeService.addChange(event.getChange());
    }
}
