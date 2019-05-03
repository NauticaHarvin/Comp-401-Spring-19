package a6;


public class Roll implements Sushi {

	private String name;	
	private IngredientPortion[] ingredients;


	public Roll(String name, IngredientPortion[] roll_ingredients) {
		if(roll_ingredients == null) {
			throw new RuntimeException("nope");
		}
		if(name == null) {
			throw new RuntimeException("nope");
		}


		for(int i = 0; i < roll_ingredients.length; i++) {
			if(roll_ingredients[i] == null)
				throw new RuntimeException("nope");
		}

		this.name = name;
		this.ingredients = roll_ingredients.clone();


	
		
	}
	
//	
//	for(int i = 1; i < roll_ingredients.length; i++) {
//		boolean combine = false;
//		for(int j =0; j < ingredients.size(); i++) {
//			if(roll_ingredients[i].getIngredient().equals(ingredients.get(j).getIngredient())) {
//				ingredients.add(ingredients.get(j).combine(roll_ingredients[i]));
//				ingredients.remove(j);
//				combine=true;
//				break;
//			}
//		}
//		if(combine != true) {
//			ingredients.add(roll_ingredients[i]);
//		}
//	}
//	for(int i = 0; i < ingredients.size(); i++) {
//		if(ingredients.get(i).getIngredient().equals(seaweed.getIngredient())) {
//			hasSeaweed = true;
//			break;
//		}
//	}
//}
//	

	
	
	

	
	


	public String getName() {
		return name;
	}


	public IngredientPortion[] getIngredients() {
		return ingredients.clone();
	}


	public int getCalories() {
		return (int) ((Math.ceil((ingredients[0].getIngredient().getCaloriesPerOunce()) * 3.05)));
	}


	public double getCost() {
		double costAll = 0.00; 
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

}


	
