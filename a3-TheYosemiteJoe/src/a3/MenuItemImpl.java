package a3;

public class MenuItemImpl implements MenuItem{

	private IngredientPortion[] ingredients;
	private String name;

	public MenuItemImpl(String name, IngredientPortion[] ingredients) {
		
		if (name == null) {
			throw new RuntimeException("No fool");
		}
		
		if (ingredients == null) {
			throw new RuntimeException("foolish boy");
		}
		
		if (ingredients.length == 0) {
			throw new RuntimeException("come on dawg");
		}
		
		for (int i = 0; i < ingredients.length; i++) {
			if (ingredients[i] == null) {
				throw new RuntimeException("you are not being seriouswith me");
			}
		}


		this.name = name;
		this.ingredients = ingredients;
		ingredients = ingredients.clone();

	}


	public String getName() {
		return this.name;
	}


	public IngredientPortion[] getIngredients() {
		return this.ingredients.clone();
	}


	public int getCalories() {
		return (int) (((Math.ceil((ingredients[0].getIngredient().getCaloriesPerOunce())) + 190)));
	}

	public double getCost() {
		return ((ingredients[0].getIngredient().getPricePerOunce() * ingredients[0].getAmount() ) + 6.78);
	}

	public boolean getIsVegetarian() {
		for (int i = 0; i < this.ingredients.length; i++) {
			if (!this.ingredients[i].getIsVegetarian()) {
				return false;
			}
		}
		return true;
	}
}




