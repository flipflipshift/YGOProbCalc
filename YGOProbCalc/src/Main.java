import java.io.File;
import java.io.FileWriter;

public class Main {
	public static void main(String args[])
	{
		
		Card tuner1 = card("Tuner lv 1", 3, "tuner").numerics(1,1);
		Card tuner2 = card("Tuner lv 2", 3, "tuner").numerics(2,1);
		Card tuner3 = card("Tuner lv 3", 3, "tuner").numerics(3,1);
		Card tuner4 = card("Tuner lv 4", 3, "tuner").numerics(4,1);
		Card nontuner1 = card("Non-Tuner lv 1", 3, "non-tuner").numerics(1,1);
		Card nontuner2 = card("Non-Tuner lv 2", 3, "non-tuner").numerics(2,1);
		Card nontuner3 = card("Non-Tuner lv 3", 3, "non-tuner").numerics(3,1);
		Card nontuner4 = card("Non-Tuner lv 4", 3, "non-tuner").numerics(4,1);
		
		Card sync4 = card("Synchro lv 4", 0).numerics(4, 1);
		Card sync5 = card("Synchro lv 5", 0).numerics(5,1);
		Card sync6 = card("Synchro lv 6", 0).numerics(6,1);
		Card sync7 = card("Synchro lv 7", 0).numerics(7,1);
		Card sync8 = card("Synchro lv 8", 0).numerics(8,1);
		Card sync9 = card("Synchro lv 9", 0).numerics(9,1);
		Card sync10 = card("Synchro lv 10", 0).numerics(10,1);
		
		Card link2 = card("Synchro lv 10", 0).numerics(0,2);
		Card link3 = card("Synchro lv 10", 0).numerics(0,3);
		
		locations("Deck", "Hand", "Field", "GY");
		
		action("Unlimited normal").move_all(1,2).open().hopt();
		action("Synchro 4").add_poss(poss(move(1, "tuner",2,3), move(1,"non-tuner",2,3), move(sync4,-1,2)).sum(4,2)).open();
		action("Synchro 4").add_poss(poss(move(1, "tuner",2,3), move(2,"non-tuner",2,3), move(sync4,-1,2)).sum(4,2)).open();
		action("Synchro 5").add_poss(poss(move(1, "tuner",2,3), move(1,"non-tuner",2,3), move(sync5,-1,2)).sum(5, 2)).open();
		action("Synchro 5").add_poss(poss(move(1, "tuner",2,3), move(2,"non-tuner",2,3), move(sync5,-1,2)).sum(5, 2)).open();
		action("Synchro 6").add_poss(poss(move(1, "tuner",2,3), move(1,"non-tuner",2,3), move(sync6,-1,2)).sum(6, 2)).open();
		action("Synchro 6").add_poss(poss(move(1, "tuner",2,3), move(2,"non-tuner",2,3), move(sync6,-1,2)).sum(6, 2)).open();
		action("Synchro 7").add_poss(poss(move(1, "tuner",2,3), move(1,"non-tuner",2,3), move(sync7,-1,2)).sum(7, 2)).open();
		action("Synchro 7").add_poss(poss(move(1, "tuner",2,3), move(2,"non-tuner",2,3), move(sync7,-1,2)).sum(7, 2)).open();
		action("Synchro 8").add_poss(poss(move(1, "tuner",2,3), move(1,"non-tuner",2,3), move(sync8,-1,2)).sum(8, 2)).open();
		action("Synchro 8").add_poss(poss(move(1, "tuner",2,3), move(2,"non-tuner",2,3), move(sync8,-1,2)).sum(8, 2)).open();
		action("Synchro 9").add_poss(poss(move(1, "tuner",2,3), move(1,"non-tuner",2,3), move(sync9,-1,2)).sum(9, 2)).open();
		action("Synchro 9").add_poss(poss(move(1, "tuner",2,3), move(2,"non-tuner",2,3), move(sync9,-1,2)).sum(9, 2)).open();
		action("Synchro 10").add_poss(poss(move(1, "tuner",2,3), move(1,"non-tuner",2,3), move(sync10,-1,2)).sum(10, 2)).open();
		action("Synchro 10").add_poss(poss(move(1, "tuner",2,3), move(2,"non-tuner",2,3), move(sync10,-1,2)).sum(10, 2)).open();
		
		action("Link 2 Summon").add_poss(poss(move(2, "card", 2, 3), move(link2, -1,2)).sum(1,2,1)).open();
		action("Link 3 Summon").add_poss(poss(move(2, "card", 2, 3), move(link3, -1,2)).sum(1,3,1)).open();
		
		
		Gov.poss(cond(sync10, 2));
		//Gov.poss(cond(link3, 2));
		go("Sum testing", 10);
		
		
		
	}
	
