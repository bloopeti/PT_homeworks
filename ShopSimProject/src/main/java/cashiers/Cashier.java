package cashiers;

import java.util.*;

public class Cashier extends Thread
{
	private Vector<Customer> customers = new Vector<Customer>();
	private boolean openShop = true;
	private String textOut = "";
	private String visualization = "";
	
	public Cashier(String name)
	{
		setName(name);
	}
	
	public synchronized void addCustomer(Customer c)
	{
		customers.addElement(c);
		notifyAll();
	}
	
	public synchronized Customer deleteCustomer() throws InterruptedException
	{
		while(customers.size() == 0)
			wait();
		Customer c = (Customer )customers.elementAt(0);
//		System.out.println(Long.toString(c.getCID())+" was served by cashier"+getName());
		customers.removeElementAt(0);
		notifyAll();
		return c;
	}
	
	public synchronized long QLength()
	{
		notifyAll();
		long size = customers.size();
		return size;
	}
	
	public synchronized int QTotalTime()
	{
		notifyAll();
		int totalServeTime = 0;
		long size = customers.size();
		for (int i = 0; i < size; i++)
		{
			Customer c = (Customer )customers.elementAt(i);
			totalServeTime += c.getServeTime();
		}
		return totalServeTime;
	}
	
	public synchronized void setClosed()
	{
		notifyAll();
		this.openShop = false;
	}
	
	public String getTextOut()
	{
		return textOut;
	}
	
	private synchronized void changeVisualization()
	{
		notifyAll();
		String locStr = "";
		locStr = getName()+": ";
//		int visuLen = locStr.length();
		for(int i = 0; i < customers.size(); i++)
		{
			locStr = locStr + "O";
		}
		this.visualization = locStr;
	}
	
	public String getVisualization()
	{
		return visualization;
	}
	
	
	public void run()
	{
//		File file = new File("../log.txt");
//		FileWriter fr = null;
//		BufferedWriter br = null;
		try
		{
			int leaveTime = 0;
			int i = 0;
			String qName = getName();
//			System.out.println(visualization);
		
			while((openShop) || (customers.size() != 0))
			{
//				fr = new FileWriter(file);
//				br = new BufferedWriter(fr);
				changeVisualization();
				
				if (qName.equals("Cashier 0"))
				{
					SwingGUI.jtfQ0.setText(visualization);
				}
				else if(qName.equals("Cashier 1"))
				{
					SwingGUI.jtfQ1.setText(visualization);
				}
				else if(qName.equals("Cashier 2"))
				{
					SwingGUI.jtfQ2.setText(visualization);
				}
				else if(qName.equals("Cashier 3"))
				{
					SwingGUI.jtfQ3.setText(visualization);
				}
//				System.out.println(visualization);
				
				String logLine = "";
				Customer c = deleteCustomer();
				i++;
				sleep(c.getServeTime());
				if (i == 1)
					leaveTime = leaveTime + c.getArrivalTime() + c.getServeTime();
				else
					leaveTime = leaveTime + c.getServeTime();
				logLine = "at "+leaveTime+" Customer "+Long.toString(c.getCID())+" was served by "+getName();
				textOut = logLine;
				SwingGUI.jtaLogArea.append(logLine+"\n");
				System.out.println(textOut);
				
//				fr.append(logLine);
//				br.write(logLine);
			}
			changeVisualization();
			if (qName.equals("Cashier 0"))
			{
				SwingGUI.jtfQ0.setText(visualization);
			}
			else if(qName.equals("Cashier 1"))
			{
				SwingGUI.jtfQ1.setText(visualization);
			}
			else if(qName.equals("Cashier 2"))
			{
				SwingGUI.jtfQ2.setText(visualization);
			}
			else if(qName.equals("Cashier 3"))
			{
				SwingGUI.jtfQ3.setText(visualization);
			}
			String logLine = "";
			logLine = "Last customer left at: " + leaveTime;
			SwingGUI.jtaLogArea.append(logLine+"\n");
			System.out.println(logLine);
//			System.out.println(visualization);
//				SwingGUI.jtaQDisp.append(visualization+"\n");
			
		}
		catch(InterruptedException e)
		{
			System.out.println("Interrupt");
			System.out.println(e.toString());
		}
/*		catch(IOException e)
		{
			System.out.println("IO");
			System.out.print(e.toString());
		}
		finally
		{
			try
			{
//				fr.close();
//				br.close();
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
		}
*/	}
	
}
