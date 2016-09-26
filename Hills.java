public class Hills extends Location{
	public Hills(String name, XY_Grid g, int x, int y, int h, boolean is, boolean w, boolean e, boolean s, boolean no, String et){
		super( name, x, y, h, is, no, s, e, w, "You are in the " + name + "." + et, g);
	}
}
