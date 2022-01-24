package com.yabanci.vet.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PetOwnerDto {

	private long id;

	private String name;

	private String lastName;

	private String address;

	private String phoneNumber;

	private String email;

	private List<PetOwnerPetDto> pets;

}
