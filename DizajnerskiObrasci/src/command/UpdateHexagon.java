package command;

import adapter.HexagonAdapter;

public class UpdateHexagon implements Command {

	private HexagonAdapter oldH;
	private HexagonAdapter newH;
	private HexagonAdapter original = new HexagonAdapter(0, 0, 0);
	
	public UpdateHexagon(HexagonAdapter oldHex, HexagonAdapter newHex) {
		this.oldH = oldHex;
		this.newH = newHex;
	}
	
	@Override
	public void execute() {
		try {
			original = oldH.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		
		try {

			oldH.setCenter(newH.getCenter());
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		try {
			oldH.setRadius(newH.getRadius());
		} catch (Exception e) {
			e.printStackTrace();
		}
		oldH.setColor(newH.getColor());
		oldH.setInsideColor(newH.getInsideColor());
		//oldH.setSelected(false);

	}

	@Override
	public void unexecute() {
		try {
			oldH.setCenter(original.getCenter());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			oldH.setRadius(original.getRadius());
		} catch (Exception e) {
			e.printStackTrace();
		}
		oldH.setColor(original.getColor());
		oldH.setInsideColor(original.getInsideColor());
	}

}
