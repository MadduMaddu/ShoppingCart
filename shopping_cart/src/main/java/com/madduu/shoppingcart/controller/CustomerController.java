package com.madduu.shoppingcart.controller;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.madduu.shoppingcart.dao.CustomerDao;
import com.madduu.shoppingcart.dto.Customer;

@Controller
public class CustomerController 
{
	@Autowired
	CustomerDao cdao;
	@RequestMapping("/addcustomer")
	public ModelAndView addCustomer()
	{
		Customer c=new Customer();
		ModelAndView mav=new ModelAndView();
		mav.addObject("customerobj",c);
		mav.setViewName("customerform");
		return mav;
	}
	@RequestMapping("/savecustomer")
	public ModelAndView saveCustomer(@ModelAttribute("customerobj")Customer customer)
	{
		cdao.saveCustomer(customer);
		ModelAndView mav=new ModelAndView();
		mav.addObject("msg","Registed Successfully");
		mav.setViewName("customer_menu");
		return mav;
		
	}
	@RequestMapping("/customerloginvalidation")
	public ModelAndView loginvalidation(ServletRequest req,HttpSession session)
	{
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		Customer c=cdao.login(email, password);
		
		if(c!=null)
		{
			ModelAndView mav=new ModelAndView();
			mav.addObject("msg","Login Successfull");
			mav.setViewName("customeroptions");
			session.setAttribute("customerinfo",c);
			return mav;
		}
		else
		{
			ModelAndView mav=new ModelAndView();
			mav.addObject("msg","invalid credentials");
			mav.setViewName("customerloginform");
			return mav;
			
		}
	}
}
