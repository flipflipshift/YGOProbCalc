import java.io.File;
import java.io.FileWriter;

public class SampleMains {
	//Just random main methods for different decks; some incomplete
	public static void mainFlufSmallWorldTest(String args[])
	{
		Card dog = card("Fluffal Dog", 3, "fluffal",   "ns", "monster", "lv4").small();
		Card bear = card("Fluffal Bear", 2, "fluffal", "ns", "monster").small();
		Card dolphin = card("Fluffal Dolphin", 2, "fluffal",  "lv4water", "ns", "monster", "lv4").small();
		Card sheep = card("Fluffal Sheep", 1, "fluffal",  "ns", "monster").small();
		Card wings = card("Fluffal Wings", 1, "fluffal",  "ns", "monster", "good_discard").small();
		Card penguin = card("Fluffal Penguin", 3, "fluffal",  "lv4water", "ns", "monster", "lv4", "peng").small();
		Card penguin3 = card("lv3 Fluffal Penguin", 0, "fluffal", "peng", "monster");
		Card octo = card("Fluffal Octopus", 1, "fluffal", "ns", "monster").small();
		Card vendor = card("Toy Vendor", 3, "goods_target", "s/t", "good_discard");
		Card repair = card("Frightfur Repair", 1, "frightfur",  "goods_target", "s/t", "good_discard");
		Card patchwork = card("Frightfur Patchwork", 3, "frightfur", "s/t");
		Card frightfur_fus = card("Frightfur Fusion", 1, "frightfur", "s/t");
		Card poly = card("Polymerization", 3, "s/t");
		Card goods = card("Foolish Burial Goods", 3, "s/t");
		Card chain = card("Edge Imp Chain", 3, "edge", "ns", "monster", "lv4", "good_discard").small();
		Card edge_scythe = card("Edge Imp Scythe", 3, "edge", "ns", "monster").small();
		Card sabres = card("Edge Imp Sabres", 1, "edge", "ns", "monster", "good_discard").small();
		Card gardens = card("Royal Penguin Gardens", 3, "s/t");
		Card driver = card("Psy-Frame Driver", 1, "monster").small();
		Card gamma = card("Psy-Framegear Gamma", 3, "monster", "dugcross_spec").small();
		Card arti_scythe = card("Artifact Scythe", 1, "monster").small();
		Card arti_lancea = card("Artifact Lancea", 1).small();
		Card nib = card("Nibiru, the Primal Being",1).small();
		Card ash = card("Ash Blossom & Joyous Spring",1).small();
		Card eldlich = card("Eldlich the Golden Lord", 2, "monster").small();
		Card illusion = card("Illusion of Chaos",3).small("Spellcaster", "DARK", "7", "2100", "2500");
		Card smallworld = card("Small World",3);

		locations("Deck", "Hand", "Monster Zone", "S/T Zone", "GY", "Banish", "Prosp Zone", "banishfd");
		
		setsmallworld(smallworld,4,7);
		
		
		poss(cond(chain));
		go("SmallWorldTest",1000);
	}
	public static void mainT(String args[])
	{
		Card rescue = card("Rescue Cat", 3, "tri-type", "monster");
		Card frak = card("TB Fraktall", 3, "tb", "tri-type", "monster", "main tb");
		Card kitt = card("TB Kitt", 3, "tb", "tri-type", "monster", "cat_summon", "good_gy", "main tb");
		Card nerv = card("TB Nervall", 3, "tb", "tri-type", "monster", "good_gy", "main tb");
		Card keras = card("TB Keras", 2, "tb", "tri-type", "monster", "cat_summon", "main tb");
		Card ash_veiler = card("ash/veiler",5, "monster", "first_trap", "second_trap", "altnormal");
		Card gamma = card("Gamma", 3, "monster", "second_trap");
		Card driver = card("Driver",1);
		Card imperm = card("Impermanence", 2, "first_trap", "second_trap");
		Card strike = card("Solemn Strike", 2, "first_trap");
		Card revolt = card("TB Revolt", 2);
		Card imporder = card("Imperial Order", 1);
		Card dheroes = card("DFusion brick", 2);
		Card Dfusion = card("Fusion Destiny", 3);
		Card tenki = card("Tenki", 1);
		Card cbtg = card("cbtg",1);
		Card prosperity = card("Pot of Prosperity",3);
		//Card desires = card("Desires", 0);
		
		Card almiraj = card("Almiraj", 0);
		Card ferrijit = card("Ferrijit", 0, "tb", "tri-type", "tb link-2", "ferrijit");
		Card brumm = card("Bearbrumm", 0, "tb", "tri-type", "tb link-2", "brumm");
		Card rugal = card("Rugal", 0, "tb", "tri-type", "tb link-3", "rugal", "good_with_rev");
		Card omen =  card("Shuraig", 0, "tb", "tri-type", "tb link-4", "omen");
		Card fake_ferrijit = card("Imp Ferrijit", 0, "fake tb", "tri-type", "tb link-2", "ferrijit");
		Card fake_brumm = card("Imp Bearbrumm", 0, "fake tb", "tri-type", "tb link-2", "brumm");
		Card fake_rugal = card("Imp Rugal", 0, "fake tb", "tri-type", "tb link-3", "rugal", "good_with_rev");
		Card fake_omen =  card("Imp Shuraig", 0, "fake tb", "tri-type", "tb link-4", "omen");
		Card verte = card("Verte", 0);
		Card enforcer = card("Enforcer",0);
		/*Card apo2 = card("Apollousa-2", 0 , "apo", "good_with_rev");
		Card apo3 = card("Apollousa-3", 0 , "apo", "good_with_rev");
		Card apo4 = card("Apollousa-4",0, "apo", "good_with_rev");*/
		
		locations("Deck", "Hand", "Monster Zone", "S/T Zone", "GY", "Banish", "Prosp Zone", "Desires zone");
		hand(5);
		
		Action place_revolt = action("Place revolt").open().hopt().poss(move(revolt,1,3));
		
		action("Normal Summon").open().hopt().poss(move("tri-type", 1, 2));
		Action frak_eff = action("Frak eff").open().hopt().poss(move(frak,1,4), move("tb",0,4).exclude(frak));
		Action kitt_eff = action("Kitt send").hopt().poss(move(nerv,0,4));
		Action nerv_eff = action("Nerv add").hopt().poss(move("tb",0,1).exclude(nerv));
		MT.add(kitt, list(0,1,2), 4, kitt_eff);
		MT.add(nerv, list(0,1,2), 4, nerv_eff);
		action("Keras eff").open().hopt().poss(move(keras,1,2), move("tri-type", 1, 4));
		
		Action fraktall_summon = action("Frak summon link").open().hopt();
		fraktall_summon.poss(cond(frak,2), move(2,"tri-type",4,5), move(fake_ferrijit, -1, 2));
		fraktall_summon.poss(cond(frak,2), move(2,"tri-type",4,5), move(fake_brumm, -1, 2));
		fraktall_summon.poss(cond(frak,2), move(3,"tri-type",4,5), move(fake_rugal, -1, 2));
		fraktall_summon.poss(cond(frak,2), move(4,"tri-type",4,5), move(fake_omen, -1, 2));
		Action kitt_summon = action("Kitt summon link").open().hopt();
		kitt_summon.poss(cond(kitt,2), move(2,"tri-type",4,5), move(fake_ferrijit, -1, 2));
		kitt_summon.poss(cond(kitt,2), move(2,"tri-type",4,5), move(fake_brumm, -1, 2));
		kitt_summon.poss(cond(kitt,2), move(3,"tri-type",4,5), move(fake_rugal, -1, 2));
		kitt_summon.poss(cond(kitt,2), move(4,"tri-type",4,5), move(fake_omen, -1, 2));
		Action nerv_summon = action("Nerv summon link").open().hopt();
		nerv_summon.poss(cond(nerv,2), move(2,"tri-type",4,5), move(fake_ferrijit, -1, 2));
		nerv_summon.poss(cond(nerv,2), move(2,"tri-type",4,5), move(fake_brumm, -1, 2));
		nerv_summon.poss(cond(nerv,2), move(3,"tri-type",4,5), move(fake_rugal, -1, 2));
		nerv_summon.poss(cond(nerv,2), move(4,"tri-type",4,5), move(fake_omen, -1, 2));
		Action keras_summon = action("Keras summon link").open().hopt();
		keras_summon.poss(cond(keras,2), move(2,"tri-type",4,5), move(fake_ferrijit, -1, 2));
		keras_summon.poss(cond(keras,2), move(2,"tri-type",4,5), move(fake_brumm, -1, 2));
		keras_summon.poss(cond(keras,2), move(3,"tri-type",4,5), move(fake_rugal, -1, 2));
		keras_summon.poss(cond(keras,2), move(4,"tri-type",4,5), move(fake_omen, -1, 2));
		
		action("Cat eff").open().hopt().poss(move(rescue,2,4), move(2,"cat_summon", 0, 2));
		action("Tenki eff").open().hopt().poss(move(tenki,1,3), move(frak,0,1));
		Action prosp_eff = action("Prosp eff").open().hopt().poss(move(prosperity,1,4)).draw(6, 6);
		Action prosp_processing = action("Prosp processing").poss(move("card", 6,1)).move_all(6,0);
		prosp_eff.trigger(prosp_processing);
		
		action("Summon almiraj").open().hopt().poss(move(kitt,2,4), move(almiraj,-1,2)).poss(move(nerv,2,4), move(almiraj,-1,2));
		action("Summon Ferrijit").open().poss(move(2,"tri-type",2,4), move(ferrijit,-1,2));
		Action summon_rugal = action("Summon Rugal").open().poss(move(3,"tri-type",2,4), move(rugal,-1,2));
		summon_rugal.poss(cond(2, "tri-type", 2), move("tb link-2", 2,4), move("tri-type", 2,4));
		Action summon_omen = action("Summon Omen").open().poss(move(4,"tri-type",2,4), move(omen,-1,2));
		summon_omen.poss(cond(3, "tri-type", 2), move("tb link-2", 2,4), move(2, "tri-type", 2,4));
		summon_omen.poss(cond(2, "tri-type", 2), move("tb link-3", 2,4), move("tri-type", 2,4));
		
		/*Action summon_apo = action("Summon apo4").open().hopt().poss(move(4, "tri-type", 2,4).distinct(), move(apo4,-1,2));
		summon_apo.poss(cond(3,"tri-type",2),move(1,"tb link-2", 2,4),move(2, "tri-type", 2,4).distinct(), move(apo3,-1,2));
		summon_apo.poss(move(2,"tb link-2", 2,4).distinct(), move(apo2,-1,2)).poss(cond(2,"tri-type",2),move("tb link-3", 2,4),move( "tri-type", 2,4).distinct(), move(apo2,-1,2));*/

		
		Action ferrijit_eff = action("Ferri eff to spec").open().hopt().poss(cond("ferrijit",2), move("tri-type", 1, 2));
		Action ferrijit_draw = action("Ferri eff to draw").hopt().draw(1,1);
		Action put_back = action("Put back 1").poss(move("card",1,0));
		ferrijit_draw.trigger(put_back);
		ferrijit_draw.turnoff(prosp_eff);
		prosp_eff.turnoff(ferrijit_draw);
		MT.add("ferrijit", 2, 4, ferrijit_draw);
		
		
		
		Action brumm_eff = action("Brumm eff to spec").open().hopt().poss(cond("brumm",2), move(2,"card",1,4), move("main tb",5,2));
		Action brumm_add = action("Brumm eff to add").hopt().poss(move(revolt,0,1)).trigger(put_back);
		MT.add("brumm", 2, 4, brumm_add);

		
		
		Action omen_add = action("Omen eff to add").hopt().poss(cond("card", 5), move(nerv, 0,1)).poss(cond(2,"card", 5), move("cat_summon",0,1));
		MT.add("omen", 2, 4, omen_add);
		
		Action enforcer_eff = action("Enforcer pop").hopt().open().poss(cond(enforcer,2), move("brumm",2,4));
		
		
		Action fusion_destiny = action("Fusion Destiny eff").hopt().open().poss(move(Dfusion,1,4),move(2,dheroes, list(0,1),4), move(enforcer,-1,2));
		
		
		action("Summon Verte").open().hopt().poss(cond(Dfusion,0),cond(2,dheroes, list(0,1)),move(2,"tri-type",2,4), move(verte,-1,2));
		Action verte_eff = action("Eff Verte").open().hopt().poss(move(Dfusion,0,4),move(2,dheroes, list(0,1),4), move(enforcer,-1,2), cond(verte,2));
		verte_eff.turnoff_all().turnon(enforcer_eff).turnon(brumm_add).turnon(kitt_eff).turnon(nerv_eff).turnon(frak_eff);
		brumm_add.turnoff_all().turnon(place_revolt).turnon(put_back);
		fusion_destiny.turnoff_all().turnon(enforcer_eff).turnon(brumm_add).turnon(kitt_eff).turnon(nerv_eff).turnon(frak_eff);
		brumm_add.turnoff_all().turnon(place_revolt).turnon(put_back);
		/*Action desires_eff = action("Activate Desires").open().hopt().poss(move(desires, 1, 4)).draw(7, 10).draw(1,2);
		desires_eff.turnoff(prosp_eff);
		prosp_eff.turnoff(desires_eff);*/
		
		
		Gov.poss(cond(enforcer,2),cond(revolt,3), cond(4, "tri-type", list(4,5)).exclude("fake tb"), cond(1, "good_gy", list(4,5)));
		Gov.poss(cond(enforcer,2),cond(revolt,3), cond(3, "tri-type", list(4,5)).exclude("fake tb"), cond(1,"tb link-2", list(4,5)).exclude("fake tb"), cond(1, "good_gy", list(4,5)));
		//Gov.poss(cond(revolt,3), cond(4, "tri-type", list(4,5)).exclude("fake tb"), cond(1, "good_gy", list(4,5)));
		//Gov.poss(cond(revolt,3), cond(3, "tri-type", list(4,5)).exclude("fake tb"), cond(1,"tb link-2", list(4,5)).exclude("fake tb"), cond(1, "good_gy", list(4,5)));
		//Gov.poss(cond("good_with_rev",2),cond(revolt,3), cond(4, "tri-type", list(4,5)).exclude("fake tb"), cond(1, "good_gy", list(4,5)));
		//Gov.poss(cond("good_with_rev",2),cond(revolt,3), cond(3, "tri-type", list(4,5)).exclude("fake tb"), cond(1,"tb link-2", list(4,5)).exclude("fake tb"), cond(1, "good_gy", list(4,5)));
		//Gov.poss(cond("apo",2),cond(enforcer,2),cond(revolt,3), cond(4, "tri-type", list(4,5)).exclude("fake tb"), cond(1, "good_gy", list(4,5)));
		//Gov.poss(cond("apo",2),cond(enforcer,2),cond(revolt,3), cond(3, "tri-type", list(4,5)).exclude("fake tb"), cond(1,"tb link-2", list(4,5)).exclude("fake tb"), cond(1, "good_gy", list(4,5)));

		
		//Gov.terminate(cond(2, revolt, 7));
		//Gov.terminate(cond(dheroes, 7));
		//Gov.terminate(cond(Dfusion, 7));
		
		go("Enforcer + Revolt 2", 5);
		
		
	}
	public static void mainFTK(String args[])
	{
		Card peg = card("Pegasus", 3);
		Card shield = card("Shield", 3);
		Card heritrota = card("Heritage/ROTA", 4, "spell");
		Card bridgebond = card("Bridge/Bond", 6, "spell");
		Card zenith = card("zenith", 2);
		Card brick = card("soft brick", 3);
		Card garnet1 = card("garnet1", 2);
		Card garnet2 = card("garnet2", 2);
		Card garnet3 = card("garnet3", 2);
		Card garnet4 = card("garnet4", 2);
		Card handoff = card("Left Hand Offering", 3);
		Card htcounter = card("Dragged Down / cbtg / exchange", 7, "spell");
		Card mallet = card("Mallet/Reload", 6); //Functionally identical here
		Card invoid = card("Into Void", 3);
		
		locations("Deck", "Hand", "Monster Zone", "S/T Zone", "GY", "Banish");
		hand(5);
		
		Action placezen = action("Place zenith").poss(move(zenith,list(0,1,4),3));
		action("Summon peg").open().hopt().poss(move(peg, 1, 2)).trigger(placezen);
		Action mallet1 = action("Mallet eff").open().poss(move(mallet, 1, 4), move(1, "card", 1, 0)).draw(1,1);
		Action mallet2 = action("Mallet eff").open().poss(move(mallet, 1, 4), move(2, "card", 1, 0)).draw(1,2);
		Action mallet3 = action("Mallet eff").open().poss(move(mallet, 1, 4), move(3, "card", 1, 0)).draw(1,3);
		Action mallet4 = action("Mallet eff").open().poss(move(mallet, 1, 4), move(4, "card", 1, 0)).draw(1,4);
		Action mallet5 = action("Mallet eff").open().poss(move(mallet, 1, 4), move(5, "card", 1, 0)).draw(1,5);
		Action mallet6 = action("Mallet eff").open().poss(move(mallet, 1, 4), move(6, "card", 1, 0)).draw(1,6);
		action("Into The Void").open().poss(move(invoid,1,4)).draw(1,1);
		action("Search Shield").open().hopt().poss(move(heritrota,1,4), move(shield,0,1));
		action("Shield search").open().hopt().poss(move(shield,1,5), move(peg,0,1));
		action("Bond eff").open().hopt().poss(move(bridgebond,1,4), move(peg,0,1), move(zenith,0,3));
		Action left_add = action("Left Hand add").poss(move("spell",0,1));
		Action left = action("Left Hand Off").open().hopt().poss(cond(3, "card", 1), move(handoff,1,4)).move_all(1, 5).trigger(left_add);
		
		
		poss(cond(peg,2), cond(zenith,3), cond(peg,0),cond(garnet1, 0), cond(garnet2, 0), cond(garnet3, 0), cond(garnet4, 0));
		
		go("ignore ftk v2, 2xgarnet", 100000);
	}
	public static void mainCBTriAlb(String args[])
	{
		Card peg = card("Pegasus", 3, "ns", "beast", "monster", "tri-type", "lv4", "cb");
	    Card zenith = card("Zenith", 2, "monster", "dragon", "cb");
	    Card rdd = card("Rainbow Dark", 1, "monster", "dark", "dragon");
	    Card bond = card("Crystal Bond", 2, "crystal s/t");
	    Card bridge = card("Rainbow Bridge", 3);
	    Card conc = card("Crystal Conclave", 1, "crystal s/t");
	    Card brandedfus = card("Branded Fusion", 1, "branded s/t");
	    Card albaz = card("albaz", 1,  "monster", "dragon", "dark", "lv4", "ns", "alb");
	    Card brandred = card("Branded in Red", 1, "branded s/t");
	    Card brandcond = card("Branded Condemnation", 1, "branded s/t");
	    Card brandspirit = card("Branded in High Spirits", 3, "branded s/t");
	    Card brandblade = card("Branded Blade", 1, "branded s/t");
	    Card sprigkitt = card("Spriggans Kitt", 1, "monster", "ns", "lv4", "alb", "beast", "tri-type");
	    Card albion = card("Albion the Shrouded", 1, "alb", "monster", "dark", "dragon");
	    Card ecclesia = card("Incredible Ecclesia", 1, "alb", "monster", "lv4", "ns");
	    Card merc = card("TB Mercourier", 2, "alb", "monster", "ns", "lv4", "dark", "tri-type");
	    Card frak = card("TB Fraktall", 3, "ns", "tb", "tri-type", "monster", "main tb");
		Card kitt = card("TB Kitt", 3, "ns", "tb", "tri-type", "monster", "beast", "main tb");
		Card nerv = card("TB Nervall", 3, "ns","tb", "tri-type", "monster","main tb");
		Card keras = card("TB Keras", 3, "ns", "tb", "tri-type", "monster", "beast", "main tb");
		Card revolt = card("TB Revolt", 1);
		Card tenki = card("Tenki", 1);
		Card foolish = card("Foolish", 1);
	    Card crow = card("D.D. Crow", 1, "dark", "monster", "tri-type");
	    Card allure = card("Allure", 3);
	    
		Card almiraj = card("Almiraj", 0);
		Card ferrijit = card("Ferrijit", 0, "tb", "tri-type", "tb link-2", "ferrijit");
		Card brumm = card("Bearbrumm", 0, "tb", "tri-type", "tb link-2", "brumm");
		Card rugal = card("Rugal", 0, "tb", "tri-type", "tb link-3", "rugal", "good_with_rev");
		Card omen =  card("Shuraig", 0, "tb", "tri-type", "tb link-4", "omen");
		Card fake_ferrijit = card("Imp Ferrijit", 0, "fake tb", "tri-type", "tb link-2", "ferrijit");
		Card fake_brumm = card("Imp Bearbrumm", 0, "fake tb", "tri-type", "tb link-2", "brumm");
		Card fake_rugal = card("Imp Rugal", 0, "fake tb", "tri-type", "tb link-3", "rugal", "good_with_rev");
		Card fake_omen =  card("Imp Shuraig", 0, "fake tb", "tri-type", "tb link-4", "omen");
		Card verte = card("Verte", 0);
		Card apo2 = card("Apollousa-2", 0 , "apo", "good_with_rev");
		Card apo3 = card("Apollousa-3", 0 , "apo", "good_with_rev");
		Card apo4 = card("Apollousa-4",0, "apo", "good_with_rev");
		Card raff = card("Rafflesia", 0);
		Card mirror = card("Mirrorjade", 0);
		
	    
	    locations("Deck", "Hand", "Monster Zone", "S/T Zone", "GY", "Banish");
		hand(5);
		action("Normal Summon").open().hopt().poss(move("ns", 1, 2));
		action("zenith eff").open().hopt().poss(move(zenith, 3, 5), move(peg, 0, 2), move(rdd, 0, 1));
		Action peg_eff = action("Pegasus eff").poss(move(zenith, list(0,1,4),3));
		MT.add(peg, list(1,4), 2, peg_eff);
	    action("Bond eff").open().hopt().poss(move(bond,1,4), move(zenith,0,3), move(peg,0,1));
	    action("Bridge eff").open().hopt().poss(move(bridge,1,4), move("crystal s/t",0,1));
	    
	}
	public static void mainBF(String args[])
	{
	Card peg = card("Pegasus", 3, "ns", "beast", "monster", "windlv4");
    Card zenith = card("Zenith", 3, "monster", "dragon");
    Card dyna = card("Dynatherium", 1, "beast", "monster", "windlv4");
	Card shield = card("Shield", 3, "monster");
	Card rdd = card("Rainbow Dark", 1, "monster", "dark", "dragon");
    Card brandedfus = card("Branded Fusion", 3);
    Card albaz = card("albaz", 1,  "monster");
    Card lhsf = card("Light HS Fusion", 1, "monster");
    Card brandred = card("Branded in Red", 1);
    Card sprigkitt = card("Spriggans Kitt", 3, "monster", "ns");
    Card prosp = card("Prosperity", 3);
    Card bond = card("Crystal Bond", 3);
    Card bridge = card("Rainbow Bridge", 3);
    Card othermon = card("monster", 10);
    Card otherst = card("s/t", 10);

    Card albion = card("Albion", 0, "dark", "monster");
    Card beasteyes = card("Beast Eyes", 0, "fusion", "dragon", "monster");
    Card dragoon = card("Dragoon", 0, "monster", "dark");

    locations("Deck", "Hand", "Monster Zone", "S/T Zone", "GY", "Banish", "Exc");
	hand(5);
    action("Normal Summon").open().hopt().poss(move("ns", 1, 2));
	action("zenith eff").open().hopt().poss(move(zenith, 3, 5), move(peg, 0, 2), move(rdd, 0, 1));
	action("shield eff").open().hopt().poss(move(shield, 1, 5), move("windlv4", 0, 1));
	Action peg_eff = action("Pegasus eff").poss(move(zenith, list(0,1,4),3));
	MT.add(peg, list(1,4), 2, peg_eff);
	action("Dyna spec").open().hopt().poss(move(dyna, 1, 2));
    action("Branded Fusion eff").open().hopt().poss(move(brandedfus,1,4),move(albaz, list(0,1), 4), 
    move(lhsf, list(0,1), 4), move(albion, -1, 2));
    Action albioneff = action("Albion eff").hopt().poss(move(lhsf,list(1,4),5), 
    move("dragon", list(1,2,4),5), move(dragoon,-1,2));
    MT.add(albion,-1, 2,albioneff);
    action("Summon Beast-Eyes").open().hopt().poss(move("beast",2,4), move(albion,2,4));
    Action albiongyeff = action("Albion gy eff").hopt().poss(move(brandred,list(0,1),3));
    MT.add(albion,2,4,albiongyeff);
    action("Bond eff").open().hopt().poss(move(bond,1,4), move(zenith,0,3), move(peg,0,1));
    action("Bridge eff").open().hopt().poss(move(bridge,1,4), move(bond,0,1));
	Action prosp_eff = action("Prosp eff").open().hopt().poss(move(prosp,1,4)).draw(6, 6);
	Action prosp_processing = action("Prosp processing").poss(move("card", 6,1)).move_all(6,0);
	prosp_eff.trigger(prosp_processing);


    Gov.poss(cond(brandred,3), cond(albaz,4));

    go("Branded", 100);
  }
	
