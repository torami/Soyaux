package com.disp.event;

import com.disp.activmq.App;
import com.disp.bean.Demande;

public class EventManager {
	public static void ProduceEvent (Demande signalement, String typeEvent){
		Object ob = null;
		ob = signalement;
		App.Producer(ob, typeEvent);
		System.out.println("Nouveau Signlement de Type :" +typeEvent);
		System.out.println("Importance: "+signalement.getImportance()+" Commentaire: "+signalement.getComment()+" Adresse: "+signalement.getPlace());

	}
}
