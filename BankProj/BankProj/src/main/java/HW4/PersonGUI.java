package HW4;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTable;



public class PersonGUI implements ActionListener, WindowListener
{
	private JFrame appFrame;
	private JLabel jlbID, jlbName;
	private JTextField jtfID, jtfName;
	private JTable jtbTableContent;
	private JScrollPane jspTableContent;
	private JButton jbnAdd, jbnDelete, jbnView;
	private Container cPane;
	
//	public static void main(String[] args)
//	{
//		ClientGUI demo = new ClientGUI();
//		demo.createGUI();
//	}
	
	public PersonGUI()
	{
	}
	
	public void createGUI()
	{
		appFrame = new JFrame("Person manager");
		cPane = appFrame.getContentPane();
		cPane.setLayout(new GridBagLayout());
		
		arrangeComponents();
		appFrame.pack();
		appFrame.setVisible(true);
	}
	
	public void arrangeComponents()
	{
		jlbID = new JLabel("ID of the person");
		jlbName = new JLabel("Name of the person");
		
		jtfID = new JTextField(10);
		jtfName = new JTextField(10);
		
		String[] columnNames = { "ID", "Name" };
		Object[][] data = {{0, ""}};
		jtbTableContent = new JTable(data, columnNames);		
		jspTableContent = new JScrollPane(jtbTableContent);
		jspTableContent.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
			
		jbnAdd = new JButton("Add");
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

		GridBagConstraints gridBagConstraintsx15 = new GridBagConstraints();
		gridBagConstraintsx15.gridx = 1;
		gridBagConstraintsx15.insets = new Insets(5, 5, 5, 5);
		gridBagConstraintsx15.gridy = 2;
		cPane.add(jbnDelete, gridBagConstraintsx15);
		
		
		GridBagConstraints gridBagConstraintsx16 = new GridBagConstraints();
		gridBagConstraintsx16.gridx = 0;
		gridBagConstraintsx16.insets = new Insets(5, 5, 5, 5);
		gridBagConstraintsx16.gridy = 3;
		gridBagConstraintsx02.gridwidth = 2;
		gridBagConstraintsx02.fill = GridBagConstraints.BOTH;
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
		jbnDelete.addActionListener(this);		
		jbnView.addActionListener(this);		
		appFrame.addWindowListener(this);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		//main main main main main main main main main 
		jtbTableContent.setModel(Start.b.toTableModelPerson());
		if (e.getSource() == jbnAdd) 
		{
			Start.b.addPerson(jtfName.getText());
			//b.removePerson(1);
//			Person p = new Person();
//			for (HashMap.Entry<Integer, Person> entry : Start.b.persons.entrySet()) {
//				p = entry.getValue();
//				System.out.println(p.toString());
//			}
		}
		else if (e.getSource() == jbnDelete)
		{
			Start.b.removePerson(Integer.parseInt(jtfID.getText()));
		}
		else if (e.getSource() == jbnView)
		{
			//update table
			jtbTableContent.setModel(Start.b.toTableModelPerson());
			//jtbTableContent = Start.b.createPersonsTable();
			//b.removePerson(1);
//			Person p = new Person();
//			for (HashMap.Entry<Integer, Person> entry : Start.b.persons.entrySet()) {
//				p = entry.getValue();
//				System.out.println(p.toString());
//			}
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
