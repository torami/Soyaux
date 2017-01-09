package com.disp.event;

import java.sql.SQLException;

import javax.jms.JMSException;

import com.disp.activmq.Consumer;
import com.disp.activmq.Producer;
import com.disp.bean.Demande;
import com.disp.bean.OrdreDeMission;
import com.disp.dao.DemandesBean;
import com.disp.dao.OrdreMissionBean;
import com.disp.email.Email;

public class EventManager {
	public static void ProduceEvent (Demande signalement, String typeEvent, String EmailReporter) throws SQLException{
		/* LOG INFO */
		System.out.println("Nouveau Signalement de Type :" +typeEvent);
		System.out.println("Importance: "+signalement.getImportance()+" Commentaire: "+signalement.getComment()+" Adresse: "+signalement.getPlace());
		
		/* route the report to the concerned queue */
		Object ob = signalement;
		Producer.ProduceReport(ob, typeEvent);
		DemandesBean.create(signalement.getImportance(), typeEvent, signalement.getDescription(),signalement.getComment(),signalement.getPlace(),1);

		
		/* Send Email to confirm */
		Email.SendMyEmail("rami.torkhani@gmail.com", "Votre signalement à était pris en charge par nos Services");
	}
	public static void ConsumeEvent (String typeEvent, OrdreDeMission mission, int idSig) throws JMSException, SQLException{
		System.out.println("Consumed Signalement de Type :" +typeEvent);
		OrdreMissionBean.create(idSig, mission.getAgent(),mission.getIntervenant(), mission.getDateIntervention(), mission.getDetailIntervention());
		DemandesBean.updateState(idSig);
		Consumer.consume(typeEvent, mission.getIntervenant());
		Producer.ProduceReport(mission, "Mission"+typeEvent);

		

		

	}
}
