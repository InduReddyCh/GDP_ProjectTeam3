package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Product;
import com.example.demo.model.ProductOrder;
import com.example.demo.repository.OrderRepository;
import com.example.demo.repository.ProductRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository repo;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private ProductRepository productRepo;
	
	public ProductOrder save(ProductOrder order)
	{
		return repo.save(order);
	}
	
	public List<Product> findAllByUserID(String username)
	{
		List<Product> orders=new ArrayList<Product>();
		
		for(ProductOrder order : repo.findAll())
		{
			if(order.getUsername().equals(username))
			{
				Product product=productRepo.findById(order.getPid()).get();
				product.setName(product.getName()+"-- Ordered On: "+order.getDate());
				orders.add(product);
			}
		}
		
		return orders;
	}
	
	public List<ProductOrder> getProductOrdersByID(int productId)
	{
		List<ProductOrder> orders=new ArrayList<ProductOrder>();
		
		for(ProductOrder order : repo.findAll())
		{
			if(order.getPid()==productId)
			{
				orders.add(order);
			}
		}
		
		return orders;
	}
	
	public List<Product> findAllByProductID(int productId)
	{
		List<Product> orders=new ArrayList<Product>();
		
		for(ProductOrder order : repo.findAll())
		{
			if(order.getPid()==productId)
			{
				Product product=productRepo.findById(order.getPid()).get();
				product.setName(product.getName()+"-- Ordered On: "+order.getDate());
				orders.add(product);
			}
		}
		
		return orders;
	}
	
	public List<Product> findAllByVendorID(String vendorId)
	{
		List<Product> myproducts=productService.findAllByVendorId(vendorId);
		List<Product> orders=new ArrayList<Product>();
		
		for(Product product : myproducts)
		{
			for(Product order : findAllByProductID(product.getId()))
			{
				orders.add(order);
			}
		}
		
		return orders;
	}
	
	public ProductOrder findById(int id)
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
