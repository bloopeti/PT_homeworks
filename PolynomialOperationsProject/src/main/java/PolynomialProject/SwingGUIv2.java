package PolynomialProject;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import PolynomialProject.StringSplit;
import PolynomialProject.Polynomial;


public class SwingGUIv2 implements ActionListener{

	private JFrame appFrame;
	private JLabel jlbPoly1, jlbPoly2, jlbResult, jlbResultLabel; 
	private JTextField jtfPoly1, jtfPoly2;
	private JButton jbnAdd, jbnSubtract, jbnMultiply, jbnDifferentiate;	
	private Container cPane;

	public static void main(String[] args)
	{
		SwingGUIv2 demo = new SwingGUIv2();
		demo.createGUI();
	}
	
	public SwingGUIv2() {
	}

	public void createGUI(){

   		/*Create a frame, get its contentpane and set layout*/
   		appFrame = new JFrame("Polynomial Operations");
   		cPane = appFrame.getContentPane();
   		cPane.setLayout(new GridBagLayout());
   		
   		//Arrange components on contentPane and set Action Listeners to each JButton

   		arrangeComponents();
   		appFrame.pack();
//   		appFrame.setResizable(false);
   		appFrame.setVisible(true);

   	}
	
	public void arrangeComponents() {
		
		jlbPoly1 = new JLabel("Insert the first polynomial");
		jlbPoly2 = new JLabel("Insert the second polynomial");		
		jlbResult = new JLabel("Result");
		jlbResultLabel = new JLabel("");
		
		jtfPoly1 = new JTextField(20);
		jtfPoly2 = new JTextField(20);
		
		
		jbnAdd = new JButton("Add");
		jbnSubtract = new JButton("Subtract");
		jbnMultiply = new JButton("Multiply");
		jbnDifferentiate = new JButton("Differentiate");
		
		
		/*add all initialized components to the container*/
		
		/*
		 * (from https://docs.oracle.com/javase/tutorial/uiswing/layout/gridbag.html)
		 * gridx, gridy - Specify the row and column at the upper left of the component. 
		 *                The leftmost column has address gridx=0 and the top row has address gridy=0. 
		 *                Use GridBagConstraints.RELATIVE (the default value) to specify that the component
		 *                be placed just to the right of (for gridx) or just below (for gridy) the component 
		 *                that was added to the container just before this component was added. We recommend 
		 *                specifying the gridx and gridy values for each component rather than just using 
		 *                GridBagConstraints.RELATIVE; this tends to result in more predictable layouts.
		 *                
		 * gridwidth, gridheight - Specify the number of columns (for gridwidth) or rows (for gridheight) in 
		 *                         the component's display area. These constraints specify the number of cells 
		 *                         the component uses, not the number of pixels it uses. The default value is 1. 
		 *                         Use GridBagConstraints.REMAINDER to specify that the component be the last one 
		 *                         in its row (for gridwidth) or column (for gridheight). Use GridBagConstraints.RELATIVE 
		 *                         to specify that the component be the next to last one in its row (for gridwidth) or column 
		 *                         (for gridheight). We recommend specifying the gridwidth and gridheight values for each 
		 *                         component rather than just using GridBagConstraints.RELATIVE and GridBagConstraints.REMAINDER; 
		 *                         this tends to result in more predictable layouts.  
		 *                         
		 * insets - Specifies the external padding of the component -- the minimum amount of space between the component and the 
		 *          edges of its display area. The value is specified as an Insets object. By default, each component has no external padding.                               
		 */
		
		GridBagConstraints gridBagConstraintsx01 = new GridBagConstraints();
		gridBagConstraintsx01.gridx = 0;
		gridBagConstraintsx01.gridy = 0;
		gridBagConstraintsx01.insets = new Insets(5, 5, 5, 5);
		cPane.add(jlbPoly1, gridBagConstraintsx01);
		
		GridBagConstraints gridBagConstraintsx02 = new GridBagConstraints();
		gridBagConstraintsx02.gridx = 1;
		gridBagConstraintsx02.insets = new Insets(5, 5, 5, 5);
		gridBagConstraintsx02.gridy = 0;
		gridBagConstraintsx02.gridwidth = 2;
		gridBagConstraintsx02.fill = GridBagConstraints.BOTH;
		cPane.add(jtfPoly1, gridBagConstraintsx02);
		
		GridBagConstraints gridBagConstraintsx03 = new GridBagConstraints();
		gridBagConstraintsx03.gridx = 0;
		gridBagConstraintsx03.insets = new Insets(5, 5, 5, 5);
		gridBagConstraintsx03.gridy = 1;
		cPane.add(jlbPoly2, gridBagConstraintsx03);
		
		GridBagConstraints gridBagConstraintsx04 = new GridBagConstraints();
		gridBagConstraintsx04.gridx = 1;
		gridBagConstraintsx04.insets = new Insets(5, 5, 5, 5);
		gridBagConstraintsx04.gridy = 1;
		gridBagConstraintsx04.gridwidth = 2;
		gridBagConstraintsx04.fill = GridBagConstraints.BOTH;
		cPane.add(jtfPoly2, gridBagConstraintsx04);
		
		
		GridBagConstraints gridBagConstraintsx05 = new GridBagConstraints();
		gridBagConstraintsx05.gridx = 0;
		gridBagConstraintsx05.insets = new Insets(5, 5, 5, 5);
		gridBagConstraintsx05.gridy = 2;
		cPane.add(jlbResult, gridBagConstraintsx05);
		
		GridBagConstraints gridBagConstraintsx06 = new GridBagConstraints();
		gridBagConstraintsx06.gridx = 1;
		gridBagConstraintsx06.gridy = 2;
		gridBagConstraintsx06.insets = new Insets(5, 5, 5, 5);
		gridBagConstraintsx06.gridwidth = 2;
		gridBagConstraintsx06.fill = GridBagConstraints.BOTH;
		cPane.add(jlbResultLabel, gridBagConstraintsx06);
		
		GridBagConstraints gridBagConstraintsx09 = new GridBagConstraints();
		gridBagConstraintsx09.gridx = 0;
		gridBagConstraintsx09.gridy = 4;
		gridBagConstraintsx09.insets = new Insets(5, 5, 5, 5);
		cPane.add(jbnAdd, gridBagConstraintsx09);
		
		GridBagConstraints gridBagConstraintsx10 = new GridBagConstraints();
		gridBagConstraintsx10.gridx = 0;
		gridBagConstraintsx10.gridy = 6;
		gridBagConstraintsx10.insets = new Insets(5, 5, 5, 5);
		cPane.add(jbnSubtract, gridBagConstraintsx10);

		GridBagConstraints gridBagConstraintsx15 = new GridBagConstraints();
		gridBagConstraintsx15.gridx = 1;
		gridBagConstraintsx15.insets = new Insets(5, 5, 5, 5);
		gridBagConstraintsx15.gridy = 4;
		cPane.add(jbnMultiply, gridBagConstraintsx15);
		

		GridBagConstraints gridBagConstraintsx16 = new GridBagConstraints();
		gridBagConstraintsx16.gridx = 1;
		gridBagConstraintsx16.insets = new Insets(5, 5, 5, 5);
		gridBagConstraintsx16.gridy = 6;
		cPane.add(jbnDifferentiate, gridBagConstraintsx16);
		
		
		jbnAdd.addActionListener(this);
		jbnSubtract.addActionListener(this);
		jbnMultiply.addActionListener(this);
		jbnDifferentiate.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {

		Polynomial poly1 = new Polynomial();
		poly1.initialize();

		Polynomial poly2 = new Polynomial();
		poly2.initialize();

		Polynomial polyResult = new Polynomial();
		polyResult.initialize();
		
		if (e.getSource() == jbnAdd) 
		{
			poly1.setMaxPower(StringSplit.splitInputPower(jtfPoly1.getText()));
			poly1.setElements(StringSplit.splitInputCoefficients(jtfPoly1.getText(), poly1.getMaxPower()));
//			System.out.println(poly1.getPolynomial());
			
			poly2.setMaxPower(StringSplit.splitInputPower(jtfPoly2.getText()));
			poly2.setElements(StringSplit.splitInputCoefficients(jtfPoly2.getText(), poly2.getMaxPower()));
//			System.out.println(poly2.getPolynomial());

			polyResult = poly1.addPolynomials(poly2);
//			System.out.println(polyResult.getPolynomial());	

            jlbResultLabel.setText(polyResult.getPolynomial());
		} 
		else if (e.getSource() == jbnSubtract) 
		{
			poly1.setMaxPower(StringSplit.splitInputPower(jtfPoly1.getText()));
			poly1.setElements(StringSplit.splitInputCoefficients(jtfPoly1.getText(), poly1.getMaxPower()));
//			System.out.println(poly1.getPolynomial());
			
			poly2.setMaxPower(StringSplit.splitInputPower(jtfPoly2.getText()));
			poly2.setElements(StringSplit.splitInputCoefficients(jtfPoly2.getText(), poly2.getMaxPower()));
//			System.out.println(poly2.getPolynomial());

			polyResult = poly1.subtractPolynomials(poly2);
//			System.out.println(polyResult.getPolynomial());	
			
            jlbResultLabel.setText(polyResult.getPolynomial());
		} 
		else if (e.getSource() == jbnMultiply) 
		{
			poly1.setMaxPower(StringSplit.splitInputPower(jtfPoly1.getText()));
			poly1.setElements(StringSplit.splitInputCoefficients(jtfPoly1.getText(), poly1.getMaxPower()));
//			System.out.println(poly1.getPolynomial());
			
			poly2.setMaxPower(StringSplit.splitInputPower(jtfPoly2.getText()));
			poly2.setElements(StringSplit.splitInputCoefficients(jtfPoly2.getText(), poly2.getMaxPower()));
//			System.out.println(poly2.getPolynomial());

			polyResult = poly1.multiplyPolynomials(poly2);
//			System.out.println(polyResult.getPolynomial());	
			
            jlbResultLabel.setText(polyResult.getPolynomial());
		} 
		else if (e.getSource() == jbnDifferentiate)
		{
			poly1.setMaxPower(StringSplit.splitInputPower(jtfPoly1.getText()));
			poly1.setElements(StringSplit.splitInputCoefficients(jtfPoly1.getText(), poly1.getMaxPower()));
//			System.out.println(poly1.getPolynomial());
			
			polyResult = poly1.differentiatePolynomial();
//			System.out.println(polyResult.getPolynomial());
			
            jlbResultLabel.setText(polyResult.getPolynomial());
		}
	}
	
}
