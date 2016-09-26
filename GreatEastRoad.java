public class GreatEastRoad extends Location {
	public GreatEastRoad( XY_Grid g, int x, int y, int h, boolean w, boolean e, boolean s, boolean no, String et){
		super( "Great East Road", x, y, h, false, no, s, e, w, "You are standing on the Great East Road, which stretches as far as the eye can see to the east and west." + et, g);
	}
}
