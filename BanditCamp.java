import java.util.ArrayList;

public class BanditCamp extends Location {
	public boolean campDestroyed = false;
	
	public BanditCamp( XY_Grid g ){
		super( "Path", 16, 11, 0, false, true, true, false, true, "You are standing on a north-south path through the Bree-Fields. The lights of Bree are visible to the south.", g);
		addNPC(new Bandit());
		addNPC(new Bandit());
		addNPC(new BanditChief());
	}
	
	public String getName(){
		for( int i = 0; i < getNPCs().size(); i++ )
			if(getNPCs().get(i) instanceof BanditChief)
				return "Bandit Camp";
		return "Path";
	}
	
	public String getText(){
			for( int i = 0; i < getNPCs().size(); i++ )
				if(getNPCs().get(i) instanceof BanditChief && campDestroyed == false)
					return "A bandit camp stands here, with fires smoking and loathsome bandits counting their riches.";
			this.setCampdestroyed(true);
			campDestroyed = true;
			return "You are standing on a north-south path through the Bree-Fields. The lights of Bree are visible to the south.";
	}
}
