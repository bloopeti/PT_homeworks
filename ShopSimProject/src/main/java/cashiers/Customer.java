package cashiers;

//import java.util.*;

public class Customer
{

	private long cID;
	private int arrivalTime;
	private int serveTime;

	public Customer(long cID, int arrivalTime, int serveTime)
	{
		this.cID = cID;
		this.arrivalTime = arrivalTime;
		this.serveTime = serveTime;
	}
	
	public long getCID()
	{
		return this.cID;
	}
	
	public int getArrivalTime()
	{
		return this.arrivalTime;
	}
	
	public int getServeTime()
	{
		return this.serveTime;
	}
}
