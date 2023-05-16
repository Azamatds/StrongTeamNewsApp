package com.example.strongteambackendassignment.dto;

import java.util.List;

public class PersonResponse {
    private List<PersonDTO> personDTOS;

    public PersonResponse(List<PersonDTO> personDTOS) {
        this.personDTOS = personDTOS;
    }

    public List<PersonDTO> getPersonDTOS() {
        return personDTOS;
    }

    public void setPersonDTOS(List<PersonDTO> personDTOS) {
        this.personDTOS = personDTOS;
    }
}
