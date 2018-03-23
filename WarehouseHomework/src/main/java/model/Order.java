package model;
/**
 * This class models the 'order' table in the MySQL database warehouse
 * @author Peter
 *
 */
public class Order 
{
	private int id;
	private String client;
	private String product;
	private int nr;
	
	/**
	 * constructor
	 * @param id the int type id field of a row in the order table
	 * @param client the String type client field of a row in the order table
	 * @param product the String type product field of a row in the order table
	 * @param nr the int type nr field of a row in the order table
	 */
	public Order(int id, String client, String product, int nr)
	{
		super();
		this.id = id;
		this.client = client;
		this.product = product;
		this.nr = nr;
	}
	
	/**
	 * constructor
	 * @param client the String type client field of a row in the order table
	 * @param product the String type product field of a row in the order table
	 * @param nr the int type nr field of a row in the order table
	 */
	public Order(String client, String product, int nr)
	{
		super();
		this.client = client;
		this.product = product;
		this.nr = nr;
	}

	/**
	 * method for getting the id field of the object
	 * @return the int type id field of the object
	 */
	public int getId()
	{
		return id;
	}

	/**
	 * method for setting the id field of the object
	 * @param id int type value to be inserted into the id field
	 */
	public void setId(int id) 
	{
		this.id = id;
	}

	/**
	 * method for getting the client field of the object
	 * @return the String type client field of the object
	 */
	public String getClient() 
	{
		return client;
	}

	/**
	 * method for setting the client field of the object
	 * @param client String type value to be inserted into the client field
	 */
	public void setClient(String client) 
	{
		this.client = client;
	}	

	/**
	 * method for getting the product field of the object
	 * @return the String type product field of the object
	 */
	public String getProduct() 
	{
		return product;
	}

	/**
	 * method for setting the product field of the object
	 * @param product String type value to be inserted into the product field
	 */
	public void setProduct(String product) 
	{
		this.product = product;
	}

	/**
	 * method for getting the nr field of the object
	 * @return the int type nr field of the object
	 */
	public int getNr() 
	{
		return nr;
	}

	/**
	 * method for setting the nr field of the object
	 * @param nr int type value to be inserted into the nr field
	 */
	public void setNr(int nr) 
	{
		this.nr = nr;
	}	
}
