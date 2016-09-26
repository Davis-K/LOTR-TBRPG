import java.util.ArrayList;
import java.util.Scanner;

public class Market extends Building {
	private Scanner unwanted = new Scanner(System.in);
	private ArrayList<Item> forSale = new ArrayList<Item>();
	private XY_Grid g;
	public Market( String r, XY_Grid gr ){
		super( "market", r );
		g = gr;
		fillMarket();
	}
	
	public void fillMarket(){
		Lembas l = new Lembas();
		Sword s = new Sword();
		Corn c = new Corn(); 
		Food applePie = new Food(10, "Apple Pie", 6);
		Food carrot = new Food(5, "Carrot", 3);
		Potion bh = new Potion( 7, "Basic Healing", 5, "Health");
		Potion hh = new Potion( 9, "Hobbit Medicine", 6, "Health");
		if(getRace().equals("Elf")){
			for(int i = 0; i < 5; i++)
				if( (int)(Math.random()*6+1) % 2 == 0 )
					forSale.add(l);	
			for(int i = 0; i < 5; i++)
				if( (int)(Math.random()*6+1) % 2 == 0 )
					forSale.add(bh);
			for(int i = 0; i < 3; i++)
				if((int)(Math.random()*8+1) == 8)
					forSale.add(new Armor(24, "Elvish Mithril Coat", 5, "Chest"));
			for(int i = 0; i < 5; i++)
				if((int)(Math.random()*6+1) % 3 == 0)
					forSale.add(new Armor(14, "Elvish Steel Helm", 2, "Head"));
		}
		else if(getRace().equals("Hobbit")){
			for(int x = 0; x < 5; x++)
				if( (int)(Math.random()*6+1) % 2 == 0 ){
					forSale.add(c);
					forSale.add(hh);
					forSale.add(new Armor(3, "Oven Mitts", 0, "Gloves"));
				}
			for(int x = 0; x < 5; x++)
				if( (int)(Math.random()*4+1) % 3 == 0 ){
					forSale.add(new Food(8, "Bread", 5));
					forSale.add(new Armor(5, "Walking Boots", 1, "Boots"));
				}
			for(int x = 0; x < 3; x++)
				if( (int)(Math.random()*4+1) % 4 == 0)
					forSale.add(applePie);
		
		}
		else if(getRace().equals("Human")){
			for(int x = 0; x < 5; x++){
				if( (int)(Math.random()*8+1) < 4 ){
					forSale.add(s);
					forSale.add(new Armor(8, "Leather Armor", 2, "Chest"));
				}
				if( (int)(Math.random()*8+1) > 4)
					forSale.add(c);
				if( (int)(Math.random()*6+1) % 3 == 0 )
					forSale.add(new Food(8, "Bread", 5));
			}
			for(int x = 0; x < 7; x++)
				if( (int)(Math.random()*6+1) % 2 == 0 )
					forSale.add(carrot);
				if( (int)(Math.random()*6+1) % 3 == 0 )
					forSale.add(new Armor(5, "Winter Mitts", 1, "Gloves"));
		}

	}
	
