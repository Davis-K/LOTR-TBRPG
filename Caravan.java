
public class Caravan extends Character {
	int moves = 0;
	
	public Caravan( String n, int x, int y, int h ){
		super( n, "Caravan", x, y, h, 0, 100, 200, 0 );
	}
	
	public void buy(){
		Location currLoc;
		if(getGrid().isLoc(getXPos(), getYPos(), getHeight())){
			currLoc = getGrid().getLocations()[getXPos()][getYPos()][getHeight()];
		for( int i = 0; i < currLoc.getBuildings().size(); i++ ){
			Market m;
			
			if( currLoc.getBuildings().get(i) instanceof Market ){
				m = (Market)currLoc.getBuildings().get(i);
				for( int x = 0; x < 2; x++ ){
					if( m.getForSale().size() >= x){
					getPossessions().add(m.getForSale().get(x));
					m.getForSale().remove(x);
					spendMoney(m.getForSale().get(x).getCost());
					}
				}
				break;
		}
		}
		}
	}
	
	public void move(){
		if(getXPos() > 8)
			moveWest();
		else if(getXPos() < 19)
			moveEast();
		getCurrLoc().enterLoc();
		moves++;
		
	}
	
	public String intro(){
		for( int x = 0; x < getPossessions().size(); x++)
			System.out.print( " " + getPossessions().get(x).getName() + "," );
		return "There is a Caravan here.";
	}
}
