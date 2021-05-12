package com.petclinic.model;

import java.time.LocalDate;

public class Pet {

    private PetType oetType;
    private Owner owner;
    private LocalDate birthDate;

    public PetType getOetType() {
        return oetType;
    }

    public void setOetType(PetType oetType) {
        this.oetType = oetType;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}
