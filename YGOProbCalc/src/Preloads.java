import java.util.ArrayList;
import java.util.List;
public class Preloads {
	List<List<int[]>> preloads;
	int[] init_quantities; //assume first item is 0 (no preloading from deck)
	boolean non_empty = false;
	public Preloads(Locations locations, int[] quantities) //assume locations just initialized
	{
		this.init_quantities=quantities;
		preloads = new ArrayList<List<int[]>>(Gov.num_locations());
		preloads.add(new ArrayList<int[]>(0));
		int[] deck = locations.locations[0];
		List<int[]> marked_deck = new ArrayList<int[]>(60);
		
		for(int i = 0; i<deck.length; i++)
		{
			for(int j =0; j<deck[i]; j++)
			{
				marked_deck.add(new int[] {i,j+1});
			}
		}
		List<int[]> marked_copy=new ArrayList<int[]>(marked_deck);
		for(int i=1; i<Gov.num_locations(); i++)
		{
			List<int[]> loc_preloads = new ArrayList<int[]>(quantities[i]);
			for(int j=0; j<quantities[i]; j++)
			{
				non_empty = true;
				int rand =(int) (Math.random()*marked_copy.size());
				loc_preloads.add(marked_copy.remove(rand));
			}
			preloads.add(loc_preloads);
		}
		//here we create the backups, in case the above get exhausted
		
		
		for(int i=1; i<Gov.num_locations(); i++)
		{
			if(quantities[i]==0)
				continue;
			marked_copy=new ArrayList<int[]>(marked_deck);
			List<int[]> loc_preloads = preloads.get(i);
			for(int j=0; j<marked_deck.size(); j++)
			{
				int rand =(int) (Math.random()*marked_copy.size());
				loc_preloads.add(marked_copy.remove(rand));
			}
		}
	}
	public String toString()
	{
		//only print first 10
		String s = "";
		for(int i=1; i<preloads.size(); i++)
		{
			if(preloads.get(i).isEmpty())
				continue;
			s=s+"Preloaded draws to "+ Gov.locations[i]+": ";
			for(int j=0; j<15; j++)
			{
				if(j==init_quantities[i])
					s=s+" Backups: ";
				int[] preload =preloads.get(i).get(j);
				s=s+Card.num_to_card.get(preload[0]).name+" "+preload[1]+", ";
			}
			s=s+"\n";
		}
		return s;
	}

}
