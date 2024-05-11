package com.regex.app1.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.regex.app1.model.Product;
import com.regex.app1.repo.ProductRepository;

@Component
public class SpringBootRunner implements ApplicationRunner{

	@Autowired
	private ProductRepository repo;
	@Override
	public void run(ApplicationArguments args) throws Exception {
		repo.save(new Product("Tablet pc",12000.00));
		repo.save(new Product("Laptop",55000.00));
		repo.save(new Product("PC",45000.00));
		repo.save(new Product("Mobile",65000.00));
		System.out.println("=============================");
		repo.findAll().forEach(System.out::println);
		System.out.println("=============================");
		Product p=repo.findById(1).get();
		System.out.println(p);
		
		System.out.println("=======================");
		repo.deleteById(2);
		repo.findAll().forEach(System.out::println);
		System.out.println("=======================");
		//	repo.deleteAllInBatch();
		
		long count=repo.count();
		System.out.println(count);
		
	}

}