	public void enter(){
		String response;
		
		if(getRace().equals("Elf"))
			System.out.println("Elven men and women move between the shops, buying and selling goods.");
		else if(getRace().equals("Human"))
			System.out.println("Human men and women move between the shops, buying and selling goods.");
		else if(getRace().equals("Dwarf"))
			System.out.println("Dwarves move between the shops, buying and selling goods.");
		else if(getRace().equals("Hobbit"))
			System.out.println("Hobbits move between the shops, buying and selling goods.");
		
		System.out.println("The following items are for sale here:");
		
		int i = 0;
		showContents();
		while( i < 1 ){
			System.out.print("> ");
			response = unwanted.nextLine();
			switch(response){
				default :
					if(response.indexOf(' ') > 0){
						String firstWord = response.substring(0,response.indexOf(' '));
						String name = response.substring(response.indexOf(' ')+1);
						if(firstWord.equals("buy")){
					
					for(int x = 0; x < forSale.size(); x++ ){
						if( forSale.get(x).getName().equals(name)){
							if(g.getPlayer().getMoney() >= forSale.get(x).getCost()){
								g.getPlayer().getPossessions().add(forSale.get(x));
								g.getPlayer().spendMoney(forSale.get(x).getCost());
								forSale.remove(x);
								System.out.println("Purchased. You have $" + g.getPlayer().getMoney() + " remaining.");
								break;
							}else
								System.out.println("You do not have enough money to complete the purchase.");
						}
					}
					showContents();
					}
				if(firstWord.equals("sell")){
					for(int x = 0; x < g.getPlayer().getPossessions().size(); x++ ){
						if(name.equals(g.getPlayer().getPossessions().get(x).getName())){
							Item sold = g.getPlayer().getPossessions().get(x);
							
							if(sold.equals(g.getPlayer().getEquippedWeapon())){
								g.getPlayer().setNull(g.getPlayer().getEquippedWeapon());
							}else if(sold.equals(g.getPlayer().getHead()))
								g.getPlayer().setNull(g.getPlayer().getHead());
							else if(sold.equals(g.getPlayer().getChest()))
								g.getPlayer().setNull(g.getPlayer().getChest());
							else if(sold.equals(g.getPlayer().getGloves()))
								g.getPlayer().setNull(g.getPlayer().getGloves());
							else if(sold.equals(g.getPlayer().getBoots()))
								g.getPlayer().setNull(g.getPlayer().getBoots());
							forSale.add(g.getPlayer().getPossessions().get(x));
							
							g.getPlayer().addMoney(g.getPlayer().getPossessions().get(x).getCost());
							g.getPlayer().getPossessions().remove(x);
							System.out.println("Sold. You have $" + g.getPlayer().getMoney() + " remaining.");
							break;
						}
					}
					showContents();
					}
				
				}
				}
			if(response.equals("leave")){
				System.out.println("You leave the market.");
				i++;
							
			}
		}
			
			
		}
	
	public void showContents(){
		System.out.println("Food:		Hunger Bonus:	Cost:");
		for( int i = 0; i < forSale.size(); i++ ){
			if(forSale.get(i) instanceof Food)
				if( forSale.get(i).getName().length() > 7 )
					System.out.println( forSale.get(i).getName() + "	" + forSale.get(i).getHungerBonus() + "		" +  forSale.get(i).getCost());
				else
					System.out.println( forSale.get(i).getName() + "		" + forSale.get(i).getHungerBonus() + "		" +  forSale.get(i).getCost());
		}
		System.out.println();
		System.out.println("Weapon:		Attack Bonus:	Cost:		Level:");
		Weapon w;
		for( int i = 0; i < forSale.size(); i++ ){
			if(forSale.get(i) instanceof Weapon){
				w = (Weapon)forSale.get(i);
				if( w.getName().length() > 7 )
					System.out.println( w.getName() + "	" + w.getModifier() + "		" + w.getCost() + "		" + w.getLevel());
				else
					System.out.println( w.getName() + "		" + w.getModifier() + "		" + w.getCost() + "		" + w.getLevel());
			}
		}
		System.out.println();
		System.out.println("Armor:		Defense Bonus:	Cost:		Type:");
		Armor a;
		for( int i = 0; i < forSale.size(); i++ ){
			if(forSale.get(i) instanceof Armor){
				a = (Armor)forSale.get(i);
				if( a.getName().length() > 7 )
					System.out.println( a.getName() + "	" + a.getBonus() + "		" + a.getCost() + "		" + a.getType());
				else
					System.out.println( a.getName() + "		" + a.getBonus() + "		" + a.getCost() + "		" + a.getType());
			}
		}
		System.out.println();
		System.out.println("Potion:		Bonus:		Cost:		Type:");
		Potion p;
		for( int i = 0; i < forSale.size(); i++ ){
			if(forSale.get(i) instanceof Potion){
				p = (Potion)forSale.get(i);
				if( p.getName().length() > 7 )
					System.out.println( p.getName() + "	" + p.getBonus() + "		" + p.getCost() + "		" + p.getBonusType());
				else
					System.out.println( p.getName() + "		" + p.getBonus() + "		" + p.getCost() + "		" + p.getBonusType());
			}
		}
		System.out.println();
		System.out.println("Other Items:	Cost:");
		for(int i = 0; i < forSale.size(); i++){
			if(!(forSale.get(i) instanceof Potion ) && !(forSale.get(i) instanceof Weapon) && !(forSale.get(i) instanceof Armor) && !(forSale.get(i) instanceof Food))
				if( forSale.get(i).getName().length() > 7 )
					System.out.println(forSale.get(i).getName() + "	" + forSale.get(i).getCost());
				else
					System.out.println(forSale.get(i).getName() + "		" + forSale.get(i).getCost());
		}
	}
	
	public ArrayList<Item> getForSale(){
		return forSale;
	}
}
