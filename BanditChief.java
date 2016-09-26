
public class BanditChief extends NPC{
	public BanditChief(){
		super( "Bandit Chieftain", "Human", 14, 8, 19,"Evil", 12, new Weapon( 6, "Axe", 3, 2 ) );
	}
	
	public String intro(){
		return "There is a Bandit Chief here.";
	}
	
	public String death(){
		if( getHealth() <= 0)
			return "The Chief falls dead. You quickly disperse his followers and destroy the camp, which will no longer menace Bree-Land. \nMission 1 Completed!";
		else
			return "The cackling Chief ends your life with a swift blow.";
	}
}
