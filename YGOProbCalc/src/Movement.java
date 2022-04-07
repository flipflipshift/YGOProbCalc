
public class Movement {
	int card_num;
	int origin;
	int destination;
	Card card;
	public Movement(int card_num, int in, int out)
	{
		this.card_num = card_num;
		origin = in;
		destination = out;
		card = Card.num_to_card.get(card_num);
	}
	public String toString()
	{
		if(origin!=-1 && destination != -1)
			return "Moved " + card.name + " from " + Gov.locations[origin] + " to " + Gov.locations[destination];
		if(destination != -1)
			return "Placed " + card.name + " in " + Gov.locations[destination];
		if(origin != -1)
			return "Removed " + card.name + " from " + Gov.locations[origin];
		System.out.println("do not move cards from nowhere to nowhere");
		System.exit(0);
		return "";
	}
	public String DrawtoString()
	{
		if(origin!=0)
		{
			System.out.println("Invalid call of DrawToString");
			System.exit(0);
		}
		return "Drew " + card.name + " to " + Gov.locations[destination];
		

	}

}
