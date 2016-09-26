public class TheHill extends Location {
	
	Sword s = new Sword();
	Chest c = new Chest( 0, this );
	public TheHill( XY_Grid g ){
		super( "The Hill", 10, 9, 0, false, false, true, false, false, "You are standing atop The Hill, home of the Baggins family of Hobbits.", g);
	}
}