	public static void main1(String args[])
	{
		Card dog = card("Fluffal Dog", 3, "fluff", "ns");
		Card peng = card("Fluffal Penguin", 2, "fluff", "ns");
		Card cat = card("Fluffal Cat", 1, "fluff");
		Card owl = card("Fluffal Owl", 1, "fluff", "ns");
		Card bear = card("Fluffal Bear", 2, "fluff");
		Card wings = card("Fluffal Wings", 2, "fluff");
		Card chain = card("Edge Imp Chain", 3, "edge");
		Card sabres = card("Edge Imp Sabres", 1, "edge");
		Card souls = card("Magicians' Souls", 2);
		Card ioc = card("Illusion of Chaos", 2);
		Card patch = card("Patchwork", 3, "frightfur");
		Card ff = card("Frightfur Fu", 1, "frightfur");
		Card repair = card("Frightfur rep", 1, "frightfur");
		Card poly = card("Poly", 3);
		Card small = card("Small World", 2);
		Card vend = card("Toy Vendor", 3);
		Card goods = card("Foolish goods", 3);
		Card gardens = card("Peng Gardens", 2);
		Card desires = card("Desires", 1);
		Card prosp = card("Prosp", 1);
		Card allure = card("Allure", 1);
		
		locations("Deck", "Hand", "MZ", "STZ", "GY", "Banish");
		hand(5);
		
		action("Gardens eff").poss(move(gardens,1,3),move(peng,0,1)).hopt().open();
		action("Patch eff").poss(move(patch,1,4), move(poly,0,1), move("edge",0,1)).hopt().open();	
		action("Goods eff").poss(move(goods,1,4), move(vend,0,4)).poss(move(goods,1,4), move(repair,0,4)).hopt().open();
		action("Repair gy eff").poss(move(repair,4,5), move("fluff",1,2));
		
		Action vend_gyeff = action("Vend gy effect").poss(move("fluff",0,1)).poss(move(sabres,0,1));
		MT.add(vend, list(0,1,3), 4, vend_gyeff);
		Action owl_effect=action("Owl effect").poss(move(poly,0,1)).hopt();
		MT.add(owl, 1, 2, owl_effect);
		Action dog_effect = action("Dog effect").poss(move("fluff",0,1).exclude(dog)).poss(move(sabres,0,1)).hopt();
		MT.add(dog,1, 2, dog_effect);
		action("normal").poss(move("ns",1,2)).open().hopt();
		action("Gardens field eff").poss(cond(gardens,3), cond(peng,list(1,2)), move("card", 1, 4)).open().hopt();
		Action chain_eff = action("Chain eff").poss(move("frightfur",0,1)).hopt();
		MT.add(chain, list(1,2), 4, chain_eff);	
		action("Vendor primitive field eff").poss(cond(vend,3), move("card",1,4)).open().hopt();
		action("Bear eff").poss(move(bear,1,4), move(vend,0,3)).open().hopt();
		action("Place Vend").poss(move(vend,1,3)).open();	
		
		Gov.poss(cond("fluff", list(1,2)), cond("edge", list(1,2)), cond(poly, 1));	
		go("Fluffal Demo 1", 100);
	
		
	}
	
