package PolynomialProject;
//import java.io.*;
//import java.lang.*;
import java.util.Arrays;

public class Polynomial 
{
	private Monomial[] poly = new Monomial[50];
	private int maxPower;
	
	public Polynomial()
	{
	}
	
	//start a new empty polynomial by initializing the monomial array
	public void initialize()
	{
		for(int i = 0; i < 50; i++)
		{
			this.poly[i] = new Monomial();
		}
	}
	
	//set the power of the polynomial, 
	//aka the power of the monomial with the highest power and nonzero coefficient
	public void setMaxPower(int power)
	{
		this.maxPower = power;
	}
	
	//set the properties of the monomials of the polynomial
	public void setElements(int[] coefficients)
	{
		for(int i = 0; i < this.maxPower; i++)
		{
			this.poly[i].setCoefficient(coefficients[i]);
			this.poly[i].setPower(i);
		}
	}
	
	//return the highest power appearing in the polynomial
	public int getMaxPower()
	{
		return this.maxPower;
	}
	
	//return an array with the coefficients
	public int[] getCoefficients()
	{
		int[] arr = new int[this.maxPower];
		for(int i = 0; i < this.maxPower; i++)
		{
			arr[i] = this.poly[i].getCoefficient();
		}
		
		return( arr );
	}
	
	//print the polynomial to console
	public String getPolynomial()
	{
		String result = "";
		for(int i = this.maxPower - 1; i >= 0; i--)
		{
			if (this.poly[i].getCoefficient() >= 0)
			{
				result = result + " +";						
			}
			else
			{
				result = result + " -";					
			}
			
			result = result + Math.abs(this.poly[i].getCoefficient());
			
			result = result + "x^";
			
			result = result + this.poly[i].getPower();
		}
		
		return result;
	}

	//add 2 polynomials
	//return = this + polyAdd
	public Polynomial addPolynomials(Polynomial polyAdd)
	{
		Polynomial result = new Polynomial();
		result.initialize();
		
		int maxPower = 0;		
		int k = 0;
		
		if ( this.maxPower > polyAdd.maxPower )
		{
			maxPower = this.maxPower;
			k = 1;
		}
		else
		{
			maxPower = polyAdd.maxPower;
			k = 2;
		}
		
		result.setMaxPower(maxPower);

		int[] coefficients1 = new int[this.maxPower];
		int[] coefficients2 = new int[polyAdd.maxPower];
		int[] coefficientsRes = new int[maxPower];

		Arrays.fill(coefficients1, 0);
		Arrays.fill(coefficients2, 0);
		Arrays.fill(coefficientsRes, 0);	
		
		coefficients1 = this.getCoefficients();
		coefficients2 = polyAdd.getCoefficients();
		
		switch (k)
		{
		case 1:
			for( int i = 0; i < polyAdd.maxPower; i++ )
			{
				coefficientsRes[i] = coefficients1[i] + coefficients2[i];
			}
			for( int i = polyAdd.maxPower; i < this.maxPower; i++)
			{
				coefficientsRes[i] = coefficients1[i] + 0;
			}
			
			break;
		case 2:
			for( int i = 0; i < this.maxPower; i++ )
			{
				coefficientsRes[i] = coefficients1[i] + coefficients2[i];
			}
			for( int i = this.maxPower; i < polyAdd.maxPower; i++)
			{
				coefficientsRes[i] = 0 + coefficients2[i];
			}
			
			break;
			
		}		
		result.setElements(coefficientsRes);
		
		return result;
	}
	
	//subtract 2 polynomials
	//return = this - polySub
	public Polynomial subtractPolynomials(Polynomial polySub)
	{
		Polynomial result = new Polynomial();
		result.initialize();
		
		int maxPower = 0;
		int k = 0;
		
		if (this.maxPower > polySub.maxPower)
		{
			maxPower = this.maxPower;
			k = 1;
		}
		else
		{
			maxPower = polySub.maxPower;
			k = 2;
		}		

		result.setMaxPower(maxPower);

		int[] coefficients1 = new int[this.maxPower];
		int[] coefficients2 = new int[polySub.maxPower];
		int[] coefficientsRes = new int[maxPower];

		Arrays.fill(coefficients1, 0);
		Arrays.fill(coefficients2, 0);
		Arrays.fill(coefficientsRes, 0);

		coefficients1 = this.getCoefficients();
		coefficients2 = polySub.getCoefficients();
		
		switch (k)
		{
		case 1:
			for( int i = 0; i < polySub.maxPower; i++ )
			{
				coefficientsRes[i] = coefficients1[i] - coefficients2[i];
			}
			for( int i = polySub.maxPower; i < this.maxPower; i++)
			{
				coefficientsRes[i] = coefficients1[i] - 0;
			}
			
			break;
		case 2:
			for( int i = 0; i < this.maxPower; i++ )
			{
				coefficientsRes[i] = coefficients1[i] - coefficients2[i];
			}
			for( int i = this.maxPower; i < polySub.maxPower; i++)
			{
				coefficientsRes[i] = 0 - coefficients2[i];
			}
			
			break;
			
		}
		result.setElements(coefficientsRes);
		
		return result;
	}

	//multiply 2 polynomials
	//return = this * polyMul
	public Polynomial multiplyPolynomials(Polynomial polyMul)
	{
		Polynomial result = new Polynomial();
		result.initialize();
		
		int maxPower = 0;
		
		maxPower = this.maxPower;
		maxPower = maxPower + polyMul.maxPower - 1;		
		
		int[] coefficients1 = new int[this.maxPower];
		int[] coefficients2 = new int[polyMul.maxPower];
		int[] coefficientsRes = new int[maxPower];

		Arrays.fill(coefficients1, 0);
		Arrays.fill(coefficients2, 0);
		Arrays.fill(coefficientsRes, 0);
		
	 	coefficients1 = this.getCoefficients();
		coefficients2 = polyMul.getCoefficients();
		
		for( int i = 0; i < this.maxPower; i++ )
		{
			for( int j = 0; j < polyMul.maxPower; j++ )
			{
					coefficientsRes[i + j] = coefficientsRes[i + j] + coefficients1[i] * coefficients2[j];
			}
		}		
		result.setMaxPower(maxPower);
		result.setElements(coefficientsRes);
		
		return result;
	}

	//differentiate a polynomial
	//return = d(this) / d(x)
	public Polynomial differentiatePolynomial()
	{
		Polynomial result = new Polynomial();
		result.initialize();		
		
		int[] coefficientsRes = new int[this.maxPower];

		Arrays.fill(coefficientsRes, 0);
		
		coefficientsRes = this.getCoefficients();		
		
		for (int i = 0; i < this.maxPower - 1; i++)
		{
			coefficientsRes[i] = coefficientsRes[i + 1] * (i + 1);
		}		
		result.setMaxPower(this.maxPower - 1);
		result.setElements(coefficientsRes);
		
		return result;
	}
}
