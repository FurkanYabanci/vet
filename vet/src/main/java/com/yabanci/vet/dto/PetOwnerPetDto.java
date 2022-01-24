package com.yabanci.vet.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class PetOwnerPetDto {
	
	private long id;

	private String name;

	private String type;

	private String species;

	private String age;

	private String explanation;
}
