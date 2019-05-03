package a1;

import java.util.Scanner;

public class A1Adept {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int itemCount = scan.nextInt();
		double[] PArray = new double[itemCount];
		String[] itemNme = new String[itemCount];
		
		for (int i = 0; i < itemCount; i++) {
			itemNme[i] = scan.next();
			PArray[i] = scan.nextDouble();
		}
		
		int Ccounter = scan.nextInt();
		String[] nAMES = new String[Ccounter];
		double[] iiTotals = new double[Ccounter];
		
		for (int i = 0; i < Ccounter; i++) {
			
			nAMES[i] = scan.next() + " " + scan.next();
			int distinctItems = scan.nextInt();
			iiTotals[i] = 0;
			
			for (int j = 0; j < distinctItems; j++) {
				
				int iiAmount = scan.nextInt();
				String name = scan.next();
				int index = 0;
				
				while (!itemNme[index].equals(name)) {
					index++;
				}
				iiTotals[i] += iiAmount * PArray[index];
			}
		}
		
		double thheBiggest = 0;
		
		for (int i = 0; i < iiTotals.length; i++) {
			if (iiTotals[i] > thheBiggest) {
				thheBiggest = iiTotals[i];
			}
		}
		
		int iiNDEX = 0;
		
		while (iiTotals[iiNDEX] != thheBiggest) {
			iiNDEX++;
		}
		
		int biggestIndex = iiNDEX;
		iiNDEX = 0;
		double theSmmalest = thheBiggest;
		double sum = 0;
		
		for (int i = 0; i < iiTotals.length; i++) {
			if (iiTotals[i] < theSmmalest) {
				theSmmalest = iiTotals[i];
			}
			sum += iiTotals[i];
		}
		
		while (iiTotals[iiNDEX] != theSmmalest) {
			iiNDEX++;
		}
		
		int smallestIndex = iiNDEX;
		double iiAdverage = sum / iiTotals.length;
		
		System.out.println("Biggest: " + nAMES[biggestIndex] + " (" + String.format("%.2f", iiTotals[biggestIndex]) + ")");
		System.out.println("Smallest: " + nAMES[smallestIndex] + " (" + String.format("%.2f",iiTotals[smallestIndex]) + ")");
		System.out.println("Average: " + String.format("%.2f", iiAdverage));
	}
}
