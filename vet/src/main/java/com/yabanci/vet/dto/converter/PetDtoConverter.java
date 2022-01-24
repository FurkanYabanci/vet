package com.yabanci.vet.dto.converter;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.yabanci.vet.dto.PetDto;
import com.yabanci.vet.model.Pet;

@Component
public class PetDtoConverter {

	private final PetOwnerDtoConverter petOwnerDtoConverter;
	
	public PetDtoConverter(PetOwnerDtoConverter petOwnerDtoConverter) {
		super();
		this.petOwnerDtoConverter = petOwnerDtoConverter;
	}

	
	public PetDto convert(Pet from) {
		return new PetDto(
				from.getId(), 
				from.getName(), 
				from.getType(), 
				from.getSpecies(), 
				from.getAge(), 
				from.getExplanation(),
				petOwnerDtoConverter.convertToPetPetOwner(Optional.ofNullable(from.getPetOwner())));
	}
}
