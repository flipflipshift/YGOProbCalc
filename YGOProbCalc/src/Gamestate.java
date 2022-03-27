import java.util.ArrayList;
import java.util.Deque;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
public class Gamestate {
	Preloads preloads;
	int[] preload_indices;
	Locations locations;
	List<Trigger> triggers;
	Hashtable<Action, Boolean> is_on;//TODO: Make into array
	List<Modification> log;
	int[] initial_deck;
	
	public Gamestate()
	{
		locations = new Locations();
		int[] quantities = new int[Gov.num_locations()];
		int total_preloads=0;
		for(int i = 1; i< quantities.length; i++)
		{
			total_preloads+=Action.draw_counter[i];
		}
		for(int i=1; i<quantities.length; i++)
		{
			if(Action.draw_counter[i]==0)
			{
				quantities[i]=0;
			}
			else {
				quantities[i]=(Action.draw_counter[i] * (Card.deck_size-Gov.hand_size))/total_preloads;
			}
		}
		preloads = new Preloads(locations, quantities);
		preload_indices = new int[Gov.num_locations()];
		initial_deck = locations.locations[0].clone();
		triggers = new ArrayList<Trigger>();
		is_on = new Hashtable<Action, Boolean>();
		for(Action action : Action.actions)
		{
			is_on.put(action, action.default_live);
		}
		log = new ArrayList<Modification>();
	}
	public List<Integer> executable(Action action)
	{
		List<Possibility> possibilities = action.possibilities;
		if(possibilities.size()==0)
		{
			action.no_conditions();
		}
		List<Integer> executables = new ArrayList<Integer>(possibilities.size());
		if(!is_on.get(action))
		{
			return executables; //will be empty
		}
		for(int i = 0; i<possibilities.size(); i++)
		{
			if(locations.satisfies(possibilities.get(i)))
				executables.add(i);
		}
		return executables;
	}
	public void modify(Modification mod)
	{
		log.add(mod);
		locations = mod.new_locations;
		for(Action action : mod.events_turned_off)
			is_on.replace(action, false);
		for(Action action : mod.events_turned_on)
			is_on.replace(action, true);
		triggers.addAll(mod.triggers_added);
		preload_indices = mod.current_preload_locations;
	}
	public void unmodify(Modification mod)
	{
		log.remove(log.size()-1);
		locations = mod.initial_locations;
		for(Action action : mod.events_turned_off)
			is_on.replace(action, true);
		for(Action action : mod.events_turned_on)
			is_on.replace(action, false);
		while(triggers.size()>mod.current_trigger_size)
		{
			triggers.remove(triggers.size()-1);
		}
		preload_indices = mod.initial_preload_locations;
	}
	private static void movecondition_recur(List<List<int[]>> available, List<Movement[]> ret, Movement[] moves, int curr_loc, int curr_index,  int todo, int[] origins,  int destination, int distinct)
	{
		if(todo == 0)
		{
			ret.add(moves.clone());
			return;
		}
		List<int[]> temp = available.get(curr_loc);
		int origin = origins[curr_loc];
		for(int j = curr_index + distinct; j<temp.size(); j++)
		{
			int[] consideration = temp.get(j);
			if(consideration[1]>0)
			{
				moves[moves.length-todo] = new Movement(consideration[0],origin, destination);
				consideration[1]--;
				movecondition_recur(available, ret, moves, curr_loc, j, todo-1, origins, destination, distinct);
				consideration[1]++;
			}
		}
		for(int i = curr_loc+1; i<available.size(); i++)
		{
			temp = available.get(i);
			origin = origins[i];
			for(int j = 0; j< temp.size(); j++)
			{
				int[] consideration = temp.get(j);
				if(consideration[1]>0)
				{
					moves[moves.length-todo] = new Movement(consideration[0],origin, destination);
					consideration[1]--;
					movecondition_recur(available, ret, moves, i, j, todo-1, origins, destination, distinct);
					consideration[1]++;
				}
			}
		}
	}
	public List<Movement[]> movecondition_moves(MoveCondition cond)
	{
		List<Movement[]> ret = new ArrayList<Movement[]>();
		if(cond.num==1) //This is the most common anyway so make it fast
		{
			for(int i : cond.locations)
			{
				if(cond.card_or_cat)
				{
					if(locations.has(cond.card_num, i))
					{
						ret.add(new Movement[] {new Movement(cond.card_num, i, cond.destination)});
					}
				}
				else
				{
					for(int j : Card.get_cards(cond.category))
					{
						if(cond.exclude.contains(j))
							continue;
						if(locations.has(j, i))
						{
							ret.add(new Movement[] {new Movement(j, i, cond.destination)});
						}
					}
				}
			}
		}
		else
		{
			Movement[] initialize = new Movement[cond.num];
			List<List<int[]>> available = new ArrayList<List<int[]>>(cond.locations.length);
			for(int i: cond.locations)
			{
				List<int[]> available_at_loc = new ArrayList<int[]>();
				if(!cond.card_or_cat)
				{
					for(int j : Card.category_hash.get(cond.category))
					{
						if(cond.exclude.contains(j))
							continue;
						if(locations.has(j, i))
						{
							if(i==-1)
							{
								available_at_loc.add(new int[] {j, 3});
							}
							else
							{
							available_at_loc.add(new int[] {j, locations.locations[i][j]});
							}
						}
					}
				}
				else
				{
					if(i==-1)
					{
						available_at_loc.add(new int[] {cond.card_num, 5});
					}
					else
					{
						if(locations.has(cond.card_num, i))
							available_at_loc.add(new int[] {cond.card_num, locations.locations[i][cond.card_num]});
					}
				}
				available.add(available_at_loc);
			}
			int distinct = 0;
			if(cond.distinct)
				distinct=1;
			movecondition_recur(available, ret, initialize, 0, 0, cond.num, cond.locations, cond.destination, distinct);
		}
		return ret;
	}
	
