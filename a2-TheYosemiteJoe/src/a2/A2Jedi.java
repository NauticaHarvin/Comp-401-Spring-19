package a2;

import java.util.Scanner;

public class A2Jedi {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		//Getting all my variables
		int lgth = scan.nextInt();
		double[] tOuncez = new double[lgth];
		String[] iinames = new String[lgth];
		
		//Starting the for loop
		for (int i = 0; i < lgth; i++) {
			iinames[i] = scan.next();
			scan.nextDouble();
			scan.next();
			scan.nextDouble();
			tOuncez[i] = 0;
		}
		
		int mLength = scan.nextInt();
		double[][] totalOzPerItem = new double[mLength][lgth];
		String[] meNames = new String[mLength];
		
		for (int i = 0; i < mLength; i ++) {
			meNames[i] = scan.next();
			int qofIngredients = scan.nextInt();
			String[] iiIngredients = new String[qofIngredients];
			double[] iiAmounts = new double[qofIngredients];
			int[] iiIndices = new int[qofIngredients];
			
			for (int j = 0; j < qofIngredients; j++) {
				iiIngredients[j] = scan.next();
				iiAmounts[j] = scan.nextDouble();
			}
			
			int index;
			
			for (int k = 0; k < qofIngredients; k++) {
				index = 0;
				while (!iiIngredients[k].equals(iinames[index])) {
					index++;
				}
				iiIndices[k] = index;
			}
			
			double[] ozPerItem = new double[lgth];
			
			for (int l = 0; l < lgth; l++) {
				ozPerItem[l] = 0;
			}
			
			for (int l = 0; l < qofIngredients; l++) {
				ozPerItem[iiIndices[l]] 
						+= iiAmounts[l];
			}
			
			for (int l = 0; l < lgth; l++) {
				totalOzPerItem[i][l] 
						= ozPerItem[l];
			}
		}
		
		double[] order = new double[mLength];
		
		for (int i = 0; i < mLength;
				i++) {
			order[i] = 0;
		}
		
		String next = scan.next();
		
		while (!next.equals
				("EndOrder")) {
			int index = 0;
			
			while (!meNames[index]
					.equals(next)) {
				index++;
			}
			
			order[index]++;
			next = scan.next();
		}
		
		for (int i = 0; i < order.length; i++) {
			for (int j = 0; j 
					< lgth; j++) {
				tOuncez[j] += order[i] * totalOzPerItem[i][j];
			}
		}
		
		//My Print Line
		System.out.println("The order will require:");
		for (int i = 0; i < lgth; i++) {
			System.out.println(String.format
					("%.2f", tOuncez[i]) + " ounces of " + iinames[i]);
		}
	}
}
