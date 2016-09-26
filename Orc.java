
public class Orc extends NPC{
	public Orc(){
		super( "Orc Grunt", "Orc", 7, 10, 18, "Evil", 5, new Weapon( 4, "Orcish Sword", 1, 1 ));
	}
	
	public void interact(){
		System.out.println("*Unintelligible muttering and shouting, presumably in orcish*");
	}
}
