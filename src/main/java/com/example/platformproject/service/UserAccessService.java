package com.example.platformproject.service;

import com.example.platformproject.domain.Student;
import com.example.platformproject.domain.UserAccess;
import com.example.platformproject.repository.UserAccessRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class UserAccessService implements UserDetailsService {

  //  @Autowired
    UserAccessRepository userAccessRepository;

    public Student findStudentByUsername(String username){
        return userAccessRepository.findUserAccessByUsername(username).getStudent();
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserAccess userAccess = userAccessRepository.findUserAccessByUsername(username);
        if(userAccess == null){
            throw new UsernameNotFoundException("User name: " + username);
        }
        UserDetails user = User.withDefaultPasswordEncoder()
                .username(userAccess.getUsername())
                .password(userAccess.getPassword())
                .roles(userAccess.getRole())
                .build();
        return userAccess;
    }
}