	public static void main2(String args[])
	{
		Card dog = card("Fluffal Dog", 3, "fluff", "ns").small();
		Card peng = card("Fluffal Penguin", 2, "fluff", "ns").small();
		Card cat = card("Fluffal Cat", 1, "fluff").small();
		Card owl = card("Fluffal Owl", 1, "fluff", "ns").small();
		Card bear = card("Fluffal Bear", 2, "fluff").small();
		Card wings = card("Fluffal Wings", 2, "fluff").small();
		Card chain = card("Edge Imp Chain", 3, "edge").small();
		Card sabres = card("Edge Imp Sabres", 1, "edge").small();
		Card souls = card("Magicians' Souls", 2).small();
		Card ioc = card("Illusion of Chaos", 2).small();
		Card patch = card("Patchwork", 3, "s/t", "frightfur");
		Card ff = card("Frightfur Fu", 1, "s/t", "frightfur");
		Card repair = card("Frightfur rep", 1, "s/t", "frightfur");
		Card poly = card("Poly", 3, "s/t");
		Card small = card("Small World", 2, "s/t");
		Card vend = card("Toy Vendor", 3, "s/t");
		Card goods = card("Foolish goods", 3, "s/t");
		Card gardens = card("Peng Gardens", 2, "s/t");
		Card desires = card("Desires", 1, "s/t");
		Card prosp = card("Prosp", 1, "s/t");
		Card allure = card("Allure", 1, "s/t");
		
		Card whale = card("FF Whale", 0);
		Card VFD = card("VFD", 0);
		
		locations("Deck", "Hand", "MZ", "STZ", "GY", "Banish", "fdBanish", "Fusion Processing");
		hand(5);
		
		setsmallworld(small, 4, 6);
		
		action("Gardens eff").poss(move(gardens,1,3),move(peng,0,1)).hopt().open();
		action("Patch eff").poss(move(patch,1,4), move(poly,0,1), move("edge",0,1)).hopt().open();
		action("Goods eff").poss(move(goods,1,4), move(vend,0,4)).poss(move(goods,1,4), move(repair,0,4)).hopt().open();
		action("Repair gy eff").poss(move(repair,4,5), move("fluff",1,2));
		Action vend_gyeff = action("Vend gy effect").poss(move("fluff",0,1)).poss(move(sabres,0,1));
		MT.add(vend, list(0,1,3), 4, vend_gyeff);
		Action vend_field = action("Vendor field eff").poss(cond(vend,3), move("card",1,4)).open().hopt();
		action("Gardens field eff").poss(cond(gardens,3), cond(peng,list(1,2)), move("card", 1, 4)).open().hopt();
		action("Bear eff").poss(move(bear,1,4), move(vend,0,3)).open().hopt();
		action("Place Vend").poss(move(vend,1,3)).open();
		Action chain_eff = action("Chain eff").poss(move("frightfur",0,1)).hopt();
		MT.add(chain, list(1,2), 4, chain_eff);
		action("normal").poss(move("ns",1,2)).open().hopt();
		Action owl_effect=action("Owl effect").poss(move(poly,0,1)).hopt();
		MT.add(owl, 1, 2, owl_effect);
		Action dog_effect = action("Dog effect").poss(move("fluff",0,1).exclude(dog)).poss(move(sabres,0,1)).hopt();
		MT.add(dog,1, 2, dog_effect);
		
		action("Vendor primitive field eff").poss(cond(vend,3), move("card",1,4)).open().hopt();
		action("Bear eff").poss(move(bear,1,4), move(vend,0,3)).open().hopt();
		action("Place Vend").poss(move(vend,1,3)).open();	
		
		action("Wings eff").poss(move(wings,4,5), move("fluff",4,5), move(vend,3,4)).open().hopt().draw(1,2);
		action("Activate Desires").poss(move(desires,1,4)).draw(6,10).draw(1,2).open().hopt();
		action("Special Souls").poss(move(souls,1,2), move(ioc,0,4)).open().hopt();
		Action souls_1=action("souls for 1").poss(cond(souls,2),move("s/t", list(1,3),4)).draw(1,1).open().hopt();
		Action souls_2=action("souls for 2").poss(cond(souls,2),move(2,"s/t", list(1,3),4)).draw(1,2).open().hopt();
		souls_1.turnoff(souls_2);
		souls_2.turnoff(souls_1);
		action("IOC search").poss(move(ioc,1,0),move(souls,0,1)).open().hopt();
		action("Sabres Special").poss(move(sabres,4,2), move("card", 1,0)).open().hopt();
		Action IOC_vend = action("IOC Vendor Combo").poss(cond(vend,3), move(ioc,1,4),move("fluff",1,2), move(souls,0,1)).open().hopt();
		Action Sabres_vend = action("Sabres Vendor Combo").poss(cond(vend,3), move(sabres,4,2), move("fluff",1,2), move("card",1,4)).open().hopt();
		Sabres_vend.turnoff(IOC_vend, vend_field);
		IOC_vend.turnoff(Sabres_vend, vend_field);
		vend_field.turnoff(Sabres_vend, IOC_vend);
		Action fuse = action("Fuse into Whale").poss(move(poly,1,4), move("fluff",list(1,2),7), move("edge", list(1,2),4),move(whale,-1,2)).open();
		fuse.poss(move(ff,1,4), move("fluff", list(2,4), 5), move("edge", list(2,4), 5), move(whale,-1,2));
		fuse.poss(move(ff,1,4), move(2, "fluff", list(2,4), 5), move("edge", list(2,4), 5), move(whale,-1,2));
		fuse.poss(move(poly,1,4), move(2, "fluff",list(1,2),7), move("edge", list(1,2),4),move(whale,-1,2));
		Action fusion_process = action("Fusion processing").move_all(7, 4);
		fuse.trigger(fusion_process);
		Action penguin_discard = action("Peng disard").poss(move("card",1,4));
		Action penguin_draw = action("Penguin eff").no_conditions().draw(1, 2).trigger(penguin_discard).hopt();
		Action cat_eff = action("Cat eff").poss(move(poly,4,1)).hopt();
		MT.add(cat, 7, 4, cat_eff);
		MT.add(peng, 7, 4, penguin_draw);
		action("whale eff").poss(cond(whale,2), move(repair,0,4)).open().hopt();
		action("Make VFD").poss(move(2,whale,2,4), move(VFD,-1,2)).open().hopt();
		
		Gov.poss(cond(VFD,2));
		Gov.timeout(5);
		go("Fluffal Demo 2", 100);
	}
		
	
	public static void main3(String args[])
	{
		Card dog = card("Fluffal Dog", 3, "fluff", "ns").small();
		Card peng = card("Fluffal Penguin", 2, "fluff", "ns").small();
		Card cat = card("Fluffal Cat", 1, "fluff").small();
		Card owl = card("Fluffal Owl", 1, "fluff", "ns").small();
		Card bear = card("Fluffal Bear", 2, "fluff").small();
		Card wings = card("Fluffal Wings", 2, "fluff").small();
		Card chain = card("Edge Imp Chain", 3, "edge", "dark").small();
		Card sabres = card("Edge Imp Sabres", 1, "edge", "dark").small();
		Card souls = card("Magicians' Souls", 2, "dark").small();
		Card ioc = card("Illusion of Chaos", 2, "dark").small();
		Card patch = card("Patchwork", 3, "s/t", "frightfur");
		Card ff = card("Frightfur Fu", 1, "s/t", "frightfur");
		Card repair = card("Frightfur rep", 1, "s/t", "frightfur");
		Card poly = card("Poly", 3, "s/t");
		Card small = card("Small World", 2, "s/t");
		Card vend = card("Toy Vendor", 3, "s/t", "vend");
		Card vend_dead = card("Used Toy Vendor", 0, "s/t", "vend");
		Card goods = card("Foolish goods", 3, "s/t");
		Card gardens = card("Peng Gardens", 2, "s/t");
		Card desires = card("Desires", 1, "s/t");
		Card prosp = card("Prosp", 1, "s/t");
		Card allure = card("Allure", 1, "s/t");
		
		Card whale = card("FF Whale", 0);
		Card VFD = card("VFD", 0);
		
		locations("Deck", "Hand", "MZ", "STZ", "GY", "Banish", "fdBanish", "Fusion Processing", "Vend Exc", "Prosp Exc");
		hand(5);
		
		
		
		Action vend_gyeff = action("Vend gy effect").poss(move("fluff",0,1)).poss(move(sabres,0,1));
		MT.add(vend, list(-1,0,1,3,8), 4, vend_gyeff);
		Action chain_eff = action("Chain eff").poss(move("frightfur",0,1)).hopt();
		MT.add(chain, list(1,2), 4, chain_eff);
		Action owl_effect=action("Owl effect").poss(move(poly,0,1)).hopt();
		MT.add(owl, 1, 2, owl_effect);
		Action dog_effect = action("Dog effect").poss(move("fluff",0,1).exclude(dog)).poss(move(sabres,0,1)).hopt();
		MT.add(dog,1, 2, dog_effect);
		Action penguin_discard = action("Peng disard").poss(move("card",1,4));		
		Action penguin_draw = action("Penguin eff").no_conditions().draw(1, 2).trigger(penguin_discard).hopt();		
		Action cat_eff = action("Cat eff").poss(move(poly,4,1)).hopt();		
		MT.add(cat, 7, 4, cat_eff);
		MT.add(peng, 7, 4, penguin_draw);
		Action fusion_process = action("Fusion processing").move_all(7, 4);
		Action dump_all =action("Allure dump hand").move_all(1, 4);
		Action allure_payment = action("Allure Payment").poss(move("dark",1,5)).poss(dump_all).first();
		Action vend_swapback = action("Swap back vendor").poss(move(vend_dead,4,-1), move(vend,-1,4)).poss(move(vend_dead,1,-1), move(vend,-1,1));
		MT.add(vend_dead, 3, list(1,4), vend_swapback);		
		Action vend_hit = action("Vendor Hit!").poss(move("ns",1,2)).poss(move("fluff",1,2));
		Action vend_processing=action("Vendor Processing").poss(vend_hit,move("fluff",8,1)).poss(move("card",8,4)).first();		
		Action prosp_return = action("Return to deck").move_all(9, 0);
		Action prosp_add=action("Add off Prosperity").poss(move("card",9,1)).trigger(prosp_return);
		
		action("Gardens eff").guarantee_poss(move(gardens,1,3),move(peng,0,1)).hopt().open();
		action("Patch eff").guarantee_poss(move(patch,1,4), move(poly,0,1), move("edge",0,1)).hopt().open();
		action("Goods eff").guarantee_poss(move(goods,1,4), move(vend,0,4)).poss(move(goods,1,4), move(repair,0,4)).hopt().open();
		action("Make VFD").guarantee_poss(move(2,whale,2,4), move(VFD,-1,2)).open().hopt();
		Action fuse = action("Fuse into Whale").poss(move(poly,1,4), move("fluff",list(1,2),7), move("edge", list(1,2),4),move(whale,-1,2));
		fuse.poss(move(ff,1,4), move("fluff", list(2,4), 5), move("edge", list(2,4), 5), move(whale,-1,2)).open();
		fuse.poss(move(ff,1,4), move(2, "fluff", list(2,4), 5), move("edge", list(2,4), 5), move(whale,-1,2));
		fuse.poss(move(poly,1,4), move(2, "fluff",list(1,2),7), move("edge", list(1,2),4),move(whale,-1,2));
		fuse.trigger(fusion_process);
		Action wings_eff = action("Wings eff").poss(move(wings,4,5), move("fluff",4,5), move("vend",3,4)).open().hopt().draw(1,2);
		action("whale eff").poss(cond(whale,2), move(repair,0,4)).open().hopt();
		action("Special Souls").poss(move(souls,1,2), move(ioc,0,4)).open().hopt();
		Action IOC_vend = action("IOC Vendor Combo").poss(move(vend,3,-1), move(vend_dead,-1,3), move(ioc,1,4),move("fluff",1,2), move(souls,0,1)).open().hopt();
		Action Sabres_vend = action("Sabres Vendor Combo").poss(move(vend,3,-1), move(vend_dead,-1,3),move(sabres,4,2), move("fluff",1,2), move("card",1,4)).open().hopt();		
		action("IOC search").poss(move(ioc,1,0),move(souls,0,1)).open().hopt();
		action("Repair gy eff").poss(move(repair,4,5), move("fluff",1,2));
		action("normal").poss(move("ns",1,2)).open().hopt();
		action("Place Vend").poss(move(vend,1,3)).open();
		Action vend_field=action("Vendor field eff").poss(move(vend,3,-1),move(vend_dead,-1,3), move("card",1,4)).open().draw(8, 1);
		vend_field.trigger(vend_processing);
		action("Bear eff").poss(move(bear,1,4), move(vend,0,3)).open().hopt();
		Action souls_1=action("souls for 1").poss(cond(souls,2),move("s/t", list(1,3),4)).draw(1,1).open().hopt();
		Action souls_2=action("souls for 2").poss(cond(souls,2),move(2,"s/t", list(1,3),4)).draw(1,2).open().hopt();
		souls_1.turnoff(souls_2);
		souls_2.turnoff(souls_1);
		action("Sabres Special").poss(move(sabres,4,2), move("card", 1,0)).open().hopt();
		setsmallworld(small, 4, 6);
		action("Gardens field eff").poss(cond(gardens,3), cond(peng,list(1,2)), move("card", 1, 4)).open().hopt();
		Action desires_eff=action("Activate Desires").poss(move(desires,1,4)).draw(6,10).draw(1,2).open().hopt();
		action("Allure eff").poss(move(allure,1,4)).draw(1,2).open().trigger(allure_payment);
		Action prosp_eff=action("Prosperity eff").poss(move(prosp,1,4)).open().hopt().draw(9,6).trigger(prosp_add);		

		//also bear's field eff that turns off
		prosp_eff.turnoff(vend_field,IOC_vend,Sabres_vend,wings_eff,souls_1, souls_2, penguin_draw, desires_eff);
		vend_field.turnoff(prosp_eff);
		IOC_vend.turnoff(prosp_eff);
		Sabres_vend.turnoff(prosp_eff);
		wings_eff.turnoff(prosp_eff);
		souls_1.turnoff(prosp_eff);
		souls_2.turnoff(prosp_eff);
		penguin_draw.turnoff(prosp_eff);
		desires_eff.turnoff(prosp_eff);
		
		
		Gov.poss(cond(VFD,2));
		Gov.timeout(5);
		go("Fluffal Demo 3", 100);
	}
	

	
	
	
	
