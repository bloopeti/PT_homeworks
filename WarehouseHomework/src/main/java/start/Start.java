package start;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import bll.ClientBLL;
import bll.ProductBLL;
import bll.OrderBLL;
import model.Client;
import model.Product;
import model.Order;
import swingGUI.*;

public class Start 
{
	protected static final Logger LOGGER = Logger.getLogger(Start.class.getName());

	public static void main(String[] args) throws SQLException 
	{
		ClientGUI demoC = new ClientGUI();
		demoC.createGUI();
		ProductGUI demoP = new ProductGUI();
		demoP.createGUI();
		OrderGUI demoO = new OrderGUI();
		demoO.createGUI();
		/*
		ClientBLL clientBll = new ClientBLL();
		ProductBLL productBll = new ProductBLL();
		OrderBLL orderBll = new OrderBLL();
		
		Client client = new Client("dummy name");
//		int id1 = clientBll.insertClient(client);
//		if (id1 > 0) 
//		{
//			clientBll.findClientById(id1);
//		}
		
		Client client2 = new Client(1, "John Doe");
		clientBll.editClient(client2);

//		clientBll.deleteClient(3);
//		clientBll.findAllClient();
		
		Product product = new Product("dummy product", 50);
//		int id2 = productBll.insertProduct(product);
//		if (id2 > 0) 
//		{
//			productBll.findProductById(id2);
//		}
		
//		Product product2 = new Product(1, "screwdriver", 10);
//		productBll.editProduct(product2);
		
//		productBll.deleteProduct(3);
		Order order2 = new Order(5, "John May", "screwdriver", 10);
		orderBll.editOrder(order2);
		
		productBll.findAllProduct();

//		Order order = new Order("John Doe", "dummy", 10);
//		int id3 = orderBll.insertOrder(1, 1, 100);
//		if (id3 > 0) 
//		{
//			orderBll.findOrderById(id3);
//		}
		orderBll.findAllOrder();
		
//		Order order2 = new Order(1, "screwdriver", 10);
//		orderBll.editOrder(order2);
		
//		orderBll.deleteOrder(3);
//		orderBll.findAllOrder();
		
		// Generate error
		try 
		{
			clientBll.findClientById(1);
		} catch (Exception ex) 
		{
			LOGGER.log(Level.INFO, ex.getMessage());
		}

		//obtain field-value pairs for object through reflection
//		ReflectionExample.retrieveProperties(clientBll.findClientById(id1));*/
	}
}
