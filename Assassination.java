
public class Assassination extends Quest {
	NPC kill;
	public Assassination( String n, String p, Location l, int r, NPC np, XY_Grid g ){
		super( n, "Assassination", p, l, r, g);
		kill = np;
	}
	
	public void fulfill(){
		boolean dead = true;
		int num = 0;
		if(getEngaged()){
			
			for( int i = 0; i < fulfillSpot().getNPCs().size(); i++ )
				if( fulfillSpot().getNPCs().get(i).equals(kill) ){
					dead = false;
					num = i;
				}
			
		}
			
		if( dead ){
			getGrid().getPlayer().addMoney(reward());
			System.out.println("You have completed " + getName() + "! You receive $" + reward() + ".");
			getGrid().getPlayer().getQuests().remove(num);
		}
	}
	
	public NPC getTarget(){
		return kill;
	}
	
}
