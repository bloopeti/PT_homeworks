package PolynomialProject;
//import java.io.*;
import PolynomialProject.StringSplit;

public class PolynomialTest 
{
	public static void main(String[] args) 
	{
		Polynomial poly1 = new Polynomial();
		poly1.initialize();
//		int[] arr1 = {1, 3, 1};
		String poly1str = "+1x^2 +3x^1 +1x^0";
		poly1.setMaxPower(StringSplit.splitInputPower(poly1str));
		poly1.setElements(StringSplit.splitInputCoefficients(poly1str, poly1.getMaxPower()));
		System.out.println(poly1.getPolynomial());
		
		Polynomial poly2 = new Polynomial();
		poly2.initialize();
//		int[] arr2 = {2, 2, 2};
		String poly2str = "+2x^2 +2x^1 +2x^0";
		poly2.setMaxPower(StringSplit.splitInputPower(poly2str));
		poly2.setElements(StringSplit.splitInputCoefficients(poly2str, poly2.getMaxPower()));
		System.out.println(poly2.getPolynomial());

//		Polynomial poly3 = new Polynomial();
//		poly3.initialize();
//		poly3 = poly1.addPolynomials(poly2);
//		System.out.println(poly3.getPolynomial());

		Polynomial poly4 = new Polynomial();
		poly4.initialize();
		poly4 = poly1.subtractPolynomials(poly2);
		System.out.println(poly4.getPolynomial());
//		
//		Polynomial poly5 = new Polynomial();
//		poly5.initialize();
//		poly5 = poly1.multiplyPolynomials(poly2);
//		System.out.println(poly5.getPolynomial());
//
//		Polynomial poly6 = new Polynomial();
//		poly6.initialize();
//		poly6 = poly1.differentiatePolynomial();
//		System.out.println(poly6.getPolynomial());

	}
	
}
