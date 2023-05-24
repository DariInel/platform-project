package com.example.platformproject.event;

import com.example.platformproject.domain.dto.request.ChangeAddress;
import org.springframework.context.ApplicationEvent;

public class ChangeAddressEvent extends ApplicationEvent {
    private final ChangeAddress data;

    public ChangeAddressEvent(Object source, ChangeAddress data) {
        super(source);
        this.data = data;
    }
    public ChangeAddress getChange(){
        return data;
    }
}
