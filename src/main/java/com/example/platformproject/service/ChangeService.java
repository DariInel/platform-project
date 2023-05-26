package com.example.platformproject.service;

import com.example.platformproject.domain.Change;
import com.example.platformproject.domain.dto.request.ChangeAddress;
import com.example.platformproject.repository.ChangeRepository;
import com.example.platformproject.util.CustomResponse;
import com.example.platformproject.util.CustomStatus;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ChangeService {

    @Autowired
    ChangeRepository changeRepository;

    public Change findChange(Long id){
        return changeRepository.findChangeById(id);
    }
    public List<Change> findChangesForView(){
        return changeRepository.findAllByViewed(false);
    }
    public void updateChange(Long id){
        Change change = findChange(id);
        change.setViewed(true);
        changeRepository.save(change);
    }

    public CustomResponse addChange(ChangeAddress changeAddress){
        Change change = new Change();
        change.setDate(changeAddress.getDate());
        change.setId_student(changeAddress.getId_student());
        change.setNew_value(changeAddress.getNew_address());
        change.setOld_value(changeAddress.getOld_address());
        change.setViewed(false);
        changeRepository.save(change);
        log.info("Изменение адреса зафиксировано");
        return new CustomResponse<>(null, CustomStatus.SUCCESS);
    }
}
