
public class ZeroCondition extends Condition {
	public ZeroCondition(String category, int... locations)
	{
		super(0, '=', category, locations);
	}
	public ZeroCondition(Card c, int... locations)
	{
		super(0, '=', c, locations);
	}
	

}
