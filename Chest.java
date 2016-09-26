import java.util.ArrayList;

public class Chest extends Item{
	private ArrayList<Item> contents = new ArrayList<Item>();
	Location here;
	public Chest( int c, Location l ){
		super(c, "Chest");
		here = l;
	}
	
	public ArrayList<Item> getContents(){
		return contents;
	}
	
	public void openChest(){
		if(contents.size() > 0){
			System.out.println("The chest contains the following items:");
			for( int i = 0; i < contents.size(); i++ ){
				System.out.println(contents.get(i).getName());
				here.getItems().add(contents.remove(i));
			}
		}else
			System.out.println("The chest is revealed to be empty.");
	}
		
}
