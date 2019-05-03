package a6;

import java.util.Iterator;

public class PriceThresholdBeltIterator implements Iterator{

	private Belt belt;
	private int start_position;
	private double max_price;
	private int lastPosition;

	public PriceThresholdBeltIterator(Belt belt, int start_position, double max_price) {
		this.belt = belt;
		this.start_position = start_position;
		this.max_price = max_price;
		this.lastPosition = -1;
	}
	
	public Plate next() {
		if(!hasNext()) {
			throw new  java.util.NoSuchElementException();
		}
		Plate plate = belt.getPlateAtPosition(start_position);
		lastPosition = start_position;
		start_position ++;
		return plate ;
	}
	
	boolean n = true;
	public boolean hasNext() {
		for(int i = 0; i <belt.getSize(); i++) {
			if((belt.getPlateAtPosition(start_position) != null) && belt.getPlateAtPosition(start_position).getPrice() <= max_price) {
				return true;
			} else {
				start_position++;
			}
		}
		return false;
	}
	
}
