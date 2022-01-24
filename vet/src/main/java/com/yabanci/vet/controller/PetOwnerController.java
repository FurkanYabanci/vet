package com.yabanci.vet.controller;


import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.yabanci.vet.dto.request.CreatePetOwnerRequest;
import com.yabanci.vet.dto.request.EditPetOwnerRequest;
import com.yabanci.vet.service.PetOwnerService;

@Controller
@RequestMapping("/v1/petOwner")
public class PetOwnerController {

	private final PetOwnerService petOwnerService;
	
	public PetOwnerController(PetOwnerService petOwnerService) {
		super();
		this.petOwnerService = petOwnerService;
	}

	@GetMapping("/getAll")
	public ModelAndView getAllPetOwner() {
		ModelAndView mv = new ModelAndView("list-pet-owner");
		mv.addObject("petOwners", petOwnerService.getAll());
		return mv;
	}
	
	@GetMapping("/createPetOwnerForm")
	public ModelAndView createPetOwnerForm() {
		ModelAndView mv = new ModelAndView("add-pet-owner");
		CreatePetOwnerRequest createPetOwnerRequest = new CreatePetOwnerRequest();
		mv.addObject("petOwner", createPetOwnerRequest);
		return mv;
	}
	
	@PostMapping("/createPetOwner")
	public String createPetOwner(@ModelAttribute @Valid CreatePetOwnerRequest createPetOwnerRequest) {
		petOwnerService.createPetOwner(createPetOwnerRequest);
		return "redirect:/v1/petOwner/getAll";		
	}
	
	@GetMapping("/editPetOwnerForm")
	public ModelAndView editPetOwnerForm(@RequestParam Long petOwnerId,EditPetOwnerRequest editPetOwnerRequest) {
		ModelAndView mv = new ModelAndView("add-pet-owner");
		mv.addObject("petOwner",petOwnerService.editPetOwner(petOwnerId, editPetOwnerRequest));
		return mv;
	}
	
	@GetMapping("/deletePetOwner")
	public String deletePetOwner(@RequestParam Long petOwnerId) {
		petOwnerService.deletePetOwner(petOwnerId);
		return "redirect:/v1/petOwner/getAll";
	}
	
	
}
