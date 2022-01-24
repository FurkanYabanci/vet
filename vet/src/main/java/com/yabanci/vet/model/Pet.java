package com.yabanci.vet.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
public class Pet implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String name;
	
	private String type;
	
	private String species;
	
	private String age;
	
	@Lob
	private String explanation;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "petowner_id")
	private PetOwner petOwner;

	public Pet(PetOwner petOwner, String name, String type, String species, String age, String explanation) {
		super();
		this.petOwner = petOwner;
		this.name = name;
		this.type = type;
		this.species = species;
		this.age = age;
		this.explanation = explanation;
	}
	
	public Pet(long id,String name, String type, String species, String age, String explanation,PetOwner petOwner) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.species = species;
		this.age = age;
		this.explanation = explanation;
		this.petOwner = petOwner;
	}
}
