package com.yabanci.vet.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.yabanci.vet.dto.PetOwnerDto;
import com.yabanci.vet.dto.converter.PetOwnerDtoConverter;
import com.yabanci.vet.dto.request.CreatePetOwnerRequest;
import com.yabanci.vet.dto.request.EditPetOwnerRequest;
import com.yabanci.vet.exception.PetOwnerNotFoundException;
import com.yabanci.vet.model.PetOwner;
import com.yabanci.vet.repository.PetOwnerRepository;

@Service
public class PetOwnerService {

	private final PetOwnerRepository petOwnerRepository;
	private final PetOwnerDtoConverter converter;

	public PetOwnerService(PetOwnerRepository petOwnerRepository, PetOwnerDtoConverter converter) {
		super();
		this.petOwnerRepository = petOwnerRepository;
		this.converter = converter;
	}
	
	public PetOwner findPetOwnerById(long id) {
		return petOwnerRepository.
				findById(id).
				orElseThrow(() -> new PetOwnerNotFoundException("PetOwner could not find by id: " + id));
	}	
	
	public List<PetOwnerDto> getAll() {
		return petOwnerRepository.
				findAll().
				stream().
				map(converter::convert).
				collect(Collectors.toList());
	}
	
	public PetOwnerDto createPetOwner(CreatePetOwnerRequest createPetOwnerRequest) {
		PetOwner petOwner = new PetOwner(
				createPetOwnerRequest.getId(),
				createPetOwnerRequest.getName(),
				createPetOwnerRequest.getLastName(),
				createPetOwnerRequest.getAddress(), 
				createPetOwnerRequest.getPhoneNumber(), 
				createPetOwnerRequest.getEmail());
		
		return converter.convert(petOwnerRepository.save(petOwner));
	}
	
	public PetOwnerDto editPetOwner(Long petOwnerId,EditPetOwnerRequest editPetOwnerRequest) {
		PetOwner petOwner = findPetOwnerById(petOwnerId);
		editPetOwnerRequest.setId(editPetOwnerRequest.getId());
		editPetOwnerRequest.setName(editPetOwnerRequest.getName());
		editPetOwnerRequest.setLastName(editPetOwnerRequest.getLastName());
		editPetOwnerRequest.setAddress(editPetOwnerRequest.getAddress());
		editPetOwnerRequest.setEmail(editPetOwnerRequest.getEmail());
		editPetOwnerRequest.setPhoneNumber(editPetOwnerRequest.getPhoneNumber());
		return converter.convert(petOwnerRepository.save(petOwner));
	}
	
	public void deletePetOwner(long petOwnerId) {
		petOwnerRepository.deleteById(petOwnerId);
	}
}
