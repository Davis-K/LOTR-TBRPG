import java.util.ArrayList;

public class Pipe extends Item{
	private ArrayList<Pipeweed> fill = new ArrayList<Pipeweed>();
	public Pipe( int c, String n ){
		super( c, n );
	}
	
	public void fillPipe(Pipeweed p){
		if( fill.size() < 1 ){
			fill.add(p);
			System.out.println("You fill your pipe with " + p.getName() + ".");
		}else
			System.out.println("Your pipe is already full.");
	}
	
	public void smokePipe(){
		if(fill.size() == 1){
			System.out.println("You blow magnificent smoke rings into the sky.");
			fill.remove(0);
		}else
			System.out.println("Your pipe is not full.");
	}
	
	public ArrayList<Pipeweed> getFill(){
		return fill;
	}
}
