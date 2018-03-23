package bll;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
//import java.util.logging.Logger;

import javax.swing.table.DefaultTableModel;

import bll.validators.Validator;
import dao.ClientDAO;
import dao.OrderDAO;
import dao.ProductDAO;
import model.Order;

public class OrderBLL 
{
//	protected static final Logger LOGGER = Logger.getLogger(OrderDAO.class.getName());
	private List<Validator<Order>> validators;

	public OrderBLL() 
	{
		validators = new ArrayList<Validator<Order>>();
	}

	public Order findOrderById(int id) 
	{
		Order loc = OrderDAO.findById(id);
		if (loc == null) 
		{
			throw new NoSuchElementException("The order with id =" + id + " was not found!");
		}
		return loc;
	}

	public int insertOrder(int clientId, int productId, int nr/* Order order*/) 
	{
		ProductBLL productBll = new ProductBLL();
		String client = ClientDAO.findById(clientId).getName();
		String product = ProductDAO.findById(productId).getName();
		int orderNr = productBll.decProduct(productId, nr);
		Order order = new Order(client, product, orderNr);
//		Order order = new Order("John Doe", "dummy", 5);
		for (Validator<Order> v : validators) 
		{
			v.validate(order);
		}
		return OrderDAO.insert(order);
	}
	
	public Order deleteOrder(int id)
	{
		Order loc = OrderDAO.delete(id);
		if (loc == null)
		{
			throw new NoSuchElementException("The order with id =" + id + " was not found!");
		}
		return loc;
	}
	
	public int editOrder(Order order)
	{
		for (Validator<Order> v : validators)
		{
			v.validate(order);
		}
		return OrderDAO.edit(order);
	}
	
	public DefaultTableModel findAllOrder() 
	{
		DefaultTableModel loc = OrderDAO.findAll();
		if (loc == null) 
		{
			System.out.println("The order table is empty!");
		}
		return loc;
	}
}
