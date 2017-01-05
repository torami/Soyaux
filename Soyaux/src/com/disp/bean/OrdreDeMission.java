package com.disp.bean;

import java.io.Serializable;

public class OrdreDeMission implements Serializable  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer traitId;
	private String sig_sig_id;
	private String agent;
	private String intervenant;
	private String dateIntervention;
	private String detailIntervention;
	
	public Integer getTraitId() {
		return traitId;
	}
	public void setTraitId(Integer traitId) {
		this.traitId = traitId;
	}
	public String getSig_sig_id() {
		return sig_sig_id;
	}
	public void setSig_sig_id(String sig_sig_id) {
		this.sig_sig_id = sig_sig_id;
	}
	public String getAgent() {
		return agent;
	}
	public void setAgent(String agent) {
		this.agent = agent;
	}
	public String getIntervenant() {
		return intervenant;
	}
	public void setIntervenant(String intervenant) {
		this.intervenant = intervenant;
	}
	public String getDateIntervention() {
		return dateIntervention;
	}
	public void setDateIntervention(String dateIntervention) {
		this.dateIntervention = dateIntervention;
	}
	public String getDetailIntervention() {
		return detailIntervention;
	}
	public void setDetailIntervention(String detailIntervention) {
		this.detailIntervention = detailIntervention;
	}

}
