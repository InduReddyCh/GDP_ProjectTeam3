package com.example.demo.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.model.Product;
import com.example.demo.model.ProductOrder;
import com.example.demo.service.OrderService;
import com.example.demo.service.ProductService;

@Controller
public class OrderController {

	@Autowired
	private OrderService service;
	
	@Autowired
	private ProductService productService;

	@RequestMapping("/viewcustomerorders")
	public String viewCustomerOrders(HttpServletRequest request,Model model)
	{
		model.addAttribute("orders",service.findAllByUserID((String)request.getSession().getAttribute("username")));
		return "vieworders";
	}
	
	@RequestMapping("/viewvendororders")
	public String viewVendorOrders(HttpServletRequest request,Model model)
	{
		model.addAttribute("orders",service.findAllByVendorID((String)request.getSession().getAttribute("username")));
		return "vieworders";
	}

	@RequestMapping(value = "/addorder",method = RequestMethod.POST)
	public String addOrder(HttpServletRequest request, Model model,@ModelAttribute("order") ProductOrder order)
	{
		request.getSession().setAttribute("pid",order.getPid());
		model.addAttribute("amount",productService.findById(order.getPid()).getPrice());
		
		return "payment";
	}
	
	@RequestMapping(value = "/ordersubmit",method = RequestMethod.POST)
	public String orderSubmit(HttpServletRequest request)
	{
		int pid=(Integer)request.getSession().getAttribute("pid");
		
		ProductOrder order=new ProductOrder();
		
		order.setPid(pid);
		order.setDate(new Date());
		order.setUsername((String)request.getSession().getAttribute("username"));
		
		service.save(order);

		return "redirect:/home";
	}
	
	@RequestMapping(value = "/ordercart")
	public String orderCart(HttpServletRequest request, Model model)
	{
		List<Integer> sessionProducts=(List<Integer>)request.getSession().getAttribute("cart");
		
		if(sessionProducts!=null)
		{
			float amount=0;
			
			for(Integer i : sessionProducts)
			{
				amount=amount+productService.findById(i).getPrice();
			}
			
			model.addAttribute("amount",amount);
			return "cartpayment";
		}
		else
		{
			return "redirect:/viewcart";
		}
	}
	
	@RequestMapping(value = "/submitcart",method = RequestMethod.POST)
	public String submitCart(HttpServletRequest request)
	{
		List<Integer> sessionProducts=(List<Integer>)request.getSession().getAttribute("cart");
		
		if(sessionProducts!=null)
		{
			for(Integer i : sessionProducts)
			{
				Product p=productService.findById(i);
				
				ProductOrder order=new ProductOrder();
				
				order.setPid(p.getId());
				order.setDate(new Date());
				order.setUsername((String)request.getSession().getAttribute("username"));
				
				service.save(order);
			}
			request.getSession().removeAttribute("cart");
		}
		
		return "redirect:/viewcart";
	}
}

