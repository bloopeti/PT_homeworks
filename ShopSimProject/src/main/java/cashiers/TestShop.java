package cashiers;

public class TestShop
{
	public static void main(String args[])
	{
		int nrOfCashiers = 3;
		Cashier c[] = new Cashier[nrOfCashiers];
		for (int i = 0; i < nrOfCashiers; i++)
		{
			c[i] = new Cashier("Cashier "+Integer.toString(i));
			c[i].start();
		}
		Shop s = new Shop(nrOfCashiers, c, 5000, 1000, 750, "Burger King");
		s.start();
	}
}
