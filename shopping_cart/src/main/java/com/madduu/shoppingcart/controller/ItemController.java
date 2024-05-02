package com.madduu.shoppingcart.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.madduu.shoppingcart.dao.CartDao;
import com.madduu.shoppingcart.dao.CustomerDao;
import com.madduu.shoppingcart.dao.ItemDao;
import com.madduu.shoppingcart.dao.ProductDao;
import com.madduu.shoppingcart.dto.Cart;
import com.madduu.shoppingcart.dto.Customer;
import com.madduu.shoppingcart.dto.Item;
import com.madduu.shoppingcart.dto.Product;

@Controller
public class ItemController 
{
	@Autowired
	ItemDao idao;
	@Autowired
	ProductDao pdao;
	@Autowired
	CartDao cdao;
	@Autowired
	CustomerDao custdao;
	@RequestMapping("/additem")
	public ModelAndView addItem(@RequestParam("id")int id)
	{
			ModelAndView mav=new ModelAndView();
			Product p=pdao.findProductById(id);
			mav.addObject("productobj",p);
			mav.setViewName("itemform");
			return mav;
	}
	@RequestMapping("/additemtocart")
	public  ModelAndView addItemToCart(ServletRequest req,HttpSession session)
	{
		int pid=Integer.parseInt( req.getParameter("id"));
		String brand=req.getParameter("brand");
		double price=Double.parseDouble(req.getParameter("price"));
		String model=req.getParameter("model");
		String category=req.getParameter("category");
		int quantity=Integer.parseInt(req.getParameter("quantity"));
		
		Item item=new Item();
		item.setBrand(brand);
		item.setCategory(category);
		item.setModel(model);
		item.setQuantity(quantity);
		item.setP_id(pid);
		item.setPrice(quantity*price);
		
		Customer customer=(Customer) session.getAttribute("customerinfo");
		Cart c=customer.getCart();
		if(c==null)
		{
			
			Cart cart=new Cart();
			List<Item> items=new ArrayList<Item>();
			items.add(item);
			cart.setItems(items);
			cart.setName(customer.getName());
			
			
			cart.setTotalprice(item.getPrice());
			customer.setCart(cart);
			idao.saveItem(item);
			cdao.saveCart(cart);
			custdao.updateCustomer(customer);
		}
		else
		{
			List<Item> items=c.getItems();
			if(items.size()>0)
			{
				items.add(item);
				c.setItems(items);
				double totalprice=0;
				for(Item i:items)
				{
					totalprice+=i.getPrice();
				}
				c.setTotalprice(totalprice);
				customer.setCart(c);
				idao.saveItem(item);
				cdao.updateCart(c);
				custdao.updateCustomer(customer);
			}
			else
			{
				List<Item> itemslist=new ArrayList<Item>();
				itemslist.add(item);
				c.setItems(itemslist);
				c.setTotalprice(item.getPrice());
				idao.saveItem(item);
				cdao.updateCart(c);
				custdao.updateCustomer(customer);
			}
		}
		ModelAndView mav=new ModelAndView();
		mav.setViewName("redirect://displayproducts");
		return mav;
	}
}
