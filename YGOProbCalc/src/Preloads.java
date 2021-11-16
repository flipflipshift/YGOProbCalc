import java.util.ArrayList;
import java.util.List;
public class Preloads {
	List<List<Integer>> preloads;
	int[] quantities; //assume first item is 0 (no preloading from deck)
	public Preloads(Locations locations, int[] quantities) //assume locations just initialized
	{
		this.quantities=quantities;
		preloads = new ArrayList<List<Integer>>(Gov.num_locations());
		preloads.add(new ArrayList<Integer>(0));
		Locations loc_copy = locations.copy();
		for(int i=1; i<Gov.num_locations(); i++)
		{
			List<Integer> loc_preloads = new ArrayList<Integer>(quantities[i]);
			for(int j=0; j<quantities[i]; j++)
			{

				int card_num = loc_copy.getrand(0);
				loc_copy.location_sizes[0]--;
				loc_copy.locations[0][card_num]--;
				loc_preloads.add(card_num);
			}
			preloads.add(loc_preloads);
		}		
	}
	public String toString()
	{
		String s = "";
		for(int i=1; i<preloads.size(); i++)
		{
			if(preloads.get(i).isEmpty())
				continue;
			s=s+"Preloaded draws to "+ Gov.locations[i]+": ";
			for(Integer j : preloads.get(i))
			{
				s=s+Card.num_to_card.get(j).name+", ";
			}
			s=s+"\n";
		}
		return s;
	}

}
