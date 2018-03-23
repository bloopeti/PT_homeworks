package model;

public class Product 
{
	private int id;
	private String name;
	private int nr;
	
	public Product(int id, String name, int nr)
	{
		super();
		this.id = id;
		this.name = name;
		this.nr = nr;
	}
	
	public Product(String name, int nr)
	{
		super();
		this.name = name;
		this.nr = nr;
	}

	public int getId() 
	{
		return id;
	}

	public void setId(int id) 
	{
		this.id = id;
	}

	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}
	
	public int getNr() 
	{
		return nr;
	}

	public void setNr(int nr) 
	{
		this.nr = nr;
	}	
}
