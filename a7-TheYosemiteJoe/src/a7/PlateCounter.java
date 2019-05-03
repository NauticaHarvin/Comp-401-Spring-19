
package a7;

import comp401sushi.Plate;

public class PlateCounter implements BeltObserver {

	
	private int blueCount;
	private int goldCount;
	private int redCount;
	private int greenCount;
	private Belt b;
	
	
	public PlateCounter (Belt b) {
		if (b == null) {
			
			throw new IllegalArgumentException();
		}
		
		this.b = b;
	    this.b.addBeltObserver(this);
		
		redCount = 0;
		greenCount = 0;
		blueCount = 0;
		goldCount = 0;
		
		for (int i = 0; i < b.getSize(); i++) {
			if (b.getPlateAtPosition(i) == null) {
				continue;
			}
			
			switch (b.getPlateAtPosition(i).getColor()) {
			
			case BLUE:
				this.blueCount++;
				break;
				
			case GOLD:
				this.goldCount++;
				break;
				
			case RED:
				this.redCount++;
				break;
				
			case GREEN:
				this.greenCount++;
				break;
			}
		}
	}
	
	

	public int getBluePlateCount() {
		return blueCount;
	}
	
	public int getGoldPlateCount() {
		return goldCount;
	}
	
	public int getRedPlateCount() {
		return redCount;
	}
	
	public int getGreenPlateCount() {
		return greenCount;
	}
	
	
	
	public void handlePlateEvent(PlateEvent e) {
		
		switch (e.getType()) {
		
		
		case PLATE_PLACED:
			addCounters(e.getPlate());
			break;
			
		case PLATE_REMOVED:
			subtractCounters(e.getPlate());
			break;
		}
	}
	
	public void addCounters(Plate p) {
		switch (p.getColor()) {
		
		case BLUE:
			this.blueCount++;
			break;
			
		case GOLD:
			this.goldCount++;
			break;
			
		case RED:
			this.redCount++;
			break;
			
		case GREEN:
			this.greenCount++;
			break;
		}
	}
	
	public void subtractCounters(Plate p) {
		switch (p.getColor()) {
		
		case BLUE:
			this.blueCount--;
			break;
			
		case GOLD:
			this.goldCount--;
			break;
			
		case RED:
			this.redCount--;
			break;
			
		case GREEN:
			this.greenCount--;
			break;
		}
	}
}
