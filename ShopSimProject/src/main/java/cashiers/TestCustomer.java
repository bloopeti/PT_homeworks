package cashiers;

import java.util.*;

public class TestCustomer
{

	public static void main(String[] args)
	{
		Scanner kb = new Scanner(System.in);
		int minServeTime = kb.nextInt();
		int maxServeTime = kb.nextInt();
		int serveTime = (int )(Math.random() * (maxServeTime - minServeTime + 1) + minServeTime);
		int arrivalTime = (int )(Math.random() * (maxServeTime - serveTime + 1) + serveTime);
		Customer one = new Customer(1, arrivalTime, serveTime);
		System.out.println(serveTime);
		System.out.println(one.getServeTime());

		kb.close();
	}

}
