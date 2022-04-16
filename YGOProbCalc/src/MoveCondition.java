
public class MoveCondition extends Condition {
	int destination;
	boolean distinct = false;
	boolean cost = false;
	public MoveCondition(String category, int[] in, int out)
	{
		super(category, in);
		destination=out;
	}
	public MoveCondition(String category, int in, int out)
	{
		super(category, in);
		destination=out;
	}
	public MoveCondition(Card card, int[] in, int out)
	{
		super(card, in);
		destination=out;
	}
	public MoveCondition(Card card, int in, int out)
	{
		super(card, in);
		destination=out;
	}
	public MoveCondition(int num, String category, int[] in, int out)
	{
		super(num, category, in);
		destination=out;
	}
	public MoveCondition(int num, String category, int in, int out)
	{
		super(num, category, in);
		destination=out;
	}
	public MoveCondition(int num, Card card, int[] in, int out)
	{
		super(num, card, in);
		destination=out;
	}
	public MoveCondition(int num, Card card, int in, int out)
	{
		super(num, card, in);
		destination=out;
	}
	public MoveCondition distinct()
	{
		distinct = true;
		return this;
	}
	public MoveCondition cost()
	{
		cost = true;
		return this;
	}
}
