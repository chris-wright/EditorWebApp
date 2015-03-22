package com.autoinput.hibernate.objects;

public class Competition extends EditorObject {
	
	private Long id;
	
	private String shortName;
	private String threeLetterName;
	private Long fgRed;
	private Long fgGreen;
	private Long fgBlue;
	private Long bgRed;
	private Long bgGreen;
	private Long bgBlue;
	private Long tRed;
	private Long tGreen;
	private Long tBlue;
	private String nation;
	private String continent;
	private Long rep;
	private Long type;
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
	
	
}
