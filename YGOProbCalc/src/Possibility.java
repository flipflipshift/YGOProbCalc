import java.util.List;
import java.util.ArrayList;
public class Possibility {
	Condition[] conditions;
	List<Trigger> trigger = new ArrayList<Trigger>();; //for now just add one trigger at most; can have an intermediate if necessary
	boolean guarantee = false;
	public Possibility(Condition... conditions)
	{
		this.conditions=conditions;
	}
	public Possibility(Action action, Condition... conditions)
	{
		this.conditions=conditions;
		trigger.add( new Trigger(action));
	}
}

