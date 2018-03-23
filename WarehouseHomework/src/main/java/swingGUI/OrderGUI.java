package swingGUI;

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
import javax.swing.JTextField;
import javax.swing.JTable;

import bll.*;

public class OrderGUI implements ActionListener
{
	private JFrame appFrame;
	private JLabel jlbID, jlbClient, jlbProduct, jlbNr;
	private JTextField jtfID, jtfClient, jtfProduct, jtfNr;
	private JTable jtbTableContent;
	private JScrollPane jspTableContent;
	private JButton jbnAdd, jbnView;
	private Container cPane;
	
//	public static void main(String[] args)
//	{
//		OrderGUI demo = new OrderGUI();
//		demo.createGUI();
//	}
	
	public OrderGUI()
	{
	}
	
	public void createGUI()
	{
		appFrame = new JFrame("Order manager");
		cPane = appFrame.getContentPane();
		cPane.setLayout(new GridBagLayout());
		
		arrangeComponents();
		appFrame.pack();
		appFrame.setVisible(true);
	}
	
	public void arrangeComponents()
	{
		jlbID = new JLabel("ID of the order");
		jlbClient = new JLabel("ID of the client");
		jlbProduct = new JLabel("ID of the product");
		jlbNr = new JLabel("Nr of order");
		
		jtfID = new JTextField(10);
		jtfClient = new JTextField(10);
		jtfProduct = new JTextField(10);
		jtfNr = new JTextField(10);
		
		String[] columnNames = {"id", "client", "product", "nr"};
		Object[][] data = {{0, "", "", 0}};
		jtbTableContent = new JTable(data, columnNames);		
		jspTableContent = new JScrollPane(jtbTableContent);
		jspTableContent.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
			
		jbnAdd = new JButton("Add");
//		jbnEdit = new JButton("Edit");
//		jbnDelete = new JButton("Delete");
		jbnView = new JButton("View");
		
		GridBagConstraints gridBagConstraintsx01 = new GridBagConstraints();
		gridBagConstraintsx01.gridx = 0;
		gridBagConstraintsx01.gridy = 0;
		gridBagConstraintsx01.insets = new Insets(5, 5, 5, 5);
		cPane.add(jlbID, gridBagConstraintsx01);
		
		GridBagConstraints gridBagConstraintsx02 = new GridBagConstraints();
		gridBagConstraintsx02.gridx = 1;
		gridBagConstraintsx02.insets = new Insets(5, 5, 5, 5);
		gridBagConstraintsx02.gridy = 0;
		gridBagConstraintsx02.gridwidth = 2;
		gridBagConstraintsx02.fill = GridBagConstraints.BOTH;
		cPane.add(jtfID, gridBagConstraintsx02);

		GridBagConstraints gridBagConstraintsx03 = new GridBagConstraints();
		gridBagConstraintsx03.gridx = 0;
		gridBagConstraintsx03.gridy = 1;
		gridBagConstraintsx03.insets = new Insets(5, 5, 5, 5);
		cPane.add(jlbClient, gridBagConstraintsx03);
		
		GridBagConstraints gridBagConstraintsx04 = new GridBagConstraints();
		gridBagConstraintsx04.gridx = 1;
		gridBagConstraintsx04.insets = new Insets(5, 5, 5, 5);
		gridBagConstraintsx04.gridy = 1;
		gridBagConstraintsx04.gridwidth = 2;
		gridBagConstraintsx04.fill = GridBagConstraints.BOTH;
		cPane.add(jtfClient, gridBagConstraintsx04);

		GridBagConstraints gridBagConstraintsx05 = new GridBagConstraints();
		gridBagConstraintsx05.gridx = 0;
		gridBagConstraintsx05.gridy = 2;
		gridBagConstraintsx05.insets = new Insets(5, 5, 5, 5);
		cPane.add(jlbProduct, gridBagConstraintsx05);
		
		GridBagConstraints gridBagConstraintsx06 = new GridBagConstraints();
		gridBagConstraintsx06.gridx = 1;
		gridBagConstraintsx06.insets = new Insets(5, 5, 5, 5);
		gridBagConstraintsx06.gridy = 2;
		gridBagConstraintsx06.gridwidth = 2;
		gridBagConstraintsx06.fill = GridBagConstraints.BOTH;
		cPane.add(jtfProduct, gridBagConstraintsx06);

		
		GridBagConstraints gridBagConstraintsx07 = new GridBagConstraints();
		gridBagConstraintsx07.gridx = 0;
		gridBagConstraintsx07.gridy = 3;
		gridBagConstraintsx07.insets = new Insets(5, 5, 5, 5);
		cPane.add(jlbNr, gridBagConstraintsx07);
		
		GridBagConstraints gridBagConstraintsx08 = new GridBagConstraints();
		gridBagConstraintsx08.gridx = 1;
		gridBagConstraintsx08.insets = new Insets(5, 5, 5, 5);
		gridBagConstraintsx08.gridy = 3;
		gridBagConstraintsx08.gridwidth = 2;
		gridBagConstraintsx08.fill = GridBagConstraints.BOTH;
		cPane.add(jtfNr, gridBagConstraintsx08);
		
		GridBagConstraints gridBagConstraintsx09 = new GridBagConstraints();
		gridBagConstraintsx09.gridx = 0;
		gridBagConstraintsx09.gridy = 4;
		gridBagConstraintsx09.insets = new Insets(5, 5, 5, 5);
		cPane.add(jbnAdd, gridBagConstraintsx09);
		
		GridBagConstraints gridBagConstraintsx10 = new GridBagConstraints();
		gridBagConstraintsx10.gridx = 1;
		gridBagConstraintsx10.insets = new Insets(5, 5, 5, 5);
		gridBagConstraintsx10.gridy = 4;
		cPane.add(jbnView, gridBagConstraintsx10);
		
		GridBagConstraints gridBagConstraintsx14 = new GridBagConstraints();
		gridBagConstraintsx14.gridx = 6;
		gridBagConstraintsx14.gridy = 0;
		gridBagConstraintsx14.gridwidth = 5;
		gridBagConstraintsx14.gridheight = 6;
		gridBagConstraintsx14.insets = new Insets(5, 5, 5, 5);
		gridBagConstraintsx14.fill = GridBagConstraints.BOTH;
		cPane.add(jspTableContent, gridBagConstraintsx14);
		
		
		jbnAdd.addActionListener(this);			
		jbnView.addActionListener(this);		
	}
	
	public void actionPerformed(ActionEvent e)
	{
		//main main main main main main main main main 	//main main main main main main main main main 
		OrderBLL orderBll = new OrderBLL();
		if (e.getSource() == jbnAdd) 
		{
			int clientID = Integer.parseInt(jtfClient.getText());
			int productID = Integer.parseInt(jtfProduct.getText());
			int nr = Integer.parseInt(jtfNr.getText());
			@SuppressWarnings("unused")
			int id1 = orderBll.insertOrder(clientID, productID, nr);
		}
		else if (e.getSource() == jbnView)
		{
			//update table
			jtbTableContent.setModel(orderBll.findAllOrder());
		}
	}
}
