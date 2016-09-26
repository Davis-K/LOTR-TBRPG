
public class Armor extends Item{
	private int bonus;
	private String type;
	public Armor( int c, String n, int b, String t){
		super(c, n);
		bonus = b;
		type = t;
	}
	
	public int getBonus(){
		return bonus;
	}
	
	public String getType(){
		return type;
	}
}
