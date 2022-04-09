import java.util.ArrayList;
import java.util.List;
public class Locations {
	int[][] locations;
	int[] location_sizes;
	public Locations()
	{
		locations = new int[Gov.num_locations()][Card.num_created];
		for(int i = 0; i<Card.num_created; i++)
		{
			locations[0][i]=Card.deck.get(i);
			if(Gov.using_extra)
				locations[Gov.extra_deck_index][i]=Card.extra_deck.get(i);
		}
		location_sizes= new int[Gov.num_locations()];
		location_sizes[0] = Card.deck_size;
		if(Gov.using_extra)
			location_sizes[Gov.extra_deck_index] = Card.extra_deck_size;
		for(int i=0; i<Gov.hand_size; i++)
		{
			moverand(0,1);
		}
		
	}
	public Locations(int[][] locations, int[] location_sizes)
	{
		this.locations=locations;
		this.location_sizes=location_sizes;
	}
	public Locations copy()
	{
		int[][] new_locations = new int[locations.length][locations[0].length];
		int[] new_location_sizes = new int[location_sizes.length];
		//TODO see if can be sped up since very sparse
		for(int i=0; i< locations.length; i++)
		{
			if(location_sizes[i]==0)
				continue;
			new_location_sizes[i]=location_sizes[i];
			for(int j=0; j< locations[0].length; j++)
			{
				new_locations[i][j]=locations[i][j];
			}
		}
		return new Locations(new_locations, new_location_sizes);
	}
	public boolean has(int card_num, int loc)
	{
		return loc == -1 || locations[loc][card_num]>0 ;
	}
	public boolean can(Movement m)
	{
		return has(m.card_num, m.origin);
	}
	/*public void fast_move(int quantity, int card_num, int in, int out)
	{
		if(in!= -1)
		{
			location_sizes[in]-= quantity;
			locations[in][card_num]-= quantity;
		}
		if(out != -1)
		{
			location_sizes[out]+= quantity;
			locations[out][card_num]+= quantity;
		}
	}*/
	
	public List<Trigger> move(Movement movement)
	{
		int in = movement.origin;
		int out = movement.destination;
		int card_num = movement.card_num;
		if(in!= -1)
		{
			location_sizes[in]--;
			locations[in][card_num]--;
		}
		if(out != -1)
		{
			location_sizes[out]++;
			locations[out][card_num]++;
		}
		return MT.library[card_num][in+1][out+1];
	}
	//Do not use with -1, it wouldn't make sense.
	public int getrand(int in)
	{
		if(location_sizes[in]==0)
		{
			System.out.println("Nothing left in "+Gov.locations[in]);
		}
		int index = (int) (Math.random()*location_sizes[in]);
		int card_num= -1;
		for(int i=0; i<locations[in].length; i++)
		{
			index= index - locations[in][i];
			if(index<0)
			{
				card_num=i;
				break;
			}
		}
		return card_num;
	}
	//Do not use with -1, it wouldn't make sense.
	public List<Trigger> moverand(int in, int out)
	{
		int card_num = getrand(in);
		location_sizes[in]--;
		locations[in][card_num]--;
		location_sizes[out]++;
		locations[out][card_num]++;
		return MT.library[card_num][in+1][out+1];
	}
	//Do not use with -1; it wouldn't make sense
	public List<Trigger> moveall(int in, int out)
	{
		List<Trigger> ret = new ArrayList<Trigger>();
		for(int i=0; i<locations[in].length; i++)
		{
			if(locations[in][i]>0)
			{
				locations[out][i]+=locations[in][i];
				locations[in][i]=0;
				ret.addAll(MT.library[i][in+1][out+1]);
			}
		}
		location_sizes[out]+=location_sizes[in];
		location_sizes[in]=0;
		return ret;
	}
	public List<Trigger> moveall(int in, int out, List<Movement> move_log) //was more helpful when implementing gamestate
	{
		List<Trigger> ret = new ArrayList<Trigger>();
		for(int i=0; i<locations[in].length; i++)
		{
			if(locations[in][i]>0)
			{
				for(int j = 0; j<locations[in][i]; j++)
					move_log.add(new Movement(i, in, out));
				locations[out][i]+=locations[in][i];
				locations[in][i]=0;
				ret.addAll(MT.library[i][in+1][out+1]);
			}
		}
		location_sizes[out]+=location_sizes[in];
		location_sizes[in]=0;
		return ret;
	}
	public boolean satisfies(Condition cond)
	{
		if(cond.locations[0]==-1)
		{
			if(cond instanceof MoveCondition && cond.locations.length==1)
				return true;
			else
			{
				System.out.println("If using -1 as an origin, must be a Move Condition with no other possible origin");
				System.exit(0);
			}
		}
		int total=0;
		for(int i : cond.locations)
		{
			if(cond.card_or_cat)
			{
				total += locations[i][cond.card_num];
				if(total>cond.num)
					break;
			}
			else
			{
				for(int j : Card.get_cards(cond.category))
				{
					if(!cond.exclude.contains(j))
						total+=locations[i][j];
						if(total>cond.num)
							break;
				}
			}

		}
		if(cond.symbol=='-')
		{
			return total<= cond.num;
		}
		if(cond.symbol=='+')
		{
			return total>= cond.num;
		}
		if(cond.symbol=='=')
		{
			return total == cond.num;
		}
		System.out.println("Invalid Symbol");
		System.exit(0);
		return false;
	}
	public boolean satisfies(Possibility poss)
	{
		for(Condition cond : poss.conditions)
		{
			if(!satisfies(cond))
				return false;
		}
		return true;
	}
	public boolean satisfies(List<Possibility> goal)
	{
		for(Possibility poss : goal)
		{
			if(satisfies(poss))
				return true;
		}
		return false;
	}
	public String hand_string()
	{
		String s = "Hand: ";
		for(int i = 0; i<locations[1].length; i++)
		{
			for(int j =0; j<locations[1][i]; j++)
			{
				s=s+Card.num_to_card.get(i).name+", ";
			}
		}
		s=s+"\n";
		return s;
	}

}
