package com.example.strongteambackendassignment.controller;

import com.example.strongteambackendassignment.dto.AuthenticationDTO;
import com.example.strongteambackendassignment.dto.PersonDTO;
import com.example.strongteambackendassignment.entity.Users;
import com.example.strongteambackendassignment.repository.PeopleRepository;
import com.example.strongteambackendassignment.security.JWTUtils;
import com.example.strongteambackendassignment.service.RegistrService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final ModelMapper modelMapper;
    private final RegistrService registrService;
    private final JWTUtils jwtUtils;

    @Autowired
//    @Qualifier("authenticationManagerBean")
    private AuthenticationManager authenticationManager;

    @Autowired
    public AuthController(ModelMapper modelMapper, RegistrService registrService, PeopleRepository peopleRepository, JWTUtils jwtUtils, AuthenticationManager authenticationManager) {
        this.modelMapper = modelMapper;
        this.registrService = registrService;
        this.jwtUtils = jwtUtils;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/registration")

    public Map<String, String> performRegistration(@RequestBody PersonDTO personDTO) {
        Users person = convertToPerson(personDTO);

        registrService.registration(person);
        String token = jwtUtils.generateToken(person.getUsername());

        return Map.of("jwt-token",token);
    }

    @PostMapping("/login")
    public Map<String,String> performLogin(@RequestBody AuthenticationDTO authenticationDTO) {
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                authenticationDTO.getUsername(),
                authenticationDTO.getPassword());
        try {
            authenticationManager.authenticate(authentication);
        }catch (BadCredentialsException e) {
            return Map.of("message", "Incorrect credentials!");
        }
        String token = jwtUtils.generateToken(authenticationDTO.getUsername());
        return Map.of("jwt-token", token);
    }

    public Users convertToPerson(PersonDTO personDTO) {
        return this.modelMapper.map(personDTO, Users.class);
    }


}

