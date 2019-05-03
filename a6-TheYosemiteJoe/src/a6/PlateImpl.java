package a6;


public class PlateImpl implements Plate{

	private Sushi contents;
	private Plate.Color color;
	private double price;
	
	public PlateImpl(Sushi contents, Plate.Color color, double price) {

		this.contents = contents;
		this.color = color;
		this.price = price;
	}

	public Sushi getContents() {
		if(contents == null) {
			return null;
		}else {
			return contents;
		}		
	}

	public Sushi removeContents() {
		if(contents == null) {
			return null;
		}else {
			Sushi nullCon = contents ;
			contents = null;
		
		return nullCon;		
		}
	}

	public void setContents(Sushi s) throws PlatePriceException {
		contents = s;
		if(s == null) {
			throw new  IllegalArgumentException("Nahh Bro");
		}
		
		if(price <= s.getCost()) {
			throw new PlatePriceException();
		}
	}

	public boolean hasContents() {
		if(this.contents == null) {
			return false;
		}else { 
			return true;
		}
	}

	
	public double getPrice() {
		return price;
	}

	public Color getColor() {
		return color;
	}

	
	public double getProfit() {
		if(this.contents == null) {
			return 0.0;
		}else {
			//return -(((contents.getCost() - this.price)*100)/100);
			double profit = price - contents.getCost();
			
			
		return (((int) ((profit * 100.0) + 0.5)) / 100.0) - 0.01;
		}
	}
}
