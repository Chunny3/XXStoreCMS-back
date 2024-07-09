package com.example.demo.controller;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.*;

@RestController
@RequestMapping("/api/")
@CrossOrigin("http://localhost:3000/")
public class ProductController {
	@Autowired
	private ProductRepository productRepository;
	
	@GetMapping("/products")
	public List<Product> getAllProducts(){
		return productRepository.findAll();
	}
	
	@GetMapping("/find_product/{pid}")
	public ResponseEntity findById(@PathVariable("pid") int pid) {
		List<Product> allList = getAllProducts();
		for(Iterator<Product> iterator = allList.iterator(); iterator.hasNext();) {
			Product product = (Product) iterator.next();
			if(product.getPid() == pid) {
				return ResponseEntity.ok(product);
			}
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping("/add_product")
	public Product addProduct(@RequestBody Product product) {
		return productRepository.save(product);
	}
	
	@PutMapping("/update_product/{pid}")
	public void updateProduct(@PathVariable("pid") int pid, @RequestBody Product product) {
		List<Product> productList = (productRepository.findById(pid));
		Product upProduct = productList.get(0);
		upProduct.setName(product.getName());
		upProduct.setPrice(product.getPrice());
		upProduct.setIntroduce(product.getIntroduce());
		productRepository.save(upProduct);
	}
	
	@DeleteMapping("/delete_product/{pid}")
	public ResponseEntity deleteProduct(@PathVariable("pid") int pid) {
		productRepository.deleteById(pid);
		return ResponseEntity.ok(pid);
	}
}
