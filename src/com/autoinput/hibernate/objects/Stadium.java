package com.autoinput.hibernate.objects;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "STADIUM")
public class Stadium extends EditorObject {

	@Id
    @GeneratedValue
	private Long id;

	@Column(name="NAME_ID")
	private String nameId;
	
	@Column(name="DATE_ADDED")
	private Date dateAdded;
	
	@Column(name="CITY")
	private String city;
	
	@Column(name="CAPACITY")
	private Long capacity;
	
	@Column(name="SEATING_CAPACITY")
	private Long seatingCapacity;
	
	@Column(name="EXPANSION_CAPACITY")
	private Long expansionCapacity;
	
	@Column(name="USED_CAPACITY")
	private Long usedCapacity;
	
	@Column(name="PITCH_TYPE")
	private Long pitchType;
	
	@Column(name="PITCH_CONDITION")
	private Long pitchCondition;
	
	@Column(name="IS_COVERED")
	private Long isCovered;
	
	@Column(name="RETRACT_ROOF")
	private Long retractRoof;
	
	@Column(name="UNDERSOIL_HEATING")
	private Long undersoilHeating;
	
	@Column(name="STATE")
	private Long state;
	
	@Column(name="OWNER")
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
