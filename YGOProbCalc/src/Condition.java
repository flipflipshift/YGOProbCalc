import java.util.List;
import java.util.ArrayList;

public class Condition {
	int num;
	char symbol;
	String category;
	int[] locations;
	int card_num;
	boolean card_or_cat;
	List<Integer> exclude = new ArrayList<Integer>();
	public Condition(int num, char symbol, String category, int... locations)
	{
		this.num=num;
		this.symbol=symbol;
		this.category=category;
		this.locations=locations;
		if(!Card.category_hash.containsKey(category))
		{
			System.out.println("Unspecified category name "+category);
			System.exit(0);
		}
	}
	public Condition(int num, String category, int... locations)
	{
		this.num=num;
		this.symbol='+';
		this.category=category;
		this.locations=locations;
		if(!Card.category_hash.containsKey(category))
		{
			System.out.println("Unspecified category name "+category);
			System.exit(0);
		}
	}
	public Condition(String category, int... locations)
	{
		this.num=1;
		this.symbol='+';
		this.category=category;
		this.locations=locations;
		if(!Card.category_hash.containsKey(category))
		{
			System.out.println("Unspecified category name "+category);
			System.exit(0);
		}
	}
	public Condition(int num, char symbol, Card card, int... locations)
	{
		card_or_cat=true;
		this.num=num;
		this.symbol=symbol;
		card_num=card.num;
		this.locations=locations;
	}
	public Condition(int num, Card card, int... locations)
	{
		card_or_cat=true;
		this.num=num;
		this.symbol='+';
		card_num=card.num;
		this.locations=locations;
	}
	public Condition(Card card, int... locations)
	{
		card_or_cat=true;
		this.num=1;
		this.symbol='+';
		card_num=card.num;
		this.locations=locations;
	}

	public Condition(int num, Card card)
	{
		card_or_cat=true;
		this.num=num;
		this.symbol='+';
		card_num=card.num;
		this.locations=new int[] {1};
	}
	public Condition(Card card)
	{
		card_or_cat=true;
		this.num=1;
		this.symbol='+';
		card_num=card.num;
		this.locations=new int[] {1};
	}
	public Condition(int num, String category)
	{
		this.num=num;
		this.symbol='+';
		this.category=category;
		this.locations=new int[] {1};
		if(!Card.category_hash.containsKey(category))
		{
			System.out.println("Unspecified category name "+category);
			System.exit(0);
		}
	}
	public Condition(String category)
	{
		this.num=1;
		this.symbol='+';
		this.category=category;
		this.locations=new int[] {1};
		if(!Card.category_hash.containsKey(category))
		{
			System.out.println("Unspecified category name "+category);
			System.exit(0);
		}
	}
	public Condition exclude(Card c)
	{
		exclude.add(c.num);
		return this;
	}
	public Condition exclude(String cat)
	{
		for(int c : Card.category_hash.get(cat))
			exclude.add(c);
		return this;
	}
}
