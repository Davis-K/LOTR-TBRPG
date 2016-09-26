
public class QuarryEntrance extends Location{
	/*XY_Grid quarry = new XY_Grid();
	Location firstCave = new Location( "First Cave", 1, 2, 4, true, false, false, true, true, "You are in the first cave of the Quarry. The light of day shines to the west, and there is a deep shaft, with rocks forming a ladder, leading down into the deep.", quarry);
	Location shaft = new Location( "Shaft", 1, 2, 3, true, false, false, false, false, "You are in a dark mine shaft, clutching on to a rock ladder which leads down into the dark.", quarry);
	Location outside = new Location( "Outside Mine", 0, 2, 4, false, false, false, true, true, "You emerge from the Quarry into the bright sunlight.", quarry);
	Location mine = new Location("Mine", 13, 9, 0, false, false, false, false, true, "You are in a mine.", getGrid());*/
	
	public QuarryEntrance(XY_Grid g){
		super("The Quarry", 12, 9, 0, false, true, true, true, true, "You are standing at the entrance of the Quarry, the only mine of the Shire. Hobbits and men delved deep \ninto the dark in this place, and there are rumors of foul spirits below.", g);
		
		/*quarry.addLocation(firstCave);
		quarry.addLocation(shaft);
		quarry.addLocation(outside);
		getGrid().addLocation(mine);*/
	}
	
	public boolean canGoEast(){
		/*quarry.setPlayer(getGrid().getPlayer());
		quarry.getPlayer().setGridPos(1, 2, 4);
		int i = 1;
		while( i > 0){
			quarry.act();
			if( quarry.getPlayer().getCurrLoc().equals(outside)){
				i--;
				getGrid().setPlayer(quarry.getPlayer());
				}
			}*/
		return false;
	}
		
		
		
	
}
