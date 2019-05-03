package a6;

import java.util.Iterator;

public class ColorFilteredBeltIterator implements Iterator{

	private Belt belt;
	private int start_position;
	private Plate.Color color;
	private int lastPosition;
	private boolean nope;


	public ColorFilteredBeltIterator(Belt belt, int start_position, Plate.Color color_filter) {
		this.belt = belt;
		this.start_position = start_position;
		this.color = color_filter;
		this.lastPosition = -1;
		nope = false;

	}
	
	
public Plate next() {
	

		if(!hasNext()) {
			throw new  java.util.NoSuchElementException();
		}
		Plate plate = belt.getPlateAtPosition(start_position);
	//	lastPosition = start_position;
		start_position ++;
		return plate ;
	}

	boolean n = true;
	public boolean hasNext() {
		for(int i = 0; i <belt.getSize(); i++) {
			if(belt.getPlateAtPosition(start_position) != null && (belt.getPlateAtPosition(start_position).getColor() == color)) {
				return true;
			} else {
				 start_position++;
			}
		}
		return false;
	}

}
