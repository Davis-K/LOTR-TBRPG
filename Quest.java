
public class Quest {
	private String type;
	private String name;
	private String hirer;
	private Location fulfill;
	private int reward;
	private boolean engaged = false;
	private boolean fulfilled = false;
	XY_Grid grid;
	public Quest( String n, String t, String p, Location ta, int r, XY_Grid g ){
		type = t;
		name = n;
		fulfill = ta;
		reward = r;
		grid = g;
		hirer = p;
	}
	
	public String getType(){
		return type;
	}
	
	public String getName(){
		return name;
	}
	
	public String person(){
		return hirer;
	}
	
	public Location fulfillSpot(){
		return fulfill;
	}
	
	public int reward(){
		return reward;
	}
	
	public boolean getEngaged(){
		return engaged;
	}
	
	public void engageQuest(){
		engaged = true;
		grid.getPlayer().getQuests().add(this);
	}
	
	public void fulfill(){
		fulfilled = true;
	}
	
	public boolean getFulfill(){
		return fulfilled;
	}
	
	public XY_Grid getGrid(){
		return grid;
	}
	
	public Location getLoc(){
		return fulfill;
	}
}
