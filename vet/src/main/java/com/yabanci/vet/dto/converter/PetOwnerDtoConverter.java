package com.yabanci.vet.dto.converter;

import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.yabanci.vet.dto.PetOwnerDto;
import com.yabanci.vet.dto.PetPetOwnerDto;
import com.yabanci.vet.model.PetOwner;

@Component
public class PetOwnerDtoConverter {

	private final PetOwnerPetDtoConverter converter;

	public PetOwnerDtoConverter(PetOwnerPetDtoConverter converter) {
		super();
		this.converter = converter;
	}

	public PetPetOwnerDto convertToPetPetOwner(Optional<PetOwner> from) {
		return from.
				map(f -> new PetPetOwnerDto(
						f.getId(), 
						f.getName(), 
						f.getLastName(), 
						f.getAddress(), 
						f.getPhoneNumber(), 
						f.getEmail())).
				orElse(null);
	}
	
	public PetOwnerDto convert(PetOwner from) {
		return new PetOwnerDto(
				from.getId(), 
				from.getName(), 
				from.getLastName(),
				from.getAddress(), 
				from.getPhoneNumber(), 
				from.getEmail(),
				from.getPets().
						stream().
						map(converter::convert).
						collect(Collectors.toList()));
	}
}
