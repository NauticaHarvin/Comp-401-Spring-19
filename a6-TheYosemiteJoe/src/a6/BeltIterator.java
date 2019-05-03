package a6;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class BeltIterator implements Iterator{

	private Belt belt;
	private int start_position;
	private int lastindexval;
	private int lastPosition;
	private boolean nope;

	public BeltIterator(Belt belt, int start_position) {
		this.belt = belt;
		this.start_position = start_position;
		this.lastPosition = -1;
		nope = false;

	}

	//boolean n = true;
	public boolean hasNext() {
		for(int i = 0; i <belt.getSize(); i++) {
			if(belt.getPlateAtPosition(start_position) != null) {
				return true;
			} else {
				start_position++;			
			}
		}
		return false;
	}


	public Plate next() {
		if(!hasNext()) {
			throw new  java.util.NoSuchElementException();
		}// {
		//	if(hasNext()== true) 
		//{
		Plate result = belt.getPlateAtPosition(start_position);
		start_position ++;
		nope = true;
		return result;
		//			} else{
		//				throw new java.util.NoSuchElementException();
		//			}
	}




	//		Plate plate = belt.getPlateAtPosition(start_position);
	//		lastPosition = start_position;
	//		start_position ++;
	//		return plate ;


	public int normalize(int position) {
		return ((position % belt.getSize() + belt.getSize() % belt.getSize()));
	}
	//	public void remove() {
	//		lastindexval[] = start_position[start_position.length - 1];
	//
	//		if(lastIndex)
	//			throw new UnsupportedOperationException();
	//	}

	public void remove() {
		if (!nope) {
			throw new IllegalStateException();

		} else {
			start_position--;
			belt.removePlateAtPosition(start_position);
			nope = false;
		}


	}
}
//	if(nope == true) {
//		belt.clearPlateAtPosition(lastposition - 1);
//	} else {
//		throw new IllegalStateException();
//	}
//	nope = false;

//	public void remove() {
//		if ( == -1) {
//			throw new IllegalStateException();
//		}
//		belt.clearPlateAtPosition(lastPosition);
//		lastPosition = -1;
//	}

