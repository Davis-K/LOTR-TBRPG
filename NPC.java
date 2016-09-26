public class NPC {
	private String name;
	private String race;
	private int atk;
	private int health;
	private int expDrop;
	private int armorClass;
	private String alignment;
	private Item itemDrop;
	
	public NPC( String n, String r, int a, int h, int ac, String al, int e, Item d ){
		name = n;
		race = r;
		atk = a;
		health = h;
		alignment = al;
		expDrop = e;
		itemDrop = d;
		armorClass = ac;
	}
	
	public String getName(){
		return name;
	}
	
	public String getRace(){
		return race;
	}
	public int getAttack(){
		return atk;
	}
	
	public int getHealth(){
		return health;
	}
	
	public void interact(){
	}
	
	public void takeDamage(int d){
		health -= d;
	}
	
	public String getAlignment(){
		return alignment;
	}
	
	public String intro(){
		return "There is a " + name + " here.";
	}
	
	public String death(){
		return "The " +  name + " falls dead from your blow. You gain " + expDrop + " experience!";
	}
	
	public int getExp(){
		return expDrop;
	}
	
	public Item getItemDrop(){
		return itemDrop;
	}
	
	public int getArmorClass(){
		return armorClass;
	}
	
}
