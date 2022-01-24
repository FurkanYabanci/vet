package com.yabanci.vet.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.yabanci.vet.dto.request.CreatePetRequest;
import com.yabanci.vet.dto.request.EditPetRequest;
import com.yabanci.vet.service.PetService;

@Controller
@RequestMapping("/v1/pet")
public class PetController {

	private final PetService petService;

	public PetController(PetService petService) {
		super();
		this.petService = petService;
	}
	
	@GetMapping("/getAll")
	public ModelAndView getAllPetOwner() {
		ModelAndView mv = new ModelAndView("list-pet");
		mv.addObject("pets", petService.getAll());
		return mv;
	}
	
	@GetMapping("/findPetByPetOwnerId")
	public ModelAndView findPetByPetOwnerId(@RequestParam long petOwnerId) {
		ModelAndView mv = new ModelAndView("list-pet");
		mv.addObject("petById", petService.findPetByPetOwnerId(petOwnerId));
		return mv;
	}
	
	@GetMapping("/createPetForm")
	public ModelAndView createPetForm() {
		ModelAndView mv = new ModelAndView("add-pet");
		CreatePetRequest createPetRequest = new CreatePetRequest();
		mv.addObject("pet", createPetRequest);
		return mv;
	}
	
	@PostMapping("/createPet")
	public String createPet(@ModelAttribute @Valid CreatePetRequest createPetRequest) {
		petService.createPet(createPetRequest);
		return "redirect:/v1/petOwner/getAll";		
	}
	
	@GetMapping("/editPetForm")
	public ModelAndView editPetOwnerForm(@RequestParam Long petId,EditPetRequest editPetRequest) {
		ModelAndView mv = new ModelAndView("add-pet");
		mv.addObject("pet",petService.editPet(petId, editPetRequest));
		return mv;
	}
	
	@GetMapping("/deletePet")
	public String deletePet(@RequestParam Long petId) {
		petService.deletePet(petId);
		return "redirect:/v1/petOwner/getAll";
	}
	
}
