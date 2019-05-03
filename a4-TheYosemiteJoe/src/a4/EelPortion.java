package a4;

public class EelPortion extends MainIngredientPortion {
	
	

	public EelPortion(double amount) {
	super(new Eel(), amount);

	
}
}


/*
 * package a4;


public class EelPortion extends MainIngredientPortion implements IngredientPortion{

	public EelPortion(double amount) {
		super(new Eel(), amount);



	}
	public IngredientPortion combine(IngredientPortion other) {
		if(other == null) {
			return this;
		}

		if (!other.getIngredient() .equals(this.getIngredient())) {
			throw new RuntimeException("they dont match");
		}
		
		return (new EelPortion(other.getAmount() + this.getAmount()));
	}

}
 */