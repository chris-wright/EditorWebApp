package com.autoinput.hibernate.objects;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CLUB")
public class Club extends EditorObject {

	@Id
    @GeneratedValue
	private Long id;

	@Column(name="NAME_ID")
	private String nameId;

	@Column(name="SHORT_NAME")
	private String shortName;

	@Column(name="SIX_LETTER_NAME")
	private String sixLetterName;

	@Column(name="NICKNAME")
	private String nickname;

	@Column(name="SECOND_NICKNAME")
	private String secondNickname;

	@Column(name="NATION")
	private String nation;

	@Column(name="BASED_NATION")
	private String basedNation;

	@Column(name="CONTINENTAL_NATION")
	private String continentalCupNation;

	@Column(name="CITY")
	private String city;

	@Column(name="STATUS")
	private Long status;

	@Column(name="MORALE")
	private Long morale;

	@Column(name="REP")
	private Long rep;

	@Column(name="STADIUM")
	private String stadium;

	@Column(name="TRAINING")
	private Long training;

	@Column(name="YOUTH_COACHING")
	private Long youthCoaching;

	@Column(name="YOUTH_FACILITIES")
	private Long youthFacilities;

	@Column(name="YOUTH_RECRUITMENT")
	private Long youthRecruitment;

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

	@Column(name="THIRD_SHIRT")
	private Long thirdShirtType;

	@Column(name="THIRD_SHORTS")
	private Long thirdShortsType;

	@Column(name="THIRD_SOCKS")
	private Long thirdSocksType;

	@Column(name="COMPETITION")
	private String competition;

	@Column(name="HAS_RESERVES")
	private Long hasReserves;

	@Column(name="HAS_U19S")
	private Long hasUnder19s;

	@Column(name="MIN_AGE")
	private Long minimumAge;

	@Column(name="MAX_AGE")
	private Long maximumAge;

	@Column(name="BALANCE")
	private BigDecimal balance;

	@Column(name="TRANSFER")
	private BigDecimal transfer;

	@Column(name="WAGES")
	private BigDecimal wages;

	@Column(name="SEASON_TICKETS")
	private Long seasonTickets;

	@Column(name="FAN_LOYALTY")
	private Long fanLoyalty;

	@Column(name="FAN_PASSION")
	private Long fanPassion;

	@Column(name="FAN_PATIENCE")
	private Long fanPatience;

	@Column(name="FAN_AFFLUENCE")
	private Long fanAffluence;

	@Column(name="FAN_TEMPERAMENT")
	private Long fanTemperament;

	@Column(name="AR1")
	private Long ar1;
	@Column(name="AG1")
	private Long ag1;
	@Column(name="AB1")
	private Long ab1;
	@Column(name="AR2")
	private Long ar2;
	@Column(name="AG2")
	private Long ag2;
	@Column(name="AB2")
	private Long ab2;
	@Column(name="AR3")
	private Long ar3;
	@Column(name="AG3")
	private Long ag3;
	@Column(name="AB3")
	private Long ab3;
	@Column(name="HAS_THIRD_KIT")
	private boolean hasThirdKit;
	
