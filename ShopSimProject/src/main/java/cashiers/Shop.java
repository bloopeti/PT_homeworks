package cashiers;

public class Shop extends Thread
{
	private int nrOfCashiers;
	private Cashier cashier[];
	private static long ID = 0;
	private int openTime;
	private int maxServeTime;
	private int minServeTime;
	private String textOut = ""; 
	
	public Shop(int nrOfCashiers, Cashier cashier[], int openTime, int maxServeTime, int minServeTime, String name)
	{
		setName(name);
		this.nrOfCashiers = nrOfCashiers;
		this.cashier = new Cashier[nrOfCashiers];
		for (int i = 0; i < nrOfCashiers; i++)
		{
			this.cashier[i] = cashier[i];
		}
		this.openTime = openTime;
		this.maxServeTime = maxServeTime;
		this.minServeTime = minServeTime;
	}

	private int shortestQ()
	{
		int k = 0;
		
		int min = cashier[0].QTotalTime();
		for (int i = 1; i < nrOfCashiers; i++)
		{
			int temp = cashier[i].QTotalTime();
			if (temp < min)
			{
				min = temp;
				k = i;
			}
		}
		return k;
	}
	
	public String getTextOut()
	{
		return textOut;
	}
	
	public long totalCustomers()
	{
		long total = 0;
		for (int i = 0; i < nrOfCashiers; i++)
		{
			total += cashier[i].QLength();
		}
		return total;
	}
	
	public void run()
	{
		try
		{
			int peakTime = 0;
			long maxCustomers = 0;
			int currentTime = 0;
			int totalServeTime = 0;
			int totalCustomers = 0;
			do
			{
				String logLine = "";
				int serveTime = (int )(Math.random() * (maxServeTime - minServeTime + 1) + minServeTime);
				totalServeTime += serveTime;
				++totalCustomers;
				Customer c = new Customer( ++ID, currentTime, serveTime);
				int m = shortestQ();
				logLine = "at "+c.getArrivalTime()+" Customer "+Long.toString(ID)+" stepped into q of Cashier "+Integer.toString(m);
				textOut = logLine;
				SwingGUI.jtaLogArea.append(logLine+"\n");
				System.out.println(logLine);
				
				cashier[m].addCustomer(c);
			//	int totalCust = tota
				if(totalCustomers() > maxCustomers)
				{
					maxCustomers = totalCustomers();
					peakTime = currentTime;
				}
				int arrivalTime = (int )(Math.random() * (openTime - currentTime + 1) + currentTime);
				arrivalTime = arrivalTime/30;
				sleep(arrivalTime);
				currentTime += arrivalTime;
			}while (currentTime < openTime);
			String logLine = "";
			logLine = "Peak time at: "+peakTime+" with "+maxCustomers+" customers";
			SwingGUI.jtaLogArea.append(logLine+"\n");
			System.out.println(logLine);
			logLine = "Average serve time of: "+(totalServeTime / totalCustomers);
			SwingGUI.jtaLogArea.append(logLine+"\n");
			System.out.println(logLine);
			for(int i = 0; i < nrOfCashiers; i++)
			{
				cashier[i].setClosed();
			}
		}
		catch(InterruptedException e)
		{
			System.out.println(e.toString());
		}
	}
}
