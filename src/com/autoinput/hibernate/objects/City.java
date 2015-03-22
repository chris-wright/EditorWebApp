package com.autoinput.hibernate.objects;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CITY")
public class City extends EditorObject {

	@Id
    @GeneratedValue
	private Long id;

	@Column(name="NAME_ID")
	private String nameId;
	
	@Column(name="NATION")
	private String nation;
	@Column(name="LANGUAGE")
	private String language;
	@Column(name="ATTRACTION")
	private Long attraction;
	@Column(name="INHABITANTS_RANGE")
	private Long inhabitantsRange;
	@Column(name="CITIZEN_DESCRIPTION")
	private String citizenDescription;
	@Column(name="LATITUDE")
	private String latitude;
	@Column(name="LONGITUDE")
	private String longitude;
	@Column(name="ALTITUDE")
	private Long altitude;
	@Column(name="WEATHER")
	private String weather;
	@Column(name="LOCAL_REGION")
	private String localRegion;
	@Column(name="DATE_ADDED")
	private Date dateAdded;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public Long getAttraction() {
		return attraction;
	}

	public void setAttraction(Long attraction) {
		this.attraction = attraction;
	}

	public Long getInhabitantsRange() {
		return inhabitantsRange;
	}

	public void setInhabitantsRange(Long inhabitantsRange) {
		this.inhabitantsRange = inhabitantsRange;
	}

	public String getCitizenDescription() {
		return citizenDescription;
	}

	public void setCitizenDescription(String citizenDescription) {
		this.citizenDescription = citizenDescription;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public Long getAltitude() {
		return altitude;
	}

	public void setAltitude(Long altitude) {
		this.altitude = altitude;
	}

	public String getWeather() {
		return weather;
	}

	public void setWeather(String weather) {
		this.weather = weather;
	}

	public String getLocalRegion() {
		return localRegion;
	}

	public void setLocalRegion(String localRegion) {
		this.localRegion = localRegion;
	}

	public Date getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(Date dateAdded) {
		this.dateAdded = dateAdded;
	}

	public String getNameId() {
		return nameId;
	}

	public void setNameId(String nameId) {
		this.nameId = nameId;
	}
	
}
