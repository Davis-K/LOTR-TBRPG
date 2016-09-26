import java.util.ArrayList;
import java.util.Scanner;

public class Player {
	private int xPos;
	private int yPos;
	private int atk;
	private int health;
	private int armorClass;
	private int height;
	private int level;
	private int exp;
	private int money;
	private int hunger;
	private int maxHealth = 50;
	private Weapon equipped;
	private Armor head;
	private Armor chest;
	private Armor gloves;
	private Armor boots;
	private Pipe pipe;
	private String race;
	private String name;
	private ArrayList<Item> possessions = new ArrayList<Item>();
	private ArrayList<Quest> quests = new ArrayList<Quest>();
	private XY_Grid xyg;
	String cannotDo = "You can't do that.";
	private String response;
	private String defense;
	private Scanner unwanted = new Scanner(System.in);
	private Scanner unwanted2 = new Scanner(System.in);
	private int reputation = 0;
	
	public Player( String n, String r, int x, int y, int h, int a, int he, int m, int ac ){
		xPos = x;
		yPos = y;
		height = h;
		atk = a;
		health = he;
		level = 1;
		exp = 0;
		hunger = 0;
		money = m;
		armorClass = ac;
		race = r;
		name = n;

	}
	
	public void inventory(){
		System.out.println("Health : " + health + "(" + maxHealth + ") " + "Level : " + level + "  Exp : " + exp + " Attack : " + atk + " Armor Class : " + armorClass + " Money : " + money + " Hunger : " + hunger + " Reputation : " + reputation);
		if(equipped != null){
			System.out.println("Equipped Weapon : " + equipped.getName());
		}else
			System.out.println("Equipped Weapon : None");
		if(pipe != null)
			System.out.println("Pipe : " + pipe.getName());
		else
			System.out.println("Pipe: None");
		String headS, chestS, glovesS, bootsS;
		if(head != null)
			headS = head.getName();
		else
			headS = "None";
		if(chest != null)
			chestS = chest.getName();
		else
			chestS = "None";
		if(gloves != null)
			glovesS = gloves.getName();
		else
			glovesS = "None";
		if(boots != null)
			bootsS = boots.getName();
		else
			bootsS = "None";
		System.out.println("Armor : Head : " + headS + ", Chest : " + chestS + ", Gloves : " + glovesS + ", Boots : " + bootsS);
		System.out.println("\n	---- INVENTORY ----");
		System.out.println("Food:		Hunger Bonus:");
		for( int i = 0; i < possessions.size(); i++ ){
			if(possessions.get(i) instanceof Food)
				if(possessions.get(i).getName().length() > 7)
					System.out.println( possessions.get(i).getName() + "	" + possessions.get(i).getHungerBonus() );
				else
					System.out.println( possessions.get(i).getName() + "		" + possessions.get(i).getHungerBonus() );
		}
		System.out.println();
		System.out.println("Weapon:		Attack Bonus: 	Level: ");
		Weapon w;
		for( int i = 0; i < possessions.size(); i++ ){
			if(possessions.get(i) instanceof Weapon){
				w = (Weapon)possessions.get(i);
				if(w.getName().length() > 7)
					System.out.println(w.getName() + "	" + w.getModifier() + "		" + w.getLevel());
				else
					System.out.println( w.getName() + "		" + w.getModifier() + "		" + w.getLevel());
			}
		}
		System.out.println();
		System.out.println("Armor:		Defense Bonus:");
		Armor a;
		for( int i = 0; i < possessions.size(); i++ ){
			if(possessions.get(i) instanceof Armor){
				a = (Armor)possessions.get(i);
				if(a.getName().length() > 7)
					System.out.println(a.getName() + "	" + a.getBonus());
				else
					System.out.println( a.getName() + "		" + a.getBonus());
			}
		}
		System.out.println("\nOther Items: ");
		for( int i = 0; i < possessions.size(); i++ ){
			if(!(possessions.get(i) instanceof Weapon) && !(possessions.get(i) instanceof Food) && !( possessions.get(i) instanceof Armor)){
				System.out.println( possessions.get(i).getName());
			}
		}
		System.out.println();
	}
	
