import java.util.List;
public class Modification {
	Action action;
	List<Movement> movements;
	Locations initial_locations;
	Locations new_locations;
	List<Action> events_turned_on;
	List<Action> events_turned_off;
	List<Trigger> triggers_added;
	int current_trigger_size;
	int[] initial_preload_locations;
	int[] current_preload_locations;
	public String toString()
	{
		String s="";
		for(Movement movement : movements)
		{
			s=s+movement.toString()+"\t("+ action.name+")"+"\n";
		}
		return s;
	}
}
