package com.yabanci.vet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yabanci.vet.model.PetOwner;

@Repository
public interface PetOwnerRepository extends JpaRepository<PetOwner, Long>{

}
