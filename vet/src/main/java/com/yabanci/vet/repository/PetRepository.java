package com.yabanci.vet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.yabanci.vet.model.Pet;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long>{

	@Query(name = "SELECT * FROM pet  WHERE petowner_id = :id",nativeQuery = true)
	List<Pet> findPetByPetOwnerId(long id);
}
