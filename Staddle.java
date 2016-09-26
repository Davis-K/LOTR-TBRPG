public class Staddle extends Location {
	Market m = new Market( "Hobbit", getGrid() );
	public Staddle( XY_Grid g ){
		super( "Staddle", 17, 12, 0, false, true, true, true, true, "You are in the town of Staddle, which is a western subdivision of Bree and the location of the homes \nof that town's hobbits. The Great East Road turns south here, heading into the Chetwood forests.", g);
		addBuilding(m);
	}
}
