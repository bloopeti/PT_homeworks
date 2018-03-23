package PolynomialProject;

public class StringSplitTest {
	
	public static void main(String args[])
	{
		String polyIn = "+1x^0 -5x^40 +10x^4";
		int maxPower = 0;
		int[] coefficients = new int[50];
		
		maxPower = StringSplit.splitInputPower(polyIn);
		System.out.println(maxPower);

		
		coefficients = StringSplit.splitInputCoefficients(polyIn, maxPower);
		for (int i = 0; i < coefficients.length; i++)
		{
			System.out.print(coefficients[i]);
			System.out.print(".");
		}
		
	}
}
