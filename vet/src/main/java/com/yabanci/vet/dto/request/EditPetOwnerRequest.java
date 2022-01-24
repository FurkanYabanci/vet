package com.yabanci.vet.dto.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class EditPetOwnerRequest {

	private long id;
	@NotBlank
	private String name;
	@NotBlank
	private String lastName;
	@NotBlank
	private String address;
	@Pattern(regexp ="[0-9\\s]{11}")
	private String phoneNumber;
	@Email(message = "Wrong Email")
	private String email;

}
