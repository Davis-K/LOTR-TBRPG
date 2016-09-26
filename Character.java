
public class Character extends Player {
	String name;
	String type;
	public Character( String n, String t, int x, int y, int h, int a, int he, int m, int ac ){
		super( n, t, x, y, h, a, he, m, ac );
		name = n;
		type = t;
	}
	
	public String getName(){
		return name;
	}
	
	public String getType(){
		return type;
	}
	
	public void encounter(){
		if( getGrid().getPlayer().getCurrLoc().equals(getCurrLoc())){
			System.out.println(intro());
		}
	}
	
	public String intro(){
		return name + " is here.";
	}
	
	public void move(){
		if(getCurrLoc().canGoEast() && getGrid().isLoc(getXPos()+1, getYPos(), getHeight()))
				moveEast();
		else if(getCurrLoc().canGoWest() && getGrid().isLoc(getXPos()+1, getYPos(), getHeight()))
				moveWest();
			
	}
}
