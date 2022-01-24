package com.yabanci.vet.dto.request;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class EditPetRequest {

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
}
