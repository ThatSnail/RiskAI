import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;


public class Player {
	private List<Card> cardList;
	private Map<Territory, Integer> unitMap;
	public Player()
	{
		cardList = new ArrayList<Card>();
		unitMap = new HashMap<Territory, Integer>();
	}
	public void placeReinforcements(int number)
	{
		//TODO: Be shitty and place everything in one territory randomly
		Territory territory = getRandomControlledTerritory();
		addToTerritory(territory, number);
	}
	public void attack()
	{
		
	}
	public Territory getRandomControlledTerritory()
	{
		Set<Territory> territories = unitMap.keySet();
		Random random = new Random();
		int territoryID = random.nextInt(territories.size());
		int i = 0;
		for(Territory terr : territories)
		{
			if(i == territoryID)
			{
				return terr;
			}
			++i;
		}
		throw new RuntimeException("wat");
	}
	public void addToTerritory(Territory territory, int number)
	{
		unitMap.put(territory, unitMap.get(territory)+number);
	}
	public boolean isOwnerOf(Territory territory)
	{
		return unitMap.containsKey(territory);
	}
	public int getUnitsInTerritory(Territory territory)
	{
		return unitMap.get(territory);
	}

}