	@Column(name="DATE_ADDED")
	private Date dateAdded;
	
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
	public String getSixLetterName() {
		return sixLetterName;
	}
	public void setSixLetterName(String sixLetterName) {
		this.sixLetterName = sixLetterName;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getSecondNickname() {
		return secondNickname;
	}
	public void setSecondNickname(String secondNickname) {
		this.secondNickname = secondNickname;
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Long getStatus() {
		return status;
	}
	public void setStatus(Long status) {
		this.status = status;
	}
	public Long getMorale() {
		return morale;
	}
	public void setMorale(Long morale) {
		this.morale = morale;
	}
	public Long getRep() {
		return rep;
	}
	public void setRep(Long rep) {
		this.rep = rep;
	}
	public String getStadium() {
		return stadium;
	}
	public void setStadium(String stadium) {
		this.stadium = stadium;
	}
	public Long getTraining() {
		return training;
	}
	public void setTraining(Long training) {
		this.training = training;
	}
	public Long getYouthCoaching() {
		return youthCoaching;
	}
	public void setYouthCoaching(Long youthCoaching) {
		this.youthCoaching = youthCoaching;
	}
	public Long getYouthFacilities() {
		return youthFacilities;
	}
	public void setYouthFacilities(Long youthFacilities) {
		this.youthFacilities = youthFacilities;
	}
	public Long getYouthRecruitment() {
		return youthRecruitment;
	}
	public void setYouthRecruitment(Long youthRecruitment) {
		this.youthRecruitment = youthRecruitment;
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
	public String getBasedNation() {
		return basedNation;
	}
	public void setBasedNation(String basedNation) {
		this.basedNation = basedNation;
	}
	public String getContinentalCupNation() {
		return continentalCupNation;
	}
	public void setContinentalCupNation(String continentalCupNation) {
		this.continentalCupNation = continentalCupNation;
	}
	public String getCompetition() {
		return competition;
	}
	public void setCompetition(String competition) {
		this.competition = competition;
	}
	public Long getThirdShirtType() {
		return thirdShirtType;
	}
	public void setThirdShirtType(Long thirdShirtType) {
		this.thirdShirtType = thirdShirtType;
	}
	public Long getThirdShortsType() {
		return thirdShortsType;
	}
	public void setThirdShortsType(Long thirdShortsType) {
		this.thirdShortsType = thirdShortsType;
	}
	public Long getThirdSocksType() {
		return thirdSocksType;
	}
	public void setThirdSocksType(Long thirdSocksType) {
		this.thirdSocksType = thirdSocksType;
	}
	public Long getHasReserves() {
		return hasReserves;
	}
	public void setHasReserves(Long hasReserves) {
		this.hasReserves = hasReserves;
	}
	public Long getHasUnder19s() {
		return hasUnder19s;
	}
	public void setHasUnder19s(Long hasUnder19s) {
		this.hasUnder19s = hasUnder19s;
	}
	public Long getMinimumAge() {
		return minimumAge;
	}
	public void setMinimumAge(Long minimumAge) {
		this.minimumAge = minimumAge;
	}
	public Long getMaximumAge() {
		return maximumAge;
	}
	public void setMaximumAge(Long maximumAge) {
		this.maximumAge = maximumAge;
	}
	public BigDecimal getBalance() {
		return balance;
	}
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	public BigDecimal getTransfer() {
		return transfer;
	}
	public void setTransfer(BigDecimal transfer) {
		this.transfer = transfer;
	}
	public BigDecimal getWages() {
		return wages;
	}
	public void setWages(BigDecimal wages) {
		this.wages = wages;
	}
	public Long getSeasonTickets() {
		return seasonTickets;
	}
	public void setSeasonTickets(Long seasonTickets) {
		this.seasonTickets = seasonTickets;
	}
	public Long getFanLoyalty() {
		return fanLoyalty;
	}
	public void setFanLoyalty(Long fanLoyalty) {
		this.fanLoyalty = fanLoyalty;
	}
	public Long getFanPassion() {
		return fanPassion;
	}
	public void setFanPassion(Long fanPassion) {
		this.fanPassion = fanPassion;
	}
	public Long getFanPatience() {
		return fanPatience;
	}
	public void setFanPatience(Long fanPatience) {
		this.fanPatience = fanPatience;
	}
	public Long getFanAffluence() {
		return fanAffluence;
	}
	public void setFanAffluence(Long fanAffluence) {
		this.fanAffluence = fanAffluence;
	}
	public Long getFanTemperament() {
		return fanTemperament;
	}
	public void setFanTemperament(Long fanTemperament) {
		this.fanTemperament = fanTemperament;
	}
	public Long getAr1() {
		return ar1;
	}
	public void setAr1(Long ar1) {
		this.ar1 = ar1;
	}
	public Long getAg1() {
		return ag1;
	}
	public void setAg1(Long ag1) {
		this.ag1 = ag1;
	}
	public Long getAb1() {
		return ab1;
	}
	public void setAb1(Long ab1) {
		this.ab1 = ab1;
	}
	public Long getAr2() {
		return ar2;
	}
	public void setAr2(Long ar2) {
		this.ar2 = ar2;
	}
	public Long getAg2() {
		return ag2;
	}
	public void setAg2(Long ag2) {
		this.ag2 = ag2;
	}
	public Long getAb2() {
		return ab2;
	}
	public void setAb2(Long ab2) {
		this.ab2 = ab2;
	}
	public Long getAr3() {
		return ar3;
	}
	public void setAr3(Long ar3) {
		this.ar3 = ar3;
	}
	public Long getAg3() {
		return ag3;
	}
	public void setAg3(Long ag3) {
		this.ag3 = ag3;
	}
	public Long getAb3() {
		return ab3;
	}
	public void setAb3(Long ab3) {
		this.ab3 = ab3;
	}
	public boolean isHasThirdKit() {
		return hasThirdKit;
	}
	public void setHasThirdKit(boolean hasThirdKit) {
		this.hasThirdKit = hasThirdKit;
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
