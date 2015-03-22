package com.autoinput.hibernate.objects;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CONTINENT")
public class Continent extends EditorObject {
	
	@Id
    @GeneratedValue
	private Long id;
	
	@Column(name="NAME_ID")
	private String nameId;

    @Column(name="OLD_NAME")
	private String oldName;

    @Column(name="THREE_LETTER_NAME")
	private String threeLetterName;

    @Column(name="CONTINENTALITY_NAME")
	private String continentalityName;

    @Column(name="FED_NAME")
	private String federationName;

    @Column(name="SHORT_FED_NAME")
	private String shortFederationName;

    @Column(name="REGION_STRENGTH")
	private Long regionalStrength;
    
    @Column(name="DATE_ADDED")
    private Date dateAdded;
    

	public Continent(String oldName, String threeLetterName,
			String continentalityName, String federationName,
			String shortFederationName, Long regionalStrength,
			String nameId, Date dateAdded) {
		this.oldName = oldName;
		this.threeLetterName = threeLetterName;
		this.continentalityName = continentalityName;
		this.federationName = federationName;
		this.shortFederationName = shortFederationName;
		this.regionalStrength = regionalStrength;
		this.nameId = threeLetterName + "_" + super.getName();
		this.dateAdded = dateAdded;
	}
	public Continent() {
		// TODO Auto-generated constructor stub
	}
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
	public String getNameId() {
		return nameId;
	}
	public void setNameId(String nameId) {
		this.nameId = nameId;
	}
	public Date getDateAdded() {
		return dateAdded;
	}
	public void setDateAdded(Date dateAdded) {
		this.dateAdded = dateAdded;
	}
}
