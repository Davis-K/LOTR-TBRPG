public class ShireJunction extends Location{
	Chest c = new Chest( 0, this);
	Sword s = new Sword();
	public ShireJunction( XY_Grid g ){
		super( "Shire Junction", 11, 12, 0, false, true, true, true, true, "You are standing at a junction on the Great East Road. Woods lie to the south and a rutted road leads north \nthrough fields.", g);
		addItem(c);
		c.getContents().add(s);
	}
}
