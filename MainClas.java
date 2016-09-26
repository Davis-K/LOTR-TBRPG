
public class MainClas {
	
	public static void main(String[]args){
		XY_Grid a = new XY_Grid();
		
		//LOCATIONS
		//The Shire
		TheHill theHill = new TheHill( a );//^
		Location pathFH = new Location( "Stone Path", 10, 10, 0, false, true, true, false, false, "You are standing on a narrow stone path heading north-south on a green, grassy hill. \nHobbit-holes can be seen all over. To the south, the sleepy village of Hobbiton sits amid the widespread fields.", a);
		Hobbiton hobbiton = new Hobbiton( a );//^
		Location gerPastHobbiton = new Location( "Great East Road", 10, 12, 0, false, true, true, true, true, "You are standing on the Great East Road at a four way junction. Paths lead north to Hobbiton and south towards Tuckborough.", a);
		Location waymeet = new Location( "Waymeet", 9, 12, 0, false, true, false, true, true, "You are standing at a junction on the Great East Road. Fields of Hay and Corn surround you, tended by Hobbit farmers. \nA path leads north through the fields, and another south through a line of hills.", a );
		Location hayfield = new Location( "Hayfield", 9, 11, 0, false, true, true, false, true, "You are standing on a dirt path in the middle of a hayfield. To the north, the path leads into a bog. \nTo the south is the Waymeet junction. A path also leads west into some low hills.", a );
		Location michelDelving = new Location( "Michel Delving", 8, 12, 0, false, true, false, true, true, "You are in the center of the largest town and capital of the Shire, Michel Delving. This town \nis situated at the Eastern edge of the White Downs, the set of low hills that form the Western border of the Shire. \nThe Great East Road passes through the town and heads East towards Hobbiton and West beyond the White Downs. ", a );//^
		ShireJunction shireJunction = new ShireJunction( a );
		Location stock = new Location( "Stock", 12, 13, 0, false, true, true, false, true, "You are in the little town of Stock, renowned for its pipeweed and agricultural product. The Great East \nRoad is to the north and the Marish to the south.", a);
		Location theMarish = new Location( "The Marish", 12, 14, 0, false, true, true, false, true, "You are in the midst of a boggy area, known as the Marish to the Hobbits of Stoorish descent that \nlive here. The fertility of this area has led to the construction of numerous farms.", a);
		Location budgefordFields = new Location( "Budgeford Fields", 11, 11, 0, false, true, true, true, false, "You are on a north-south path through the fields around the Hobbit hamlet of Budgeford. All is green and quiet here.", a);
		Location rushockBog = new Location( "Rushock Bog", 9, 10, 0, false, true, true, false, false, "You are in a small bog. Insects and little swamp creatures rise from the long grass and dragonflies \nbuzz around the rushocks. You can see the White Downs rising to the west. A path runs through the \nbog to the north and south.", a);
		Location tuckborough = new Location( "Tuckborough", 10, 13, 0, false, true, false, true, true, "You stand on a junction where an north-south and east-west path meet. This is Tuckborough, home of the prestigious Took clan of Hobbits. Their holes are arrayed on a hillside to the south.", a);
		Location nsFieldPath = new Location( "Path", 11, 10, 0, false, true, true, true, false, "You are on a north-south path through some fields.", a);
		Location scary =  new Location("Scary", 11, 9, 0, true, true, true, true, true, "You are in the village of Scary, the mining central of the Shire. Here are housed the Miner's Guild, \nas well as the bustling mines that in recent times have driven deep down into the earth.", a);
		Location littleDelving =  new Location("Little Delving", 8, 10, 0, false, false, true, true, true, "You are in the small hobbit community of Little Delving, where roads lead east and south. There are not \nmany inhabitants of this place, but it cannot be seen why, as the rolling hills and rippling creeks make this \na lovely place.", a);
		QuarryEntrance quarry = new QuarryEntrance(a);
		Location brandywineBridge = new Location( "Brandywine Bridge", 12, 12, 0, false, true, true, true, true, "You stand on the Great East Road on the west bank of the Brandywine River, which flows peacefully north-south and \nforms the eastern border of the Shire. The road continues west towards Hobbiton and east over the Brandywine Bridge \ntowards Buckland. Little farms dot the area and wooded and marshy areas can be seen to the south.", a );
		//Bree-Land
		Location buckland = new Location( "Buckland", 13, 12, 0, false, true, true, true, true, "You are in the small town of Buckland, home of the Brandybuck family of Hobbits. The Great East Road passes \nthrough here, heading west over the Brandywine Bridge and east towards the town of Bree. The looming, ominous mass of \nthe Old Forest can be easily seen to the south.",a );//^
		Location breeFieldsSouth = new Location( "Southern Bree-Fields", 14, 12, 0, false, true, true, true, true, "You are standing on the Great East Road as it passes east-west through the southernmost Bree-Fields. To the \nsouth, the Barrow-Downs loom amid the mist. To the east, a creek is visible through the corn stalks, running \nnorth-south perpendicular to the road.",a );
		Location breeJunction = new Location( "Bree Junction", 15, 12, 0, false, true, true, true, true, "You are standing at a four-way junction on the Great East Road. The road itself runs west through a small \ncreek and beyond into cornfields and east into the town of Bree. There is also a north-south path here, \nleading North into the cornfields and south into the Barrow-Downs which loom above the junction.", a );
		Bree bree = new Bree( a );
		Staddle staddle = new Staddle( a );
		Location combe = new Location( "Combe", 17, 11, 0, false, true, true, true, false, "You are in Combe, a little town on the north-south road between the Archet Dale and Bree. A line of hills \nblocks westward passage.", a );
		Location archet = new Location( "Archet", 17, 10, 0, false, false, true, true, false, "You are in Archet, a small trading village in Archet Dale, a little valley surrounded by low hills in the \nnorth of Bree-Land. A road leads to the south and a path leads east into the Dale.", a );
		Hills brandyHills = new Hills( "Brandy Hills", a, 13, 11, 0, false, false, true, true, true, " The town of Buckland is visible to the south.");
		Hills weatherHills = new Hills( "Weather Hills", a, 19, 12, 0, false, true, false, true, false, " Any evidence of human passage through this area is at a premium. The Great East Road is visible to the south.");
		Hills wh2 = new Hills( "Weather Hills", a, 19, 11, 0, false, true, false, false, true, "");
		MidgewaterMarsh midgewaterMarsh = new MidgewaterMarsh( a );
		GreatEastRoad gerToLL = new GreatEastRoad( a, 19, 13, 0, true, true, true, true, " You have reached the eastern boundary \nof Bree-Land. The empty plains and hills of the Lone-Lands beckon to the east, and the Weather Hills rise to the north and south.");
		Location oldForest = new Location( "The Old Forest", 13, 13, 0, false, true, true, true, true, "You are standing in a dense, dark forest. This is the Old Forest, one of the oldest wooded areas in the world. \nThe trees bend and groan and seem to whisper to one another in the wind.", a );
		BanditCamp banditCamp = new BanditCamp( a );
		Location chetwoodSouth = new Location( "Chetwood South", 17, 13, 0, false, true, false, true, false, "You are in a peaceful wood, full of tall oaks and singing birds. The Great East Road heads north and east here.", a);
		Location breeFieldsNorth = new Location( "Northern Bree-Fields", 16, 9, 0, false, true, true, true, false, "You are in a wheat-field. Tall yellow stalks rise into the sky, in some places blotting out the sun. \nThe owners of this place obviously run a flourishing establishment. A path runs north-south through \nhere, and another path turns east.", a);
		Location chetwoodNorth = new Location( "Chetwood North", 18, 11, 0, false, false, false, true, true, "You are in a peaceful wood, full of tall oaks and singing birds. The light of the sun reveals hills to the \nnorth and south, which look impassable.", a);
		Location barrowDownsNorth = new Location( "Barrow-Downs", 14, 13, 0, false, true, true, true, true, "You are in the midst of the Barrow-Downs, a region reputed for its habitation of Barrow-Wights. Mist and fog swirls all around.", a);
		GreatEastRoad gerBreeLand = new GreatEastRoad( a, 18, 13, 0, true, true, false, true, " The Chetwood can be seen to the west \nand a large marsh to the north.");
		Location archetDale = new Location("Archet Dale", 18, 10, 0, false, false, false, false, true, "You are standing on the shore of a small pond. Low hills ring the area, and a path leads west through the green fields.", a);
		Location andrath = new Location( "Andrath", 15, 13, 0, false, true, true, false, true, "You are standing on the Great South Road, or the Greenway, as it heads north and south over the narrow \npass of Andrath. The Barrow-Downs loom to the west and a small lake can be seen to the east.", a);
		Location greenway1 = new Location( "The Greenway", 16, 10, 0, false, true, true, false, true, "You are on the Great South Road. There are low hills to the east, and the road continues to the north and south.", a);
		Location easternBreeFields = new Location("Eastern Bree-Fields", 17, 9, 0, false, false, false, true, true, "You are standing some fields. Woods loom to the east, hills to the south, and a river blocks northward passage.", a);
		//Lone-Lands
		GERForsakenInn gerForsakenInn = new GERForsakenInn( a );
		GreatEastRoad gerAnnunlos = new GreatEastRoad( a, 21, 13, 0, true, true, false, true, " From your position, a ruined castle can \nbe seen standing atop a lonely hill directly to the north.");
		GreatEastRoad gerNainEnidh = new GreatEastRoad( a, 22, 13, 0, true, true, false, true, " Many large hills rise to your north and \nsouth, their slopes barren without vegetation. This area is called Nain Enidh by the Elves, which translates \nto 'Central Valleys'.");
		GreatEastRoad gerTalathGaun = new GreatEastRoad( a, 23, 13, 0, true, true, false, true, " This area is full of rolling hills and \ndotted by sparse trees.");
		Location beforeWeathertop = new Location( "Before Weathertop", 21, 12, 0, true, true, true, false, false, "You are standing before an abandoned fortress atop the hill of Amon Sul. Once a symbol of Numenorean reign \nin the west, it is now rumored to be haunted. Stairs wind their way up before you to the castle, and the \nGreat East Road is visible to the south.", a);
		Location weathertop =  new Location( "Weathertop", 21, 12, 1, true, false, false, false, false, "You stand in the mists atop the Watchtower of Amon Sul, Weathertop. Fog swirls and eddies around you, and a chill rolls down your spine.", a);
		Location minasEriol = new Location( "Minas Eriol", 20, 14, 0, false, true, false, false, false, "You are among the ruins of Minas Eriol, once a Gondorian Castle but now a crumbling ruin, a haven to \nbeasts of many kinds.", a);
		Location theLastBridge = new Location( "The Last Bridge", 24, 13, 0, false, true, false, true, true, "You are standing on a stone bridge spanning a small river. The Great East Road crosses this bridge and heads \nwest into the Lone Lands and east into the dark woods of Trollshaws.", a );
		//Trollshaws
		Location trollshawsSouth =  new Location( "South Trollshaws", 25, 13, 0, false, true, true, true, true, "You are in the south-western corner of Trollshaws. Pines and Firs rise all around, and the Great East Road heads east and west from this point.", a);
		Location narrowDefile = new Location( "Narrow Defile", 25, 12, 0, false, true, true, false, true, "You are in a narrow North-South defile running through the hills of Trollshaws. There are impassible hills \nto the east, and a large cave to the west. Forests abound to the north and south.", a);
		Location trollCave = new Location( "Troll Cave", 24, 12, 0, false, false, false, true, false, "You have stumbled upon a Troll Cave! Beneath the high ceiling of this monstrous locale are huge wooden \nboxes, most locked securely with huge locks forged by Dwarves in ages gone by.", a);
		Location bruinenGorges = new Location( "Bruinen Gorges", 26, 13, 0, false, true, false, true, true, "You are standing deep in a gorge running east-west through Trollshaws. The Great East Road, here a faded \ntrack broken apart by years without maintenance, runs down the gorge towards the River Bruinen.", a);
		Location bruinenFord = new Location( "Bruinen Ford", 27, 13, 0, false, false, true, true, true, "You are standing upon the west bank of the River Bruinen. Cascades of water pour southwards, but this point \nappears to be fordable. This hallowed river is rumoredly home to ancient Elven spirits of water. Rugged hills \nto the north and south make travel in those directions impossible.", a);
		Location highMoor = new Location( "High Moor", 28, 13, 0, false, true, false, true, true, "You are standing on a misty moor. To the west the River Bruinen can be seen, and there are hills all around, \nbut they look passable.", a);
		Location rivendell = new Location( "Rivendell", 28, 12, 0, true, true, true, true, false, "You are in the midst of the most beautiful city in all the west: Rivendell. Here is the haven of \nMaster Elrond, master of lores and descendant of the Noldor of old. Here are the beautiful gardens, \ntowers, and libraries of the Elves, and the last great collection of their works in the world. This fantastic \nplace, known as Imladris to the Elves, is home to many, Elves, Men, and others, all who oppose or \nfear the Dark. This is Elrond's Last Homely House before passage over the Misty Mountains, which rise \nabove the city to the east, and all that lies beyond. Waterfalls cascade down from cliffs overlooking \nthe city, and trees, well-tended and healthy, swing in the gentle breeze that blows through this city of light.", a);
		Location trollshawsNorth = new Location( "North Trollshaws", 25, 11, 0, false, false, true, true, false, "You are in an open forest surrounded by tall pines and firs. Wild animals surely hide \nand hunt in this area.", a);
		Location talBruinen =  new Location( "Tal Bruinen", 27, 14, 0, false, true, false, true, false, "You in a wooded area full of little winding rivers, rocks, and ruins. These are the wilds of Tal Bruinen, once civilized land but now broken and desolate.", a);
		Location giantValley = new Location( "Giant Valley", 29, 13, 0, false, false, true, true, true, "You are on a sloping valley clad in tall trees. Many, though, have been smashed and broken, as if a hurricane or wild beast has passed.", a);
		//Eregion
		Location gwingris = new Location( "Gwingris", 28, 14, 0, false, false, true, true, true, "You are standing before the outpost of Gwingris, a partially ruined Elven settlement. A few Elves wander among the low stone buildings.", a);
		
		a.addLocation(pathFH);
		a.addLocation(theHill);
		a.addLocation(hobbiton);
		a.addLocation(waymeet);
		a.addLocation(hayfield);
		a.addLocation(michelDelving);
		a.addLocation(shireJunction);
		a.addLocation(brandywineBridge);
		a.addLocation(buckland);
		a.addLocation(breeFieldsSouth);
		a.addLocation(breeJunction);
		a.addLocation(bree);
		a.addLocation(staddle);
		a.addLocation(combe);
		a.addLocation(archet);
		a.addLocation(brandyHills);
		a.addLocation(weatherHills);
		a.addLocation(wh2);
		a.addLocation(midgewaterMarsh);
		a.addLocation(gerToLL);
		a.addLocation(oldForest);
		a.addLocation(gerForsakenInn);
		a.addLocation(gerAnnunlos);
		a.addLocation(gerNainEnidh);
		a.addLocation(gerTalathGaun);
		a.addLocation(banditCamp);
		a.addLocation(theLastBridge);
		a.addLocation(trollshawsSouth);
		a.addLocation(narrowDefile);
		a.addLocation(trollCave);
		a.addLocation(bruinenGorges);
		a.addLocation(bruinenFord);
		a.addLocation(chetwoodSouth);
		a.addLocation(breeFieldsNorth);
		a.addLocation(chetwoodNorth);
		a.addLocation(beforeWeathertop);
		a.addLocation(weathertop);
		a.addLocation(highMoor);
		a.addLocation(rivendell);
		a.addLocation(barrowDownsNorth);
		a.addLocation(minasEriol);
		a.addLocation(gerBreeLand);
		a.addLocation(gerPastHobbiton);
		a.addLocation(trollshawsNorth);
		a.addLocation(talBruinen);
		a.addLocation(theMarish);
		a.addLocation(budgefordFields);
		a.addLocation(stock);
		a.addLocation(rushockBog);
		a.addLocation(tuckborough);
		a.addLocation(nsFieldPath);
		a.addLocation(scary);
		a.addLocation(giantValley);
		a.addLocation(quarry);
		a.addLocation(littleDelving);
		a.addLocation(andrath);
		a.addLocation(archetDale);
		a.addLocation(greenway1);
		a.addLocation(easternBreeFields);
		a.addLocation(gwingris);
	
		bree.addBuilding(new Inn("Prancing Pony", "Human", a));
		gerForsakenInn.getBuildings().add(new Inn("Forsaken", "Human", a));
		midgewaterMarsh.getNPCs().add(new MarshAdder());
		trollCave.addNPC(new NPC("Cave Troll", "Troll", 14, 35, 24, "Evil", 20, new Weapon( 8, "Troll Hammer", 3, 4 )));
		Chest c = new Chest( 6, trollCave );
		c.getContents().add(new GondolinBlade());
		c.getContents().add(new Armor(14, "Dwarven Helm", 4, "Head"));
		trollCave.addItem(c);
		waymeet.addNPC(new NPC("Farmer", "Hobbit", 6, 18, 9, "Good", 2, null));
		oldForest.addNPC(new NPC("Forest Spider", "Spider", 7, 25, 15, "Evil", 10, new Potion( 10, "Spider Venom", -2, "Health")));
		//banditCamp.addItem(new Weapon(6, "Axe", 3, 2));
		weathertop.addNPC(new Nazgul());
		//weathertop.addItem(new Weapon(50, "Morgul Blade", 8, 15));
		rivendell.addBuilding(new Market("Elf", a));
		barrowDownsNorth.addNPC(new NPC("Barrow-Wight", "Wight", 12, 20, 20, "Evil", 15, new Weapon( 12, "Ancient Blade", 5, 3)));
		tuckborough.addNPC(new NPC("Wandering Took", "Hobbit", 6, 18, 10, "Good", 2, null));
		buckland.addNPC(new NPC("Shire Bounder", "Hobbit", 8, 16, 13, "Neutral", 5, new Item(6, "Shirriff Feather")));
		scary.addNPC(new NPC("Hobbit Miner", "Hobbit", 7, 19, 12, "Neutral", 4, new Item(1, "Copper Bit")));
		highMoor.addNPC(new NPC("Rivendell Scout", "Elf", 10, 18, 13, "Good", 6, new Weapon(6, "Elvish Dagger", 3, 3)));
		giantValley.addNPC(new NPC("Giant", "Giant", 18, 40, 24, "Evil", 35, null));
		minasEriol.addNPC(new NPC("Warg Scout", "Warg", 12, 16, 10, "Evil", 20, new Item(12, "Bolt of Warg Fur")));
		archet.addBuilding(new Market("Human", a));
		michelDelving.addBuilding(new Market("Hobbit", a));
		breeFieldsNorth.addNPC(new NPC("Dunedain Tracker", "Human", 13, 24, 12, "Good", 16, new Armor(10, "Dunedain Cloak", 3, "Chest")));
		gwingris.addNPC(new NPC("Rivendell Scout", "Elf", 10, 18, 13, "Good", 6, new Weapon(6, "Elvish Dagger", 3, 3)));
		
		//a.getLocations()[5][10][0].getText();
		System.out.println("Welcome to Middle Earth, Professor Tolkein's wonderful and magical world from his The Lord of the Rings, The Hobbit, and \nThe Silmarillion books. This game endeavors to create a colorful representation of Tolkein's world for the enjoyment \nof his fans and lovers of fantasy alike. So without further ado, we now present: \nTHE LORD OF THE RINGS");
		
		System.out.println("\nControls: North - n, South - s, East - e, West - w");
		System.out.println("Note: When interacting with an item or NPC, always type its full and correct name.");
		System.out.println("\nYou are " + a.getPlayer().getName() + " the " + a.getPlayer().getRace());
		System.out.println("\n***========THE BEGINNING========***");
		a.getLocations()[10][10][0].enterLoc();
		
		while(a.getPlayer().getHealth() > 0){
			
			a.act();
			a.wildAnimalSpawn(breeFieldsNorth, new NPC("Brown Bear", "Bear", 10, 25, 19, "Neutral", 5, new Item(4, "Bear Tooth")), 3);
			a.wildAnimalSpawn(midgewaterMarsh, new NPC("Marsh Spider", "Spider", 6, 18, 14, "Evil", 6, new Food( 1, "Swamp Grass", 1)) , 4);
		}
	}
}