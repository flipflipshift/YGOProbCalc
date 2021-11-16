public class Termination_Possibility extends Possibility{
	Action[] are_off;
	
	public Termination_Possibility(Action[] are_off, Condition... conds)
	{
		super(conds);
		this.are_off=are_off;
	}

}
