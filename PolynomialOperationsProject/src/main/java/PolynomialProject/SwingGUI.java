package PolynomialProject;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class SwingGUI {
	   private JFrame mainFrame;
	   private JLabel headerLabel;
	   private JLabel statusLabel;
	   private JPanel controlPanel;
//	   private JLabel msglabel;

	   JTextField jtfPoly1, jtfPoly2, jtfResult;
	   
	   public static void main(String[] args){
		      SwingGUI swingGUI = new SwingGUI();  
		      swingGUI.showGridLayoutDemo();       
	   }

	   public SwingGUI(){
	      prepareGUI();
	   }
	   
	   private void prepareGUI(){
		      mainFrame = new JFrame("Java SWING Examples");
		      mainFrame.setSize(400,400);
		      mainFrame.setLayout(new GridLayout(3, 1));

		      headerLabel = new JLabel("",JLabel.CENTER );
		      statusLabel = new JLabel("",JLabel.CENTER);        
		      statusLabel.setSize(350,100);
		      
		      mainFrame.addWindowListener(new WindowAdapter() {
		         public void windowClosing(WindowEvent windowEvent){
		            System.exit(0);
		         }        
		      });    
		      controlPanel = new JPanel();
		      controlPanel.setLayout(new FlowLayout());

		      mainFrame.add(headerLabel);
		      mainFrame.add(controlPanel);
		      mainFrame.add(statusLabel);
		      mainFrame.setVisible(true);  
		   }
	  
	   private void showGridLayoutDemo(){
		      headerLabel.setText("Layout in action: GridLayout");      
		      

		      JButton addButton = new JButton("Add");
		      JButton subtractButton = new JButton("Subtract");
		      JButton multiplyButton = new JButton("Multiply");
		      JButton derivateButton = new JButton("Derivate");
		      
		      GridLayout layout = new GridLayout(5,1);
		      layout.setHgap(10);
		      layout.setVgap(10);


	   		jtfPoly1 = new JTextField(20);
			jtfPoly2 = new JTextField(20);
			jtfResult = new JTextField(20);
		      
		      addButton.setActionCommand("Add");
		      subtractButton.setActionCommand("Subtract");
		      multiplyButton.setActionCommand("Multiply");
		      derivateButton.setActionCommand("Derivate");

		      addButton.addActionListener(new ButtonClickListener()); 
		      subtractButton.addActionListener(new ButtonClickListener()); 
		      multiplyButton.addActionListener(new ButtonClickListener());
		      derivateButton.addActionListener(new ButtonClickListener());
		      
		      
		      controlPanel.add(jtfPoly1);
		      controlPanel.add(jtfPoly2);
		      
		      controlPanel.add(addButton);
		      controlPanel.add(subtractButton);
		      controlPanel.add(multiplyButton);
		      controlPanel.add(derivateButton);

		      controlPanel.add(jtfResult);
		      
		      mainFrame.setVisible(true);  
		   }
	   

	   private class ButtonClickListener implements ActionListener{
	      public void actionPerformed(ActionEvent e) {
	         String command = e.getActionCommand();  
	         
	         if( command.equals( "Add" ))  {
	            statusLabel.setText("Add Button clicked.");
	         } else if( command.equals( "Subtract" ) )  {
		            statusLabel.setText("Subtract Button clicked."); 
	         }else if( command.equals( "Multiply" ) )  {
		            statusLabel.setText("Multiply Button clicked."); 
	         } else {
	            statusLabel.setText("Derivate Button clicked.");
	         }  	
	      }
	   }
	  
	  
	   
}
