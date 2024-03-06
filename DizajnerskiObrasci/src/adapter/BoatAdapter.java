package adapter;

public class BoatAdapter implements Vehicle {

	private Boat boat;
	
	@Override
	public void moveFaster() {
		// TODO Auto-generated method stub
		boat.rowFaster();

	}

	public BoatAdapter(Boat boat) {
		super();
		this.boat = boat;
	}

}
