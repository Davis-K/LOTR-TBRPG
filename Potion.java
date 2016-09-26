
public class Potion extends Item{
	private int bonus;
	private String bonusType;
	public Potion( int c, String n, int b, String bT ){
		super( c, n );
		bonus = b;
		bonusType = bT;
	}
	
	public int getBonus(){
		return bonus;
	}
	
	public String getBonusType(){
		return bonusType;
	}
}