	//Ignore below this line
	private static void go(String filename, int num_trials)
	{
		try{
			File f = new File("src/"+filename+".txt");
			FileWriter fw = new FileWriter(f);
			Gov.probability(fw, num_trials);
			fw.close();
		}
		
		catch(Exception e)
		{
		e.printStackTrace();
		}
	}
	private static int[] list(int... arr)
	{
		return arr;
	}
	private static Action[] list(Action... arr)
	{
		return arr;
	}
	private static MoveCondition move(String category, int in, int out)
	{
		return new MoveCondition(category, in, out);
	}
	private static MoveCondition move(String category, int[] in, int out)
	{
		return new MoveCondition(category, in, out);
	}
	private static MoveCondition move(Card card, int in, int out)
	{
		return new MoveCondition(card, in, out);
	}
	private static MoveCondition move(Card card, int[] in, int out)
	{
		return new MoveCondition(card, in, out);
	}
	private static MoveCondition move(int num, String category, int in, int out)
	{
		return new MoveCondition(num, category, in, out);
	}
	private static MoveCondition move(int num, String category, int[] in, int out)
	{
		return new MoveCondition(num, category, in, out);
	}
	private static MoveCondition move(int num, Card card, int in, int out)
	{
		return new MoveCondition(num, card, in, out);
	}
	private static MoveCondition move(int num, Card card, int[] in, int out)
	{
		return new MoveCondition(num, card, in, out);
	}
	private static Condition cond(int num, char symbol, String category, int... locations)
	{
		return new Condition(num, symbol, category, locations);
	}
	private static Condition cond(int num, char symbol, Card card, int... locations)
	{
		return new Condition(num, symbol, card, locations);
	}
	private static Condition cond(int num, String category, int... locations)
	{
		return new Condition(num, category, locations);
	}
	private static Condition cond(String category, int... locations)
	{
		return new Condition(category, locations);
	}
	private static Condition cond(int num, Card card, int... locations)
	{
		return new Condition(num, card, locations);
	}
	private static Condition cond(Card card, int... locations)
	{
		return new Condition(card, locations);
	}
	private static Condition zcond(String category, int... locations)
	{
		return new Condition(0, '=', category, locations);
	}
	private static Condition zcond(Card c, int... locations)
	{
		return new Condition(0, '=', c, locations);
	}
	private static Condition lcond(int num, String category, int... locations)
	{
		return new Condition(num, '-', category, locations);
	}
	private static Condition lcond(int num, Card c, int... locations)
	{
		return new Condition(num, '-', c, locations);
	}
	private static Action action(String name)
	{
		return new Action(name);
	}
	private static Card card(String name, int quantity)
	{
		return new Card(name, quantity);
	}
	private static Card card(String name, int quantity, String... cats)
	{
		return new Card(name, quantity, cats);
	}
	private static void hand(int hand_size)
	{
		Gov.hand_size=hand_size;
	}
	private static void locations(String... locations)
	{
		Gov.locations=locations;
	}
	public static Condition cond(int num, Card card)
	{
		return new Condition(num, card);
	}
	public static Condition cond(Card card)
	{
		return new Condition(card);
	}
	public static Condition cond(int num, String category)
	{
		return new Condition(num, category);
	}
	public static Condition cond(String category)
	{
		return new Condition(category);
	}
	public static void complete(int num)
	{
		if(Card.deck_size>num)
		{
			System.out.println("Deck inputs larger than deck size");
			System.exit(0);
		}
		card("blank", num-Card.deck_size);
	}
	public static void terminate(Action[] are_off, Condition... conds)
	{
		Gov.terminate(are_off, conds);
	}
	public static void setsmallworld(Card smallworld, int gy_locnum, int banishfd_locnum)
	{
		SmallWorld.small_world=smallworld;
		SmallWorld.gy=gy_locnum;
		SmallWorld.banish_fd=banishfd_locnum;
		SmallWorld.actions();
	}
	public static void set_extra(int extra_loc)
	{
		Gov.extra_deck_index=extra_loc;
	}
	public static Condition[] or(Condition... conds)
	{
		return conds;
	}
}

