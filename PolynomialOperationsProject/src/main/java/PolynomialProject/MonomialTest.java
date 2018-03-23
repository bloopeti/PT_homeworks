package PolynomialProject;
//import java.io.*;

public class MonomialTest 
{

	public static void main(String[] args) 
	{
		Monomial monOne = new Monomial( 5, 2 );
		System.out.println(monOne.getCoefficient());
		System.out.println(monOne.getPower());

		monOne.setCoefficient(15);
		monOne.setPower(10);
		System.out.println(monOne.getCoefficient());
		System.out.println(monOne.getPower());
	}

}
