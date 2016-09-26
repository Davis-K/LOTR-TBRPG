public class Bree extends Location {
	
	Market m = new Market( "Human", getGrid() );
	public Bree( XY_Grid g ){
		super( "Bree", 16, 12, 0, false, true, true, true, true, "You are standing in the town of Bree. This is the most western settlement of Men and one of the largest \ntowns in the area. The town sits upon a four-way junction with roads heading north into the fields, east \ninto the town of Staddle, and south towards Andrath. The town is dark and stormy, and rain pours down upon \nthe wooden buildings. However, lights shine from within most places and laughter from the inns rings \ninto the streets. This is not the most properous time for Bree, and it has not been such since the last king fell \nat Fornost, but things could be a lot worse, though bandits still plague the lands around the town. The streets \nare dark and many are narrow, and the buildings tall and wooden with angled roofs.", g );
		addBuilding(m);
	}
}
