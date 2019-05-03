 package a5;


public class MainIngredientPortion implements IngredientPortion {

	protected Ingredient ing;
	protected double amount;
//	protected String Name;
//	protected double Calories;
//	protected double Cost;
//	protected boolean isRice;
//	protected boolean isShellfish;
//	protected boolean isVegetarian;
	
	public MainIngredientPortion(Ingredient ing, double amount) {
		
//		
		this.ing = ing;
		this.amount = amount;
//		this.Name = ing.getName();
//		this.Calories = ing.getCaloriesPerOunce() * amount;
//		this.Cost = ing.getPricePerOunce() * amount;
//		this.isRice = ing.getIsVegetarian();
//		this.isShellfish = ing.getIsShellfish();
//		this.isVegetarian = ing.getIsVegetarian();
		if(ing == null) {
			throw new RuntimeException("cfxcgh");
		}
		if(amount <= 0 ) {
			throw new RuntimeException("Sorry idiot");
		}
	}

	public Ingredient getIngredient() {
		return this.ing;
	}

	public String getName() {
		return ing.getName();
	}

	public double getAmount() {
		return amount;
	}

	public double getCalories() {
		return ing.getCaloriesPerOunce() * amount;
	}

	public double getCost() {
		return ing.getPricePerOunce() * amount;
	}

	public boolean getIsVegetarian() {
		return ing.getIsVegetarian();
	}

	public boolean getIsRice() {
		return ing.getIsRice();
	}

	public boolean getIsShellfish() {
		return ing.getIsShellfish();
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

	
	}




/*
 package a4;


public class MainIngredientPortion implements IngredientPortion {

	private Ingredient ing;
	private double amount;
	private Ingredient Ingredient;
	private String Name;
	private double Amount;
	private double Calories;
	private double Cost;
	private boolean IsVegetarian;
	private boolean IsRice;
	private boolean IsShellfish;


	public MainIngredientPortion(Ingredient ing, double amount) {
		if(amount < 0 ) {
			throw new RuntimeException();
		}
		
		this.ing = ing;
		this.amount = amount;


	}

	public Ingredient getIngredient() {
		return Ingredient;
	}

	public String getName() {
		return Name;
	}

	public double getAmount() {
		return Amount;
	}

	public double getCalories() {
		return Calories;
	}

	public double getCost() {
		return Cost;
	}

	public boolean getIsVegetarian() {
		return IsVegetarian;
	}

	public boolean getIsRice() {
		return IsRice;
	}

	public boolean getIsShellfish() {
		return IsShellfish;
	}

	public IngredientPortion combine(IngredientPortion other) {
		return other;
	}
}





 * 
 */


