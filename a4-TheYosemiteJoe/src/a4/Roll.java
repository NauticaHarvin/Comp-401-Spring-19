package a4;

import java.util.ArrayList;

public class Roll implements Sushi {

	private String name;	
	private IngredientPortion[] ingredients;


//	public Roll(String name, IngredientPortion[] roll_ingredients) {
//		if(roll_ingredients == null) {
//			throw new RuntimeException("nope");
//		}
//		if(name == null) {
//			throw new RuntimeException("nope");
//		}
//
//
//		for(int i = 0; i < roll_ingredients.length; i++) {
//			if(roll_ingredients[i] == null)
//				throw new RuntimeException("nope");
//		}
//
//		
//		this.name = name;
//		this.ingredients = roll_ingredients.clone();
	public Roll(String name, IngredientPortion[] roll_ingredients) {
	this.name = name;
		this.ingredients = roll_ingredients.clone();
		
		if (this.ingredients.clone() == null) {
			throw new RuntimeException("Ingredient portion array must not be null");
		}
				
		for (int i = 0; i < this.ingredients.clone().length; i++) {
			if (this.ingredients[i] == null) {
				throw new RuntimeException("Ingredients cannot be null");
			}
		}
		
		IngredientPortion[] arr = ingredients.clone();
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != null) {
				for (int j = 0; j < arr.length; j++) {
					if (i != j && arr[j] != null) {
						if (arr[i].getIngredient().equals(arr[j].getIngredient())) {
							arr[i] = arr[i].combine(arr[j]);
							arr[j] = null;
						}
					}
				}
			}
		}
		
		ArrayList<IngredientPortion> ingList = new ArrayList<IngredientPortion>();
	
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != null) {
				ingList.add(arr[i]);
			}
		}
		
		IngredientPortion[] arr2 = new IngredientPortion[ingList.size()];
		
		for (int i = 0; i < ingList.size(); i++) {
			arr2[i] = ingList.get(i);
		}
		
		if (!hasSeaweed(arr2)) {
			for (int i = 0; i < arr2.length; i++) {
				if (arr2[i].getName().equals("seaweed")) {
					ingList.remove(i);
				}
			}
			IngredientPortion newSeaweed = new SeaweedPortion(.1);
			ingList.add(newSeaweed);
		}
		
		IngredientPortion[] ingF = new IngredientPortion[ingList.size()];
		
		for (int i = 0; i < ingList.size(); i++) {
			ingF[i] = ingList.get(i);
		}

		this.ingredients = ingF;
	}


	

	

	public String getName() {
		return name;
	}


//	public IngredientPortion[] getIngredients() {
//		return ingredients.clone();
//

	public IngredientPortion[] getIngredients() {
	for (int i = 0; i < ingredients.length; i++) {
		if (ingredients[i] != null) {
			for (int j = 0; j < ingredients.length; j++) {
				if (i != j && ingredients[j] != null) {
					if (ingredients[i].getIngredient().equals(ingredients[j].getIngredient())) {
						ingredients[i] = ingredients[i].combine(ingredients[j]);
						ingredients[j] = null;
					}
				}
			}
		}
	}
	return ingredients;
	}
	
	public int getCalories() {
		return (int) ((Math.ceil((ingredients[0].getIngredient().getCaloriesPerOunce()) * 3.05)));
	}


	public double getCost() {
		double costAll = 0; 
		for(int i = 0; i < ingredients.length; i++) {
			costAll += ingredients[i].getCost();

		}
		return Math.floor(costAll * 100) / 100;	
	}


	public boolean getHasRice() {
		for(int i = 0; i < ingredients.length; i++) {
			if(ingredients[i].getIsRice() == true) {
				return true;
			}
		}
		return false;
	}

	public boolean getHasShellfish() {
		for(int i = 0; i < ingredients.length; i++) {
			if(ingredients[i].getIsShellfish() == true) {
				return true;
			}
		}
		return false;

	}


	public boolean getIsVegetarian() {
		for(int i = 0; i < ingredients.length; i++) {
			if(ingredients[i].getIsVegetarian() == true) {
				return true;
			}
		}
		return false;
	}

	public boolean hasSeaweed(IngredientPortion[] input) {
		for (int i = 0; i < input.length; i++) {
			if (input[i].getName().equals("seaweed") && input[i].getAmount() >= 0.1) {
				return true;
			}
		}
		return false;
	}
}



