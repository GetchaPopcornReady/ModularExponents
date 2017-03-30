package edu.ilstu;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class ModularExponential
{

	//Need exceptions for things that cant work
	// What big numbers do not work???
	//

	public static void main(String[] args)
	{
		
		Scanner keyboard = new Scanner(System.in);
		
		System.out.print("What is the base number: ");
		int baseNumber = keyboard.nextInt();
		
		System.out.print("What is the exponential number: ");
		int exponentialNumber = keyboard.nextInt();
		
		System.out.print("What is the modular number: ");
		int modularNumber = keyboard.nextInt();
		
		//Changed to User Input
//		int baseNumber = 4000;
//		int exponentialNumber = 100000;
//		int modularNumber = 54353;
		int calculatedNumber = 0;
	//	System.out.println(Math.pow(baseNumber,2));
		
		int countNumber = 2;
		System.out.println(baseNumber + "^   1 =    "  +  "calculatedNumber: " + baseNumber);
		calculatedNumber = (int) Math.pow(baseNumber,2) % modularNumber ;
		System.out.println(baseNumber + "^   2 =    "  +  "calculatedNumber: " + calculatedNumber);
		
		
		ArrayList<Integer> powers = new ArrayList<Integer>();
		powers.add(1);
		powers.add(2);
		
		ArrayList<Integer> calcNumbers = new ArrayList<Integer>();
		calcNumbers.add(baseNumber);
		calcNumbers.add(calculatedNumber);
		while(countNumber < exponentialNumber )
		{
			
			
			
			
			
			countNumber = countNumber * 2;
			System.out.print(baseNumber + "^  " + countNumber + " = ");
			
			calculatedNumber = (int) Math.pow(calculatedNumber,2) % modularNumber ;
			System.out.println(" calculatedNumber: " + calculatedNumber + " ");
			
			//Add exponents to arraylist
			powers.add(countNumber);
			calcNumbers.add(calculatedNumber);
		
			
		}
			//ONE ISNT THERE
//		calcNumbers.remove(calcNumbers.size()-1);
//		calcNumbers.remove(calcNumbers.size()-2);
//		
		//These Indexes are aligned!
		System.out.println(powers.toString());
		
		System.out.println(calcNumbers.toString());
		System.out.println("Calculating...");
		
		int powersSIZE = powers.size();
		
		//go through arrayList and add the powers until they add to exponential number
		
		//random number of items you will grab from the powers List
//		Random random1 = new Random();
//		int RANDOM = random1.nextInt(powersSIZE) + 1;
		
		ArrayList<Integer> indexedNumbers = new ArrayList<Integer>();
		
		
		int tryingExponential = 0;
		int count = 0;
		while(tryingExponential != exponentialNumber)
		{
			Random random1 = new Random();
			int RANDOM = random1.nextInt(powersSIZE) + 1;
		
		while(count < RANDOM)
		{
			Random random2 = new Random();
			//this is the index of powers Array
			int RANDOM2 = random2.nextInt(powersSIZE-1); //+ 1;
			
			indexedNumbers.add(powers.get(RANDOM2));
			
			tryingExponential = tryingExponential + powers.get(RANDOM2);
			
			
			
			count++;
			//System.out.println(count +" " + tryingExponential) ;
		}
			if(isDuplicate(indexedNumbers) == true)
			{
				indexedNumbers.clear();
				count = 0;
				tryingExponential = 0;
			}
			if(tryingExponential == exponentialNumber)
			{
				break;
			}
			
			indexedNumbers.clear();
			count = 0;
			tryingExponential = 0;
			
		}
		
/////////////
///TEST CASE
/////////////
		
		//WHEN PRINTING: takes an approximate 10 seconds to find the combination for a 4 digit expoentialNumber
		//STRAIGHT UP: 2 seconds
//		System.out.println("tryingExpoenential = " + tryingExponential);
//		
//		System.out.println("Power List: " + indexedNumbers.toString());
		

		//baseNumber ^power.get(1) % modular number
		
		
		//////////
		//Close
		//////////
		int arithmeticAnswer;
		//powers?
		arithmeticAnswer = modularArithmetic(baseNumber, modularNumber, indexedNumbers);
		
		System.out.print("Modular equivalent: ");
		System.out.println(arithmeticAnswer);
		
		
		
	}
	//end main
	
	
	//returns true if there is a duplicate in the arrayList
		private static boolean isDuplicate(ArrayList<Integer> intList)
		{
			//Should sort the list from greatest to smallest
			Collections.sort(intList);
			
			for(int i = 1; i < intList.size(); i++) 
			{
			    if(intList.get(i) == intList.get(i - 1)) 
			    {
			      return true;
			    	// System.out.println("Duplicate: " + intList.get(i));
			    }
			}
				  return false;
		}
		
		//pass in an arrayList 
		private static int modularArithmetic(int baseNumber, int modularNumber,ArrayList<Integer> powerList)
		{
			int answer = 1;
			int count = 0;
			
			
			while(count < powerList.size()) //correct
			{
				
//				System.out.print("Exponent: " + powerList.get(count)+ " Answer:");
//				
//				int exponentAnswer = (int) Math.pow(baseNumber, powerList.get(count));
//				
//			//	answer = answer * baseNumber ^ powerList.get(count) % modularNumber;
//				int Tempanswer = (exponentAnswer % modularNumber);
//				
//				answer = (answer * Tempanswer) % modularNumber;
//				
				
				BigInteger BIbase,BIpower,BImod, BIans,BIfinal;
				
				String strPower = powerList.get(count) + "";
				
				BIpower = new BigInteger(strPower);
		
				String strBase = baseNumber + "";
				
				BIbase = new BigInteger(strBase);
				
				String strMod = modularNumber + "";
				
				BImod = new BigInteger(strMod);
				
				BIans = BIbase.modPow(BIpower, BImod);
				
				int bigIntBACK = BIans.intValue();
				
//				String strFinal = answer + "";
//				
//				BIfinal = new BigInteger(strFinal);
				
				answer = (answer * bigIntBACK) % modularNumber;
				//	answer = answer * baseNumber ^ powerList.get(count) % modularNumber;
				
				
				
				
//				// create 2 BigInteger objects
//				BigInteger bi1, bi2,bi3,bi4;
		//
		//	
		//
//				// assign value to bi1
//				bi1 = new BigInteger("1994");
		//
//				bi3 = new BigInteger("9410");
//				
//				bi4 = new BigInteger("62703");
//				// perform pow operation on bi1 using exponent
//				bi2 = bi1.modPow(bi3, bi4);
//				
//				
				
				
				//System.out.println(answer);

				count++;
			}
			
			
			return answer;
			
		}
		
	
}
