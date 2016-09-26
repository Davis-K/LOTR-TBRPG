
public class Item {
	private int cost;
	private String name;
	public Item( int c, String n ){
		cost = c;
		name = n;
	}
	
	public int getCost(){
		return cost;
	}
	
	public String getName(){
		return name;
	}
	
	public int getHungerBonus(){ //TO-DO : Find way to delete this without wrecking code
		return 0;
	}
}
