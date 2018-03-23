package bll;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import javax.swing.table.DefaultTableModel;

import bll.validators.Validator;
import dao.ClientDAO;
import model.Client;

public class ClientBLL 
{

	private List<Validator<Client>> validators;

	public ClientBLL() 
	{
		validators = new ArrayList<Validator<Client>>();
	}

	public Client findClientById(int id) 
	{
		Client loc = ClientDAO.findById(id);
		if (loc == null) 
		{
			throw new NoSuchElementException("The client with id =" + id + " was not found!");
		}
		return loc;
	}

	public int insertClient(Client client) 
	{
		for (Validator<Client> v : validators) 
		{
			v.validate(client);
		}
		return ClientDAO.insert(client);
	}
	
	public Client deleteClient(int id)
	{
		Client loc = ClientDAO.delete(id);
		if (loc == null)
		{
			throw new NoSuchElementException("The client with id =" + id + " was not found!");
		}
		return loc;
	}
	
	public int editClient(Client client)
	{
		for (Validator<Client> v : validators)
		{
			v.validate(client);
		}
		return ClientDAO.edit(client);
	}
	
	public DefaultTableModel findAllClient() 
	{
		DefaultTableModel loc = ClientDAO.findAll();
		if (loc == null) 
		{
			System.out.println("The client table is empty!");
		}
		return loc;
	}
}