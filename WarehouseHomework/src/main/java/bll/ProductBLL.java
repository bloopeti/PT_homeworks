package bll;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import javax.swing.table.DefaultTableModel;

import bll.validators.Validator;
import dao.ProductDAO;
import model.Product;

public class ProductBLL 
{

	private List<Validator<Product>> validators;

	public ProductBLL() 
	{
		validators = new ArrayList<Validator<Product>>();
	}

	public Product findProductById(int id) 
	{
		Product loc = ProductDAO.findById(id);
		if (loc == null) 
		{
			throw new NoSuchElementException("The product with id =" + id + " was not found!");
		}
		return loc;
	}

	public int insertProduct(Product product) 
	{
		for (Validator<Product> v : validators) 
		{
			v.validate(product);
		}
		return ProductDAO.insert(product);
	}
	
	public Product deleteProduct(int id)
	{
		Product loc = ProductDAO.delete(id);
		if (loc == null)
		{
			throw new NoSuchElementException("The product with id =" + id + " was not found!");
		}
		return loc;
	}
	
	public int editProduct(Product product)
	{
		for (Validator<Product> v : validators)
		{
			v.validate(product);
		}
		return ProductDAO.edit(product);
	}
	
	public DefaultTableModel findAllProduct() 
	{
		DefaultTableModel loc = ProductDAO.findAll();
		if (loc == null) 
		{
			System.out.println("The product table is empty!");
		}
		return loc;
	}
	
	public int decProduct(int id, int nr)
	{
		if(ProductDAO.findById(id).getNr() - nr < 0)
		{
			System.out.println("Not enough products for this order");
		}
		return ProductDAO.dec(id, nr);
	}
}
