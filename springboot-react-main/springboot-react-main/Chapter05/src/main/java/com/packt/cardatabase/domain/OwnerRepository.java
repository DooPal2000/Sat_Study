package com.packt.cardatabase.domain;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface OwnerRepository extends CrudRepository<Owner, Long> {
	Optional<Owner> findByFirstname(String firstname);
	// findByFirstNameAndLastName
	Optional<Owner> findByLastname(String lastname);

	Optional<Owner> findByFirstnameAndLastname(String firstname, String lastname);
}
