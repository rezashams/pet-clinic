/*
 * Copyright (c) 2021.
 * Author:  Reza Shams (rezashams86@gmail.com)
 */

package com.petclinic.services.map;

import com.petclinic.model.Visit;
import com.petclinic.services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default", "map"})
public class VisitMapService extends AbstractMapService<Visit,Long> implements VisitService {



    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Visit object) {
        super.delete(object);
    }

    @Override
    public Visit save(Visit object) {
        if(object.getPet()== null || object.getPet().getOwner()==null || object.getPet().getId()==null ||
                object.getPet().getOwner().getId()==null)
            throw new RuntimeException("Invalid visit");
        return super.save(object);
    }

    @Override
    public Visit findById(Long id) {
        return super.findById(id);
    }
}
