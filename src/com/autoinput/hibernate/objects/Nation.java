package com.autoinput.hibernate.objects;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "NATION")
public class Nation extends EditorObject {

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
    
    @Column(name="NATIONALITY_NAME")
	private String nationalityName;
    
    @Column(name="NICKNAME")
	private String nickname;
    
    @Column(name="CAPITAL")
	private String capital;
    
    @Column(name="CONTINENT")
	private String continent;
    
    @Column(name="REGION")
	private String region;
    
    @Column(name="REPUTATION")
	private Long reputation;
    
    @Column(name="ECONOMIC_FACTOR")
	private Long economicFactor;
    
    @Column(name="FA_POWER")
	private Long faFinancialPower;
    
    @Column(name="YEARS_FOR_NAT")
	private Long yearsToGainNationality;
    
    @Column(name="STATE_OF_DEVELOPMENT")
	private Long stateOfDevelopment;
    
    @Column(name="GAME_IMPORTANCE")
	private Long gameImportance;
    
    @Column(name="FA_PATIENCE")
	private Long faPatience;
    
    @Column(name="YOUTH_RATING")
	private Long youthRating;
    
    @Column(name="R1")
	private Long r1;
    
    @Column(name="G1")
	private Long g1;
    
    @Column(name="B1")
	private Long b1;
    
    @Column(name="R2")
	private Long r2;
    
    @Column(name="G2")
	private Long g2;
    
    @Column(name="B2")
	private Long b2;
    
    @Column(name="R3")
	private Long r3;
    
    @Column(name="G3")
	private Long g3;
    
    @Column(name="B3")
	private Long b3;
    
    @Column(name="HOME_SHIRT")
	private Long homeShirtType;
    
    @Column(name="HOME_SHORTS")
	private Long homeShortsType;
    
    @Column(name="HOME_SOCKS")
	private Long homeSocksType;
    
    @Column(name="AWAY_SHIRT")
	private Long awayShirtType;
    
    @Column(name="AWAY_SHORTS")
	private Long awayShortsType;
    
    @Column(name="AWAY_SOCKS")
	private Long awaySocksType;
    
    @Column(name="REPLACE_NATION")
	private String replaceNation;
    
    @Column(name="CURRENCY")
	private String currency;
    
    @Column(name="LANGUAGES")
	private String languages;
    
    @Transient
	private ArrayList<String> languageNames = new ArrayList<String>();
    @Transient
	private ArrayList<Integer> languageStrengths = new ArrayList<Integer>();
	
