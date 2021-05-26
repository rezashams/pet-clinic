package com.petclinic.bootstrap;

import com.petclinic.model.Owner;
import com.petclinic.model.Pet;
import com.petclinic.model.PetType;
import com.petclinic.model.Vet;
import com.petclinic.services.OwnerService;
import com.petclinic.services.PetTypeService;
import com.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

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

        System.out.println("Loaded Owners....");

        Vet vet1 = new Vet();
        vet1.setFirstName("Vahid");
        vet1.setLastName("Shams");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Hojat");
        vet2.setLastName("Lagizian");

        vetService.save(vet2);

        System.out.println("Loaded Vets....");

    }
}
