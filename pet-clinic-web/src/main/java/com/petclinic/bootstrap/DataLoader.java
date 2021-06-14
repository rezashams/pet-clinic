package com.petclinic.bootstrap;

import com.petclinic.model.*;
import com.petclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private  final SpecialtyService specialtyService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtyService specialtyService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {
        int count = petTypeService.findAll().size();
        if (count==0)
            loadData();

    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedSpeciality = specialtyService.save(radiology);
        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSpeciality2 = specialtyService.save(surgery);

        Owner owner1 = new Owner();
        owner1.setFirstName("Reza");
        owner1.setLastName("Shams");
        owner1.setAddress("Noor 28");
        owner1.setCity("Rasht");
        owner1.setTelephone("934434343");

        Pet mikesPet = new Pet();
        mikesPet.setName("Dani");
        mikesPet.setPetType(savedDogPetType);
        mikesPet.setOwner(owner1);
        mikesPet.setBirthDate(LocalDate.now());
        owner1.getPets().add(mikesPet);
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Majid");
        owner2.setLastName("Shams");
        owner2.setAddress("Moalem 28");
        owner2.setCity("NeyCity");
        owner2.setTelephone("23232");

        Pet mikesPet2 = new Pet();
        mikesPet2.setName("Makhmal");
        mikesPet2.setPetType(savedCatPetType);
        mikesPet2.setOwner(owner2);
        mikesPet2.setBirthDate(LocalDate.now());
        owner2.getPets().add(mikesPet2);

        ownerService.save(owner2);

        Visit catVisit = new Visit();
        catVisit.setDate(LocalDate.now());
        catVisit.setDescription("Sneezy Kitty");
        catVisit.setPet(mikesPet2);
        visitService.save(catVisit);

        System.out.println("Loaded Owners....");

        Vet vet1 = new Vet();
        vet1.setFirstName("Vahid");
        vet1.setLastName("Shams");
        vet1.getSpecialities().add(savedSpeciality);
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Hojat");
        vet2.setLastName("Lagizian");
        vet2.getSpecialities().add(savedSpeciality);
        vet2.getSpecialities().add(savedSpeciality2);
        vetService.save(vet2);

        System.out.println("Loaded Vets....");
    }
}
