package com.example.platformproject.service;

import com.example.platformproject.domain.Module;
import com.example.platformproject.repository.ModuleRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ModuleService {

    @Autowired
    ModuleRepository moduleRepository;

    public List<Module> findModules(Long courseId){
        return moduleRepository.findAllByCourseId(courseId);
    }
}
