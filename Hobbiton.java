public class Hobbiton extends Location{
	
	Market m = new Market( "Hobbit", getGrid() );
	Inn i = new Inn( "Green Dragon", "Hobbit", getGrid());
	
	public Hobbiton( XY_Grid g ){
		super("Hobbiton", 10, 11, 0, false, true, true, false, true, "You are standing in the main square of Hobbiton. Low buildings ring the square. To the south, the Great East Road passes by. To the north, a rocky path climbs a grassy hill dotted with hobbit-holes. ", g);
		addBuilding(m);
		addBuilding(i);
		i.getQuests().add(new Assassination( "Saving Archet", "The Mayor of Archet", getGrid().getLocation(17, 10, 0), 10, new Orc(), getGrid()));
	}
}
