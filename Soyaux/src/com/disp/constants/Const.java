package com.disp.constants;

public class Const {
	public  final String EVENT_PROPRETE = "button1";
	public  final String EVENT_Eclairage = "button2";
	public  final String EVENT_Sécurité = "button3";
	public  final String EVENT_EspacesVerts = "button4";
	public  final String EVENT_Transport = "button5";
	
	public  final String CONSULTER_D = "button1";
	public  final String CONSULTER_O = "button2";
	public  final String CREER_O = "button3";
	public  final String DECONNEXION = "button4";
	/**
	 * Methode qui retourne le type d'evenement a partir de la jsp
	 * @param event_eclairage
	 * @param event_proprete
	 * @param event_ev
	 * @param event_sec
	 * @param event_trans
	 * @return
	 */
	public String EventType( final String event_eclairage, final String event_proprete,final String event_ev,final String event_sec, final String event_trans) {
		
		if ( event_eclairage != null){
			return "Eclairage";
		}
		if ( event_proprete != null){
			return "Propreté";
		}
		if (event_ev != null){
			return "Espaces Vert";
		}
		if ( event_sec != null){
			return "Securité";
		}
		if (event_trans != null){
			return "Transport";
		}
		return "";
	}

}
