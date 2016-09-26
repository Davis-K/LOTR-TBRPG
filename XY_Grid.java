import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class XY_Grid {
	private Scanner unwanted = new Scanner(System.in);
	private Location[][][] xyh_Grid = new Location[40][40][5];
	String heroName = JOptionPane.showInputDialog( null, "What is Your Name?");
	private String[] raceList = {"Man", "Dwarf", "Elf", "Hobbit"};
	private String choice = (String) JOptionPane.showInputDialog( null, "Select a Race", "Race Selection", JOptionPane.QUESTION_MESSAGE, null, raceList, raceList[2] );
	private Player p = new Player( heroName, choice, 10, 10, 0, 10, 50, 20, 12 );
	private ArrayList<Character> characters = new ArrayList<Character>();
	
	
	public XY_Grid(){
		
		//Add Other Stuff to Locations and Grid
		//Characters
		Character c = new Character( "Sam Gamgee", "Hobbit", 10, 12, 0, 8, 30, 12, 12 );
		characters.add(c);
		//Grid Assignments
		p.assignGrid(this);
		c.assignGrid(this);
	
	}
	
	public void act(){
		System.out.print("> ");
		String response = unwanted.nextLine();
		Location currLoc = xyh_Grid[p.getXPos()][p.getYPos()][p.getHeight()];
		
		
		switch(response){
			
			case "w" :
				if(isLoc(p.getXPos()-1, p.getYPos(), p.getHeight()) && currLoc.canGoWest()){
					p.moveWest();
					currLoc = p.getCurrLoc();
					currLoc.enterLoc();
					hungerStatus();
					p.incrementHunger(1);
				}else
					System.out.println("You cannot go that way.");
				break;
			case "n" :
				if(isLoc(p.getXPos(), p.getYPos()-1, p.getHeight()) && currLoc.canGoNorth()){
					p.moveNorth();
					currLoc = p.getCurrLoc();
					currLoc.enterLoc();
					hungerStatus();
					p.incrementHunger(1);
				}else
					System.out.println("You cannot go that way.");
				break;
			case "s" :
				if(isLoc(p.getXPos(), p.getYPos()+1, p.getHeight()) && currLoc.canGoSouth()){
					p.moveSouth();
					currLoc = p.getCurrLoc();
					currLoc.enterLoc();
					hungerStatus();
					p.incrementHunger(1);
				}else
					System.out.println("You cannot go that way.");
				break;
			case "e" :
				if(isLoc(p.getXPos()+1, p.getYPos(), p.getHeight()) && currLoc.canGoEast()){
					p.moveEast();
					currLoc = p.getCurrLoc();
					currLoc.enterLoc();
					hungerStatus();
					p.incrementHunger(1);
				}else
					System.out.println("You cannot go that way.");
				break;
			case "u" :
				if(isLoc(p.getXPos(), p.getYPos(), p.getHeight()+1) && currLoc.getStairs()){
					p.moveUp();
					currLoc = p.getCurrLoc();
					currLoc.enterLoc();
					hungerStatus();
					p.incrementHunger(1);
				}else
					System.out.println("You cannot go that way.");
				break;
			case "d" :
				if(p.getHeight() > 0 && isLoc(p.getXPos(), p.getYPos(), p.getHeight()-1) && currLoc.getStairs()){
					p.moveDown();
					currLoc = p.getCurrLoc();
					currLoc.enterLoc();
					hungerStatus();
					p.incrementHunger(1);
				}else
					System.out.println("You cannot go that way.");
				break;
			case "i":
				p.inventory();
				break;
			case "look" :
				currLoc.enterLoc();
				break;
			default :
				if(response.indexOf(' ') > 0){
					String firstWord = response.substring(0,response.indexOf(' '));
					String secondWord = response.substring(response.indexOf(' ')+1);
					if(firstWord.equals("enter"))
						p.enterBuilding(secondWord);
					else if(firstWord.equals("take"))
						p.takeItem(secondWord);
					else if(firstWord.equals("drop")){
						p.dropItem(secondWord);
					}else if(firstWord.equals("equip")){
						p.equipWeapon(secondWord);
					}else if(firstWord.equals("eat")){
						p.eat(secondWord);
					}else if(firstWord.equals("open")){
						p.open(secondWord);
					}else if(firstWord.equals("fight")){
						p.fightNPC(secondWord);
					}else if(firstWord.equals("interact")){
						p.interactNPC(secondWord);
					}else if(firstWord.equals("drink")){
						p.drinkPotion(secondWord);
					}else if(firstWord.equals("wear")){
						p.wearArmor(secondWord);
					}else if(firstWord.equals("fill_pipe")){
						p.fillPipe(secondWord);
					}else if(firstWord.equals("smoke")){
						p.smokePipe();
					}else if(firstWord.equals("use")){
						p.use(secondWord);
					}else if(firstWord.equals("attack")){
						p.attackCharacter(secondWord);
				}else if(response.equals("help") || response.equals("manual"))
					p.readManual();
				else
					System.out.println("You can't do that.");
				break;
				}
				
		}
		
		p.leveling();
		
		for( int i = 0; i < characters.size(); i++ ){
			characters.get(i).encounter();
			characters.get(i).move();
				
			}
		
			
	}
	
	public Player getPlayer(){
		return p;
	}
	
	public Location[][][] getLocations(){
		return xyh_Grid;
	}
	
	public boolean isLoc(int x, int y, int h){
		if(xyh_Grid[x][y][h] instanceof Location)
			return true;
		else
			return false;
	}
	
	public void addLocation( Location l ){
		xyh_Grid[l.getXPos()][l.getYPos()][l.getHeight()] = l;
	}
	
	public void wildAnimalSpawn( Location l, NPC n, int r ){
		if(!(l.getNPCs().size() > 0))
			if( (int)(Math.random()*8+1) % r == 0)
				l.addNPC(n);
	}
	
	public void hungerStatus(){
		if(p.getHunger() > 30)
			p.takeDamage(1);
		else if(p.getHunger() > 45)
			p.takeDamage(2);
		else if(p.getHunger() > 70)
			p.takeDamage(5);
	}
	
	public void setPlayer(Player pl){
		p = pl;
	}
	
	public void getRacialBonuses(){
			
	}
	
	public ArrayList<Character> getCharcters(){
		return characters;
	}
	
	public Location getLocation(int x, int y, int h){
		//if(isLoc(x,y,h))
			return xyh_Grid[x][y][h];
		//else
			//return null;
	}
}