	public static Movement[][] cartesian_product(List<List<Movement[]>> movements)
	{
		int[] running_products = new int[movements.size()+1];
		int run_prod=1;
		running_products[0]=1;
		int num_of_moves=0;
		for(int i=0; i< movements.size(); i++)
		{

			run_prod*=movements.get(i).size();
			running_products[i+1]=run_prod;
			num_of_moves+=movements.get(i).get(0).length;
			
		}
		Movement[][] ret = new Movement[run_prod][num_of_moves];
		for(int i=0; i < run_prod; i++)
		{
			int index = 0;
			for(int j = 0; j < movements.size(); j++)
			{
				List<Movement[]> possible_moves = movements.get(j);
				for(int k = 0; k<possible_moves.get(0).length; k++)
				{
					ret[i][index] = possible_moves.get((i % running_products[j+1])/running_products[j])[k];
					index++;
				}
			}
		}
		return ret;
	}
	public List<Modification> modifications(Action action, Possibility poss)
	{
		List<Modification> modifications = new ArrayList<Modification>();
		int length = Gov.num_locations();		
		List<List<Movement[]>> movement_set = new ArrayList<List<Movement[]>>();
		for(Condition cond : poss.conditions)
		{
			if(cond instanceof MoveCondition)
			{
				List<Movement[]> to_add = movecondition_moves((MoveCondition) cond);
				if(to_add.size()==0)
					return modifications;
				movement_set.add(to_add);
			}
		}
		Movement[][] movement_lists = cartesian_product(movement_set);
		
		
		List<Action> turn_off = new ArrayList<Action>();
		for(Action a : action.turn_off)
		{
			if(is_on.get(a)==true)
				turn_off.add(a);
		}
		List<Action> turn_on = new ArrayList<Action>();
		for(Action a : action.turn_on)
		{
			if(is_on.get(a)==false)
				turn_on.add(a);
		}
		boolean problem;
		//can randomize:
		//while(movement_lists.size()>0)
		//List<Movement> movements = movement_lists.remove((int)(Math.random()*movement_lists.size()));
		for(Movement[] movements : movement_lists)
		{
			problem = false;
			List<Movement> move_log = new ArrayList<Movement>();
			List<Trigger> new_triggers = new ArrayList<Trigger>();
			new_triggers.addAll(action.triggers);
			new_triggers.addAll(poss.trigger);
			Locations locations_save = locations.copy();
			for(Movement m : movements)
			{
				if(!locations.can(m))
				{
					locations = locations_save;
					problem = true;
					break;
				}
				move_log.add(m);
				new_triggers.addAll(locations.move(m));
			}
			if(problem)
				continue;
			int[] preload_indices_save = preload_indices.clone();
			if(action.draws!=null)
			{
				for(int i=1; i<length; i++)
				{
					for(int j=0; j < action.draws[i]; j++)
					{
						if(preload_indices[i]==preloads.quantities[i])
						{
							int card_num = locations.getrand(0);
							Movement m = new Movement(card_num, 0, i);
							move_log.add(m);
							new_triggers.addAll(locations.move(m));
						}
						else
						{
							int card_num = preloads.preloads.get(i).get(preload_indices[i]);
							preload_indices[i]+=1;
							double rand = Math.random();
							double original = (double) initial_deck[card_num];
							double current = (double) locations.locations[0][card_num];
							boolean dont_skip = rand>(original-current)/original;
							
							if(dont_skip)
							{
								Movement m = new Movement(card_num, 0, i);
								move_log.add(m);
								new_triggers.addAll(locations.move(m));
							}
							else
							{
								j--;
							}
						}
					}
				}
			}
			if(action.move_all==true)
			{
				new_triggers.addAll(locations.moveall(action.move_all_origin, action.move_all_destination, move_log));
			}
			Modification mod = new Modification();
			mod.action=action;
			mod.movements=move_log;
			mod.initial_locations=locations_save;
			mod.new_locations=locations;
			mod.initial_preload_locations=preload_indices_save;
			mod.current_preload_locations=preload_indices;
			mod.current_trigger_size=triggers.size();
			mod.triggers_added=new_triggers;
			mod.events_turned_off=turn_off;
			mod.events_turned_on=turn_on;
			
			modifications.add(mod);
			locations = locations_save;
			preload_indices = preload_indices_save;
			
		}
		
		return modifications;
	}
	public boolean terminate(List<Termination_Possibility> tposs_list)
	{
		for(Termination_Possibility tposs : tposs_list)
		{
			if(locations.satisfies(tposs))
			{
				boolean all_off = true;
				for(Action a : tposs.are_off)
				{
					if(is_on.get(a))
					{
						all_off= false;
						break;
					}
				}
				if(all_off)
					return true;
			}
		}
		return false;
	}
	public String toString()
	{
		String s = "Gamestate info:\n";
		for(int i = 1; i<locations.locations.length; i++)
		{
			if(locations.location_sizes[i]==0)
				continue;
			s=s+"In "+Gov.locations[i]+":\n";
			for(int j = 0; j<Card.num_created; j++)
			{
				if(locations.locations[i][j]==0)
					continue;
				s=s+locations.locations[i][j]+" copies of "+Card.num_to_card.get(j).name+"\n";
			}
		}
		return s;
	}
	
}