	public static void mainB(String args[])
	{
		Card peg = card("Pegasus", 3, "ns", "lv4", "cb", "windlv4");
		Card frak = card("Fraktall", 6, "ns", "lv4", "cb");
		Card cobalt = card("Cobalt", 1, "ns", "lv4", "cb");
		Card zenith = card("Zenith", 3);
		Card dyna = card("Dynatherium", 1, "ns", "lv4", "windlv4");
		Card shield = card("Shield", 3);
		Card rdd = card("rdd", 1);
		Card other = card("blank", 21);
		Card bagooska = card("Bagooska", 0);
		Card desires = card("Desires",3);
		locations("Deck", "Hand", "Monster Zone", "S/T Zone", "GY", "Banish", "FD Banish", "Exc");
		hand(5);


		action("Normal Summon").open().hopt().poss(move("ns", 1, 2));
		action("zenith eff").open().hopt().poss(move(zenith, 3, 5), move("cb", 0, 2), move(rdd, 0, 1));
		action("shield eff").open().hopt().poss(move(shield, 1, 5), move("windlv4", 0, 1));
		Action peg_eff = action("Pegasus eff").poss(move(zenith, list(0,1,4),3));
		MT.add(peg, list(1,4), 2, peg_eff);
		action("Dyna spec").open().hopt().poss(move(dyna, 1, 2));
		action("Summon Bagooska").open().poss(move(2, "lv4", 2, 4), move(bagooska, -1, 2));
		
		Gov.poss(cond(bagooska, 2));
		
		go("bagooska", 10000);
	}
	private static void go(String filename, int num_trials)
	{
		try{
			File f = new File("src/"+filename+".txt");
			FileWriter fw = new FileWriter(f);
			System.out.println(Gov.probability(fw, num_trials));
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
		Gov.hand_size=5;
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
	public static void poss(Condition... conditions) //if something like allure, check for a dark to discard first 
	{
		Gov.poss(conditions);
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
	}

}
