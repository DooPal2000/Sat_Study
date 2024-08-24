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
		String firstname = requestBody.get("firstname");
		String lastname = requestBody.get("lastname");

		if (firstname != null && lastname != null) {
			return repository.findByFirstnameAndLastname(firstname, lastname);
		} else if (firstname != null) {
			return repository.findByFirstname(firstname);
		} else {
			return repository.findByLastname(lastname);
		}
	}
}
