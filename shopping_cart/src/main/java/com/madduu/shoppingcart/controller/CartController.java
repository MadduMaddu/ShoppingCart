package com.madduu.shoppingcart.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.madduu.shoppingcart.dao.CartDao;
import com.madduu.shoppingcart.dao.CustomerDao;
import com.madduu.shoppingcart.dto.Cart;
import com.madduu.shoppingcart.dto.Customer;
import com.madduu.shoppingcart.dto.Item;

@Controller
public class CartController 
{
	@Autowired
	CartDao cdao;
	@Autowired
	CustomerDao custdao;
	@RequestMapping("/fetchitemsfromcart")
	public ModelAndView fetchItmesFromCart(HttpSession session)
	{
		Customer c=(Customer) session.getAttribute("customerinfo");
		
		Customer customer=  custdao.findCustomerById(c.getId());
		Cart cart=customer.getCart();
		List<Item> items=cart.getItems();
		
		ModelAndView mav=new ModelAndView();
		mav.addObject("itemslist",items);
		mav.addObject("totalprice",cart.getTotalprice());
		mav.setViewName("displaycartitemstocustomer");
		return mav;
		
	}
}
