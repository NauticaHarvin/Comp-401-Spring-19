package a6;

public class GoldPlate extends PlateImpl{

	public GoldPlate(Sushi contents, double price) throws PlatePriceException
	{
		super(contents,Plate.Color.GOLD,7.50);

		if(price <= 5.0) {
			throw new  IllegalArgumentException("Can't even do it cheif");
		}

	}
}