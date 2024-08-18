package com.packt.cardatabase.web;

import com.packt.cardatabase.domain.Car;
import com.packt.cardatabase.domain.CarRepository;
import com.packt.cardatabase.domain.Owner;
import com.packt.cardatabase.domain.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;


@RestController
@RequestMapping("/api")
public class OwnerControlller {
	@Autowired
	private OwnerRepository repository;

	@RequestMapping("/owners")
	public Iterable<Owner> getOwners() {
		return repository.findAll();
	}
	@RequestMapping("/owner/name")
	public Optional<Owner> getOwnerByFirstName(@RequestBody Map<String, String> requestBody) {
		String firstName = requestBody.get("firstName");
		String lastName = requestBody.get("lastName");

		if (firstName != null && lastName != null) {
			return repository.findByFirstNameAndLastName(firstName, lastName);
		} else if (firstName != null) {
			return repository.findByFirstname(firstName);
		} else {
			return repository.findByLastname(lastName);
		}
	}
}
