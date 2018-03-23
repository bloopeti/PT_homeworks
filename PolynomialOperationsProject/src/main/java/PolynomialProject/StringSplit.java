package PolynomialProject;
import java.util.Arrays;
//import java.io.*;

public class StringSplit {

	public static int splitInputPower(String in)
	{
		int locMaxPower = 0;
		int tempPower = 0;
		
		int j = 0;
		
		String value = "";
		
		char[] tempArr = new char[in.length()];
		
		for(int i = 0; i < in.length(); i++)
		{
			tempArr[i] = in.charAt(i);
		}
				
		for(int i = 0; i < tempArr.length; i++)
		{			
			if (tempArr[i] == '^')
				{
					j = i + 1 ;
					while((j < (tempArr.length)) && (tempArr[j] != ' '))
					{
						value = value + String.valueOf(tempArr[j]);
						j = j+1;
					}
					
					tempPower = Integer.parseInt(value);
					
					if (tempPower > locMaxPower)
					{
						locMaxPower = tempPower;
					}
					
					value = "";
					j = 0;
				}			
		}		
		locMaxPower = locMaxPower + 1;
		
		return locMaxPower;
	}
	
	public static int[] splitInputCoefficients(String in, int maxPower)
	{
		char[] tempArr = new char[in.length()];
		
		for(int i = 0; i < in.length(); i++)
		{
			tempArr[i] = in.charAt(i);
		}		
			
		int[] locCoefficients = new int[maxPower];
		Arrays.fill(locCoefficients, 0);	
		
		int locCoeff = 666;
		
		int j = 0;
		int tempPower = 0;
		String value = "";
				
		if(tempArr[0] != ' ')
		{
			j = 0;
			value = "";
			
			while((j < tempArr.length) && (tempArr[j] != 'x'))
			{
				value = value + String.valueOf(tempArr[j]);
				j = j + 1;
			}
			
			if (j != (0))
			{
				locCoeff = Integer.parseInt(value);
			}
		}
		
		for(int i = 0; i < tempArr.length; i++)
		{
			
			switch (tempArr[i])
			{
			case '^':
				{					
					j = 0;
					value = "";
					
					j = i + 1 ;
					while((j < (tempArr.length)) && (tempArr[j] != ' '))
					{
						value = value + String.valueOf(tempArr[j]);
						j = j+1;
					}
					
					if(j != (i + 1))
					{
						tempPower = Integer.parseInt(value);
						locCoefficients[tempPower] = locCoeff;
					}							
				}				
				break;
				
			case ' ':				
				{
					j = 0;
					value = "";
					
					j = i + 1 ;
					while((j < tempArr.length) && (tempArr[j] != 'x'))
					{
						value = value + String.valueOf(tempArr[j]);
						j = j + 1;
					}
					
					if (j != (i + 1))
					{
						locCoeff = Integer.parseInt(value);
					}										
				}				
				break;
			}
		}
		return locCoefficients;		
	}

	
}
