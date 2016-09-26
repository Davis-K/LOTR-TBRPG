
public class MarshAdder extends NPC{
	public MarshAdder(){
		super("Marsh Adder", "Adder", 12, 30, 21, "Evil", 15, null);
	}
	
	public String intro(){
		return "The mighty Marsh Adder rises from the swamp, rearing its scaly head and body and displaying its fearsome teeth.";
	}
	
	public String death(){
		if(getHealth() <= 0)
			return "The Marsh Adder screams in pain and crashes dead to the ground.";
		else
			return "The Marsh Adder delivers you a fatal blow, and you are eaten alive.";
			
	}
}