	public void takeItem(String n){
		boolean taken = false;
		int x = getCurrLoc().getItems().size();
		for( int i = 0; i < x; i++ ){
			if( n.equals(getCurrLoc().getItems().get(i).getName())){
				possessions.add(getCurrLoc().getItems().get(i));
				getCurrLoc().getItems().remove(i);
				taken = true;
				break;
			}
		}
		if(taken)
			System.out.println("Taken.");
		else
			System.out.println(cannotDo);
	}
	
	public void eat(String n){
		boolean eaten = false;
		for( int i = 0; i < possessions.size(); i++ ){
			if( n.equals(possessions.get(i).getName()) && possessions.get(i) instanceof Food ){
				System.out.println("Eaten.");
				incrementHunger(-possessions.get(i).getHungerBonus());//not correct yet
				possessions.remove(i);
				eaten = true;
				break; 
			}	
		}
		if(!eaten)
			System.out.println("You cannot eat that.");
	}
	
	public void enterBuilding(String n){
		getCurrLoc().enterBuilding(n);
	}
	
	public void open( String n ){
		Chest c;
		for(int i = 0; i < getCurrLoc().getItems().size(); i++ ){
			if( getCurrLoc().getItems().get(i) instanceof Chest ){
				c = (Chest)getCurrLoc().getItems().get(i);
				if(n.equals(c.getName()))
				if(c.getContents().size() > 0){
					System.out.println("The chest contains the following items:");
					for(int x = 0; x < c.getContents().size(); x++ ){
						System.out.println(c.getContents().get(x).getName());
						getCurrLoc().getItems().add(c.getContents().get(x));
						c.getContents().remove(x);
						x--;
					}
			}else
				System.out.println("The chest is revealed to be empty.");
			}
		}
	}
	
	public int getXPos(){return xPos;}
	public int getYPos(){return yPos;}
	public int getHeight(){return height;}
	public int getArmorClass(){return armorClass;}
	
	public void moveNorth(){
		yPos--;
		System.out.println(xPos + "," + yPos);
	}
	
	public void moveSouth(){
		yPos++;
		System.out.println(xPos + "," + yPos);
	}
	
	public void moveEast(){
		xPos++;
		System.out.println(xPos + "," + yPos);
	}
	
	public void moveWest(){
		xPos--;
		System.out.println(xPos + "," + yPos);
	}
	
	public int getAtk(){return atk;}
	
	public int getHealth(){return health;}
	
	public void takeDamage(int x){health -= x;}
	
	public void incrementHunger(int x){hunger += x;}
	
	public void moveUp(){height++;}
	
	public void moveDown(){height--;}
	
	public void levelUp(){level++;}
	
	public void addExp(int n){exp += n;}
	
	public ArrayList<Item> getPossessions(){return possessions;}
	
	public ArrayList<Quest> getQuests(){return quests;}
	
	public void addHealth(int h){
		health += h;
		System.out.println("You have gained " + h + " health points.");
	}
	
	public void equipWeapon(String n){
		boolean found = false;
		Weapon temp;
		for( int i = 0; i < possessions.size(); i++ ){
			if( possessions.get(i).getName().equals(n) && possessions.get(i) instanceof Weapon ){
				temp = (Weapon)possessions.get(i);
				if(  level >= temp.getLevel()  ){
					equipped = (Weapon)possessions.get(i);
					found = true;
					System.out.println("Equipped.");
					break;
			}
			}
		}
		if(!found)
			System.out.println("You can't equip that.");
	}
	
	public Weapon getEquippedWeapon(){return equipped;}
	
	public int getLevel(){return level;}
	
	public int getExp(){return exp;}
	
	public int getMoney(){return money;}
	
	public int getHunger(){return hunger;}
	
	public Armor getHead(){return head;}
	
	public Armor getChest(){return chest;}
	
	public Armor getGloves(){return gloves;}
	
	public Armor getBoots(){return boots;}
	
	public void spendMoney(int v){money -= v;}
	
	public void addMoney(int v){money += v;}
	
	public void setAttack(int v){atk = v;}
	
	public void setHealth(int v){health = v;}
	
