import java.util.ArrayList;
import java.util.Scanner;

public class Location {
	private boolean campDestroyed = false;
	private int xPos;
	private int yPos;
	private int height;
	private boolean isStaircase;
	private String name;
	private String text;
	private XY_Grid grid;
	private ArrayList<NPC> guys = new ArrayList<NPC>();
	private ArrayList<Item> items = new ArrayList<Item>();
	private ArrayList<Building> buildings = new ArrayList<Building>();
	private boolean north;
	private boolean south;
	private boolean east;
	private boolean west;
	
	public Location( String n, int x, int y, int h, boolean i, boolean no, boolean s, boolean e, boolean w, String t, XY_Grid g ){
		xPos = x;
		yPos = y;
		height = h;
		name = n;
		text = t;
		grid = g;
		isStaircase = i;
		north = no;
		south = s;
		east = e;
		west = w;
		this.scanForEnemy();
	}
	
	public int getXPos(){
		return xPos;
	}
	
	public int getYPos(){
		return yPos;
	}
	
	public int getHeight(){
		return height;
	}
	
	public String getText(){
		return text;
	}
	
	public void scanForEnemy(){
		for(int i = 0; i < guys.size(); i++){
			if(guys.get(i).getHealth() <= 0)
				guys.remove(i);
			else if((guys.get(i).getAlignment().equals("Evil") && grid.getPlayer().getReputation() > -5) || (guys.get(i).getAlignment().equals("Good") && grid.getPlayer().getReputation() < -5) && guys.get(i).getHealth() > 0){
				System.out.println(guys.get(i).intro() + " You will have to fight!");
				grid.getPlayer().Fight(guys.get(i));
			}else
				System.out.println(guys.get(i).intro());
				
		}
	}
	public void enterLoc(){
		if( grid.getPlayer().getXPos() == this.getXPos() && grid.getPlayer().getYPos() == this.getYPos() && grid.getPlayer().getHeight() == this.getHeight()){
			System.out.println(getName());
			System.out.println( this.getText());
			for(int i = 0; i < items.size(); i++)
				if( items.get(i).getName().substring(0).equals("A") || items.get(i).getName().substring(0).equals("E") || items.get(i).getName().substring(0).equals("I") || items.get(i).getName().substring(0).equals("O") || items.get(i).getName().substring(0).equals("U"))
					System.out.println("There is an " + items.get(i).getName() + " here.");
				else
					System.out.println("There is a " + items.get(i).getName() + " here.");
			for(int i = 0; i < buildings.size(); i++ )
				if(!(buildings.get(i) instanceof Inn))
					System.out.println("There is a " + buildings.get(i).getName() + " here.");
				else
					System.out.println("The " + buildings.get(i).getName() + " is here.");
			if( !campDestroyed && (name.equals("Southern Bree-Fields") || name.equals("Bree Junction") || name.equals("Combe")) )	
				banditRaids();
			this.scanForEnemy();
		}
	}
	
	public void addNPC(NPC n){
		guys.add(n);
	}
	
	public boolean getStairs(){
		return isStaircase;
	}
	
	public boolean canGoWest(){
		return west;
	}
	
	public boolean canGoEast(){
		return east;
	}
	
	public boolean canGoNorth(){
		return north;
	}
	
	public boolean canGoSouth(){
		return south;
	}
	
	public ArrayList<Item> getItems(){
		return items;
	}
	
	public Building getBuilding(String n){ 
		for( int i = 0; i < buildings.size(); i++ ){
			if( n.equals(buildings.get(i).getName()))
				return buildings.get(i);
		}
		return null;
	}
	
	public XY_Grid getGrid(){
		return grid;
	}
	
	public ArrayList<Building> getBuildings(){
		return buildings;
	}
	
	public void enterBuilding( String n ){
		if( buildings.size() == 0)
			System.out.println(" There are no buildings to enter here.");
		for( int i = 0; i < buildings.size(); i++ ){
			if( n.equals(buildings.get(i).getName()))
				buildings.get(i).enter();
		}
	}
	
	public ArrayList<NPC> getNPCs(){
		return guys;
	}
	
	public void banditRaids(){
		if(campDestroyed  ==  false && (int)(Math.random()*6) % 2 == 0){
			System.out.println(new Bandit().intro() + " You will have to fight!");
			grid.getPlayer().Fight(new Bandit());
		}
	}
	
	public boolean setCampdestroyed(boolean b){
		campDestroyed = b;
		return campDestroyed;
	}
	
	public String getName(){
		return name;
	}
	
	public void addItem( Item i ){
		items.add(i);
	}
	
	public void addBuilding( Building b ){
		buildings.add(b);
	}
}
