package cashiers;

//import java.util.*;

public class TestCashier
{

	public static void main(String[] args)
	{
		Cashier one = new Cashier("Jack");
		one.start();
		int minServeTime = 1000;
		int maxServeTime = 5000;
		for(int i = 0; i < 5; i++)
		{
			int serveTime = (int )(Math.random() * (maxServeTime - minServeTime + 1) + minServeTime);
			
//			Date now = new Date();
			int now = 100;
			System.out.println(now+" customer arrived with serve time "+serveTime);
			Customer c = new Customer(i, now, serveTime);
			one.addCustomer(c);
			
		}

	}

}