	public void leveling(){
		int initialLevel = level;
		if( exp < 25 ){
			level = 1;
			if( level > initialLevel){
			if(health > 50)
				health = 50;
			atk = 10;
			armorClass++;
			maxHealth = 50;
			}
		}else if(exp < 50){
			
			level = 2;
			if( level > initialLevel){
			if(health > 75)
				health = 75;
			atk = 11;
			armorClass++;
			maxHealth = 75;
			}
		}else if(exp < 100){
			level = 3;
			if( level > initialLevel){
			if(health > 100)
				health = 100;
			atk = 12;
			armorClass++;
			maxHealth = 100;
			}
		}else if(exp < 175){
			level = 4;
			if( level > initialLevel){
			if(health > 115)
				health = 115;
			atk = 15;
			armorClass++;
			maxHealth = 115;
			}
		}else if(exp < 250){
			level = 5;
			if( level > initialLevel){
			if(health > 125)
				health = 125;
			atk = 16;
			armorClass++;
			maxHealth = 125;
			}
		}
		if( initialLevel < level ){
			System.out.println("Level Up! You are now at Level " + level + ".");
			health = maxHealth;
		}
	}
	
	public void assignGrid( XY_Grid g ){xyg = g;}
	
	public Location getCurrLoc(){return xyg.getLocations()[getXPos()][getYPos()][getHeight()];}
	
	public XY_Grid getGrid(){return xyg;}
	
	public void dropItem(String n){
		boolean dropped = false;
		Item droppedItem;
		for(int i = 0; i < possessions.size(); i++){
			if(possessions.get(i).getName().equals(n)){
				droppedItem = possessions.get(i);
				getCurrLoc().getItems().add(possessions.get(i));
				possessions.remove(i);
				System.out.println("Dropped.");
				dropped = true;
				if(droppedItem.equals(equipped))
					equipped = null;
				else if(droppedItem.equals(head))
					head = null;
				else if(droppedItem.equals(chest))
					chest = null;
				else if(droppedItem.equals(gloves))
					gloves = null;
				else
					boots = null;
				break;
			}
		}
		if(!dropped)
			System.out.println("You do not possess this item.");
	}
	
	public void fightNPC( String n ){
		boolean fought = false;
		for(int i = 0; i < getCurrLoc().getNPCs().size(); i++ ){
			if( n.equals(getCurrLoc().getNPCs().get(i).getName())){
					Fight(getCurrLoc().getNPCs().get(i));
					fought = true;
					break;
			}
		}
		if( !fought ){
			System.out.println(cannotDo);
			
		}
	}
	
	public void interactNPC( String n ){
		boolean interacted = false;
		for(int i = 0; i < getCurrLoc().getNPCs().size(); i++ ){
			if( n.equals(getCurrLoc().getNPCs().get(i).getName())){
				getCurrLoc().getNPCs().get(i).interact();
				interacted = true;
				System.out.println("Hi.");
				break;
			}
		}
		if( !interacted ){
			System.out.println(cannotDo);
			
		}
	}
	
	public void drinkPotion(String n){
		boolean eaten = false;
		for( int i = 0; i < possessions.size(); i++ ){
			if( n.equals(possessions.get(i).getName()) && possessions.get(i) instanceof Potion ){
				System.out.println("Eaten.");
				Potion p = (Potion)possessions.get(i);
				if( p.getBonusType().equals("Health") )
					addHealth(p.getBonus());
				else if( p.getBonusType().equals("Strength"))
					atk += p.getBonus();
				else if( p.getBonusType().equals("Exp"))
					addExp(p.getBonus()); 
				else
					System.out.println("The potion had no effect.");
				possessions.remove(i);
				eaten = true;
				break; 
			}	
		}
		if(!eaten)
			System.out.println("You cannot drink that.");
	}
	
	public void wearArmor(String n){
		boolean worn = false;
		for( int i = 0; i < possessions.size(); i++ ){
			if( n.equals(possessions.get(i).getName()) && possessions.get(i) instanceof Armor ){
				System.out.println("You put it on.");
				Armor a = (Armor)possessions.get(i);
				String t = a.getType();
				if(t.equals("Head"))
					head = a;
				else if(t.equals("Chest"))
					chest = a;
				else if(t.equals("Gloves"))
					gloves = a;
				else if(t.equals("Boots"))
					boots = a;
				worn = true;
				break; 
			}	
		}
		if(!worn)
			System.out.println("You cannot wear that.");
	}
	
	public int getArmorScore(){
		int score = 0;
		if( head != null)
			score += head.getBonus();
		if( chest != null)
			score += chest.getBonus();
		if( boots != null)
			score += boots.getBonus();
		if( gloves != null)
			score += gloves.getBonus();
		return score;
	}
	
