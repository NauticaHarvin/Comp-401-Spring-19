package a6;

import java.util.Iterator;

import a6.Plate.Color;

public class BeltImpl implements Belt{

	private int belt_size;
	private Plate[] platess;
	public BeltImpl(int belt_size) {
		if(belt_size < 0) {
			throw new IllegalArgumentException();
		}
		this.belt_size = belt_size;

		platess = new Plate[belt_size];
	}

	public int setPlateNearestToPosition(Plate plate, int position) throws BeltFullException {
		int counter = 0;
		while(counter < belt_size) {
			try {
				setPlateAtPosition(plate, position);
				return position;
			}catch(BeltPlateException e) {
				position++;
				counter++;
			}
//		position = normalize(position);
//		
//		for(int i = position; i < belt_size + position; i++ ) {
//			i = normalize(i);
//			if(platess[i] == null) {
//				platess[position] = plate;
//				return position;
//			} else {
//				
//			}
				
			}
		throw new BeltFullException(this);
		}
		
	
	
	public int normalize(int position) {
		return ((position % belt_size) + belt_size) % belt_size;
	}

	public int getSize() {
		return belt_size;
	}


	public Plate getPlateAtPosition(int position) {
		return platess[normalize(position)];	
	}

	public void setPlateAtPosition(Plate plate, int position) throws BeltPlateException {
		
		if(plate == null) {
			throw new IllegalArgumentException();
		}
		position = normalize(position);
		
		if(platess[(position)] != null) {
			throw new BeltPlateException(position, plate, this);
		}
		platess[position] = plate;
	}


	
	public void clearPlateAtPosition(int position) {
		normalize( position);
		platess[normalize(position)]= null;
			
		}
	
	
	public Plate removePlateAtPosition(int position) {
		
		
		if(platess[normalize(position)] == null) {
		
		 throw new java.util.NoSuchElementException();
		} else {
			Plate currentPlate = platess[normalize(position)];
			platess[normalize(position)] = null;
			return currentPlate;
		}
		
		
		 
		 
	}
	
	
	@SuppressWarnings("unchecked")
	public Iterator<Plate> iterator(){
		BeltIterator platey = new BeltIterator(this, 1);
		return platey;
		
	}
	
	@SuppressWarnings("unchecked")
	public Iterator<Plate> iteratorFromPosition(int position){
		position = normalize(position);
		BeltIterator platey = new BeltIterator(this, position);
		return platey;
	}
	
	@SuppressWarnings("unchecked")
	public Iterator<Plate> iterator(double max_price) {
		PriceThresholdBeltIterator platey = new PriceThresholdBeltIterator(this,0,max_price);
		return platey;
	}
	
	@SuppressWarnings("unchecked")
	public Iterator<Plate> iterator(Color color) {
		 ColorFilteredBeltIterator platey = new  ColorFilteredBeltIterator(this,0,color);
		return platey;
	}

	@SuppressWarnings("unchecked")
	public Iterator<Plate> iteratorFromPosition(int position, double max_price) {
		position = normalize(position);
		PriceThresholdBeltIterator platey = new PriceThresholdBeltIterator(this,position ,max_price);
		return platey;
	}
	
	@SuppressWarnings("unchecked")
	public Iterator<Plate> iteratorFromPosition(int position, Color color){
		position = normalize(position);
		ColorFilteredBeltIterator platey = new  ColorFilteredBeltIterator(this,position,color);
		return platey;
	}

	
	public void rotate() {
		Plate[] cups = new Plate[belt_size];
		for(int i = 1; belt_size > i; i++) {
			cups[i] = platess[i-1];
		}
		cups[0] = platess[belt_size -1];
		platess = cups;
	}





		
}

