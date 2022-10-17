package com.example.demo.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.exception.ProductNotfoundException;
import com.example.demo.model.ProductOrder;
import com.example.demo.model.Product;
import com.example.demo.service.OrderService;
import com.example.demo.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	private ProductService service;
	
	@Autowired
	private OrderService orderService;
	
	@RequestMapping("/home")
	public String home(Model model)
	{
		List<Product> products=service.findAll();
		model.addAttribute("products",products);
		return "home";
	}
	
	@RequestMapping("/searchproduct")
	public String searchProduct(Model model,@RequestParam String productname)
	{
		List<Product> products=service.findAllByProductName(productname);
		model.addAttribute("products",products);
		return "home";
	}
	
	@RequestMapping("/searchmyproduct")
	public String searchMyProduct(Model model,@RequestParam String productname,HttpServletRequest request)
	{
		List<Product> products=service.findAllByVendorSearch((String)request.getSession().getAttribute("username"),productname);
		model.addAttribute("products",products);
		return "viewproducts";
	}
	
	@RequestMapping("/viewproducts")
	public String viewproducts(Model model,HttpServletRequest request)
	{
		List<Product> products=service.findAllByVendorId((String)request.getSession().getAttribute("username"));
		model.addAttribute("products",products);
		return "viewproducts";
	}
	
	@RequestMapping("/addcart")
	public String addCart(@RequestParam int id,Model model,HttpServletRequest request)
	{
		List<Integer> products=(List<Integer>)request.getSession().getAttribute("cart");
		
		if(products!=null)
		{
			System.out.println("in if");
			
			products.add(id);
			request.getSession().setAttribute("cart",products);
		}
		else
		{
			System.out.println("in else");
			
			List<Integer> list=new ArrayList<Integer>();
			list.add(id);
			request.getSession().setAttribute("cart",list);
		}
		
		model.addAttribute("message","product added to cart");
		return "redirect:/viewcart";
	}
	
	@RequestMapping("/viewcart")
	public String viewCart(Model model,HttpServletRequest request)
	{
		List<Integer> sessionProducts=(List<Integer>)request.getSession().getAttribute("cart");
		
		if(sessionProducts!=null)
		{
			List<Product> list=new ArrayList<Product>();
			
			for(Integer i : sessionProducts)
			{
				list.add(service.findById(i));
			}
			
			model.addAttribute("products",list);
		}
		
		return "viewcart";
	}
	
	@RequestMapping("/deletecart")
	public String deleteCart(@RequestParam int id,Model model,HttpServletRequest request)
	{
		List<Integer> sessionProducts=(List<Integer>)request.getSession().getAttribute("cart");
		
		if(sessionProducts!=null)
		{
			sessionProducts.remove(new Integer(id));
			request.getSession().setAttribute("cart",sessionProducts);
		}
		
		return "redirect:/viewcart";
	}
	
	@RequestMapping("/viewproduct")
	public String viewProduct(@RequestParam int id,Model model)
	{
		model.addAttribute("product",service.findById(id));
		model.addAttribute("order",new ProductOrder());
		return "viewproduct";
	}

	@RequestMapping("/addproduct")
	public String addProduct(Model model)
	{
		model.addAttribute("product",new Product());
		return "addproduct";
	}

	@RequestMapping(value = "/saveproduct",method = RequestMethod.POST)
	public String saveProduct(HttpServletRequest request, Model model,@ModelAttribute("product") Product product)
	{
		// Root Directory.
		String uploadRootPath = "C:\\Users\\S545156\\Downloads\\FarmMatrix\\FarmMatrix\\src\\main\\resources\\static\\productimages";
		System.out.println("uploadRootPath=" + uploadRootPath);

		File uploadRootDir = new File(uploadRootPath);
		// Create directory if it not exists.
		if (!uploadRootDir.exists()) {
			uploadRootDir.mkdirs();
		}
		
		System.out.println("Real Path:"+request.getServletContext().getRealPath(""));

		MultipartFile image =product.getImage();
		
		String name = image.getOriginalFilename();
		System.out.println("Client File Name = " + name);

		if (name != null && name.length() > 0) {
			try {
				// Create the file at server
				File serverFile = new File(uploadRootDir.getAbsolutePath() + File.separator + name);

				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
				stream.write(image.getBytes());
				stream.close();
				
			} catch (Exception e) {
				System.out.println("Error Write file: " + name);
			}
		}
		
		product.setVendorid((String)request.getSession().getAttribute("username"));
		product.setCategory((String)request.getSession().getAttribute("role"));
		product.setImageName(name);
		
		service.save(product);
		return "redirect:/home";
	}

	@RequestMapping("/editproduct")
	public String editProduct(@RequestParam int id,Model model)
	{
		if(!service.isExist(id))throw new ProductNotfoundException();

		model.addAttribute("product",service.findById(id));
		return "editproduct";
	}
	
	@RequestMapping(value = "/updateproduct")
	public String updateProduct(@RequestParam int id,@RequestParam float price,@RequestParam String quantity)
	{
		Product product=service.findById(id);
		product.setPrice(price);
		product.setQuantity(quantity);
		
		service.save(product);
		return "redirect:/viewproducts";
	}

	@RequestMapping("/deleteproduct")
	public String deleteProduct(@RequestParam int id)
	{
		for(ProductOrder order : orderService.getProductOrdersByID(id))
		{
			orderService.delete(order.getId());
		}
		
		if(!service.isExist(id))throw new ProductNotfoundException();
		service.delete(id);
		return "redirect:/home";
	}
}

