package com.autoinput.objects;

public class City extends EditorObject {

	private Long id;
	
	private String nation;
	private String language;
	private Long attraction;
	private Long inhabitantsRange;
	private String citizenDescription;
	private String latitude;
	private String longitude;
	private Long altitude;
	private String weather;
	private String localRegion;

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
	
}
