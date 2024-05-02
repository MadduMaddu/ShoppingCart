package com.madduu.shoppingcart.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.madduu.shoppingcart.dao.CartDao;
import com.madduu.shoppingcart.dao.CustomerDao;
import com.madduu.shoppingcart.dao.OrdersDao;
import com.madduu.shoppingcart.dao.ProductDao;
import com.madduu.shoppingcart.dto.Cart;
import com.madduu.shoppingcart.dto.Customer;
import com.madduu.shoppingcart.dto.Item;
import com.madduu.shoppingcart.dto.Orders;
import com.madduu.shoppingcart.dto.Product;

@Controller
public class OrdersController 
{
	@Autowired
	OrdersDao odao;
	@Autowired
	CustomerDao custdao;
	@Autowired
	ProductDao pdao;
	@Autowired
	CartDao cdao;
	@RequestMapping("/addorder")
	public ModelAndView addOrder()
	{
		Orders o=new Orders();
		ModelAndView mav=new ModelAndView();
		mav.addObject("ordersobj",o);
		mav.setViewName("ordersform");
		return mav;
		
	}
	@RequestMapping("/saveorder")
	public ModelAndView saveOrder(@ModelAttribute("ordersobj")Orders o,HttpSession session)
	{
		Customer customer=(Customer)session.getAttribute("customerinfo");
		Customer c=custdao.findCustomerById(customer.getId());
		Cart cart=c.getCart();
		
		List<Item> items=cart.getItems();
		
		
		List<Item> cartitems=new ArrayList<Item>();
		List<Item> orderitems=new ArrayList<Item>();
		
		for(Item i:items)
		{
			Product p=pdao.findProductById(i.getP_id());
			if(i.getQuantity()<p.getStock())
			{
				orderitems.add(i);
				p.setStock(p.getStock()-i.getQuantity());
				pdao.updtaeProduct(p);
			}
			else
			{
				cartitems.add(i);
			}
		}
		double cartTotalPrice=0;
		double orderTotalPrice=0;
		
		
		for(Item i:cartitems)
		{
			cartTotalPrice+=i.getPrice();
		}
		for(Item i:orderitems)
		{
			orderTotalPrice+=i.getPrice();
		}
		cart.setItems(cartitems);
		cart.setTotalprice(cartTotalPrice);
		o.setItems(orderitems);
		o.setTotalprice(orderTotalPrice);
		List<Orders> order=  c.getOrders();
		if(order.size()>0)
		{
			order.add(o);
			c.setOrders(order);
		}
		else
		{
			List<Orders> orders1=new ArrayList<Orders>();
			orders1.add(o);
			c.setOrders(orders1);
		}
		cdao.updateCart(cart);
		odao.saveOrders(o);
		custdao.updateCustomer(c);
		
		ModelAndView mav=new ModelAndView();
		mav.addObject("msg","Order Placed Successfully");
		mav.addObject("orderdetails",o);
		
		mav.setViewName("customerbill");
		return mav;
	}
	
}
