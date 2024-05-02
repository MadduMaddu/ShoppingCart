package com.madduu.shoppingcart.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.madduu.shoppingcart.dto.Orders;
@Repository
public class OrdersDao 
{
	@Autowired
	EntityManagerFactory emf;
	public void saveOrders(Orders i)
	{
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		et.begin();
		em.persist(i);
		et.commit();
	}
	public void updateOrders(Orders i)
	{
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		et.begin();
		em.merge(i);
		et.commit();
	}
	public void deleteOrdersById(int id)
	{
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		Orders i=em.find(Orders.class,id);
		et.begin();
		em.remove(i);
		et.commit();
	}
	public Orders findOrdersById(int id)
	{
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		Orders i=em.find(Orders.class,id);
		if(i!=null)
			return i;
		else
			return null;
		
	}
	
}
