package com.autoinput.hibernate.objects;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "COMPETITION")
public class Competition extends EditorObject {

	@Id
    @GeneratedValue
	private Long id;

	@Column(name="NAME_ID")
	private String nameId;

	@Column(name="DATE_ADDED")
	private Date dateAdded;


	@Column(name="SHORT_NAME")
	private String shortName;

	@Column(name="THREE_LETTER_NAME")
	private String threeLetterName;

	@Column(name="FG_RED")
	private Long fgRed;

	@Column(name="FG_GREEN")
	private Long fgGreen;

	@Column(name="FG_BLUE")
	private Long fgBlue;

	@Column(name="BG_RED")
	private Long bgRed;

	@Column(name="BG_GREEN")
	private Long bgGreen;

	@Column(name="BG_BLUE")
	private Long bgBlue;

	@Column(name="T_RED")
	private Long tRed;

	@Column(name="T_GREEN")
	private Long tGreen;

	@Column(name="T_BLUE")
	private Long tBlue;

	@Column(name="NATION")
	private String nation;

	@Column(name="CONTINENT")
	private String continent;

	@Column(name="REP")
	private Long rep;

	@Column(name="TYPE")
	private Long type;

	@Column(name="LEVEL")
	private Long level;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getShortName() {
		return shortName;
	}
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	public String getThreeLetterName() {
		return threeLetterName;
	}
	public void setThreeLetterName(String threeLetterName) {
		this.threeLetterName = threeLetterName;
	}
	public Long getFgRed() {
		return fgRed;
	}
	public void setFgRed(Long fgRed) {
		this.fgRed = fgRed;
	}
	public Long getFgGreen() {
		return fgGreen;
	}
	public void setFgGreen(Long fgGreen) {
		this.fgGreen = fgGreen;
	}
	public Long getFgBlue() {
		return fgBlue;
	}
	public void setFgBlue(Long fgBlue) {
		this.fgBlue = fgBlue;
	}
	public Long getBgRed() {
		return bgRed;
	}
	public void setBgRed(Long bgRed) {
		this.bgRed = bgRed;
	}
	public Long getBgGreen() {
		return bgGreen;
	}
	public void setBgGreen(Long bgGreen) {
		this.bgGreen = bgGreen;
	}
	public Long getBgBlue() {
		return bgBlue;
	}
	public void setBgBlue(Long bgBlue) {
		this.bgBlue = bgBlue;
	}
	public Long gettRed() {
		return tRed;
	}
	public void settRed(Long tRed) {
		this.tRed = tRed;
	}
	public Long gettGreen() {
		return tGreen;
	}
	public void settGreen(Long tGreen) {
		this.tGreen = tGreen;
	}
	public Long gettBlue() {
		return tBlue;
	}
	public void settBlue(Long tBlue) {
		this.tBlue = tBlue;
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public Long getRep() {
		return rep;
	}
	public void setRep(Long rep) {
		this.rep = rep;
	}
	public Long getType() {
		return type;
	}
	public void setType(Long type) {
		this.type = type;
	}
	public Long getLevel() {
		return level;
	}
	public void setLevel(Long level) {
		this.level = level;
	}
	public String getContinent() {
		return continent;
	}
	public void setContinent(String continent) {
		this.continent = continent;
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
