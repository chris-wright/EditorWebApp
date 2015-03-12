package com.autoinput.objects;

import java.util.ArrayList;

public class Nation extends EditorObject {
	
	private Long id;
	
	private String shortName;
	private String threeLetterName;
	private String nationalityName;
	private String nickname;
	private String capital;
	private String continent;
	private String region;
	private Long reputation;
	private Long economicFactor;
	private Long faFinancialPower;
	private Long yearsToGainNationality;
	private Long stateOfDevelopment;
	private Long gameImportance;
	private Long faPatience;
	private Long youthRating;
	private Long r1;
	private Long g1;
	private Long b1;
	private Long r2;
	private Long g2;
	private Long b2;
	private Long r3;
	private Long g3;
	private Long b3;
	private Long homeShirtType;
	private Long homeShortsType;
	private Long homeSocksType;
	private Long awayShirtType;
	private Long awayShortsType;
	private Long awaySocksType;
	private String replaceNation;
	private String currency;
	private String languages;
	private ArrayList<String> languageNames = new ArrayList<String>();
	private ArrayList<Integer> languageStrengths = new ArrayList<Integer>();
	
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
	
}
