package com.autoinput.hibernate.objects;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "AGREEMENT")
public class Agreement extends EditorObject {

	@Id
    @GeneratedValue
	private Long id;
	
	@Column(name="NAME_ID")
	private String nameId;
	
	@Column(name="NATION_STRING")
	private String nationString;
	
    @Column(name="DATE_ADDED")
    private Date dateAdded;
	
	@Transient
	private List<String> nations = new ArrayList<String>();

	public List<String> getNations() {
		return nations;
	}
	
	public void setNations(List<String> nations) {
		this.nations = nations;
		StringBuilder sb = new StringBuilder();
		for(String nation : nations) {
			sb.append(nation);
			sb.append(",");
		}
		setNationString(sb.toString());
	}
	
	public void addNation(String nation) {
		getNations().add(nation);
		setNationString(getNationString() + "," + nation);
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

	public String getNationString() {
		return nationString;
	}

	public void setNationString(String nationString) {
		this.nationString = nationString;
	}

	public Date getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(Date dateAdded) {
		this.dateAdded = dateAdded;
	}
}
