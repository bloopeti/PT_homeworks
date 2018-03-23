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
import model.*;

public class ClientGUI implements ActionListener
{
	private JFrame appFrame;
	private JLabel jlbID, jlbName;
	private JTextField jtfID, jtfName;
	private JTable jtbTableContent;
	private JScrollPane jspTableContent;
	private JButton jbnAdd, jbnEdit, jbnDelete, jbnView;
	private Container cPane;
	
//	public static void main(String[] args)
//	{
//		ClientGUI demo = new ClientGUI();
//		demo.createGUI();
//	}
	
	public ClientGUI()
	{
	}
	
	public void createGUI()
	{
		appFrame = new JFrame("Client manager");
		cPane = appFrame.getContentPane();
		cPane.setLayout(new GridBagLayout());
		
		arrangeComponents();
		appFrame.pack();
		appFrame.setVisible(true);
	}
	
	public void arrangeComponents()
	{
		jlbID = new JLabel("ID of the client");
		jlbName = new JLabel("Name of the client");
		
		jtfID = new JTextField(10);
		jtfName = new JTextField(10);
		
		String[] columnNames = {"id", "name"};
		Object[][] data = {{0, ""}};
		jtbTableContent = new JTable(data, columnNames);		
		jspTableContent = new JScrollPane(jtbTableContent);
		jspTableContent.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
			
		jbnAdd = new JButton("Add");
		jbnEdit = new JButton("Edit");
		jbnDelete = new JButton("Delete");
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
		cPane.add(jlbName, gridBagConstraintsx03);
		
		GridBagConstraints gridBagConstraintsx04 = new GridBagConstraints();
		gridBagConstraintsx04.gridx = 1;
		gridBagConstraintsx04.insets = new Insets(5, 5, 5, 5);
		gridBagConstraintsx04.gridy = 1;
		gridBagConstraintsx04.gridwidth = 2;
		gridBagConstraintsx04.fill = GridBagConstraints.BOTH;
		cPane.add(jtfName, gridBagConstraintsx04);
		
		GridBagConstraints gridBagConstraintsx09 = new GridBagConstraints();
		gridBagConstraintsx09.gridx = 0;
		gridBagConstraintsx09.gridy = 2;
		gridBagConstraintsx09.insets = new Insets(5, 5, 5, 5);
		cPane.add(jbnAdd, gridBagConstraintsx09);
		
		GridBagConstraints gridBagConstraintsx10 = new GridBagConstraints();
		gridBagConstraintsx10.gridx = 0;
		gridBagConstraintsx10.gridy = 3;
		gridBagConstraintsx10.insets = new Insets(5, 5, 5, 5);
		cPane.add(jbnEdit, gridBagConstraintsx10);

		GridBagConstraints gridBagConstraintsx15 = new GridBagConstraints();
		gridBagConstraintsx15.gridx = 1;
		gridBagConstraintsx15.insets = new Insets(5, 5, 5, 5);
		gridBagConstraintsx15.gridy = 2;
		cPane.add(jbnDelete, gridBagConstraintsx15);
		

		GridBagConstraints gridBagConstraintsx16 = new GridBagConstraints();
		gridBagConstraintsx16.gridx = 1;
		gridBagConstraintsx16.insets = new Insets(5, 5, 5, 5);
		gridBagConstraintsx16.gridy = 3;
		cPane.add(jbnView, gridBagConstraintsx16);
		
		GridBagConstraints gridBagConstraintsx14 = new GridBagConstraints();
		gridBagConstraintsx14.gridx = 6;
		gridBagConstraintsx14.gridy = 0;
		gridBagConstraintsx14.gridwidth = 5;
		gridBagConstraintsx14.gridheight = 6;
		gridBagConstraintsx14.insets = new Insets(5, 5, 5, 5);
		gridBagConstraintsx14.fill = GridBagConstraints.BOTH;
		cPane.add(jspTableContent, gridBagConstraintsx14);
		
		
		jbnAdd.addActionListener(this);		
		jbnEdit.addActionListener(this);		
		jbnDelete.addActionListener(this);		
		jbnView.addActionListener(this);		
	}
	
	public void actionPerformed(ActionEvent e)
	{
		//main main main main main main main main main 
		ClientBLL clientBll = new ClientBLL();
		if (e.getSource() == jbnAdd) 
		{
			Client client = new Client(jtfName.getText());
			@SuppressWarnings("unused")
			int id1 = clientBll.insertClient(client);
		}
		else if (e.getSource() == jbnEdit)
		{
			Client client = new Client(Integer.parseInt(jtfID.getText()), jtfName.getText());
			clientBll.editClient(client);
		}
		else if (e.getSource() == jbnDelete)
		{
			clientBll.deleteClient(Integer.parseInt(jtfID.getText()));
		}
		else if (e.getSource() == jbnView)
		{
			//update table
			jtbTableContent.setModel(clientBll.findAllClient());
		}
	}
}