	public void setNull(Item i){
		if( i.equals(equipped))
			equipped = null;
		else if( i.equals(head))
			head = null;
		else if(i.equals(chest))
			chest = null;
		else if(i.equals(gloves))
			gloves = null;
		else if(i.equals(boots))
			boots = null;
		i = null;
	}
	
	public void readManual(){
		Manual m = new Manual();
		m.read();
	}
	
	public void acceptQuest(String n){
		
	}
	
	public void manageQuests(){
		for(int i = 0; i < quests.size(); i++ )
			if( !(quests.get(i).getEngaged()) )
				quests.remove(i);
			
	}
	
	public void fillPipe(String n){
		boolean eaten = false;
		for( int i = 0; i < possessions.size(); i++ ){
			if( n.equals(possessions.get(i).getName()) && possessions.get(i) instanceof Pipeweed ){
				System.out.println("Done.");
				Pipeweed p = (Pipeweed)possessions.get(i);
				pipe.fillPipe(p);
				possessions.remove(i);
				eaten = true;
				break; 
			}	
		}
		if(!eaten)
			System.out.println("You cannot do that.");
	}
	
	public void smokePipe(){
		pipe.smokePipe();
	}
	
	public void use(String n){
		for(int i = 0; i < possessions.size(); i++)
			if(possessions.get(i) instanceof Pipe && n.equals(possessions.get(i).getName())){
				Pipe p = (Pipe)possessions.get(i);
				pipe = p;
				System.out.println("Used.");
		}
	}
	
	public void setGridPos(int x, int y, int h){
		xPos = x;
		yPos = y;
		height = h;
	}
	
