package com.disp.event;

import com.disp.activmq.Producer;
import com.disp.bean.Demande;
import com.disp.email.Email;

public class EventManager {
	public static void ProduceEvent (Demande signalement, String typeEvent, String EmailReporter){
		/* LOG INFO */
		System.out.println("Nouveau Signlement de Type :" +typeEvent);
		System.out.println("Importance: "+signalement.getImportance()+" Commentaire: "+signalement.getComment()+" Adresse: "+signalement.getPlace());
		
		/* route the report to the concerned queue */
		Object ob = signalement;
		Producer.Produce(ob, typeEvent);
		
		/* Send Email to confirm */
		Email.SendMyEmail("rami.torkhani@gmail.com", ob.getClass()+" à était pris en charge par nos Services");
	}
}
