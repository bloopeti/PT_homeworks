package cashiers;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SwingGUI implements ActionListener
{
	private JFrame appFrame;
	private JLabel jlbNrOfQ, jlbMaxArrivalTime, jlbMinServeTime, jlbMaxServeTime;
	private JTextField jtfNrOfQ, jtfMaxArrivalTime, jtfMinServeTime, jtfMaxServeTime;
	static JTextField jtfQ0, jtfQ1, jtfQ2, jtfQ3;
	static JTextArea jtaLogArea;
	private JScrollPane jspLogArea;
	private JButton jbnStart;
	private Container cPane;
	
	public static void main(String[] args)
	{
		SwingGUI demo = new SwingGUI();
		demo.createGUI();
	}
	
	public SwingGUI()
	{
	}
	
	public void createGUI()
	{
		appFrame = new JFrame("Shop Simulator");
		cPane = appFrame.getContentPane();
		cPane.setLayout(new GridBagLayout());
		
		arrangeComponents();
		appFrame.pack();
		appFrame.setVisible(true);
	}
	
	public void arrangeComponents()
	{
		jlbNrOfQ = new JLabel("Insert the nr of queues");
		jlbMaxArrivalTime = new JLabel("Insert the max arrival time");
		jlbMinServeTime = new JLabel("Insert the min serve time");
		jlbMaxServeTime = new JLabel("Insert the max serve time");		
		
		jtfNrOfQ = new JTextField(10);
		jtfMaxArrivalTime = new JTextField(10);
		jtfMinServeTime = new JTextField(10);
		jtfMaxServeTime = new JTextField(10);
		jtfQ0 = new JTextField(20);
		jtfQ0.setEditable(false);
		jtfQ1 = new JTextField(20);
		jtfQ1.setEditable(false);
		jtfQ2 = new JTextField(20);
		jtfQ2.setEditable(false);
		jtfQ3 = new JTextField(20);
		jtfQ3.setEditable(false);
		
		jtaLogArea = new JTextArea(5,40);
		jtaLogArea.setEditable(false);
		jspLogArea = new JScrollPane(jtaLogArea);
		jspLogArea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
				
		jbnStart = new JButton("Start");
		
		GridBagConstraints gridBagConstraintsx01 = new GridBagConstraints();
		gridBagConstraintsx01.gridx = 0;
		gridBagConstraintsx01.gridy = 0;
		gridBagConstraintsx01.insets = new Insets(5, 5, 5, 5);
		cPane.add(jlbNrOfQ, gridBagConstraintsx01);
		
		GridBagConstraints gridBagConstraintsx02 = new GridBagConstraints();
		gridBagConstraintsx02.gridx = 1;
		gridBagConstraintsx02.insets = new Insets(5, 5, 5, 5);
		gridBagConstraintsx02.gridy = 0;
		gridBagConstraintsx02.gridwidth = 2;
		gridBagConstraintsx02.fill = GridBagConstraints.BOTH;
		cPane.add(jtfNrOfQ, gridBagConstraintsx02);
		
		GridBagConstraints gridBagConstraintsx03 = new GridBagConstraints();
		gridBagConstraintsx03.gridx = 0;
		gridBagConstraintsx03.gridy = 1;
		gridBagConstraintsx03.insets = new Insets(5, 5, 5, 5);
		cPane.add(jlbMaxArrivalTime, gridBagConstraintsx03);
		
		GridBagConstraints gridBagConstraintsx04 = new GridBagConstraints();
		gridBagConstraintsx04.gridx = 1;
		gridBagConstraintsx04.insets = new Insets(5, 5, 5, 5);
		gridBagConstraintsx04.gridy = 1;
		gridBagConstraintsx04.gridwidth = 2;
		gridBagConstraintsx04.fill = GridBagConstraints.BOTH;
		cPane.add(jtfMaxArrivalTime, gridBagConstraintsx04);
		
		GridBagConstraints gridBagConstraintsx05 = new GridBagConstraints();
		gridBagConstraintsx05.gridx = 0;
		gridBagConstraintsx05.gridy = 2;
		gridBagConstraintsx05.insets = new Insets(5, 5, 5, 5);
		cPane.add(jlbMinServeTime, gridBagConstraintsx05);
		
		GridBagConstraints gridBagConstraintsx06 = new GridBagConstraints();
		gridBagConstraintsx06.gridx = 1;
		gridBagConstraintsx06.insets = new Insets(5, 5, 5, 5);
		gridBagConstraintsx06.gridy = 2;
		gridBagConstraintsx06.gridwidth = 2;
		gridBagConstraintsx06.fill = GridBagConstraints.BOTH;
		cPane.add(jtfMinServeTime, gridBagConstraintsx06);
		
		GridBagConstraints gridBagConstraintsx07 = new GridBagConstraints();
		gridBagConstraintsx07.gridx = 0;
		gridBagConstraintsx07.gridy = 3;
		gridBagConstraintsx07.insets = new Insets(5, 5, 5, 5);
		cPane.add(jlbMaxServeTime, gridBagConstraintsx07);
		
		GridBagConstraints gridBagConstraintsx08 = new GridBagConstraints();
		gridBagConstraintsx08.gridx = 1;
		gridBagConstraintsx08.insets = new Insets(5, 5, 5, 5);
		gridBagConstraintsx08.gridy = 3;
		gridBagConstraintsx08.gridwidth = 2;
		gridBagConstraintsx08.fill = GridBagConstraints.BOTH;
		cPane.add(jtfMaxServeTime, gridBagConstraintsx08);
		
		GridBagConstraints gridBagConstraintsx09 = new GridBagConstraints();
		gridBagConstraintsx09.gridx = 0;
		gridBagConstraintsx09.gridy = 5;
		gridBagConstraintsx09.insets = new Insets(5, 5, 5, 5);
		cPane.add(jbnStart, gridBagConstraintsx09);

		GridBagConstraints gridBagConstraintsx10 = new GridBagConstraints();
		gridBagConstraintsx10.gridx = 3;
		gridBagConstraintsx10.gridy = 0;
		gridBagConstraintsx10.gridwidth = 2;
		gridBagConstraintsx10.insets = new Insets(5, 5, 5, 5);
		gridBagConstraintsx10.fill = GridBagConstraints.BOTH;
		cPane.add(jtfQ0, gridBagConstraintsx10);		

		GridBagConstraints gridBagConstraintsx11 = new GridBagConstraints();
		gridBagConstraintsx11.gridx = 3;
		gridBagConstraintsx11.gridy = 1;
		gridBagConstraintsx11.gridwidth = 2;
		gridBagConstraintsx11.insets = new Insets(5, 5, 5, 5);
		gridBagConstraintsx11.fill = GridBagConstraints.BOTH;
		cPane.add(jtfQ1, gridBagConstraintsx11);		

		GridBagConstraints gridBagConstraintsx12 = new GridBagConstraints();
		gridBagConstraintsx12.gridx = 3;
		gridBagConstraintsx12.gridy = 2;
		gridBagConstraintsx12.gridwidth = 2;
		gridBagConstraintsx12.insets = new Insets(5, 5, 5, 5);
		gridBagConstraintsx12.fill = GridBagConstraints.BOTH;
		cPane.add(jtfQ2, gridBagConstraintsx12);		

		GridBagConstraints gridBagConstraintsx13 = new GridBagConstraints();
		gridBagConstraintsx13.gridx = 3;
		gridBagConstraintsx13.gridy = 3;
		gridBagConstraintsx13.gridwidth = 2;
		gridBagConstraintsx13.insets = new Insets(5, 5, 5, 5);
		gridBagConstraintsx13.fill = GridBagConstraints.BOTH;
		cPane.add(jtfQ3, gridBagConstraintsx13);		
		
		GridBagConstraints gridBagConstraintsx14 = new GridBagConstraints();
		gridBagConstraintsx14.gridx = 6;
		gridBagConstraintsx14.gridy = 0;
		gridBagConstraintsx14.gridwidth = 5;
		gridBagConstraintsx14.gridheight = 5;
		gridBagConstraintsx14.insets = new Insets(5, 5, 5, 5);
		gridBagConstraintsx14.fill = GridBagConstraints.BOTH;
		cPane.add(jspLogArea, gridBagConstraintsx14);
		
		
		jbnStart.addActionListener(this);		
	}
	
	public void writeToLog(String s)
	{
		jtaLogArea.append(s+"\n");
	}
	
	public void actionPerformed(ActionEvent e)
	{
		int nrOfCashiers = 0;
		int MaxArrivalTime = 0;
		int MinServeTime = 0;
		int MaxServeTime = 0;
		if (e.getSource() == jbnStart)
		{
			nrOfCashiers = Integer.parseInt(jtfNrOfQ.getText());
			MaxArrivalTime = Integer.parseInt(jtfMaxArrivalTime.getText());
			MinServeTime = Integer.parseInt(jtfMinServeTime.getText());
			MaxServeTime = Integer.parseInt(jtfMaxServeTime.getText());
		}
		Cashier c[] = new Cashier[nrOfCashiers];
		String cto[] = new String[nrOfCashiers];
		String ctoLoc[] = new String[nrOfCashiers];
		for (int i = 0; i < nrOfCashiers; i++)
		{
			c[i] = new Cashier("Cashier "+Integer.toString(i));
			c[i].start();
			cto[i] = c[i].getTextOut();
			ctoLoc[i] = c[i].getTextOut();
		}
		
		Shop s = new Shop(nrOfCashiers, c, MaxArrivalTime, MaxServeTime, MinServeTime, "ABC");
		s.start();
		
		for (int i = 0; i < nrOfCashiers; i++)
		{
//			System.out.println("printing1");
//			cto[i] = c[i].getTextOut();
//			jtaLogArea.append("new line"+"\n");
		/*	if (cto[i] != ctoLoc[i])
			{
				System.out.println("printing");
				//print to text area logger
				jtaLogArea.append(cto[i]+"\n");
				ctoLoc[i] = cto[i];
			}*/
		}
	}
}
