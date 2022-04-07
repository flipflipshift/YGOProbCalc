import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class Gov {
	static String[] locations=new String[] {"Deck", "Hand"};
	static int hand_size=5;
	static int maximum_depth=Integer.MAX_VALUE;
	static List<Possibility> goal;
	static List<Termination_Possibility> terminations;
	static int max_seconds = 604800;
	static boolean print_deckout=true;
	static boolean print_full = true;
	static {
		goal = new ArrayList<Possibility>();
		terminations = new ArrayList<Termination_Possibility>();
	}
	public static int num_locations()
	{
		return locations.length;
	}
	public static void locations(String... locs)
	{
		locations = locs;
	}
	public static void timeout(int num_seconds)
	{
		max_seconds = num_seconds;
	}
	public static void poss(Condition... conditions) 
	{
		goal.add(new Possibility(conditions));
	}
	public static void terminate(Action[] are_off, Condition... tconds)
	{
		terminations.add(new Termination_Possibility(are_off, tconds));
	}
	public static void terminate(Action is_off, Condition... tconds)
	{
		terminations.add(new Termination_Possibility(new Action[] {is_off}, tconds));
	}
	public static void terminate(Condition... tconds)
	{
		terminations.add(new Termination_Possibility(new Action[] {}, tconds));
	}
	public static boolean satisfies_possibilities(Gamestate g, int depth, long end_time)
	{
		if(System.currentTimeMillis()>end_time)
		{
			return false;
		}
		if(depth > maximum_depth)
		{
			return false;
		}
		try {
			
		if(g.triggers.size()>0)
		{
			Trigger trigger = g.triggers.remove(0);
			Action action = trigger.trigger;
			List<Integer> exec = g.executable(action);
			boolean legal = false;
			if(action.first)
			{
				for(Integer i : exec)
				{

					List<Modification> modifications = g.modifications(action, action.possibilities.get(i));
					if(modifications.isEmpty())
						continue; //Only loop if move conditions can't be executed despite the naive check
					legal = true;
					for(Modification mod : modifications)
					{
						g.modify(mod);
						if(satisfies_possibilities(g, depth+1, end_time))
							return true;
						g.unmodify(mod);
					}
					break;
				}
				if(legal && action.mandatory)
					return false;
				return satisfies_possibilities(g, depth, end_time);
			}
			else
			{
				for(int i: exec)
				{
					List<Modification> modifications = g.modifications(action, action.possibilities.get(i));
					
					if(modifications.size()>0)
						legal = true;
					for(Modification mod : modifications)
					{
						g.modify(mod);
						if(satisfies_possibilities(g, depth+1, end_time))
							return true;
						g.unmodify(mod);
					}
					
				}
				if(legal && action.mandatory)
					return false;
				return satisfies_possibilities(g, depth, end_time);
			}
		}
		
		if(g.locations.satisfies(goal))
			return true;
		if(g.terminate(terminations))
			return false;
		for(Action action : Action.open_actions)
		{
			if(action.first)
			{
				for(Integer i : g.executable(action))
				{
					List<Modification> modifications = g.modifications(action, action.possibilities.get(i));
					if(modifications.isEmpty())
						continue; //Only loop if move conditions can't be executed despite the naive check
					for(Modification mod : modifications)
					{
						g.modify(mod);
						if(satisfies_possibilities(g, depth+1, end_time))
							return true;
						g.unmodify(mod);
					}
					break; //only do first possible poss
				}
			}
			else
			{
				for(int i : g.executable(action))
				{
					List<Modification> modifications = g.modifications(action, action.possibilities.get(i));
					for(Modification mod : modifications)
					{
						g.modify(mod);
						if(satisfies_possibilities(g, depth+1, end_time))
							return true;
						g.unmodify(mod);
					}
					if(action.possibilities.get(i).guarantee && modifications.size()>0)
						return false;
				}
			}
		}
		}
		catch(IndexOutOfBoundsException e)
		{
			if(print_deckout)
			{
			System.out.println("An error occured; if above says Nothing Left in Deck, ignore");
			e.printStackTrace();
			print_deckout=false;
			}
			return false;
		}

		return false;
	}
	public static double probability(FileWriter fw, int num_trials) throws IOException
	{
		int counter = 0;
		int timed_out = 0;
		for(int i=0; i<num_trials; i++)
		{
			print_deckout=true;
			print_full=true;
			System.out.println("Trial number "+ (i+1) + "; Found so far: "+counter);
			Gamestate gamestate = new Gamestate();
			String hand = gamestate.locations.hand_string();
			String preloads = gamestate.preloads.toString();
			System.out.print(hand);
			System.out.print(preloads);
			long end_time = System.currentTimeMillis()+max_seconds*1000;
			fw.write("Trial Number: "+(i+1)+"\n");
			if(satisfies_possibilities(gamestate,0, end_time))
			{
				fw.write("This Worked:\n");
				fw.write(hand+"\n");
				fw.write(preloads+"\n");
				for(Modification mod : gamestate.log)
				{
					fw.write(mod.toString());
				}
				counter+=1;
				System.out.println("Found!\n");
			}
			else if (System.currentTimeMillis()>end_time)
			{
				fw.write("This timed out: \n");
				fw.write(hand);
				fw.write(preloads);
				timed_out+=1;
				System.out.println("Timed Out!\n");
			}
			else
			{
				fw.write("This failed: \n");
				fw.write(hand);
				fw.write(preloads);
				System.out.println("Not found!\n");
			}
			fw.write("\n\n");
		}
		double probability = ((double) counter)/ num_trials;
		double probability_timed = ((double) (counter+timed_out))/ num_trials;
		String str1 = "Number of successes: "+counter +" out of "+num_trials;
		String str2 = "Number of timeouts: "+timed_out;
		String str3 = "Probability: "+Double.toString(probability);
		String str4 = "If including timeouts: "+Double.toString(probability_timed);
				
		fw.write(str1+"\n"+str2 + "\n"+str3 + "\n");
		System.out.println(str1+"\n"+str2 + "\n"+str3);
		if(timed_out>0)
		{
			fw.write(str4);
			System.out.println(str4);
		}
		return ((double) counter)/ num_trials;
	}
	

}
