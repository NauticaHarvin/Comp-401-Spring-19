package a5;

import a5.Sushi;

public class Sashimi implements Sushi  {

	protected IngredientPortion[] ingredients;
	protected SashimiType type;

	public enum SashimiType {TUNA, YELLOWTAIL, EEL, CRAB, SHRIMP};

	public Sashimi(SashimiType type) {
		ingredients = new IngredientPortion[1];
		switch(type)

		{
		default:
			break;
		case TUNA:
			ingredients[0] = new TunaPortion(0.75);
			break;
		case YELLOWTAIL:
			ingredients[0] = new YellowtailPortion(0.75);
			break;
		case EEL:
			ingredients[0] = new EelPortion(0.75);
			break;
		case CRAB:
			ingredients[0] = new CrabPortion(0.75);
			break;
		case SHRIMP:
			ingredients[0] = new ShrimpPortion(0.75);
			break;





		}

}


public String getName() {
	return ingredients[0].getName() + " sashimi";
}


public IngredientPortion[] getIngredients() {
	return ingredients.clone();
}


public int getCalories() {
	return (int) ((Math.ceil((ingredients[0].getIngredient().getCaloriesPerOunce()) * 0.75)));
}


public double getCost() {
	return (ingredients[0].getIngredient().getPricePerOunce() * ingredients[0].getAmount() );
}


public boolean getHasRice() {
	return true;
}


public boolean getHasShellfish() {
	return ingredients[0].getIsShellfish();
}


public boolean getIsVegetarian() {
	return ingredients[0].getIsVegetarian();
}

}



