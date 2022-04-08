import java.util.Hashtable;
import java.util.List;
import java.util.ArrayList;

public class Card {
	String name;
	int num;
	String[] categories;
	static List<Card> num_to_card; 
	static int num_created;
	static Hashtable<String, List<Integer>> category_hash;
	static List<Integer> deck;
	static List<Integer> extra_deck;
	static int deck_size;
	int[] numerics;
	static int extra_deck_size;
	static {
	num_created=0;
	num_to_card = new ArrayList<Card>();
	category_hash =  new Hashtable<String, List<Integer>>();
	category_hash.put("card", new ArrayList<Integer>());
	deck = new ArrayList<Integer>();
	extra_deck = new ArrayList<Integer>();
	deck_size = 0;
	extra_deck_size = 0;
	}
	public Card(String name, int quantity)
	{
		this.name = name;
		this.num = num_created;
		num_to_card.add(this);
		category_hash.get("card").add(this.num);
		deck.add(quantity);
		extra_deck.add(0);
		deck_size+= quantity;
		num_created++;
		categories = new String[0];
	}
	public Card(String name, int quantity, String... cats)
	{
		this.name = name;
		this.num = num_created;
		num_to_card.add(this);
		category_hash.get("card").add(this.num);
		deck.add(quantity);
		extra_deck.add(0);
		deck_size+=quantity;
		num_created++;
		this.categories = cats;
		for(String cat : categories)
		{
			if (!category_hash.containsKey(cat))
			{
				List<Integer> cards = new ArrayList<Integer>();
				cards.add(this.num);
				category_hash.put(cat, cards);
			}
			else
			{
				category_hash.get(cat).add(this.num);
			}
		}
		
	}
	public static List<Integer> get_cards(String category)
	{
		if(category_hash.containsKey(category))
			return category_hash.get(category);
		else
		{
			System.out.println("Check category spelling: "+category);
			System.exit(0);
			return null;
		}
	}
	public Card small(String type, String attribute, String level, String atk, String def)
	{
		SmallWorld.add(this, type, attribute, level, atk, def);
		return this;
	}
	public Card small()
	{
		SmallWorld.add(this);
		return this;
	}
	public Card numerics(int ... nums)
	{
		numerics=nums;
		return this;
	}
	public Card extra(int extra_copies)
	{
		extra_deck.set(this.num, extra_copies);
		extra_deck_size+=extra_copies;
		Gov.using_extra=true;
		return this;
	}

}