	public Nation(String nameId, Date dateAdded, String shortName,
			String threeLetterName, String nationalityName, String nickname,
			String capital, String continent, String region, Long reputation,
			Long economicFactor, Long faFinancialPower,
			Long yearsToGainNationality, Long stateOfDevelopment,
			Long gameImportance, Long faPatience, Long youthRating, Long r1,
			Long g1, Long b1, Long r2, Long g2, Long b2, Long r3, Long g3,
			Long b3, Long homeShirtType, Long homeShortsType,
			Long homeSocksType, Long awayShirtType, Long awayShortsType,
			Long awaySocksType, String replaceNation, String currency,
			String languages) {
		super();
		this.nameId = threeLetterName + "_" + super.getName();
		this.dateAdded = new Date();
		this.shortName = shortName;
		this.threeLetterName = threeLetterName;
		this.nationalityName = nationalityName;
		this.nickname = nickname;
		this.capital = capital;
		this.continent = continent;
		this.region = region;
		this.reputation = reputation;
		this.economicFactor = economicFactor;
		this.faFinancialPower = faFinancialPower;
		this.yearsToGainNationality = yearsToGainNationality;
		this.stateOfDevelopment = stateOfDevelopment;
		this.gameImportance = gameImportance;
		this.faPatience = faPatience;
		this.youthRating = youthRating;
		this.r1 = r1;
		this.g1 = g1;
		this.b1 = b1;
		this.r2 = r2;
		this.g2 = g2;
		this.b2 = b2;
		this.r3 = r3;
		this.g3 = g3;
		this.b3 = b3;
		this.homeShirtType = homeShirtType;
		this.homeShortsType = homeShortsType;
		this.homeSocksType = homeSocksType;
		this.awayShirtType = awayShirtType;
		this.awayShortsType = awayShortsType;
		this.awaySocksType = awaySocksType;
		this.replaceNation = replaceNation;
		this.currency = currency;
		this.languages = languages;
	}
	public Nation() {
		// TODO Auto-generated constructor stub
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getReplaceNation() {
		return replaceNation;
	}
	public void setReplaceNation(String replaceNation) {
		this.replaceNation = replaceNation;
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
	public String getNationalityName() {
		return nationalityName;
	}
	public void setNationalityName(String nationalityName) {
		this.nationalityName = nationalityName;
	}
	public String getCapital() {
		return capital;
	}
	public void setCapital(String capital) {
		this.capital = capital;
	}
	public String getContinent() {
		return continent;
	}
	public void setContinent(String continent) {
		this.continent = continent;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public Long getReputation() {
		return reputation;
	}
	public void setReputation(Long reputation) {
		this.reputation = reputation;
	}
	public Long getEconomicFactor() {
		return economicFactor;
	}
	public void setEconomicFactor(Long economicFactor) {
		this.economicFactor = economicFactor;
	}
	public Long getFaFinancialPower() {
		return faFinancialPower;
	}
	public void setFaFinancialPower(Long faFinancialPower) {
		this.faFinancialPower = faFinancialPower;
	}
	public Long getYearsToGainNationality() {
		return yearsToGainNationality;
	}
	public void setYearsToGainNationality(Long yearsToGainNationality) {
		this.yearsToGainNationality = yearsToGainNationality;
	}
	public Long getStateOfDevelopment() {
		return stateOfDevelopment;
	}
	public void setStateOfDevelopment(Long stateOfDevelopment) {
		this.stateOfDevelopment = stateOfDevelopment;
	}
	public Long getGameImportance() {
		return gameImportance;
	}
	public void setGameImportance(Long gameImportance) {
		this.gameImportance = gameImportance;
	}
	public Long getFaPatience() {
		return faPatience;
	}
	public void setFaPatience(Long faPatience) {
		this.faPatience = faPatience;
	}
	public Long getYouthRating() {
		return youthRating;
	}
	public void setYouthRating(Long youthRating) {
		this.youthRating = youthRating;
	}
	public Long getR1() {
		return r1;
	}
	public void setR1(Long r1) {
		this.r1 = r1;
	}
	public Long getG1() {
		return g1;
	}
	public void setG1(Long g1) {
		this.g1 = g1;
	}
	public Long getB1() {
		return b1;
	}
	public void setB1(Long b1) {
		this.b1 = b1;
	}
	public Long getR2() {
		return r2;
	}
	public void setR2(Long r2) {
		this.r2 = r2;
	}
	public Long getG2() {
		return g2;
	}
	public void setG2(Long g2) {
		this.g2 = g2;
	}
	public Long getB2() {
		return b2;
	}
	public void setB2(Long b2) {
		this.b2 = b2;
	}
	public Long getR3() {
		return r3;
	}
	public void setR3(Long r3) {
		this.r3 = r3;
	}
	public Long getG3() {
		return g3;
	}
	public void setG3(Long g3) {
		this.g3 = g3;
	}
	public Long getB3() {
		return b3;
	}
	public void setB3(Long b3) {
		this.b3 = b3;
	}
	public Long getHomeShirtType() {
		return homeShirtType;
	}
	public void setHomeShirtType(Long homeShirtType) {
		this.homeShirtType = homeShirtType;
	}
	public Long getHomeShortsType() {
		return homeShortsType;
	}
	public void setHomeShortsType(Long homeShortsType) {
		this.homeShortsType = homeShortsType;
	}
	public Long getHomeSocksType() {
		return homeSocksType;
	}
	public void setHomeSocksType(Long homeSocksType) {
		this.homeSocksType = homeSocksType;
	}
	public Long getAwayShirtType() {
		return awayShirtType;
	}
	public void setAwayShirtType(Long awayShirtType) {
		this.awayShirtType = awayShirtType;
	}
	public Long getAwayShortsType() {
		return awayShortsType;
	}
	public void setAwayShortsType(Long awayShortsType) {
		this.awayShortsType = awayShortsType;
	}
	public Long getAwaySocksType() {
		return awaySocksType;
	}
	public void setAwaySocksType(Long awaySocksType) {
		this.awaySocksType = awaySocksType;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getLanguages() {
		return languages;
	}
	public void setLanguages(String languages) {
		this.languages = languages;
	}
	public ArrayList<String> getLanguageNames() {
		return languageNames;
	}
	public void setLanguageNames(ArrayList<String> languageNames) {
		this.languageNames = languageNames;
	}
	public ArrayList<Integer> getLanguageStrengths() {
		return languageStrengths;
	}
	public void setLanguageStrengths(ArrayList<Integer> languageStrengths) {
		this.languageStrengths = languageStrengths;
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
