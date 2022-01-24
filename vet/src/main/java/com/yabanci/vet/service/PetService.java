package com.yabanci.vet.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.yabanci.vet.dto.PetDto;
import com.yabanci.vet.dto.converter.PetDtoConverter;
import com.yabanci.vet.dto.request.CreatePetRequest;
import com.yabanci.vet.dto.request.EditPetRequest;
import com.yabanci.vet.exception.PetNotFoundException;
import com.yabanci.vet.model.Pet;
import com.yabanci.vet.model.PetOwner;
import com.yabanci.vet.repository.PetRepository;

@Service
public class PetService {

	private final PetRepository petRepository;
	private final PetDtoConverter converter;
	private final PetOwnerService petOwnerService;

	public PetService(PetRepository petRepository, 
			PetDtoConverter converter, PetOwnerService petOwnerService) {
		super();
		this.petRepository = petRepository;
		this.converter = converter;
		this.petOwnerService = petOwnerService;
	}
	
	protected Pet findPetById(Long id) {
		return petRepository.findById(id).orElseThrow(() -> new PetNotFoundException("Pet could not find by id: " + id));
	}
	
	public List<PetDto> getAll() {
		return petRepository.
				findAll().
				stream().
				map(converter::convert).
				collect(Collectors.toList());
	}
	
	public List<PetDto> findPetByPetOwnerId(long id) {
		return petRepository.
				findPetByPetOwnerId(id).
				stream().
				map(converter::convert).
				collect(Collectors.toList());
	}

	public PetDto createPet(CreatePetRequest createPetRequest) {
		PetOwner petOwner = petOwnerService.findPetOwnerById(createPetRequest.getPetOwner().getId());
		Pet pet = new Pet(
				createPetRequest.getId(),
				createPetRequest.getName(), 
				createPetRequest.getType(), 
				createPetRequest.getSpecies(), 
				createPetRequest.getAge(), 
				createPetRequest.getExplanation(),
				petOwner
				);
		return converter.convert(petRepository.save(pet));	
	}
	
	public PetDto editPet(Long petId,EditPetRequest editPetRequest) {
		Pet pet = findPetById(petId);
				editPetRequest.setId(petId);
				editPetRequest.setName(editPetRequest.getName());
				editPetRequest.setAge(editPetRequest.getAge());
				editPetRequest.setExplanation(editPetRequest.getExplanation());
				editPetRequest.setSpecies(editPetRequest.getSpecies());
				editPetRequest.setType(editPetRequest.getType());				
		return converter.convert(petRepository.save(pet));	 
	}
	
	public void deletePet(long petId) {
		petRepository.deleteById(petId);
	}
}
