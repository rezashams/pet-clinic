/*
 * Copyright (c) 2021.
 * Author:  Reza Shams (rezashams86@gmail.com)
 */

package com.petclinic.formatters;

import com.petclinic.model.PetType;
import com.petclinic.services.PetTypeService;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Collection;
import java.util.Locale;
import org.springframework.format.Formatter;

@Component
public class PetTypeFormatter implements Formatter<PetType>{

    private final PetTypeService petTypeService;

    public PetTypeFormatter(PetTypeService petTypeService) {
        this.petTypeService = petTypeService;
    }

    @Override
    public String print(PetType petType, Locale locale) {
        return petType.getName();
    }

    @Override
    public PetType parse(String text, Locale locale) throws ParseException {
        Collection<PetType> findPetTypes = petTypeService.findAll();

        for (PetType type : findPetTypes) {
            if (type.getName().equals(text)) {
                return type;
            }
        }

        throw new ParseException("type not found: " + text, 0);
    }
}
