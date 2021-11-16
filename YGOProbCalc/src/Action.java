import java.util.ArrayList;
import java.util.List;
public class Action {
	static List<Action> actions;
	static List<Action> open_actions;
	static int[] draw_counter; //for preloads
	static {
		actions = new ArrayList<Action>();
		draw_counter = new int[Gov.num_locations()];
		open_actions = new ArrayList<Action>();
	}
	int[] draws;
	String name;
	boolean default_live = true;
	List<Possibility> possibilities= new ArrayList<Possibility>(5);;
	List<Action> turn_on = new ArrayList<Action>();;
	List<Action> turn_off = new ArrayList<Action>();
	List<Trigger> triggers = new ArrayList<Trigger>();
	
	boolean move_all=false;
	int move_all_origin = -1;
	int move_all_destination = -1;

	public Action(String name)
	{
		actions.add(this);
		this.name=name;
	}
	public Action draw(int location, int quantity)
	{
		if(draws == null)
			draws = new int[Gov.num_locations()];
		draws[location]= quantity;
		draw_counter[location]+=quantity;
		return this;
	}
	
	public Action poss(Condition...conditions ) 
	{
		possibilities.add(new Possibility(conditions));
		return this;
	}
	public Action poss(Action action, Condition... conditions) // for triggers, will only execute the first one. Think allure/vendor
	{
		possibilities.add(new Possibility(action,conditions));
		return this;
	}
	public Action no_conditions()
	{
		possibilities.add(new Possibility(new Condition[] {}));
		return this;
	}
	
	public Action turnon(Action action)
	{
		if(turn_off.contains(action))
			turn_off.remove(action);
		if(!turn_on.contains(action))
			turn_on.add(action);
		return this;
	}
	public Action turnoff(Action action)
	{
		if(turn_on.contains(action))
			turn_on.remove(action);
		if(!turn_off.contains(action))
			turn_off.add(action);
		return this;
	}
	public Action turnoff_all()
	{
		turn_off = new ArrayList<Action>(actions);
		return this;
	}
	/*public Action add_trigger(Trigger trigger)
	{
		triggers.add(trigger);
		return this;
	}*/
	public Action trigger(Action action)
	{
		triggers.add(new Trigger(action));
		return this;
	}
	public Action off()
	{
		default_live=false;
		return this;
	}
	public Action move_all(int origin, int destination)
	{
		move_all = true;
		move_all_origin = origin;
		move_all_destination = destination;
		return this;
	}
	public Action hopt()
	{
		turn_off.add(this);
		return this;
	}
	public Action open()
	{
		open_actions.add(this);
		return this;
	}
}
