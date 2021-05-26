package com.petclinic.bootstrap;

import com.petclinic.model.Owner;
import com.petclinic.model.PetType;
import com.petclinic.model.Vet;
import com.petclinic.services.OwnerService;
import com.petclinic.services.PetTypeService;
import com.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

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

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Majid");
        owner2.setLastName("Shams");

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
