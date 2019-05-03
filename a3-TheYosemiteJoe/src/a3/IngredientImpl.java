package a3;

public class IngredientImpl implements Ingredient {
	
	private String name;
	private double price;
	private int calories;
	private boolean is_vegetarian;


	public IngredientImpl(String name, double price, int calories, boolean is_vegetarian) {
		this.name = name;
		this.calories = calories;
		this.price = price;
		this.is_vegetarian = is_vegetarian;
		
		if (name == null || price <= 0.00 || calories <= 0) {
			throw new RuntimeException("What?");
		}

	}

	public String getName() {
		return name;
	}

	
	public boolean getIsVegetarian() {
		return is_vegetarian;
	}

	
	public double getPricePerOunce() {
		return price;
	}

	
	public int getCaloriesPerOunce() {
		return calories;
	}

	
	public double getCaloriesPerDollar() {
		return calories/price;
	}

}
