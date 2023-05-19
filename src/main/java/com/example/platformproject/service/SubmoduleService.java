package com.example.platformproject.service;

import com.example.platformproject.domain.Submodule;
import com.example.platformproject.repository.SubmoduleRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class SubmoduleService {

    @Autowired
    SubmoduleRepository submoduleRepository;

    public Submodule findSubmodule(String name){
        return submoduleRepository.findSubmoduleByName(name);
    }

    public List<Submodule> findSubmodules(Long moduleId){
        return submoduleRepository.findAllByModuleId(moduleId);
    }
}
