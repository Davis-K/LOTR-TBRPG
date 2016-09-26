
public class Food extends Item{
	private int hungerBonus;
	public Food(int c, String n, int h){
		super(c,n);
		hungerBonus = h;
	}
	
	public int getHungerBonus(){
		return hungerBonus;
	}
}
