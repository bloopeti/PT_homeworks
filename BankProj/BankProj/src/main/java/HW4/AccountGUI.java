package HW4;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTable;


public class AccountGUI implements ActionListener, WindowListener
{	private JFrame appFrame;
	private JLabel jlbID, jlbAmount, jlbOwnerID, jlbType;
	private JTextField jtfID, jtfAmount, jtfOwnerID, jtfType;
	private JTable jtbTableContent;
	private JScrollPane jspTableContent;
	private JButton jbnAdd, jbnDelete, jbnView, jbnDeposit, jbnWithdraw;
	private Container cPane;
	
//	public static void main(String[] args)
//	{
//		ClientGUI demo = new ClientGUI();
//		demo.createGUI();
//	}
	
	public AccountGUI()
	{
	}
	
	public void createGUI()
	{
		appFrame = new JFrame("Account manager");
		cPane = appFrame.getContentPane();
		cPane.setLayout(new GridBagLayout());
		
		arrangeComponents();
		appFrame.pack();
		appFrame.setVisible(true);
	}
	
	public void arrangeComponents()
	{
		jlbID = new JLabel("ID of the account");
		jlbAmount = new JLabel("Amount of money of the account");
		jlbOwnerID = new JLabel("ID of the owner of the account");
		jlbType = new JLabel("Type of the account");
		
		jtfID = new JTextField(10);
		jtfAmount = new JTextField(10);
		jtfOwnerID = new JTextField(10);
		jtfAmount = new JTextField(10);
		jtfType = new JTextField(10);
		
		String[] columnNames = { "ID", "Amount", "Owner", "Type" };
		Object[][] data = {{0, 0, 0, ""}};
		jtbTableContent = new JTable(data, columnNames);		
		jspTableContent = new JScrollPane(jtbTableContent);
		jspTableContent.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
			
		jbnAdd = new JButton("Add");
		jbnDelete = new JButton("Delete");
		jbnView = new JButton("View");
		jbnDeposit = new JButton("Deposit");
		jbnWithdraw = new JButton("Withdraw");
		
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
		cPane.add(jlbAmount, gridBagConstraintsx03);
		
		GridBagConstraints gridBagConstraintsx04 = new GridBagConstraints();
		gridBagConstraintsx04.gridx = 1;
		gridBagConstraintsx04.insets = new Insets(5, 5, 5, 5);
		gridBagConstraintsx04.gridy = 1;
		gridBagConstraintsx04.gridwidth = 2;
		gridBagConstraintsx04.fill = GridBagConstraints.BOTH;
		cPane.add(jtfAmount, gridBagConstraintsx04);
		
		GridBagConstraints gridBagConstraintsx05 = new GridBagConstraints();
		gridBagConstraintsx05.gridx = 0;
		gridBagConstraintsx05.gridy = 2;
		gridBagConstraintsx05.insets = new Insets(5, 5, 5, 5);
		cPane.add(jlbOwnerID, gridBagConstraintsx05);
		
		GridBagConstraints gridBagConstraintsx06 = new GridBagConstraints();
		gridBagConstraintsx06.gridx = 1;
		gridBagConstraintsx06.insets = new Insets(5, 5, 5, 5);
		gridBagConstraintsx06.gridy = 2;
		gridBagConstraintsx06.gridwidth = 2;
		gridBagConstraintsx06.fill = GridBagConstraints.BOTH;
		cPane.add(jtfOwnerID, gridBagConstraintsx06);
		
		GridBagConstraints gridBagConstraintsx07 = new GridBagConstraints();
		gridBagConstraintsx07.gridx = 0;
		gridBagConstraintsx07.gridy = 3;
		gridBagConstraintsx07.insets = new Insets(5, 5, 5, 5);
		cPane.add(jlbType, gridBagConstraintsx07);
		
		GridBagConstraints gridBagConstraintsx08 = new GridBagConstraints();
		gridBagConstraintsx08.gridx = 1;
		gridBagConstraintsx08.insets = new Insets(5, 5, 5, 5);
		gridBagConstraintsx08.gridy = 3;
		gridBagConstraintsx08.gridwidth = 2;
		gridBagConstraintsx08.fill = GridBagConstraints.BOTH;
		cPane.add(jtfType, gridBagConstraintsx08);
		
		GridBagConstraints gridBagConstraintsx09 = new GridBagConstraints();
		gridBagConstraintsx09.gridx = 0;
		gridBagConstraintsx09.gridy = 4;
		gridBagConstraintsx09.insets = new Insets(5, 5, 5, 5);
		cPane.add(jbnAdd, gridBagConstraintsx09);

		GridBagConstraints gridBagConstraintsx10 = new GridBagConstraints();
		gridBagConstraintsx10.gridx = 1;
		gridBagConstraintsx10.insets = new Insets(5, 5, 5, 5);
		gridBagConstraintsx10.gridy = 4;
		cPane.add(jbnDelete, gridBagConstraintsx10);
		
		GridBagConstraints gridBagConstraintsx11 = new GridBagConstraints();
		gridBagConstraintsx11.gridx = 0;
		gridBagConstraintsx11.insets = new Insets(5, 5, 5, 5);
		gridBagConstraintsx11.gridy = 5;
		gridBagConstraintsx11.gridwidth = 2;
		gridBagConstraintsx11.fill = GridBagConstraints.BOTH;
		cPane.add(jbnView, gridBagConstraintsx11);
		

		GridBagConstraints gridBagConstraintsx12 = new GridBagConstraints();
		gridBagConstraintsx12.gridx = 0;
		gridBagConstraintsx12.insets = new Insets(5, 5, 5, 5);
		gridBagConstraintsx12.gridy = 6;
		cPane.add(jbnDeposit, gridBagConstraintsx12);
		
		GridBagConstraints gridBagConstraintsx13 = new GridBagConstraints();
		gridBagConstraintsx13.gridx = 1;
		gridBagConstraintsx13.insets = new Insets(5, 5, 5, 5);
		gridBagConstraintsx13.gridy = 6;
		cPane.add(jbnWithdraw, gridBagConstraintsx13);
		
		GridBagConstraints gridBagConstraintsx14 = new GridBagConstraints();
		gridBagConstraintsx14.gridx = 6;
		gridBagConstraintsx14.gridy = 0;
		gridBagConstraintsx14.gridwidth = 5;
		gridBagConstraintsx14.gridheight = 8;
		gridBagConstraintsx14.insets = new Insets(5, 5, 5, 5);
		gridBagConstraintsx14.fill = GridBagConstraints.BOTH;
		cPane.add(jspTableContent, gridBagConstraintsx14);
		
		
		jbnAdd.addActionListener(this);				
		jbnDelete.addActionListener(this);		
		jbnView.addActionListener(this);		
		jbnDeposit.addActionListener(this);		
		jbnWithdraw.addActionListener(this);			
		appFrame.addWindowListener(this);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		//main main main main main main main main main 
		jtbTableContent.setModel(Start.b.toTableModelAccount());
		if (e.getSource() == jbnAdd) 
		{
			Start.b.addAccount(Integer.parseInt(jtfType.getText()), Integer.parseInt(jtfAmount.getText()), Integer.parseInt(jtfOwnerID.getText()));
			//b.removeAccount(1);
//			Account p = new Account();
//			for (HashMap.Entry<Integer, Account> entry : Start.b.accounts.entrySet()) {
//				p = entry.getValue();
//				System.out.println(p.toString());
//			}
		}
		else if (e.getSource() == jbnDelete)
		{
			Start.b.removeAccount(Integer.parseInt(jtfID.getText()));
		}
		else if (e.getSource() == jbnView)
		{
			//update table
			jtbTableContent.setModel(Start.b.toTableModelAccount());
			//jtbTableContent = Start.b.createAccountsTable();
			//b.removeAccount(1);
//			Account p = new Account();
//			for (HashMap.Entry<Integer, Account> entry : Start.b.accounts.entrySet()) {
//				p = entry.getValue();
//				System.out.println(p.toString());
//			}
		}
		else if (e.getSource() == jbnDeposit)
		{
			//System.out.println("in deposit");
			int key = Integer.parseInt(jtfID.getText());
			//System.out.println(key);
			Start.b.depositAccount(key, Start.b.accounts.get(key).getId(), Integer.parseInt(jtfAmount.getText()), Start.b.accounts.get(key).getOwnerId());
//			Account p = new Account();
//			for (HashMap.Entry<Integer, Account> entry : Start.b.accounts.entrySet()) {
//				p = entry.getValue();
//				System.out.println(p.toString());
//			}
//
//			System.out.println();
		}
		else if (e.getSource() == jbnWithdraw)
		{
			int key = Integer.parseInt(jtfID.getText());
			if(Start.b.accounts.get(key).getAmount() - Integer.parseInt(jtfAmount.getText()) >= 0)
				Start.b.withdrawAccount(key, Start.b.accounts.get(key).getId(), Integer.parseInt(jtfAmount.getText()), Start.b.accounts.get(key).getOwnerId());
			else
			{
				System.out.println("Not enough money");
				Start.b.withdrawAccount(key, Start.b.accounts.get(key).getId(), Start.b.accounts.get(key).getAmount(), Start.b.accounts.get(key).getOwnerId());
			}
		}
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		Start.b.serializeBank("D:\\Uni work\\Java Projects\\30423_ZavaczkiPeter_Homework4\\Bank.ser");
		System.exit(1);
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
}
