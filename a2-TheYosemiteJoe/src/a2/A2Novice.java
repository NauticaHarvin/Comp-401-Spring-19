package a2;

import java.util.Scanner;

public class A2Novice {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		// An integer number that indicates the number of ingredients. 
		int numOfIndegeridents = scan.nextInt();
		int vegeteriancount = 0;

		// Ingredients, PPO, Is Vegetarian, Calories

		/*
		String nmeOfIndergridents = "";
		Double pricePerOunce = 0.00 ;
		Boolean isVegetarian = null;
		Double caloriePerOunce = 0.00; 	
		Double caloriePerDollar = caloriePerOunce/pricePerOunce;
		 */

		double highestCal = Double.MIN_VALUE;
		double lowestCal  = Double.MAX_VALUE;
		String lowCal = "";
		String highCal = "";

		for (int i = 0; i < numOfIndegeridents; i++) {
			String nmeOfIndergridents = scan.next();
			double pricePerOunce  = scan.nextDouble();
			boolean isVegetarian  = scan.nextBoolean();
			double caloriePerOunce  = scan.nextDouble();
			double caloriePerDollar = caloriePerOunce/pricePerOunce;



			if (isVegetarian) {
				vegeteriancount ++;
			}

			if(caloriePerDollar < lowestCal) {
				lowestCal = caloriePerDollar; 
				lowCal = nmeOfIndergridents; 

			}


			if(caloriePerDollar > highestCal) {
				highestCal = caloriePerDollar; 
				highCal = nmeOfIndergridents;

			}



		}
		System.out.println("Number of vegetarian ingredients :" + vegeteriancount);
		System.out.println("Highest cals/$: " + highCal);
		System.out.println("Lowest cals/$: " +  lowCal);
	}

}
;