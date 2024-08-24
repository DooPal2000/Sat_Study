package com.packt.cardatabase.web;

import com.packt.cardatabase.domain.Car;
import com.packt.cardatabase.domain.CarRepository;
import com.packt.cardatabase.domain.Product;
import com.packt.cardatabase.domain.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
@RequestMapping("/api")
public class ProductController {
	@Autowired
	private ProductRepository repository;

	@RequestMapping("/product")
		public Iterable<Product> getProducts() {return repository.findAll();}
}
