package a4;

public class Main implements Ingredient{ 
	
    // Ingredients have  fields  
    protected String name; 
    protected double pricePerOz; 
    protected int caloriesPerOz; 
    protected boolean isVegetarian; 
    protected boolean isRice; 
    protected boolean isShellfish;

    
    public Main(String name, double pricePerOz, int caloriesPerOz, boolean isVegetarian, boolean isRice, boolean isShellfish) {
		//this.className = className;
		this.name = name;
	this.pricePerOz = pricePerOz;
		this.caloriesPerOz = caloriesPerOz;
		this.isVegetarian = isVegetarian;
		this.isRice = isRice;
		this.isShellfish = isShellfish;
		
		}


	
	public String getName() {
		return this.name;
	}

	public double getCaloriesPerDollar() {
		return (this.caloriesPerOz/ this.pricePerOz);
	}

	public int getCaloriesPerOunce() {
		return this.caloriesPerOz;
	}

	public double getPricePerOunce() {		
		return this.pricePerOz;
	}

	public boolean equals(Ingredient other) {
		if ((this.getName().equals(other.getName()))) {
				 
			return true;
		}else {
			return false;
		}
	}

	public boolean getIsVegetarian() {
		return isVegetarian;
	}

	public boolean getIsRice() {
		return isRice;
	}

	public boolean getIsShellfish() {
		return isShellfish;
	}

    }
	

 