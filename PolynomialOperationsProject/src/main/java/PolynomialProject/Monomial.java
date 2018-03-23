package PolynomialProject;
//import java.io.*;

public class Monomial 
{
	private int coefficient;
	private int power;
	
	public Monomial()
	{
		
	}
	
	public Monomial(int coefficient, int power)
	{
		this.coefficient = coefficient;
		this.power = power;	}
	
	public void setCoefficient(int coefficient) 
	{
		this.coefficient = coefficient;
	} 
	
	public void setPower(int power) 
	{
		this.power = power;
	} 
	
	public int getCoefficient()
	{
		return this.coefficient;
	}
	
	public int getPower()
	{
		return this.power;
	}

}
