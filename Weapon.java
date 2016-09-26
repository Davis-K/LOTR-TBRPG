
public class Weapon extends Item {
	private int damageModifier;
	private int level;
	public Weapon( int c, String n, int d, int l){
		super(c,n);
		damageModifier = d;
		level = l;
	}
	
	public int getModifier(){
		return damageModifier;
	}
	
	public int getLevel(){
		return level;
	}
}
