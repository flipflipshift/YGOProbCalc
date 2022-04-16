import java.util.ArrayList;
public class MT {
	static ArrayList<Trigger>[][][] library;
	static {
		library = (ArrayList<Trigger>[][][]) new ArrayList[Card.num_created][Gov.num_locations()+1][Gov.num_locations()+1];
		for(int i=0; i<Card.num_created; i++)
		{
			for(int j=0; j< Gov.num_locations()+1; j++)
			{
				for(int k=0; k< Gov.num_locations()+1; k++)
				{
					library[i][j][k]= new ArrayList<Trigger>();
				}
			}
		}
	}
	public static void add(String category,int in, int out,Action action)
	{
		for(int c : Card.get_cards(category))
			library[c][in+1][out+1].add(new Trigger(action));
	}

	public static void add(Card c,int in, int out, Action action)
	{
		int card_num = c.num;
		library[card_num][in+1][out+1].add(new Trigger(action));
	}
	public static void add(String category,int[] ins, int out, Action action)
	{
		for(int c : Card.get_cards(category))
			for(int in : ins)
				library[c][in+1][out+1].add(new Trigger(action));
	}	

	public static void add(Card c, int[] ins, int out, Action action)
	{
		int card_num = c.num;
		for(int in : ins)
			library[card_num][in+1][out+1].add(new Trigger(action));
	}
	public static void add(String category, int[] ins, int[] outs, Action action)
	{
		for(int c : Card.get_cards(category))
			for (int out : outs)
				for(int in : ins)
					library[c][in+1][out+1].add(new Trigger(action));
	}

	public static void add(Card c, int[] ins, int[] outs, Action action)
	{
		int card_num = c.num;
		for (int out : outs)
			for(int in : ins)
				library[card_num][in+1][out+1].add(new Trigger(action));
	}
	public static void add(Card c, int in, int[] outs, Action action)
	{
		int card_num = c.num;
		for (int out : outs)
			library[card_num][in+1][out+1].add(new Trigger(action));
	}
	public static void add(String category, int in, int[] outs, Action action)
	{
		for(int c : Card.get_cards(category))
			for (int out : outs)
				library[c][in+1][out+1].add(new Trigger(action));
	}
}
