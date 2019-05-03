package a3;


import java.util.Scanner;

public class A3Jedi {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		Ingredient[] ing = new Ingredient[scan.nextInt()];
		
		for (int i = 0; i < ing.length; i++) {
			String IngredientName = scan.next();
			double IngredientPrice = scan.nextDouble();
			boolean IngredientisVegetarian = scan.nextBoolean();
			int IngredientCalories = scan.nextInt();
			
			
			ing[i] = new IngredientImpl(IngredientName, IngredientPrice, IngredientCalories, IngredientisVegetarian);			
		}
		
		MenuItem[] menu = new MenuItem[scan.nextInt()];
		
		for (int i = 0; i < menu.length; i++) {
			
			String name = scan.next();
			IngredientPortion[] recipe = new IngredientPortion[scan.nextInt()];
			
			for (int j = 0; j < recipe.length; j++) {
				
				String IngredientPName = scan.next();
				double IngredientPAmout = scan.nextDouble();
				int index = 0;
				
				while (!IngredientPName.equals(ing[index].getName())) {
					index++;
				}
				
				recipe[j] = new IngredientPortionImpl(ing[index], IngredientPAmout);
			}
			
			menu[i] = new MenuItemImpl(name, recipe);
		}
		
		int[] order = new int[menu.length];
		String next = scan.next();
		
		while (!next.equals("EndOrder")) {
			int index = 0;
			
			while (!menu[index].getName().equals(next)) {
				index++;
			}
			
			order[index]++;
			next = scan.next();
		}
		
		double[] totals = new double[ing.length];
		
		for (int i = 0; i < ing.length; i++) {
			
			double totalAmount = 0;
			String localName = ing[i].getName();
			
			for (int j = 0; j < menu.length; j++) {
				
				int length = menu[j].getIngredients().length;
				for (int k = 0; k < length; k++) {
					
					if (localName.equals(menu[j].getIngredients()[k].getName())) {
						totals[i] += menu[j].getIngredients()[k].getAmount() * order[j];
						break;
						
					}
				}
			}
		}
		System.out.println("The order will require:");
		for (int i = 0; i < totals.length; i++) {
			
			System.out.println(String.format("%.2f", totals[i]) + " ounces of " + ing[i].getName());
		}	
	}
}