	public void Fight(NPC n){
		int myAtk = atk;
		if(equipped != null)
			myAtk += equipped.getModifier();
		int myAC = getArmorScore() + getArmorClass();
		int enemyAtk = n.getAttack();
		int eAC = n.getArmorClass();
		//int pBar = 10;
		//int eBar = 10;
		int pAttack;
		int eAttack;
		
		while( getHealth() > 0 && n.getHealth() > 0){
			//System.out.println("Type your attack strength (0-10) : ");
			System.out.print("> ");
			response = unwanted.nextLine();
			//int eAtkVal = (int)(Math.random()*eBar)+1;
			/*if( Integer.parseInt(response) <= pBar )
				pAttack = myAtk + Integer.parseInt(response);
			else
				pAttack = myAtk;
			eAttack = enemyAtk + eAtkVal;
			if( Integer.parseInt(response) == 0 && eAttack > pAttack){
				 takeDamage(1);
				pBar -= Integer.parseInt(response);
				eBar -= eAtkVal;
				pBar += 4; eBar += 4;
				System.out.println("You limit your losses and block the attack, taking 1 damage.\n Your Health : " +  getHealth() + " Enemy Health : " + n.getHealth() + "\nYour Attack Bar : " + pBar + " Enemy Attack Bar : " + eBar);
			}else if(pAttack > eAttack){
				n.takeDamage(2);
				pBar -= Integer.parseInt(response);
				eBar -= eAtkVal;
				pBar += 4; eBar += 4;
				System.out.println("You strike the " + n.getName() + " and open a wound.\n Your Health : " +  getHealth() + " Enemy Health : " + n.getHealth() + "\nYour Attack Bar : " + pBar + " Enemy Attack Bar : " + eBar);			
			}else if(pAttack == eAttack){
				pBar -= Integer.parseInt(response);
				eBar -= eAtkVal;
				pBar += 4; eBar += 4;
				System.out.println("Neither you or the " + n.getName() + " can land a blow upon the other.\n Your Health : " +  getHealth() + " Enemy Health : " + n.getHealth() + "\nYour Attack Bar : " + pBar + " Enemy Attack Bar : " + eBar);
			}else if(pAttack < eAttack){
				 takeDamage(2);
				pBar -= Integer.parseInt(response);
				eBar -= eAtkVal;
				pBar += 4; eBar += 4;
				System.out.println("Your attack leaves you open, and the " + n.getName() + " delivers you a blow.\n Your Health : " +  getHealth() + " Enemy Health : " + n.getHealth() + "\nYour Attack Bar : " + pBar + " Enemy Attack Bar : " + eBar);
			}
			if( pBar > 10)
				pBar = 10;
			if( eBar > 10)
				eBar = 10;
			System.out.println("Your Attack : " + pAttack + " Enemy Attack : " + eAttack);*/
			/*pAttack = myAtk + (int)(Math.random()*6)+1;
			eAttack = enemyAtk + (int)(Math.random()*6)+1;
			switch(response){
				case "heavy attack" : 
					if(pAttack > eAttack){
						n.takeDamage(4);
						System.out.println("You heavily strike the " + n.getName() + " and open a great wound.\n Your Health : " +  getHealth() + " Enemy Health : " + n.getHealth());
					}
					else if(pAttack == eAttack)
						System.out.println("Neither you or the " + n.getName() + " can land a blow upon the other.\n Your Health : " +  getHealth() + " Enemy Health : " + n.getHealth());
					else if(pAttack < eAttack){
						 takeDamage(4);
						System.out.println("Your heavy attack leaves you open, and the " + n.getName() + " hits you hard.\n Your Health : " +  getHealth() + " Enemy Health : " + n.getHealth());
					}
					break;
				case "light attack" :
					if(pAttack > eAttack){
						n.takeDamage(2);
						System.out.println("You slash the " + n.getName() + " and draw blood.\n Your Health : " +  getHealth() + " Enemy Health : " + n.getHealth());
					}
					else if(pAttack == eAttack)
						System.out.println("Neither you or the " + n.getName() + " can land a blow upon the other.\n Your Health : " +  getHealth() + " Enemy Health : " + n.getHealth());
					else if(pAttack < eAttack){
						 takeDamage(2);
						System.out.println("The " + n.getName() + "'s attack lands upon you, wounding you slightly.\n Your Health : " +  getHealth() + " Enemy Health : " + n.getHealth());
					}
					break;
				case "block" :
					if((int)(Math.random()*6+1) % 3 == 0){
						System.out.println("You block the " + n.getName() + "'s attack.\n Your Health : " +  getHealth() + " Enemy Health : " + n.getHealth());
					}else{
						 takeDamage(1);
						System.out.println("Your block fails and the " + n.getName() + " deals you a painful blow.\n Your Health : " +  getHealth() + " Enemy Health : " + n.getHealth());
					}
					break;
			}
		}*/
			pAttack = myAtk + (int)(Math.random()*20)+1;
			eAttack = enemyAtk + (int)(Math.random()*20)+1;
			
		if( response.equals("attack")){
			if( pAttack > eAC){
				n.takeDamage(pAttack - eAC);
				System.out.println("You strike the " + n.getName() + ", delivering a sizeable wound.\n Your Health : " +  getHealth() + " Enemy Health : " + n.getHealth());
			}else if( pAttack <= n.getArmorClass())
				System.out.println("You cannot hit the " + n.getName() + ".\n Your Health : " +  getHealth() + " Enemy Health : " + n.getHealth());
		}
		System.out.println("How will you defend yourself?");
		System.out.print("> ");
		defense = unwanted2.nextLine();
		if( defense.equals("parry")){
			if( pAttack >= eAttack )
				System.out.println("You parry the attack of the " + n.getName() + ".\n Your Health : " +  getHealth() + " Enemy Health : " + n.getHealth());
			else{
				 takeDamage(eAttack - pAttack);
				System.out.println("Your attempt at parrying fails, and the " + n.getName() + " lands a blow.\n Your Health : " +  getHealth() + " Enemy Health : " + n.getHealth());
			}
		}else if( defense.equals("block")){
			if(myAC >= eAttack)
				System.out.println("Your armor repels the attack of the " + n.getName() + ".\n Your Health : " +  getHealth() + " Enemy Health : " + n.getHealth());
			else{
				 takeDamage(eAttack - myAC);
				System.out.println("Your armor cannot repel the attack of the " + n.getName() + ".\n Your Health : " +  getHealth() + " Enemy Health : " + n.getHealth());
			}
		}
		}
		
		if(  getHealth() <= 0 && n.getHealth() > 0 )
			System.out.println("You have died...");
		else{
			System.out.println(n.death());
			addExp(n.getExp());
			if( n.getItemDrop() != null ){
			if( n.getItemDrop().getName().substring(0).equals("A") || n.getItemDrop().getName().substring(0).equals("E") || n.getItemDrop().getName().substring(0).equals("I") || n.getItemDrop().getName().substring(0).equals("O") || n.getItemDrop().getName().substring(0).equals("U"))
				System.out.println("The " + n.getName() + " drops an " + n.getItemDrop().getName() + ".");
			else
				System.out.println("The " + n.getName() + " drops a " + n.getItemDrop().getName() + ".");
			getCurrLoc().addItem(n.getItemDrop());
			}
			
			if( n.getAlignment().equals("Good"))
				reputation -= 5;
			else if( n.getAlignment().equals("Neutral"))
				reputation -= 1;
			else
				reputation += 2;
			
			
		}
		
		
	}
	
