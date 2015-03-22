package com.autoinput.hibernate.objects;

public class Stadium extends EditorObject {

	private Long id;
	
	private String city;
	private Long capacity;
	private Long seatingCapacity;
	private Long expansionCapacity;
	private Long usedCapacity;
	private Long pitchType;
	private Long pitchCondition;
	private Long isCovered;
	private Long retractRoof;
	private Long undersoilHeating;
	private Long state;
	private String owner;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Long getCapacity() {
		return capacity;
	}
	public void setCapacity(Long capacity) {
		this.capacity = capacity;
	}
	public Long getSeatingCapacity() {
		return seatingCapacity;
	}
	public void setSeatingCapacity(Long seatingCapacity) {
		this.seatingCapacity = seatingCapacity;
	}
	public Long getExpansionCapacity() {
		return expansionCapacity;
	}
	public void setExpansionCapacity(Long expansionCapacity) {
		this.expansionCapacity = expansionCapacity;
	}
	public Long getUsedCapacity() {
		return usedCapacity;
	}
	public void setUsedCapacity(Long usedCapacity) {
		this.usedCapacity = usedCapacity;
	}
	public Long getPitchType() {
		return pitchType;
	}
	public void setPitchType(Long pitchType) {
		this.pitchType = pitchType;
	}
	public Long getPitchCondition() {
		return pitchCondition;
	}
	public void setPitchCondition(Long pitchCondition) {
		this.pitchCondition = pitchCondition;
	}
	public Long getIsCovered() {
		return isCovered;
	}
	public void setIsCovered(Long isCovered) {
		this.isCovered = isCovered;
	}
	public Long getRetractRoof() {
		return retractRoof;
	}
	public void setRetractRoof(Long retractRoof) {
		this.retractRoof = retractRoof;
	}
	public Long getUndersoilHeating() {
		return undersoilHeating;
	}
	public void setUndersoilHeating(Long undersoilHeating) {
		this.undersoilHeating = undersoilHeating;
	}
	public Long getState() {
		return state;
	}
	public void setState(Long state) {
		this.state = state;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
}
