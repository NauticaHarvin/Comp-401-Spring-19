package a1;

import java.util.Scanner;

public class A1Novice{

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);

		int totalCustomersNum = scan.nextInt();
		String[] cmrLastName = new String[totalCustomersNum];
		char[] firstLetter = new char[totalCustomersNum];
		double[] totalPrice = new double[totalCustomersNum];

		for (int n = 0; n < totalCustomersNum; n++) {

			String firstName = scan.next();
			char firstLetter1 = firstName.charAt(0);
			firstLetter[n] = firstLetter1;

			String lastName = scan.next();
			cmrLastName[n] = lastName;

			int num = scan.nextInt();

			double total = 0.0;

			for (int i = 0; i < num; i++) {
				int quantity = scan.nextInt();
				@SuppressWarnings("unused")
				String name = scan.next();
				double price = scan.nextDouble();
				total = (total + quantity * price) ;
				//total = total / 100;

			}
			//String formatPrice = String.format("%.2f", totalPrice[n]);
			
			totalPrice[n] = total;
			System.out.println(firstLetter[n] + ". " + cmrLastName[n] + ": " + String.format("%.2f", totalPrice[n]));

		}
	}
}


