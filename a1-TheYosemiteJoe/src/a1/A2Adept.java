package a1;

import java.util.Scanner;

public class A2Adept {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int legh = scan.nextInt();
		String[] numOfIndegeridents = new String[legh];
		double[] prices = new double[legh];
		boolean[] iisVegetarian = new boolean[legh];
		double[] calories = new double[legh];
		
		for (int i = 0; i < legh; i++) {
			numOfIndegeridents[i] = scan.next();
			prices[i] = scan.nextDouble();
			if (scan.next().equals("true")) {
				iisVegetarian[i] = true;
			} else {
				iisVegetarian[i] = false;
			}
			calories[i] = scan.nextDouble();
		}
		
		int mLength = scan.nextInt();
		String[] mNames = new String[mLength];
		double[] mCalories = new double[mLength];
		double[] mPrices = new double[mLength];
		boolean[] mVegetarian = new boolean[mLength];
		
		for (int i = 0; i < mLength; i ++) {
			mNames[i] = scan.next();
			int qofIngredients = scan.nextInt();
			String[] iiofIngredients = new String[qofIngredients];
			double[] iiAmounts = new double[qofIngredients];
			int[] ingredientIndices = new int[qofIngredients];
			
			for (int j = 0; j < qofIngredients; j++) {
				iiofIngredients[j] = scan.next();
				iiAmounts[j] = scan.nextDouble();
			}
			
			int index;
			
			for (int k = 0; k < qofIngredients; k++) {
				index = 0;
				while (!iiofIngredients[k].equals(numOfIndegeridents[index])) {
					index++;
				}
				ingredientIndices[k] = index;
			}
			
			for (int l = 0; l < qofIngredients; l++) {
				mCalories[i] += calories[ingredientIndices[l]] * iiAmounts[l];
				mPrices[i] += (prices[ingredientIndices[l]] * iiAmounts[l]);
			}
			
			for (int m = 0; m < qofIngredients; m++) {
				if (iisVegetarian[ingredientIndices[m]]) {
					mVegetarian[i] = true;
				} else {
					mVegetarian[i] = false;
					break;
				}
			}		
		}
		
		//My Print Statement
		for (int i = 0; i < mLength; i++) {
			System.out.println(mNames[i] + ":");
			System.out.println("  " + ((int) (mCalories[i] + 0.5)) 
					+ " calories");
			
			System.out.println("  $" 
					+ String.format("%.2f", mPrices[i]));
			
			if (mVegetarian[i]) {
				System.out.println("  Vegetarian");
			} else {
				System.out.println("  Non-Vegetarian");
			} 
		}
	}
	
}
