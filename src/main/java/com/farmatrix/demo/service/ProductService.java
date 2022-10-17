package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repo;
	
	public Product save(Product product)
	{
		return repo.save(product);
	}
	
	public List<Product> findAll()
	{
		return repo.findAll();
	}
	
	public List<Product> findAllByCategory(String category)
	{
		List<Product> products=new ArrayList<Product>();
		
		for(Product product: repo.findAll())
		{
			if(product.getCategory().equals(category))
			{
				products.add(product);
			}
		}
		
		return products;
	}
	
	public List<Product> findAllByProductName(String productName)
	{
		List<Product> products=new ArrayList<Product>();
		
		for(Product product: repo.findAll())
		{
			if(product.getName().toLowerCase().contains(productName.toLowerCase()))
			{
				products.add(product);
			}
		}
		
		return products;
	}
	
	public List<Product> findAllByVendorId(String vendorId)
	{
		List<Product> products=new ArrayList<Product>();
		
		for(Product product: repo.findAll())
		{
			if(product.getVendorid().equals(vendorId))
			{
				products.add(product);
			}
		}
		
		return products;
	}
	
	public List<Product> findAllByVendorSearch(String vendorId,String productName)
	{
		List<Product> products=new ArrayList<Product>();
		
		for(Product product: repo.findAll())
		{
			if(product.getVendorid().equals(vendorId) && product.getName().toLowerCase().contains(productName.toLowerCase()))
			{
				products.add(product);
			}
		}
		
		return products;
	}
	
	public Product findById(int id)
	{
		return repo.findById(id).get();
	}
	
	public void delete(int id)
	{
		repo.deleteById(id);
	}	
	
	public boolean isExist(int id)
	{
		return repo.existsById(id);
	}
}
