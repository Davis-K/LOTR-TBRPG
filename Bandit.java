
public class Bandit extends NPC {
	public Bandit(){
		super( "Bandit", "Human", 7, 8, 18, "Evil", 4, new Armor( 6, "Bandit Mail", 1, "Chest" ) );
	}
	
	public String death(){
		if(getHealth() <= 0)
			return "The bandit falls dead. He will harm travelers no more.";
		else
			return "The bandit sneaks in a fatal blow, and shamelessly robs your corpse of money before departing.";
	}
}
