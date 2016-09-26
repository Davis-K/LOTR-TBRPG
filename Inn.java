import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Inn extends Building {
	private Scanner unwanted = new Scanner(System.in);
	private XY_Grid gr;
	private String name;
	private ArrayList<Quest> quests = new ArrayList<Quest>();
	
	public Inn(String n, String r, XY_Grid g) {
		super(n + " Inn", r);
		gr = g;
		name = n;
		
	}
	
	public void enter(){
		
		
		System.out.println("You enter the " + name + " Inn.");
		if(getRace().equals("Elf"))
			System.out.println("Elves sit peacefully at tables, smoking and chatting mildly of over drinks.");
		else if(getRace().equals("Human"))
			System.out.println("Humans and members of races of all sorts share drinks and gamble. Loud and drunk singing can be heard.");
		else if(getRace().equals("Dwarf"))
			System.out.println("Dwarves eat and drink boisterously in the dark inn, rolling dice and shouting as they gamble away their hard-earned riches.");
		else if(getRace().equals("Hobbit"))
			System.out.println("Hobbit men and women smoke their long pipes and down ale over gossip and tales of days gone by.");
		int x = 0;
		System.out.println("What do you want to do?");
		String response; 
		while( x < 1 ){
			System.out.println("Ale costs $5 at the counter, while dice gambling is available here. You may also undertake quests.");
			System.out.print("> ");
			response = unwanted.nextLine();
			
			switch(response){
			case "drink" :
				if( gr.getPlayer().getMoney() >= 5 ){
					System.out.println("You pay for and down a glass of ale, gaining 2 health points." );
					gr.getPlayer().spendMoney(5);
					gr.getPlayer().incrementHunger(-2);
				}else
					System.out.println("You cannot afford a drink.");
				break;
			case "gamble" :
				gamble();
				break;
			case "quest" :
				takeQuests();
				break;
			case "leave" :
				System.out.println("You leave the inn.");
				x++;
				break;
		}
	}
}
	public void gamble(){
		int x = 0;
		int roll;
		String response;
		System.out.println("The game played here is called Rull. Two 6-sided dice are rolled, and you bet on whether the sum will come up even or odd.");
		System.out.println("To play, simply enter either 'even' or 'odd' followed by the number of coins you bid.");
		System.out.println("You may quit the game at any time by entering the word 'quit'.");
		while( x < 1 ){
			System.out.print("> ");
			roll = (int)(Math.random()*12)+1;
			response = unwanted.nextLine();
			switch(response){
				case "leave" :
					x++;
					System.out.println("You decide to leave the game while you are still ahead.");
					break;
				default :
					if(response.indexOf(' ') > 0){
						String firstWord = response.substring(0,response.indexOf(' '));
						int bet = Integer.parseInt(response.substring(response.indexOf(' ')+1));
						if(bet <= gr.getPlayer().getMoney()){
							if( firstWord.equals("even")){
								if(roll % 2 == 0){
									gr.getPlayer().addMoney(2*bet);
									System.out.println("You win! You have gained " + bet*2 + " coins. You have $" + gr.getPlayer().getMoney() + " remaining.");
								}else{
									gr.getPlayer().spendMoney(bet);
									System.out.println("You lose. You have lost " + bet + " coins. You have $" + gr.getPlayer().getMoney() + " remaining.");
									}
							}else if( firstWord.equals("odd")){
								if(roll % 2 == 0){
									gr.getPlayer().spendMoney(bet);
									System.out.println("You lose. You have lost " + bet + " coins. You have $" + gr.getPlayer().getMoney() + " remaining.");
								}else{
									gr.getPlayer().addMoney(2*bet);
									System.out.println("You win! You have gained " + bet*2 + " coins. You have $" + gr.getPlayer().getMoney() + " remaining.");
								}
							}
						}	
					}
					break;
			}
		}
	}
	
	public ArrayList<Quest> getQuests(){
		return quests;
	}
	public void takeQuests(){
		System.out.println("The folowing quests are available:");
		String response;
		int x = 0;
		while( x < 1 ){
			for( int i = 0; i < quests.size(); i++ ){
				if(!(quests.get(i).getFulfill()))
					System.out.println("Name: " + quests.get(i).getName() + "	Type: " + quests.get(i).getType() + "	Employer: " + quests.get(i).person());
				else
					quests.remove(i);
			}
		System.out.print("> ");
		
		response = unwanted.nextLine();
		for( int i = 0; i < quests.size(); i++)
			if(response.equals(quests.get(i).getName())){
				if(!quests.get(i).getEngaged()){
					System.out.println("Quest Undertaken.");
					quests.get(i).engageQuest();
				}else
					quests.get(i).fulfill();
				
				
				if( quests.get(i) instanceof Assassination){
					Assassination a = (Assassination) quests.get(i);
					if(a.getLoc() != null)
						a.getLoc().addNPC(a.getTarget());
				}
			}
		
		if(response.equals("leave"))
			x++;
		}
	}
}
