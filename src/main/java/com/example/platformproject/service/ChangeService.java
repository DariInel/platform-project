package com.example.platformproject.service;

import com.example.platformproject.domain.Change;
import com.example.platformproject.domain.dto.request.ChangeAddress;
import com.example.platformproject.repository.ChangeRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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

    public void addChange(ChangeAddress changeAddress){
        Change change = new Change();
        Long id;
        while (true){
            id = Double.valueOf(Math.random()*1000).longValue();
            if(findChange(id) == null)
                break;
        }
        change.setId(id);
        change.setDate(changeAddress.getDate());
        change.setId_student(changeAddress.getId_student());
        change.setNew_value(changeAddress.getNew_address());
        change.setOld_value(changeAddress.getOld_address());
        change.setViewed(false);
        changeRepository.save(change);
    }
}
