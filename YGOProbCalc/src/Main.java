import java.io.File;
import java.io.FileWriter;

public class Main {
	
	public static void main(String args[])
	{
		 Card brandedfus = card("Branded Fusion", 2, "branded s/t");
		 Card albaz = card("albaz", 1,  "monster");
		 Card brandblade = card("Branded Blade", 1, "branded s/t");
		 Card albion = card("Albion the Shrouded", 1, "monster");
		 Card merc = card("TB Mercourier", 2, "monster", "ns", "tri-type");
		 Card rescue = card("Rescue Cat", 3, "tri-type", "monster", "ns");
		 Card frak = card("TB Fraktall", 3, "ns", "tb", "tri-type", "monster", "main tb");
		 Card kitt = card("TB Kitt", 3, "ns", "tb", "tri-type", "monster", "beast", "main tb", "cat_summon");
		 Card dead_kitt = card("Dead Kitt", 0, "ns", "tb", "tri-type", "monster", "beast", "main tb");
		 Card nerv = card("TB Nervall", 3, "ns","tb", "tri-type", "monster","main tb");
		 Card keras = card("TB Keras", 3, "ns", "tb", "tri-type", "monster", "main tb", "cat_summon");
		 Card dead_keras = card("Dead Keras", 0, "ns", "tb", "tri-type", "monster", "main tb");
		 Card revolt = card("TB Revolt", 1);
		 Card tenki = card("Tenki", 1);
		 Card foolish = card("Foolish", 1);
		 //Card crow = card("D.D. Crow", 1, "monster", "tri-type"); test
		Card blank = card("blank",0);
		complete(100);
		 
		 Card almiraj = card("Almiraj", 0, "extra").extra(1);
		 Card ferrijit = card("Ferrijit", 0, "tb", "tri-type", "tb link-2", "ferrijit", "extra", "Left-Down", "Left").extra(3);
		 Card brumm = card("Bearbrumm", 0, "tb", "tri-type", "tb link-2", "brumm", "extra", "Right-Down", "Left").extra(1);
		 //Card rugal = card("Rugal", 0, "tb", "tri-type", "tb link-3", "rugal", "good_with_rev", "extra");
		 Card omen =  card("Shuraig", 0, "tb", "tri-type", "tb link-4", "omen", "extra", "Left-Down", "Right-Down", "Left", "Right").extra(1);
		 Card fake_ferrijit = card("Imp Ferrijit", 0, "tb", "fake tb", "tri-type", "tb link-2", "ferrijit", "extra", "Left", "Left-Down");
		 Card fake_brumm = card("Imp Bearbrumm", 0, "tb", "fake tb", "tri-type", "tb link-2", "brumm", "extra", "Left", "Right-Down");
		 //Card fake_rugal = card("Imp Rugal", 0, "tb", "fake tb", "tri-type", "tb link-3", "rugal", "good_with_rev", "extra");
		 Card fake_omen =  card("Imp Shuraig", 0,  "tb","fake tb", "tri-type", "tb link-4", "omen", "extra", "Left-Down", "Right-Down", "Left", "Right");
		 Card verte = card("Verte", 0, "extra", "Left-Down", "Right-Down").extra(1);
		 Card apo2 = card("Apollousa-2", 0 , "apo", "extra","Left-Down", "Right-Down", "Down");
		 Card apo3 = card("Apollousa-3", 0 , "apo", "extra", "Left-Down", "Right-Down", "Down");
		 Card apo4 = card("Apollousa-4",0, "apo", "extra", "Left-Down", "Right-Down", "Down");
		 Card mirror = card("Mirrorjade", 0).extra(1);
		 Card albionBrand = card("Albion the Branded", 0, "extra", "albext");
		 Card DDL = card("DDL", 0, "extra", "tri-type", "fake tb", "Left-Down", "Right-Down").extra(1);
		 //Card brigrand = card("Brigrand", 0, "extra", "albext");
		 
		 locations("Deck", "Hand", "Monster Zone", "S/T Zone", "GY", "Banish", "EMZ", "MZ1","MZ2", "MZ3", "MZ4", "MZ5", "ED", "Cat Proc");
		 hand(0);
		 
		 set_extra(12);
		 
		 action("set hand").guarantee_poss(move(frak,0,1),move(keras,0,1), move(3,blank,-1,1)).open().hopt();
		 
		 Action merceff=action("Merc eff").poss(move(albion,0,1).exclude(merc)).poss().first();
		 MT.add(merc, list(0,1,2,4), 5, merceff);
		// Action kitt_eff = action("Kitt send").hopt().poss(move(nerv,0,4)).poss(move(merc,0,4));
		 Action kitt_eff = action("Kitt send").hopt().poss(move(nerv,0,4));//REMOVE
		 //Action nerv_eff = action("Nerv add").hopt().poss(move("tb",0,1).exclude(nerv));
		 Action nerv_eff = action("Nerv add").hopt().poss(move(merc,0,1));//delete later
		 MT.add(kitt, list(0,1,2,-1), 4, kitt_eff);
		 MT.add(nerv, list(0,1,2,-1), 4, nerv_eff);
		 Action put_back = action("Put back 1").poss(move("card",1,0));
		 Action ferrijit_draw = action("Ferri eff to draw").hopt().draw(1,1);
		 ferrijit_draw.trigger(put_back);
		 MT.add("ferrijit", list(6,7,8,9,10,11), 4, ferrijit_draw);
		 //Action omen_add = action("Omen eff to add").hopt().poss(cond(4, "tri-type", 5), move("tri-type", 0,1)).poss(cond(1,"card", 5), move(nerv,0,1)).poss().first();
		 Action omen_add = action("Omen eff to add").hopt().poss(cond(1,"tri-type",5),move(nerv, 0,1));//REMOVE
		 MT.add("omen", list(6,7,8,9,10,11), 4, omen_add);
		 Action brumm_add = action("Brumm eff to add").hopt().poss(move(revolt,0,1)).trigger(put_back).poss().first();
		 MT.add("brumm", list(6,7,8,9,10,11), 4, brumm_add);
		// Action turnoff_branfu = action("Shut off branfu").hopt();
		 //MT.add("extra", list(-1,12), 6, turnoff_branfu);
		 
		 Action place_revolt = action("Place revolt").open().hopt().guarantee_poss(move(revolt,1,3));
		 action("Tenki eff").open().hopt().guarantee_poss(move(tenki,1,3), move(frak,0,1));
		 action("Shrouded eff").open().hopt().guarantee_poss(move(albion,1,0), move(brandblade, 0, 4)).draw(1,1);
		 action("Blade eff").open().hopt().guarantee_poss(move(brandblade,4,5), move(merc,5,1));
		 Action frak_eff = action("Frak eff").open().hopt().guarantee_poss(move(frak,1,4), move(kitt,0,4));//REMOVE
		 Action verte_eff = action("Eff Verte").open().hopt().poss(move(brandedfus,0,4),move(albaz, list(0,1),4), move(mirror,-1,2), move(verte,list(6,7,8,9,10,11),4));
		 verte_eff.poss(move(brandedfus,0,4),move(albaz, list(0,1),4), move(brumm,list(6,7,8,9,10,11),4), move(mirror,-1,2),cond(verte,list(6,7,8,9,10,11)));
		 action("Ferri eff to spec").open().hopt().poss(cond("ferrijit",list(6,7,8,9,10,11)), move("tri-type", 1, 2));
		 
		 action("foolish eff").open().hopt().or_poss(or(move(foolish,1,4)),or(move(nerv,0,4), move(kitt,0,4), move(merc,0,4)));
		 
		// Action frak_eff = action("Frak eff").open().hopt().poss(move(frak,1,4), move("tb",0,4).exclude(frak).exclude(keras).exclude(merc));
		 
		 Action kitt_swap = action("Swap real kitt back").poss(move(kitt,-1,4), move(dead_kitt,4,-1));
		 Action keras_swap = action("Swap real keras back").poss(move(keras,-1,4), move(dead_keras,4,-1));
		 MT.add(dead_keras, 2, 4, keras_swap);
		 MT.add(dead_kitt, 2, 4, kitt_swap);
			
		 Action cat_processing = action("Negate stuff off cat");
		 cat_processing.poss(cat_processing,move(kitt,13,-1), move(dead_kitt,-1,2)).poss(cat_processing,move(keras,13,-1), move(dead_keras,-1,2)).poss().first();
		 action("Cat eff").open().hopt().poss(move(rescue,2,4), move(2,"cat_summon", 0, 13)).trigger(cat_processing);
		 
		 Action summon_verte=action("Summon Verte").open();
		 summon_verte.poss(move(2,"tri-type",list(2,6,7,8,9,10,11),4), move(verte,12,6));
		 summon_verte.poss(move(2,"tri-type",list(2,6,7,8,9,10,11),4), cond("Left-Down",6),move(verte,12,9));
		 summon_verte.poss(move(2,"tri-type",list(2,6,7,8,9,10,11),4), cond("Right-Down",6),move(verte,12,11));
		 summon_verte.poss(move(2,"tri-type",list(2,6,7,8,9,10,11),4), cond("Down",6),move(verte,12,10));
		 summon_verte.poss(move(2,"tri-type",list(2,6,7,8,9,10,11),4), cond("Left",11),move(verte,12,10));
		 summon_verte.poss(move(2,"tri-type",list(2,6,7,8,9,10,11),4), cond("Left",10),move(verte,12,9));
		 summon_verte.poss(move(2,"tri-type",list(2,6,7,8,9,10,11),4), cond("Left",9),move(verte,12,8));
		 
		 Action summon_ferr=action("Summon Ferrijit").open();
		 summon_ferr.poss(move(2,"tri-type",list(2,6,7,8,9,10,11),4), move(ferrijit,12,6));
		 summon_ferr.poss(move(2,"tri-type",list(2,6,7,8,9,10,11),4), cond("Left-Down",6),move(ferrijit,12,9));
		 summon_ferr.poss(move(2,"tri-type",list(2,6,7,8,9,10,11),4), cond("Right-Down",6),move(ferrijit,12,11));
		 summon_ferr.poss(move(2,"tri-type",list(2,6,7,8,9,10,11),4), cond("Down",6),move(ferrijit,12,10));
		 summon_ferr.poss(move(2,"tri-type",list(2,6,7,8,9,10,11),4), cond("Left",11),move(ferrijit,12,10));
		 summon_ferr.poss(move(2,"tri-type",list(2,6,7,8,9,10,11),4), cond("Left",10),move(ferrijit,12,9));
		 summon_ferr.poss(move(2,"tri-type",list(2,6,7,8,9,10,11),4), cond("Left",9),move(ferrijit,12,8));
		 
		 
		 Action summon_brumm=action("Summon Brumm").open().hopt();
		 summon_brumm.poss(move(2,"tb",list(2,6,7,8,9,10,11),4), move(brumm,12,6));
		 summon_brumm.poss(move(2,"tb",list(2,6,7,8,9,10,11),4), cond("Left-Down",6),move(verte,12,9));
		 summon_brumm.poss(move(2,"tb",list(2,6,7,8,9,10,11),4), cond("Right-Down",6),move(verte,12,11));
		 summon_brumm.poss(move(2,"tb",list(2,6,7,8,9,10,11),4), cond("Down",6),move(verte,12,10));
		 summon_brumm.poss(move(2,"tb",list(2,6,7,8,9,10,11),4), cond("Left",11),move(verte,12,10));
		 summon_brumm.poss(move(2,"tb",list(2,6,7,8,9,10,11),4), cond("Left",10),move(verte,12,9));
		 summon_brumm.poss(move(2,"tb",list(2,6,7,8,9,10,11),4), cond("Left",9),move(verte,12,8));


		 
		action("Ferri eff to spec").open().hopt().poss(cond("ferrijit",list(6,7,8,9,10,11)), move("tri-type", 1, 2));
		

		 //summon Brumm?
		 
		 action("Keras eff").open().hopt().poss(move(keras,1,2), move("tri-type", 1, 4));
		 
		 action("Normal Summon").open().hopt().poss(move("ns", 1, 2));
		 
		Action fraktall_summon = action("Frak summon link").open().hopt();
		fraktall_summon.poss(cond(frak,2), move(2,"tri-type",4,5), move(ferrijit,12,-1), move(fake_ferrijit, -1, 6));
		fraktall_summon.poss(cond(frak,2), move(2,"tri-type",4,5),cond("Left-Down",6), move(ferrijit,12,-1), move(fake_ferrijit, -1, 9));
		fraktall_summon.poss(cond(frak,2), move(2,"tri-type",4,5), cond("Right-Down",6), move(ferrijit,12,-1), move(fake_ferrijit, -1, 11));
		fraktall_summon.poss(cond(frak,2), move(2,"tri-type",4,5), cond("Down",6), move(ferrijit,12,-1), move(fake_ferrijit, -1, 10));
		fraktall_summon.poss(cond(frak,2), move(2,"tri-type",4,5), cond("Left",9), move(ferrijit,12,-1), move(fake_ferrijit, -1, 8));
		fraktall_summon.poss(cond(frak,2), move(2,"tri-type",4,5), cond("Left",10), move(ferrijit,12,-1), move(fake_ferrijit, -1, 9));
		fraktall_summon.poss(cond(frak,2), move(2,"tri-type",4,5), cond("Left",11), move(ferrijit,12,-1), move(fake_ferrijit, -1, 10));
		
		fraktall_summon.poss(cond(frak,2), move(2,"tri-type",4,5), move(brumm,12,-1), move(fake_brumm, -1, 6));
		fraktall_summon.poss(cond(frak,2), move(2,"tri-type",4,5),cond("Left-Down",6), move(brumm,12,-1), move(fake_brumm, -1, 9));
		fraktall_summon.poss(cond(frak,2), move(2,"tri-type",4,5), cond("Right-Down",6), move(brumm,12,-1), move(fake_brumm, -1, 11));
		fraktall_summon.poss(cond(frak,2), move(2,"tri-type",4,5), cond("Down",6), move(brumm,12,-1), move(fake_brumm, -1, 10));
		fraktall_summon.poss(cond(frak,2), move(2,"tri-type",4,5), cond("Left",9), move(brumm,12,-1), move(fake_brumm, -1, 8));
		fraktall_summon.poss(cond(frak,2), move(2,"tri-type",4,5), cond("Left",10), move(brumm,12,-1), move(fake_brumm, -1, 9));
		fraktall_summon.poss(cond(frak,2), move(2,"tri-type",4,5), cond("Left",11), move(brumm,12,-1), move(fake_brumm, -1, 10));
		
		fraktall_summon.poss(cond(frak,2), move(2,"tri-type",4,5), move(DDL, 12, 6));
		fraktall_summon.poss(cond(frak,2), move(2,"tri-type",4,5),cond("Left-Down",6),  move(DDL, 12, 9));
		fraktall_summon.poss(cond(frak,2), move(2,"tri-type",4,5), cond("Right-Down",6), move(DDL, 12, 11));
		fraktall_summon.poss(cond(frak,2), move(2,"tri-type",4,5), cond("Down",6), move(DDL, 12, 10));
		fraktall_summon.poss(cond(frak,2), move(2,"tri-type",4,5), cond("Left",9), move(DDL, 12, 8));
		fraktall_summon.poss(cond(frak,2), move(2,"tri-type",4,5), cond("Left",10), move(DDL, 12, 9));
		fraktall_summon.poss(cond(frak,2), move(2,"tri-type",4,5), cond("Left",11), move(DDL, 12, 10));
		
		fraktall_summon.poss(cond(frak,2), move(4,"tri-type",4,5), move(omen,12,-1), move(fake_omen, -1, 6));
		fraktall_summon.poss(cond(frak,2), move(4,"tri-type",4,5),cond("Left-Down",6), move(omen,12,-1), move(fake_omen, -1, 9));
		fraktall_summon.poss(cond(frak,2), move(4,"tri-type",4,5), cond("Right-Down",6), move(omen,12,-1), move(fake_omen, -1, 11));
		fraktall_summon.poss(cond(frak,2), move(4,"tri-type",4,5), cond("Down",6), move(omen,12,-1), move(fake_omen, -1, 10));
		fraktall_summon.poss(cond(frak,2), move(4,"tri-type",4,5), cond("Left",9), move(omen,12,-1), move(fake_omen, -1, 8));
		fraktall_summon.poss(cond(frak,2), move(4,"tri-type",4,5), cond("Left",10), move(omen,12,-1), move(fake_omen, -1, 9));
		fraktall_summon.poss(cond(frak,2), move(4,"tri-type",4,5), cond("Left",11), move(omen,12,-1), move(fake_omen, -1, 10));
		
		Action kitt_summon = action("Kitt summon link").open().hopt();
		kitt_summon.poss(cond(kitt,2), move(2,"tri-type",4,5), move(ferrijit,12,-1), move(fake_ferrijit, -1, 6));
		kitt_summon.poss(cond(kitt,2), move(2,"tri-type",4,5),cond("Left-Down",6), move(ferrijit,12,-1), move(fake_ferrijit, -1, 9));
		kitt_summon.poss(cond(kitt,2), move(2,"tri-type",4,5), cond("Right-Down",6), move(ferrijit,12,-1), move(fake_ferrijit, -1, 11));
		kitt_summon.poss(cond(kitt,2), move(2,"tri-type",4,5), cond("Down",6), move(ferrijit,12,-1), move(fake_ferrijit, -1, 10));
		kitt_summon.poss(cond(kitt,2), move(2,"tri-type",4,5), cond("Left",9), move(ferrijit,12,-1), move(fake_ferrijit, -1, 8));
		kitt_summon.poss(cond(kitt,2), move(2,"tri-type",4,5), cond("Left",10), move(ferrijit,12,-1), move(fake_ferrijit, -1, 9));
		kitt_summon.poss(cond(kitt,2), move(2,"tri-type",4,5), cond("Left",11), move(ferrijit,12,-1), move(fake_ferrijit, -1, 10));
		
		kitt_summon.poss(cond(kitt,2), move(2,"tri-type",4,5), move(brumm,12,-1), move(fake_brumm, -1, 6));
		kitt_summon.poss(cond(kitt,2), move(2,"tri-type",4,5),cond("Left-Down",6), move(brumm,12,-1), move(fake_brumm, -1, 9));
		kitt_summon.poss(cond(kitt,2), move(2,"tri-type",4,5), cond("Right-Down",6), move(brumm,12,-1), move(fake_brumm, -1, 11));
		kitt_summon.poss(cond(kitt,2), move(2,"tri-type",4,5), cond("Down",6), move(brumm,12,-1), move(fake_brumm, -1, 10));
		kitt_summon.poss(cond(kitt,2), move(2,"tri-type",4,5), cond("Left",9), move(brumm,12,-1), move(fake_brumm, -1, 8));
		kitt_summon.poss(cond(kitt,2), move(2,"tri-type",4,5), cond("Left",10), move(brumm,12,-1), move(fake_brumm, -1, 9));
		kitt_summon.poss(cond(kitt,2), move(2,"tri-type",4,5), cond("Left",11), move(brumm,12,-1), move(fake_brumm, -1, 10));
		
		kitt_summon.poss(cond(kitt,2), move(2,"tri-type",4,5), move(DDL, 12, 6));
		kitt_summon.poss(cond(kitt,2), move(2,"tri-type",4,5),cond("Left-Down",6),  move(DDL, 12, 9));
		kitt_summon.poss(cond(kitt,2), move(2,"tri-type",4,5), cond("Right-Down",6), move(DDL, 12, 11));
		kitt_summon.poss(cond(kitt,2), move(2,"tri-type",4,5), cond("Down",6), move(DDL, 12, 10));
		kitt_summon.poss(cond(kitt,2), move(2,"tri-type",4,5), cond("Left",9), move(DDL, 12, 8));
		kitt_summon.poss(cond(kitt,2), move(2,"tri-type",4,5), cond("Left",10), move(DDL, 12, 9));
		kitt_summon.poss(cond(kitt,2), move(2,"tri-type",4,5), cond("Left",11), move(DDL, 12, 10));
		
		kitt_summon.poss(cond(kitt,2), move(4,"tri-type",4,5), move(omen,12,-1), move(fake_omen, -1, 6));
		kitt_summon.poss(cond(kitt,2), move(4,"tri-type",4,5),cond("Left-Down",6), move(omen,12,-1), move(fake_omen, -1, 9));
		kitt_summon.poss(cond(kitt,2), move(4,"tri-type",4,5), cond("Right-Down",6), move(omen,12,-1), move(fake_omen, -1, 11));
		kitt_summon.poss(cond(kitt,2), move(4,"tri-type",4,5), cond("Down",6), move(omen,12,-1), move(fake_omen, -1, 10));
		kitt_summon.poss(cond(kitt,2), move(4,"tri-type",4,5), cond("Left",9), move(omen,12,-1), move(fake_omen, -1, 8));
		kitt_summon.poss(cond(kitt,2), move(4,"tri-type",4,5), cond("Left",10), move(omen,12,-1), move(fake_omen, -1, 9));
		kitt_summon.poss(cond(kitt,2), move(4,"tri-type",4,5), cond("Left",11), move(omen,12,-1), move(fake_omen, -1, 10));
		
		Action nerv_summon = action("nerv summon link").open().hopt();
		nerv_summon.poss(cond(nerv,2), move(2,"tri-type",4,5), move(ferrijit,12,-1), move(fake_ferrijit, -1, 6));
		nerv_summon.poss(cond(nerv,2), move(2,"tri-type",4,5),cond("Left-Down",6), move(ferrijit,12,-1), move(fake_ferrijit, -1, 9));
		nerv_summon.poss(cond(nerv,2), move(2,"tri-type",4,5), cond("Right-Down",6), move(ferrijit,12,-1), move(fake_ferrijit, -1, 11));
		nerv_summon.poss(cond(nerv,2), move(2,"tri-type",4,5), cond("Down",6), move(ferrijit,12,-1), move(fake_ferrijit, -1, 10));
		nerv_summon.poss(cond(nerv,2), move(2,"tri-type",4,5), cond("Left",9), move(ferrijit,12,-1), move(fake_ferrijit, -1, 8));
		nerv_summon.poss(cond(nerv,2), move(2,"tri-type",4,5), cond("Left",10), move(ferrijit,12,-1), move(fake_ferrijit, -1, 9));
		nerv_summon.poss(cond(nerv,2), move(2,"tri-type",4,5), cond("Left",11), move(ferrijit,12,-1), move(fake_ferrijit, -1, 10));
		
		nerv_summon.poss(cond(nerv,2), move(2,"tri-type",4,5), move(brumm,12,-1), move(fake_brumm, -1, 6));
		nerv_summon.poss(cond(nerv,2), move(2,"tri-type",4,5),cond("Left-Down",6), move(brumm,12,-1), move(fake_brumm, -1, 9));
		nerv_summon.poss(cond(nerv,2), move(2,"tri-type",4,5), cond("Right-Down",6), move(brumm,12,-1), move(fake_brumm, -1, 11));
		nerv_summon.poss(cond(nerv,2), move(2,"tri-type",4,5), cond("Down",6), move(brumm,12,-1), move(fake_brumm, -1, 10));
		nerv_summon.poss(cond(nerv,2), move(2,"tri-type",4,5), cond("Left",9), move(brumm,12,-1), move(fake_brumm, -1, 8));
		nerv_summon.poss(cond(nerv,2), move(2,"tri-type",4,5), cond("Left",10), move(brumm,12,-1), move(fake_brumm, -1, 9));
		nerv_summon.poss(cond(nerv,2), move(2,"tri-type",4,5), cond("Left",11), move(brumm,12,-1), move(fake_brumm, -1, 10));
		
		nerv_summon.poss(cond(nerv,2), move(2,"tri-type",4,5), move(DDL, 12, 6));
		nerv_summon.poss(cond(nerv,2), move(2,"tri-type",4,5),cond("Left-Down",6),  move(DDL, 12, 9));
		nerv_summon.poss(cond(nerv,2), move(2,"tri-type",4,5), cond("Right-Down",6), move(DDL, 12, 11));
		nerv_summon.poss(cond(nerv,2), move(2,"tri-type",4,5), cond("Down",6), move(DDL, 12, 10));
		nerv_summon.poss(cond(nerv,2), move(2,"tri-type",4,5), cond("Left",9), move(DDL, 12, 8));
		nerv_summon.poss(cond(nerv,2), move(2,"tri-type",4,5), cond("Left",10), move(DDL, 12, 9));
		nerv_summon.poss(cond(nerv,2), move(2,"tri-type",4,5), cond("Left",11), move(DDL, 12, 10));
		
		nerv_summon.poss(cond(nerv,2), move(4,"tri-type",4,5), move(omen,12,-1), move(fake_omen, -1, 6));
		nerv_summon.poss(cond(nerv,2), move(4,"tri-type",4,5),cond("Left-Down",6), move(omen,12,-1), move(fake_omen, -1, 9));
		nerv_summon.poss(cond(nerv,2), move(4,"tri-type",4,5), cond("Right-Down",6), move(omen,12,-1), move(fake_omen, -1, 11));
		nerv_summon.poss(cond(nerv,2), move(4,"tri-type",4,5), cond("Down",6), move(omen,12,-1), move(fake_omen, -1, 10));
		nerv_summon.poss(cond(nerv,2), move(4,"tri-type",4,5), cond("Left",9), move(omen,12,-1), move(fake_omen, -1, 8));
		nerv_summon.poss(cond(nerv,2), move(4,"tri-type",4,5), cond("Left",10), move(omen,12,-1), move(fake_omen, -1, 9));
		nerv_summon.poss(cond(nerv,2), move(4,"tri-type",4,5), cond("Left",11), move(omen,12,-1), move(fake_omen, -1, 10));
		
		Action keras_summon = action("keras summon link").open().hopt();
		/*keras_summon.poss(cond(keras,2), move(2,"tri-type",4,5), move(ferrijit,12,-1), move(fake_ferrijit, -1, 6));
		keras_summon.poss(cond(keras,2), move(2,"tri-type",4,5),cond("Left-Down",6), move(ferrijit,12,-1), move(fake_ferrijit, -1, 9));
		keras_summon.poss(cond(keras,2), move(2,"tri-type",4,5), cond("Right-Down",6), move(ferrijit,12,-1), move(fake_ferrijit, -1, 11));
		keras_summon.poss(cond(keras,2), move(2,"tri-type",4,5), cond("Down",6), move(ferrijit,12,-1), move(fake_ferrijit, -1, 10));
		keras_summon.poss(cond(keras,2), move(2,"tri-type",4,5), cond("Left",9), move(ferrijit,12,-1), move(fake_ferrijit, -1, 8));
		keras_summon.poss(cond(keras,2), move(2,"tri-type",4,5), cond("Left",10), move(ferrijit,12,-1), move(fake_ferrijit, -1, 9));
		keras_summon.poss(cond(keras,2), move(2,"tri-type",4,5), cond("Left",11), move(ferrijit,12,-1), move(fake_ferrijit, -1, 10));
		
		keras_summon.poss(cond(keras,2), move(2,"tri-type",4,5), move(brumm,12,-1), move(fake_brumm, -1, 6));
		keras_summon.poss(cond(keras,2), move(2,"tri-type",4,5),cond("Left-Down",6), move(brumm,12,-1), move(fake_brumm, -1, 9));
		keras_summon.poss(cond(keras,2), move(2,"tri-type",4,5), cond("Right-Down",6), move(brumm,12,-1), move(fake_brumm, -1, 11));
		keras_summon.poss(cond(keras,2), move(2,"tri-type",4,5), cond("Down",6), move(brumm,12,-1), move(fake_brumm, -1, 10));
		keras_summon.poss(cond(keras,2), move(2,"tri-type",4,5), cond("Left",9), move(brumm,12,-1), move(fake_brumm, -1, 8));
		keras_summon.poss(cond(keras,2), move(2,"tri-type",4,5), cond("Left",10), move(brumm,12,-1), move(fake_brumm, -1, 9));
		keras_summon.poss(cond(keras,2), move(2,"tri-type",4,5), cond("Left",11), move(brumm,12,-1), move(fake_brumm, -1, 10));
		
		keras_summon.poss(cond(keras,2), move(2,"tri-type",4,5), move(DDL, 12, 6));
		keras_summon.poss(cond(keras,2), move(2,"tri-type",4,5),cond("Left-Down",6),  move(DDL, 12, 9));
		keras_summon.poss(cond(keras,2), move(2,"tri-type",4,5), cond("Right-Down",6), move(DDL, 12, 11));
		keras_summon.poss(cond(keras,2), move(2,"tri-type",4,5), cond("Down",6), move(DDL, 12, 10));
		keras_summon.poss(cond(keras,2), move(2,"tri-type",4,5), cond("Left",9), move(DDL, 12, 8));
		keras_summon.poss(cond(keras,2), move(2,"tri-type",4,5), cond("Left",10), move(DDL, 12, 9));
		keras_summon.poss(cond(keras,2), move(2,"tri-type",4,5), cond("Left",11), move(DDL, 12, 10));*/
		
		keras_summon.poss(cond(keras,2), move(4,"tri-type",4,5), move(omen,12,-1), move(fake_omen, -1, 6));
		keras_summon.poss(cond(keras,2), move(4,"tri-type",4,5),cond("Left-Down",6), move(omen,12,-1), move(fake_omen, -1, 9));
		keras_summon.poss(cond(keras,2), move(4,"tri-type",4,5), cond("Right-Down",6), move(omen,12,-1), move(fake_omen, -1, 11));
		keras_summon.poss(cond(keras,2), move(4,"tri-type",4,5), cond("Down",6), move(omen,12,-1), move(fake_omen, -1, 10));
		keras_summon.poss(cond(keras,2), move(4,"tri-type",4,5), cond("Left",9), move(omen,12,-1), move(fake_omen, -1, 8));
		keras_summon.poss(cond(keras,2), move(4,"tri-type",4,5), cond("Left",10), move(omen,12,-1), move(fake_omen, -1, 9));
		keras_summon.poss(cond(keras,2), move(4,"tri-type",4,5), cond("Left",11), move(omen,12,-1), move(fake_omen, -1, 10));
		
		//action("Brumm eff to spec").open().hopt().poss(cond("brumm",list(6,7,8,9,10,11)), move(2,"card",1,4), move("main tb",5,2));
		action("Brumm eff to spec").open().hopt().poss(cond("brumm",list(6,7,8,9,10,11)), move(2,"card",1,4), move(kitt,5,2));//REMOVE
		
		brumm_add.turnoff_all().turnon(place_revolt).turnon(put_back);
		verte_eff.turnoff_all().turnon(kitt_eff).turnon(nerv_eff).turnon(brumm_add).turnon(place_revolt);
		
		//action("Summon almiraj").open().hopt().poss(move(kitt,2,4), move(almiraj,-1,4)).poss(move(nerv,2,4), move(almiraj,-1,4));
		//Gov.poss(cond(verte,2));
		//Gov.poss(cond("ferrijit",6));
		//Gov.poss(cond(mirror,2));
		//Gov.poss(cond(mirror,2), cond(merc,1));
		//Gov.poss(cond(mirror,2), cond(revolt,3));
		//Gov.poss(cond(revolt,3), cond(DDL,list(6,7,8,9,10,11)),cond(mirror,2), cond(merc,1),lcond(1,"card",list(2,7,8,9,10,11)),cond(4, "tri-type",list(4,5)).exclude("fake tb"));
		Gov.poss(cond(revolt,3),cond(DDL,list(6,7,8,9,10,11)), cond(mirror,2), cond(merc,1),lcond(2,"card",list(2,7,8,9,10,11)),cond(3, "tri-type",list(4,5)).exclude("fake tb"), cond("tb link-2", list(4,5)).exclude("fake tb"));
		//Gov.poss(cond(revolt,3),cond(DDL,list(6,7,8,9,10,11)), cond(mirror,2), cond(merc,1),cond(3, "tri-type",list(4,5)).exclude("fake tb"), cond("tb link-2", list(4,5)).exclude("fake tb"));
		//Gov.poss(cond(ferrijit,6), cond(brumm,7), cond(merc,1));
		//Gov.timeout(100);
		//Gov.poss(cond("ferrijit",6), cond("ferrijit",9));
		
		go("TriBrandTest2",1);
			
		 
		 
		
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
	    Card albaz = card("albaz", 1,  "monster", "dragon", "dark", "lv4", "alb");
	    Card brandred = card("Branded in Red", 1, "branded s/t");
	    Card brandcond = card("Branded Condemnation", 1, "branded s/t");
	    Card brandspirit = card("Branded in High Spirits", 3, "branded s/t");
	    Card brandblade = card("Branded Blade", 1, "branded s/t");
	    Card sprigkitt = card("Spriggans Kitt", 1, "monster", "ns", "lv4", "alb", "beast", "tri-type", "goodalb");
	    Card albion = card("Albion the Shrouded", 1, "alb", "monster", "dark", "dragon", "goodalb");
	    Card ecclesia = card("Incredible Ecclesia", 1, "alb", "monster", "lv4");//make this a good normal and goodalb
	    Card merc = card("TB Mercourier", 2, "alb", "monster", "lv4", "dark", "tri-type", "goodalb");
	    Card frak = card("TB Fraktall", 3, "ns", "tb", "tri-type", "monster", "main tb");
		Card kitt = card("TB Kitt", 3, "ns", "tb", "tri-type", "monster", "beast", "main tb");
		Card nerv = card("TB Nervall", 3, "ns","tb", "tri-type", "monster","main tb");
		Card keras = card("TB Keras", 3, "ns", "tb", "tri-type", "monster", "beast", "main tb");
		Card revolt = card("TB Revolt", 1);
		Card tenki = card("Tenki", 1);
		Card foolish = card("Foolish", 1);
	    Card crow = card("D.D. Crow", 1, "dark", "monster", "tri-type");
	    Card allure = card("Allure", 3);
	    
		Card almiraj = card("Almiraj", 0, "extra");
		Card ferrijit = card("Ferrijit", 0, "tb", "tri-type", "tb link-2", "ferrijit", "extra");
		Card brumm = card("Bearbrumm", 0, "tb", "tri-type", "tb link-2", "brumm", "extra");
		//Card rugal = card("Rugal", 0, "tb", "tri-type", "tb link-3", "rugal", "good_with_rev", "extra");
		Card omen =  card("Shuraig", 0, "tb", "tri-type", "tb link-4", "omen", "extra");
		Card fake_ferrijit = card("Imp Ferrijit", 0, "fake tb", "tri-type", "tb link-2", "ferrijit", "extra");
		Card fake_brumm = card("Imp Bearbrumm", 0, "fake tb", "tri-type", "tb link-2", "brumm", "extra");
		//Card fake_rugal = card("Imp Rugal", 0, "fake tb", "tri-type", "tb link-3", "rugal", "good_with_rev", "extra");
		Card fake_omen =  card("Imp Shuraig", 0, "fake tb", "tri-type", "tb link-4", "omen", "extra");
		Card verte = card("Verte", 0, "extra");
		Card apo2 = card("Apollousa-2", 0 , "apo", "good_with_rev", "extra");
		Card apo3 = card("Apollousa-3", 0 , "apo", "good_with_rev", "extra");
		Card apo4 = card("Apollousa-4",0, "apo", "good_with_rev", "extra");
		Card raff = card("Rafflesia", 0, "extra");
		Card mirror = card("Mirrorjade", 0);
		Card albionBrand = card("Albion the Branded", 0, "extra", "albext");
		Card brigrand = card("Brigrand", 0, "extra", "albext");
		Card reaper = card("Trigger mill all", 0);
		
	    
	    locations("Deck", "Hand", "Monster Zone", "S/T Zone", "GY", "Banish");
		hand(5);
		
		Action peg_eff = action("Pegasus eff").poss(move(zenith, list(0,1,4),3));
		MT.add(peg, list(1,4), 2, peg_eff);
	    Action merceff=action("Merc eff").poss(move("alb",0,1).exclude(merc));
	    MT.add(merc, list(0,1,2,4), 5, merceff);
		Action kitt_eff = action("Kitt send").hopt().poss(move(nerv,0,4)).poss(move(merc,0,4));
		Action nerv_eff = action("Nerv add").hopt().poss(move("tb",0,1).exclude(nerv));
		MT.add(kitt, list(0,1,2), 4, kitt_eff);
		MT.add(nerv, list(0,1,2), 4, nerv_eff);
		Action put_back = action("Put back 1").poss(move("card",1,0));
	    Action sprig_eff = action("Eff Spriggans Kitt").hopt().poss(move("branded s/t",0,1)).trigger(put_back);
	    MT.add(sprigkitt, 1, 2, sprig_eff);
		Action ferrijit_draw = action("Ferri eff to draw").hopt().draw(1,1);
		ferrijit_draw.trigger(put_back);
		MT.add("ferrijit", 2, 4, ferrijit_draw);
		Action omen_add = action("Omen eff to add").hopt().poss(cond(4, "tri-type", 5), move("tri-type", 0,1)).poss(cond(1,"card", 5), move(nerv,0,1));
		MT.add("omen", 2, 4, omen_add);
		Action brumm_add = action("Brumm eff to add").hopt().poss(move(revolt,0,1)).trigger(put_back);
		MT.add("brumm", 2, 4, brumm_add);
		Action allure_downside = action("Allure payment").poss(move("dark",1,5)).poss(move(reaper,-1,4));
		Action mill_all = action("Mill all").move_all(1, 4);
		MT.add(reaper, -1, 4, mill_all);	
		Action turnoff_branfu = action("Shut off branfu");
		MT.add("extra", -1, 2, turnoff_branfu);
		action("zenith eff").open().hopt().guarantee_poss(move(zenith, 3, 5), move(peg, 0, 2), move(rdd, 0, 1));
		action("Bond eff").open().hopt().guarantee_poss(move(bond,1,4), move(zenith,0,3), move(peg,0,1));
		action("Bridge eff").open().hopt().guarantee_poss(move(bridge,1,4), move(bond,0,1));//change to crystal s/t
		action("Tenki eff").open().hopt().guarantee_poss(move(tenki,1,3), move(frak,0,1));
		action("Shrouded eff").open().hopt().guarantee_poss(move(albion,1,0), move(brandblade, 0, 4)).draw(1,1);//allow to mill albaz
		Action place_revolt = action("Place revolt").open().hopt().guarantee_poss(move(revolt,1,3));
		action("Blade eff").open().hopt().guarantee_poss(move(brandblade,4,5), move(merc,5,1));
		Action verte_eff = action("Eff Verte").open().hopt().poss(move(brandedfus,0,4),move(albaz, list(0,1),4), move(mirror,-1,2), move(verte,2,4));
		verte_eff.poss(move(brandedfus,0,4),move(albaz, list(0,1),4), move(brumm,2,4), move(mirror,-1,2),cond(verte,2));
		action("Ferri eff to spec").open().hopt().poss(cond("ferrijit",2), move("tri-type", 1, 2));
		
		Action fraktall_summon = action("Frak summon link").open().hopt();
		fraktall_summon.poss(cond(frak,2), move(2,"tri-type",4,5), move(fake_ferrijit, -1, 2));
		fraktall_summon.poss(cond(frak,2), move(2,"tri-type",4,5), move(fake_brumm, -1, 2));
		//fraktall_summon.poss(cond(frak,2), move(3,"tri-type",4,5), move(fake_rugal, -1, 2));
		fraktall_summon.poss(cond(frak,2), move(4,"tri-type",4,5), move(fake_omen, -1, 2));
		Action kitt_summon = action("Kitt summon link").open().hopt();
		kitt_summon.poss(cond(kitt,2), move(2,"tri-type",4,5), move(fake_ferrijit, -1, 2));
		kitt_summon.poss(cond(kitt,2), move(2,"tri-type",4,5), move(fake_brumm, -1, 2));
		//kitt_summon.poss(cond(kitt,2), move(3,"tri-type",4,5), move(fake_rugal, -1, 2));
		kitt_summon.poss(cond(kitt,2), move(4,"tri-type",4,5), move(fake_omen, -1, 2));
		Action nerv_summon = action("Nerv summon link").open().hopt();
		nerv_summon.poss(cond(nerv,2), move(2,"tri-type",4,5), move(fake_ferrijit, -1, 2));
		nerv_summon.poss(cond(nerv,2), move(2,"tri-type",4,5), move(fake_brumm, -1, 2));
		//nerv_summon.poss(cond(nerv,2), move(3,"tri-type",4,5), move(fake_rugal, -1, 2));
		nerv_summon.poss(cond(nerv,2), move(4,"tri-type",4,5), move(fake_omen, -1, 2));
		Action keras_summon = action("Keras summon link").open().hopt();
		keras_summon.poss(cond(keras,2), move(2,"tri-type",4,5), move(fake_ferrijit, -1, 2));
		keras_summon.poss(cond(keras,2), move(2,"tri-type",4,5), move(fake_brumm, -1, 2));
		//keras_summon.poss(cond(keras,2), move(3,"tri-type",4,5), move(fake_rugal, -1, 2));
		keras_summon.poss(cond(keras,2), move(4,"tri-type",4,5), move(fake_omen, -1, 2));
		
		Action frak_eff = action("Frak eff").open().hopt().poss(move(frak,1,4), move("tb",0,4).exclude(frak).exclude(nerv).exclude(merc));
		
		action("Summon Brumm").open().hopt().poss(move(2,"tb",2,4), move(brumm,-1,2));
		action("Summon Verte").open().hopt().poss(move(2,"tri-type",2,4), move(verte,-1,2));
		action("Summon Ferrijit").open().poss(move(2,"tri-type",2,4), move(ferrijit,-1,2));
		action("Keras eff").open().hopt().poss(move(keras,1,2), move("tri-type", 1, 4));
		action("Allure eff").open().poss(move(allure,1,4)).draw(1,2).trigger(allure_downside);
	    Action hardact_Branfu = action("Active BranFu").open().hopt().poss(move(brandedfus,1,4), move(albaz,list(0,1),5), move(albionBrand,-1,5), move(mirror,-1,2));
	    turnoff_branfu.turnoff(hardact_Branfu);
	    action("High Spirits eff").open().hopt().poss(move("beast",1,4), move(brigrand,-1,4), move("goodalb",0,1)).poss(move("dragon",1,4), move(albionBrand,-1,4), move("goodalb",0,1));  
	    action("Spec Spriggans Kitt").hopt().open().poss(cond("albext",4), move(sprigkitt,1,2));  
	    action("Normal Summon").open().hopt().poss(move("ns", 1, 2));
	    action("Summon almiraj").open().hopt().poss(move(kitt,2,4), move(almiraj,-1,2)).poss(move(nerv,2,4), move(almiraj,-1,2));
	    action("BiR eff").open().hopt().poss(move(brandred, 1, 4),move(albaz,4,5), move("extra",2,5), move(mirror,-1,2));
		//Action summon_rugal = action("Summon Rugal").open().poss(move(3,"tri-type",2,4), move(rugal,-1,2));
		//summon_rugal.poss(cond(2, "tri-type", 2), move("tb link-2", 2,4), move("tri-type", 2,4));
		//Action summon_omen = action("Summon Omen").open().poss(move(4,"tri-type",2,4), move(omen,-1,2));
		//summon_omen.poss(cond(3, "tri-type", 2), move("tb link-2", 2,4), move(2, "tri-type", 2,4));
		//summon_omen.poss(cond(2, "tri-type", 2), move("tb link-3", 2,4), move("tri-type", 2,4));		
		//Action summon_apo = action("Summon apo4").open().hopt().poss(move(4, "tri-type", 2,4).distinct(), move(apo4,-1,2));
		//summon_apo.poss(cond(3,"tri-type",2),move(1,"tb link-2", 2,4),move(2, "tri-type", 2,4).distinct(), move(apo3,-1,2));
		//summon_apo.poss(move(2,"tb link-2", 2,4).distinct(), move(apo2,-1,2)).poss(cond(2,"tri-type",2),move("tb link-3", 2,4),move( "tri-type", 2,4).distinct(), move(apo2,-1,2));		
		//Action brumm_eff = action("Brumm eff to spec").open().hopt().poss(cond(brumm,2), move(2,"card",1,4), move("main tb",5,2));
	    hardact_Branfu.turnoff_all();
		brumm_add.turnoff_all().turnon(place_revolt).turnon(put_back);
		verte_eff.turnoff_all().turnon(kitt_eff).turnon(nerv_eff).turnon(brumm_add).turnon(place_revolt);	
		//Gov.poss(cond(mirror,2), cond(merc,1), cond(revolt,3), cond(4, "tri-type", list(4,5)).exclude("fake tb"));
		//Gov.poss(cond(mirror,2), cond(merc,1), cond(revolt,3), cond(3, "tri-type", list(4,5)).exclude("fake tb"), cond(1,"tb link-2", list(4,5)).exclude("fake tb"));
		Gov.poss(cond(mirror,2), cond(revolt,3), cond(3, "tri-type", list(4,5)).exclude("fake tb"), cond(1,"tb link-2", list(4,5)).exclude("fake tb"));
		Gov.poss(cond(mirror,2), cond(merc,1));
		Gov.terminate(cond(albaz,list(4,5)), zcond(mirror,2));
		Gov.timeout(5);
		
		go("CBTriAlbtest5",100);
	    
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
		
		Card whale = card("FF Whale",0).extra(2);
		Card VFD = card("VFD", 0).extra(1);
		
		locations("Deck", "Hand", "MZ", "STZ", "GY", "Banish", "fdBanish", "Extra Deck", "Fusion Processing");
		hand(5);
		set_extra(7);
		
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
		action("Desires eff").poss(move(desires,1,4)).draw(6,10).draw(1,2).open().hopt();
		Action spec_souls = action("Special Souls").poss(move(souls,1,2), move(ioc,0,4)).open().hopt();
		Action souls_1=action("souls for 1").poss(cond(souls,2),move("s/t", list(1,3),4)).draw(1,1).open().hopt();
		Action souls_2=action("souls for 2").poss(cond(souls,2),move(2,"s/t", list(1,3),4)).draw(1,2).open().hopt();
		souls_1.turnoff(souls_2);
		souls_2.turnoff(souls_1);
		Action IOCSearchSpec = action("IOC search and special").poss(move(ioc,1,4),move(souls,0,1)).open().hopt();
		IOCSearchSpec.turnoff(spec_souls);
		spec_souls.turnoff(IOCSearchSpec);
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
	private static MoveCondition costMove(String category, int in, int out)
	{
		return new MoveCondition(category, in, out).cost();
	}
	private static MoveCondition costMove(String category, int[] in, int out)
	{
		return new MoveCondition(category, in, out).cost();
	}
	private static MoveCondition costMove(Card card, int in, int out)
	{
		return new MoveCondition(card, in, out).cost();
	}
	private static MoveCondition costMove(Card card, int[] in, int out)
	{
		return new MoveCondition(card, in, out).cost();
	}
	private static MoveCondition costMove(int num, String category, int in, int out)
	{
		return new MoveCondition(num, category, in, out).cost();
	}
	private static MoveCondition costMove(int num, String category, int[] in, int out)
	{
		return new MoveCondition(num, category, in, out).cost();
	}
	private static MoveCondition costMove(int num, Card card, int in, int out)
	{
		return new MoveCondition(num, card, in, out).cost();
	}
	private static MoveCondition costMove(int num, Card card, int[] in, int out)
	{
		return new MoveCondition(num, card, in, out).cost();
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

