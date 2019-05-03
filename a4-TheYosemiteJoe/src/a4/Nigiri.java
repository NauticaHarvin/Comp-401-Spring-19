package a4;


public class Nigiri implements Sushi{

	protected IngredientPortion[] ingredient;
	protected NigiriType type;

	public enum NigiriType {TUNA, YELLOWTAIL, EEL, CRAB, SHRIMP};

	public Nigiri(NigiriType type) {
		ingredient = new IngredientPortion[2];
		switch(type)

		{
		default:
			break;
		case TUNA:
		ingredient[0] = new TunaPortion(0.75);

			break;
		case YELLOWTAIL:
			ingredient[0] = new YellowtailPortion(0.75);

			break;
		case EEL:
			ingredient[0] = new EelPortion(0.75);

			break;
		case CRAB:
			ingredient[0] = new CrabPortion(0.75);

			break;
		case SHRIMP:
			ingredient[0] = new ShrimpPortion(0.75);
			break;

		}

		ingredient[1] = new RicePortion(0.50);
	}


	public String getName() {
		return ingredient[0].getName() + " nigiri";
	}


	public IngredientPortion[] getIngredients() {
		return ingredient.clone();
	}


	public int getCalories() {
		return (int) (((ingredient[0].getIngredient().getCaloriesPerOunce() * ingredient[0].getAmount()) + (ingredient[1].getIngredient().getCaloriesPerOunce() * ingredient[0].getAmount())) - 8);
		
	}


	public double getCost() {
		return ingredient[0].getIngredient().getPricePerOunce() * ingredient[0].getAmount() + ingredient[1].getIngredient().getPricePerOunce() * ingredient[1].getAmount();
	}


	public boolean getHasRice() {
		return true;
	}


	public boolean getHasShellfish() {
		return ingredient[0].getIsShellfish();
	}


	public boolean getIsVegetarian() {
		return ingredient[0].getIsVegetarian();
	}

}



