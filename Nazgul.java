
public class Nazgul extends NPC {
	public Nazgul(){
		super("Nazgul", "Nazgul", 20, 40, 28, "Evil", 30, new Weapon(50, "Morgul Blade", 8, 15));
	}
	
	public String intro(){
		return "Appearing before you is the spectral shape of a figure clad in all Black. It is one of the Nazgul, the \nnine servants of the Dark Lord Sauron. You shiver in fear and face this indomitable foe.";
	}
}
