package com.yabanci.vet.dto.converter;

import org.springframework.stereotype.Component;

import com.yabanci.vet.dto.PetOwnerPetDto;
import com.yabanci.vet.model.Pet;

@Component
public class PetOwnerPetDtoConverter {

	public PetOwnerPetDto convert(Pet from) {
		return new PetOwnerPetDto(
				from.getId(), 
				from.getName(), 
				from.getType(), 
				from.getSpecies(), 
				from.getAge(),
				from.getExplanation());
	}
}
