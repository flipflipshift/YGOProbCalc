import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
public class Modification {
	Action action;
	List<Movement> movements;
	List<Movement> draws;
	Locations initial_locations;
	Locations new_locations;
	List<Action> events_turned_on;
	List<Action> events_turned_off;
	List<Trigger> triggers_added;
	int current_trigger_size;
	int[] initial_preload_locations;
	int[] current_preload_locations;
	List<int[]> cards_thinned;
	HashMap<String, Boolean> interruptionInitial;
	HashMap<String, Boolean> interruptionUsed;
	
	public String toString()
	{
		StringBuilder bld = new StringBuilder();
		for(Movement movement : movements)
		{
			bld.append(movement.toString()+"\t("+ action.name+")"+"\n");
		}
		for(Movement draw : draws)
		{
			bld.append(draw.DrawtoString()+"\t("+ action.name+")"+"\n");
		}
		
		/*for(Entry<String, Boolean> e : interruptionUsed.entrySet()) {
	        String key = e.getKey();
	        Boolean value = e.getValue();
	        bld.append(key+": "+ value+"\n");
	    }*/
		for(Entry<String, Boolean> e : interruptionUsed.entrySet()) {
        String key = e.getKey();
        Boolean value = e.getValue();
        if(value && (!interruptionInitial.containsKey(key)|| !interruptionInitial.get(key)))
        	bld.append("CHAIN! Opponent activates "+key+" to stop " +action.name+"\n");
       // bld.append(key+": "+ value+"\n");
    }
		return bld.toString();
	}
}
