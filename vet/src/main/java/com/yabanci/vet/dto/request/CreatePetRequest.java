package com.yabanci.vet.dto.request;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import com.yabanci.vet.model.PetOwner;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreatePetRequest {
	
	private long id;
	@NotBlank
	private String name;
	@NotBlank
	private String type;
	@NotBlank
	private String species;
	@Min(value = 0, message = "Age value must not be negative value")
	private String age;
	@NotBlank
	private String explanation;	
	
	private PetOwner petOwner;
}
