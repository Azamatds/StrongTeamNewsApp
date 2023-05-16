package com.example.strongteambackendassignment.service;

import com.example.strongteambackendassignment.entity.Roles;
import com.example.strongteambackendassignment.entity.Users;
import com.example.strongteambackendassignment.repository.PeopleRepository;
import com.example.strongteambackendassignment.repository.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;

@Service
@Transactional(readOnly = true)
public class RegistrService {
    private final PeopleRepository peopleRepository;
    private final PasswordEncoder passwordEncoder;
    private final RolesRepository rolesRepository;

    @Autowired
    public RegistrService(PeopleRepository peopleRepository, PasswordEncoder passwordEncoder, RolesRepository rolesRepository) {
        this.peopleRepository = peopleRepository;
        this.passwordEncoder = passwordEncoder;
        this.rolesRepository = rolesRepository;
    }
    @Transactional
    public void registration(Users person){
        person.setPassword(passwordEncoder.encode(person.getPassword()));
        Roles role = rolesRepository.findById(2).get();
        person.setRoles(Collections.singleton(role));
        peopleRepository.save(person);
    }
}

