package a7;

import comp401sushi.Plate;

/**
 * 	The BeltPlateException class is used by implementations of Belt to signal when an attempt 
 *  is made to place a plate on the belt at a position that is already occupied.
 */

public class BeltPlateException extends Exception {

	private int _position;
	private Plate _plate;
	private Belt _belt;

	public BeltPlateException(int position, Plate platetobeset, Belt belt) {
		super("it is already filled bro");

		if (platetobeset == null) {
			throw new IllegalArgumentException("plate_to_be_set is null again bro");
		}

		if (belt == null) {
			throw new IllegalArgumentException("Its null bro");			
		}

		_position = position;
		_plate = platetobeset;
		_belt = belt;
	}

	public int getPosition() {
		return _position;
	}

	public Plate getPlateToSet() {
		return _plate;
	}

	public Belt getBelt() {
		return _belt;
	}
	
}
