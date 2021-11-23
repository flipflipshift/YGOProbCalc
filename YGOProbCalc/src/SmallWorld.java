import java.util.List;
import java.util.ArrayList;
import java.io.File; 
import java.io.FileNotFoundException;
import java.util.Scanner;

//how to store: maybe give cards data: boolean smallworld, then attributes, etc
//call static method small world to build the according array
//or maybe instead this class can just store a list of 2-elt arrays corresponding to pairs that are distance 1 from each other.
//how to easily store? Maybe list of card nums, list of strings (attrs), then list of 5-elt int arrays
//After adding each one, and to List<int[]> pairs.
public class SmallWorld {
	static Card small_world;
	static int gy;
	static int banish_fd;
	static List<Card> cards;
	static List<String[]> data;
	static List<List<Integer>> pairs; 
	static List<String[]> card_data;
	static {
		pairs= new ArrayList<List<Integer>>();
		cards = new ArrayList<Card>();
		data = new ArrayList<String[]>();
		card_data = new ArrayList<String[]>(8000);
	    try {
	        File myObj = new File("src/CardData.txt");
	        Scanner myReader = new Scanner(myObj);
	        while (myReader.hasNextLine()) {
	          String line = myReader.nextLine();
	          card_data.add(line.split("\\$"));
	        }
	        myReader.close();
	      } catch (FileNotFoundException e) {
	        System.out.println("An error occurred.");
	        e.printStackTrace();
	      }
	}
	
	private static int find(String card_name, int l, int r)
	{
		if (r<l)
			return -1;
		int mid = l + (r-l)/2;
	    String midname=card_data.get(mid)[0];
	    //System.out.println(midname);
	    if(midname.compareToIgnoreCase(card_name)==0)
			return mid;
	    if(midname.compareToIgnoreCase(card_name)>0)
	        return find(card_name, l, mid-1);
	    return find(card_name, mid+1, r);
	}
	private static int find(String card_name)
	{
		return find(card_name,0,card_data.size()-1);
	}
	static void add(Card card)
	{
		String[] datum = new String[5];
		int index = find(card.name);
		if(index == -1)
		{
			System.out.println("Invalid name for small world. "+ card.name+ " Must use correct name of a main deck monster");
			System.exit(0);
		}
		String[] file_datum = card_data.get(index);
		add(card, file_datum[3], file_datum[1], file_datum[2], file_datum[4], file_datum[5]);
		
	}
	static void add(Card card, String type, String attribute, String level, String atk, String def)
	{
		cards.add(card);
		String[] datum = new String[] {type,attribute, level, atk, def};
		data.add(datum);
		List<Integer> new_pairings = new ArrayList<Integer>();
		for(int i = 0; i<cards.size()-1; i++)
		{
			String[] i_datum = data.get(i);
			List<Integer> i_pairings = pairs.get(i);
			int common = 0;
			for(int j = 0; j<datum.length; j++)
			{
				if(!(i_datum[j].equals("?")) && i_datum[j].equals(datum[j]))
					common++;
			}
			if(common==1)
			{
				new_pairings.add(i);
				i_pairings.add(cards.size()-1);
			}
		}
		pairs.add(new_pairings);
	}
	
	static void actions()
	{
		Action world= new Action("Small World");
		world.open().hopt();
		for(int i=0; i< pairs.size(); i++)
		{
			for(int j : pairs.get(i))
			{
				for(int k : pairs.get(j))
				{
					if(k!=i)
						world.poss(move(small_world,1,gy), move(cards.get(i), 1, banish_fd), move(cards.get(j),0,banish_fd), move(cards.get(k),0,1));
				}
			}
		}
	}
	private static MoveCondition move(Card card, int in, int out)
	{
		return new MoveCondition(card, in, out);
	}
	
}
