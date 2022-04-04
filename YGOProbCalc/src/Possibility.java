import java.util.List;
import java.util.ArrayList;
public class Possibility {
	Condition[] conditions;
	List<Trigger> trigger = new ArrayList<Trigger>();; //for now just add one trigger at most; can have an intermediate if necessary
	int sum=-1;
	boolean summable = false;
	boolean greater=false;
	int numeric=0;
	int first_k_moveconds; //sum the numerics of the cards from the first ___ moveconditions. 
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
	public Possibility sum(int numeric, int sum, int first_k_moveconds)
	{
		this.summable=true;
		this.numeric=numeric;
		this.sum = sum;
		this.first_k_moveconds = first_k_moveconds;
		for(int i=0; i<first_k_moveconds; i++)
		{
			if(!(conditions[i] instanceof MoveCondition))
			{
				System.out.println("The summed conditions in a possibility must all be Move Conditions.");
				System.exit(0);
			}
		}
		return this;
	}
	public Possibility sum(int sum, int first_k_moveconds)
	{
		this.summable = true;
		numeric = 0;
		this.sum = sum;
		this.first_k_moveconds = first_k_moveconds;
		for(int i=0; i<first_k_moveconds; i++)
		{
			if(!(conditions[i] instanceof MoveCondition))
			{
				System.out.println("The summed conditions in a possibility must all be Move Conditions");
				System.exit(0);
			}
		}
		return this;
	}
	public Possibility sum(int sum)
	{
		this.summable=true;
		numeric = 0;
		this.sum = sum;
		this.first_k_moveconds = conditions.length;
		return this;
	}
	public Possibility greater()
	{
		greater = true;
		return this;
	}
	public Possibility trigger(Action action)
	{
		trigger.add( new Trigger(action));
		return this;
	}
	public Possibility guarantee()
	{
		guarantee=true;
		return this;
	}
}