	public void FightChar(Character n){
		int myAtk = atk;
		if(equipped != null)
			myAtk += equipped.getModifier();
		int myAC = getArmorScore() + getArmorClass();
		int enemyAtk = n.getAtk();
		int eAC = n.getArmorClass();
		//int pBar = 10;
		//int eBar = 10;
		int pAttack;
		int eAttack;
		
		while( getHealth() > 0 && n.getHealth() > 0){
			//System.out.println("Type your attack strength (0-10) : ");
			System.out.print("> ");
			response = unwanted.nextLine();
			pAttack = myAtk + (int)(Math.random()*20)+1;
			eAttack = enemyAtk + (int)(Math.random()*20)+1;
			
		if( response.equals("attack")){
			if( pAttack > eAC){
				n.takeDamage(pAttack - eAC);
				System.out.println("You strike " + n.getName() + ", delivering a sizeable wound.\n Your Health : " +  getHealth() + " Enemy Health : " + n.getHealth());
			}else if( pAttack <= n.getArmorClass())
				System.out.println("You cannot hit " + n.getName() + ".\n Your Health : " +  getHealth() + " Enemy Health : " + n.getHealth());
		}
		System.out.println("How will you defend yourself?");
		System.out.print("> ");
		defense = unwanted2.nextLine();
		if( defense.equals("parry")){
			if( pAttack >= eAttack )
				System.out.println("You parry the attack of " + n.getName() + ".\n Your Health : " +  getHealth() + " Enemy Health : " + n.getHealth());
			else{
				 takeDamage(eAttack - pAttack);
				System.out.println("Your attempt at parrying fails, and " + n.getName() + " lands a blow.\n Your Health : " +  getHealth() + " Enemy Health : " + n.getHealth());
			}
		}else if( defense.equals("block")){
			if(myAC >= eAttack)
				System.out.println("Your armor repels the attack of " + n.getName() + ".\n Your Health : " +  getHealth() + " Enemy Health : " + n.getHealth());
			else{
				 takeDamage(eAttack - myAC);
				System.out.println("Your armor cannot repel the attack of " + n.getName() + ".\n Your Health : " +  getHealth() + " Enemy Health : " + n.getHealth());
			}
		}
		}
		
		if(  getHealth() <= 0 && n.getHealth() > 0 )
			System.out.println("You have died...");
		else{
			System.out.println("You kill " + n.getName() + ".");
			addExp(n.getExp());
			/*if( n.getItemDrop() != null ){
			if( n.getItemDrop().getName().substring(0).equals("A") || n.getItemDrop().getName().substring(0).equals("E") || n.getItemDrop().getName().substring(0).equals("I") || n.getItemDrop().getName().substring(0).equals("O") || n.getItemDrop().getName().substring(0).equals("U"))
				System.out.println("The " + n.getName() + " drops an " + n.getItemDrop().getName() + ".");
			else
				System.out.println("The " + n.getName() + " drops a " + n.getItemDrop().getName() + ".");
			getCurrLoc().addItem(n.getItemDrop());
			}*/
			
			/*if( n.getAlignment().equals("Good"))
				reputation -= 5;
			else if( n.getAlignment().equals("Neutral"))
				reputation -= 1;
			else
				reputation += 2;*/
			
			
		}
		
		
	}
	
	public String getName(){
		return name;
	}
	
	public String getRace(){
		return race;
	}
	
	public void incrementAtk(int i){
		atk += i;
	}
	
	public int getReputation(){
		return reputation;
	}
	
	public void incrementReputation(int i){
		reputation += i;
	}
	
	public void attackCharacter( String n ){
		boolean fought = false;
		for(int i = 0; i < xyg.getCharcters().size(); i++ ){
			if( n.equals(xyg.getCharcters().get(i).getName()) && xyg.getCharcters().get(i).getCurrLoc().equals(getCurrLoc())){
					FightChar(xyg.getCharcters().get(i));
					fought = true;
					break;
			}
		}
		if( !fought ){
			System.out.println(cannotDo);
			
		}
	}
}
