package com.autoinput.objects;


public class Continent extends EditorObject {
	
	private Long id;

	private String oldName;
	private String threeLetterName;
	private String continentalityName;
	private String federationName;
	private String shortFederationName;
	private Long regionalStrength;

	public String getThreeLetterName() {
		return threeLetterName;
	}
	public void setThreeLetterName(String threeLetterName) {
		this.threeLetterName = threeLetterName;
	}
	public String getContinentalityName() {
		return continentalityName;
	}
	public void setContinentalityName(String continentalityName) {
		this.continentalityName = continentalityName;
	}
	public String getFederationName() {
		return federationName;
	}
	public void setFederationName(String federationName) {
		this.federationName = federationName;
	}
	public String getShortFederationName() {
		return shortFederationName;
	}
	public void setShortFederationName(String shortFederationName) {
		this.shortFederationName = shortFederationName;
	}
	public Long getRegionalStrength() {
		return regionalStrength;
	}
	public void setRegionalStrength(Long regionalStrength) {
		this.regionalStrength = regionalStrength;
	}
	public String getOldName() {
		return oldName;
	}
	public void setOldName(String oldName) {
		this.oldName = oldName;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
}
