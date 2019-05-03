package a3;

public class IngredientPortionImpl implements IngredientPortion{

	private Ingredient ing;
	private double amount;

	public IngredientPortionImpl(Ingredient ing, double amount) {
	
		this.ing = ing;
		this.amount = amount;
				

		if(ing == null) {
			throw new RuntimeException("Sorry but no");
		}

		if(amount < 0) {
			throw new RuntimeException("Sorry but no");
		}
	}

	public IngredientPortion combine(IngredientPortion other) {

		if(other == null) {
			return this;
		} else if (this.getIngredient().getName() != other.getIngredient().getName()) {
			throw new RuntimeException("they dont match");
		} else {
			this.amount += other.getAmount();

		}
		return this;

	}



	public Ingredient getIngredient() {
		return ing;
	}

	public double getAmount() {
		return (amount);
	}

	public String getName() {
		return ing.getName();
	}

	public boolean getIsVegetarian() {
		return ing.getIsVegetarian();
	}

	public double getCalories() {
		return (ing.getCaloriesPerOunce() * amount); 
	}

	public double getCost() {
		return ing.getPricePerOunce() * amount;
	}
	
	
}

