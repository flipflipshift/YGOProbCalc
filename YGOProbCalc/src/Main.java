import java.io.File;
import java.io.FileWriter;

public class Main {
	public static void main(String args[])
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
		
		go("Enforcer + Revolt", 5);
		
		
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
	public static void mainF(String args[])
	{
		Card dog = card("Fluffal Dog", 3, "fluffal",   "ns", "monster", "lv4");
		Card bear = card("Fluffal Bear", 2, "fluffal", "ns", "monster");
		Card dolphin = card("Fluffal Dolphin", 2, "fluffal",  "lv4water", "ns", "monster", "lv4");
		Card sheep = card("Fluffal Sheep", 1, "fluffal",  "ns", "monster");
		Card wings = card("Fluffal Wings", 1, "fluffal",  "ns", "monster", "good_discard");
		Card penguin = card("Fluffal Penguin", 3, "fluffal",  "lv4water", "ns", "monster", "lv4", "peng");
		Card penguin3 = card("lv3 Fluffal Penguin", 0, "fluffal", "peng", "monster");
		Card octo = card("Fluffal Octo", 1, "fluffal", "ns", "monster");
		Card vendor = card("Toy Vendor", 3, "goods_target", "s/t", "good_discard");
		Card repair = card("Frightfur Repair", 1, "frightfur",  "goods_target", "s/t", "good_discard");
		Card patchwork = card("Frightfur Patchwork", 3, "frightfur", "s/t");
		Card frightfur_fus = card("Frightfur Fusion", 1, "frightfur", "s/t");
		Card poly = card("Polymerization", 3, "s/t");
		Card goods = card("Foolish Burial Goods", 3, "s/t");
		Card chain = card("Edge Imp Chain", 3, "edge", "ns", "monster", "lv4", "good_discard");
		Card edge_scythe = card("Edge Imp Scythe", 3, "edge", "ns", "monster");
		Card sabres = card("Edge Imp Sabres", 1, "edge", "ns", "monster", "good_discard");
		Card gardens = card("Royal Penguin Gardens", 3, "s/t");
		Card driver = card("Psy-Frame Driver", 1, "monster");
		Card gamma = card("Psy-Framegear Gamma", 3, "monster", "dugcross_spec");
		Card called = card("Called by the Grave", 1, "s/t");
		Card arti_scythe = card("Artifact Scythe", 1, "monster");
		Card eldlich = card("Eldlich the Golden Lord", 2, "monster");
		Card tornado = card("Tornado Dragon", 0);
		Card dagda = card("Artifact Dagda", 0, "link 2");
		Card dugares = card("Dugares the Timeless", 0);
		Card whale = card("Frightfur Whale", 0, "fusion");
		Card tiger = card("Frightfur Tiger", 0, "fusion");
		Card shark = card("Bahamut Shark", 0);
		Card toad = card("Toadally Awesome", 0);
		Card cross = card("Cross Sheep", 0, "link 2");
		Card apo3 = card("Apollousa 3", 0, "apo");
		Card apo4 = card("Apollousa 4", 0, "apo");
		//Card desires = card("Desires",3);
		
		locations("Deck", "Hand", "Monster Zone", "S/T Zone", "GY", "Banish", "Vendor Hit", "Fusion Processing", "FD Banish");
		hand(5);

		
		Action normal_summon = action("normal summon").hopt().open().poss(move("ns", 1, 2));
		
		Action dog_search = action("Search off dog").hopt().poss(move("fluffal", 0,1).exclude(dog)).poss(move(sabres, 0,1));
		MT.add(dog, 1, 2, dog_search);
		
		Action vendor_search = action("Search off vendor").poss(move("fluffal", 0,1)).poss(move(sabres, 0,1));
		MT.add(vendor, list(0,1,3,6), 4, vendor_search);
		
		Action bear_eff = action("Bear set vendor").hopt().open().poss(move(bear, 1, 4), move(vendor, 0, 3));
		
		Action penguin_special = action("Special off penguin").hopt().open().off().poss(cond("peng", 2), (move("fluffal", 1, 2)).exclude(penguin).exclude(penguin3));
		
		Action penguin_special_turnon = action("Turn on penguin's special summon").turnon(penguin_special);
		MT.add("peng", list(0,1,4), 2, penguin_special_turnon);
		
		Action penguin_draw = action("Draw 2 for penguin").hopt().draw(1,2);
		MT.add(penguin, 7, 4, penguin_draw);
		
		Action discard = action("Discard").poss(move("card", 1, 4));
		penguin_draw.trigger(discard);
		
		Action chain_search = action("Search off chain").hopt().poss(move("frightfur", 0, 1));
		MT.add(chain, list(1,2,6,7), 4, chain_search);
		
		Action special_sabres = action("Sabres special summon self from GY").open().hopt().poss(move(sabres, 4, 2), move("card", 1, 0));

		Action vendor_sabres_combo = action("Sabres vendor combo").hopt().open().off().poss(move(sabres, 4, 2), move("fluffal", 1, 2), move("card", 1, 4), cond(vendor,3));
		special_sabres.turnoff(vendor_sabres_combo);
		vendor_sabres_combo.turnoff(special_sabres);
		
		Action fusion_processing = new Action("Fusion processing").move_all(7, 4);

		Action poly_fusion = new Action("Polymerization Fusion Summon").open().trigger(fusion_processing);
		poly_fusion.poss(move(poly, 1, 4),move("edge", list(1,2), 7),move("fluffal", list(1,2), 7), move(whale, -1, 2));
		poly_fusion.poss(move(poly, 1, 4),move(sabres, list(1,2), 7),move("fluffal", list(1,2), 7), move(tiger, -1, 2));
		
		Action frightfur_fusion = action("Frightfur Fusion Effect").open().hopt();
		frightfur_fusion.poss(move(frightfur_fus, 1, 4),move("edge", list(2,4), 5),move("fluffal", list(2,4), 5), move(whale, -1, 2) );
		frightfur_fusion.poss(move(frightfur_fus, 1, 4),move(sabres, list(2,4), 5),move("fluffal", list(2,4), 5), move(tiger, -1, 2) );
		
		Action pop_vendor = action("Pop Vendor").poss(move(vendor, list(1,3), 4));
		MT.add(tiger, -1, 2, pop_vendor);
		
		Action send_repair = action("Whale send repair").hopt().poss(move(repair, 0, 4));
		MT.add(whale, -1, 2, send_repair);
		
		Action summon_shark = action("Make Bahamut Shark").hopt().open().poss(move(2, "lv4water", 2, 4), move(shark, -1, 2));
				
		Action summon_toad = action("Summon toad").poss(move(toad,-1,2));
		summon_shark.trigger(summon_toad);
		
		Action summon_cross = action("Summon cross-sheep").open().hopt().poss(move(2, "card", 2, 4), move(cross,-1,2));
		
		Action cross_special = action("Cross Sheep eff to special").hopt().poss(cond(cross, 2), move("ns", 4, 2)).poss(cond(cross, 2), move("dugcross_spec", 4, 2));
		MT.add("fusion", -1, 2, cross_special);
		
		Action dolphin_eff = action("Dolphin eff").open().hopt();
		dolphin_eff.poss(cond(dolphin, 2), move(wings, 0,4), move(vendor, 4, 3)).poss(cond(dolphin, 2), move(sabres, 0,4), move(vendor, 4, 3));
		
		Action octo_eff = action("Octo eff to add back").hopt().poss(move("fluffal", 4, 1)).poss(move("edge", 4, 1));
		MT.add(octo, list(0,1,4,5), 2, octo_eff);
		
		Action sheep_summon = action("Special sheep").open().poss(move(sheep,1,2), cond("fluffal",2).exclude(sheep));
		
		Action sheep_return = action("Sheep bounce eff").hopt().open().poss(move("edge", 4, 2), cond(sheep, 2), move("fluffal", 2, 1).exclude(sheep));
		
		Action wings_eff = action("Wings eff").open().hopt().draw(1,2).poss(cond(2, "fluffal", 4), move(wings, 4,5), move("fluffal",4,5), move(vendor,3,4));
		
		Action vendor_pitch = action("Vendor pitch").hopt().open().off().poss(cond(vendor,3), move("card",1,4));
		Action vendor_hit_processing = action("Vendor hit processing");
		Action vendor_special = action("Vendor hit! Special Summon");
	
		vendor_pitch.turnoff(vendor_sabres_combo);
		vendor_pitch.off();
		vendor_pitch.draw(6, 1);
		vendor_pitch.trigger(vendor_hit_processing);
		
		vendor_hit_processing.poss(vendor_special,move("fluffal", 6, 1));
		vendor_hit_processing.poss(move("card", 6, 4));	
		
		vendor_special.poss(move("monster", 1, 2));
		
		Action activate_vendor = action("Play vendor").open().poss(move(vendor, 1, 3));
		activate_vendor.turnon(vendor_pitch).turnon(vendor_sabres_combo);
		bear_eff.turnon(vendor_pitch).turnon(vendor_sabres_combo);
		dolphin_eff.turnon(vendor_pitch).turnon(vendor_sabres_combo);
		
		Action goods_eff = action("goods eff").open().hopt().poss(move(goods,1,4), move("goods_target",0,4));
		
		Action gardens_eff = action("gardens add").open().hopt().poss(move(gardens,1,3), move(penguin,0,1));
		
		Action repair_revive = action("Repair eff to revive").open().hopt();
		repair_revive.poss(move(repair, 1, 4), move("fusion",4,-1), move("fluffal",4,2)).poss(move(repair, 1, 4), move("fusion",4,-1), move("edge",4,2));
		
		Action repair_special = action("Repair special from hand").open().hopt();
		repair_special.poss(move(repair,4,5), move("fluffal",1,2)).poss(move(repair,4,5), move("edge",1,2));
		repair_special.turnoff(repair_revive);
		repair_revive.turnoff(repair_special);
		
		Action patchwork_eff = action("Patchwork search").hopt().open().poss(move(patchwork,1,4), move(poly,0,1), move("edge",0,1));
		
		Action garden_pitch = action("Garden discard and drop level").open().hopt();
		garden_pitch.poss(cond(gardens, 3), move(penguin, 1,-1), move(penguin3, -1, 1), move("good_discard",1,4));
		garden_pitch.poss(cond(gardens, 3), move(penguin, 2,-1), move(penguin3, -1, 2), move("good_discard",1,4));		
		Action penguin_swapback = action("Restore penguin to lv. 4").poss(move(penguin, -1, 4), move(penguin3,4,-1));
		MT.add(penguin3, list(1,2,6,7), 4, penguin_swapback);
		
		Action special_dugares = action("Make Dugares").open().hopt().poss(move(2, "lv4",2,4), move("lv4",2,4), move(dugares,-1,2));
		Action dugares_draw = action("Draw off Dugares").open().hopt().poss(cond(dugares,2)).draw(1, 2).trigger(discard);
		Action dugares_special = action("Special off Dugares").open().hopt();
		dugares_special.poss(cond(dugares,2), move("ns",4,2));
		dugares_special.poss(cond(dugares,2), move("dugcross_spec",4,2));
		dugares_special.turnoff(dugares_draw);
		dugares_draw.turnoff(dugares_special);
		
		//Action summon_dagda = action("Summon dagda + activate eff").open().hopt().poss(move(2, "card", 2, 4), move(dagda,-1,2), move(arti_scythe,0,3));
		
		Action special_tornado = action("Make Tornado").open().hopt().poss(move(2, "lv4",2,4), move(tornado,-1,2));
		MT.add(tornado, -1, 2, pop_vendor);
		
		Action eldlich_effect = action("Eff of Eldlich").open().hopt().poss(move("s/t", list(1,3), 4), move(eldlich, 4, 2));
		
		//Action summon_apo = action("Summon Apo").open().hopt().poss(move(4, "card", 2, 4).distinct(), move(apo4,-1,2)).poss(move(2, "card", 2, 4).distinct(), move("link 2", 2, 4), move(apo3, -1, 2));
		
		//action("Activate Desires").open().hopt().poss(move(desires, 1, 4)).draw(8, 10).draw(1,2);
		
		Gov.poss(cond(toad,2));
		//Gov.poss(cond(arti_scythe, list(1,3)), cond(edge_scythe,1), cond("fluffal", list(1,2)));
		//Gov.poss(cond(arti_scythe, list(1,3)), cond(tornado, 2));*/
		//Gov.poss(cond(arti_scythe, list(1,3)), cond(edge_scythe,1), cond("fluffal", list(1,2)), cond(toad, 2), cond("apo", 2));
		//Gov.poss(cond(arti_scythe, list(1,3)), cond(tornado, 2), cond(toad, 2), cond("apo", 2));
		//Gov.poss(cond(arti_scythe, list(1,3)), cond(edge_scythe,1), cond("fluffal", list(1,2)), cond("apo", 2));
		//Gov.poss(cond(arti_scythe, list(1,3)), cond(tornado, 2), cond("apo", 2));
		//Gov.poss(cond(apo4,2));

		
		go("Toad", 100);
	}
	//Ignore below this line
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
	private static ZeroCondition zcond(String category, int... locations)
	{
		return new ZeroCondition(category, locations);
	}
	private static ZeroCondition zcond(Card c, int... locations)
	{
		return new ZeroCondition(c, locations);
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

}

