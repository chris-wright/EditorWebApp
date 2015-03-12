package com.autoinput.drivers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.autoinput.actions.Actioner;
import com.autoinput.actions.actioners.AgreementActioner;
import com.autoinput.actions.actioners.CityActioner;
import com.autoinput.actions.actioners.ClubActioner;
import com.autoinput.actions.actioners.CompetitionActioner;
import com.autoinput.actions.actioners.ContinentActioner;
import com.autoinput.actions.actioners.NationActioner;
import com.autoinput.actions.actioners.PlayerActioner;
import com.autoinput.actions.actioners.StadiumActioner;

public class ActionerDriver {	
	public static void main(String[] args) {
		
		boolean isTest = true;
		boolean skeleton = false;
		String continent = "";
		String nation = "";
		// Continent | CreateNation | Agreement | Competition | City | Club | Stadium | Player | 
		//boolean[] runArray = {true,false,true,true,true,true,false};
		boolean[] runArray = {false,false,false,false,false,true,true,false};
		if(runArray[0]) {
			doContinent(isTest, -1, "C:\\Users\\Chris\\Documents\\Coding\\auto-input\\src\\com\\autoinput\\resources\\continent_input_all.txt", continent, skeleton);
		}
		if(runArray[1]) {
			doCreateNations(isTest, -1, "C:\\Users\\Chris\\Documents\\Coding\\auto-input\\src\\com\\autoinput\\resources\\nation_input_all.txt", continent, skeleton);
		}
		if(runArray[2]) {
			doAgreements(isTest, -1, "C:\\Users\\Chris\\Documents\\Coding\\auto-input\\src\\com\\autoinput\\resources\\agreement_input_all.txt", skeleton);
		}
		if(runArray[3]) {
			doCompetitions(isTest, -1, "C:\\Users\\Chris\\Documents\\Coding\\auto-input\\src\\com\\autoinput\\resources\\competition_input_all.txt", nation, skeleton);
		}
		if(runArray[4]) {
			doCities(isTest, -1, "C:\\Users\\Chris\\Documents\\Coding\\auto-input\\src\\com\\autoinput\\resources\\city_input_all.txt", nation, skeleton);
		}
		if(runArray[5]) {
			doClubs(isTest, -1, "C:\\Users\\Chris\\Documents\\Coding\\auto-input\\src\\com\\autoinput\\resources\\club_input_all.txt", nation, skeleton);
		}
		if(runArray[6]) {
			doStadiums(isTest, -1, "C:\\Users\\Chris\\Documents\\Coding\\auto-input\\src\\com\\autoinput\\resources\\stadium_input_all.txt", nation, skeleton);
		}
		if(runArray[7]) {
			doPlayers(isTest, -1, "C:\\Users\\Chris\\Documents\\Coding\\auto-input\\src\\com\\autoinput\\resources\\player_input_all.txt", skeleton);
		}
		
	}
	
	public static void doPlayers(boolean isTest, int limit, String filename, boolean skeleton) {
		printLogMsg("Starting to read players");	
		new PlayerActioner().readObject(filename, isTest, limit, "", skeleton);
		printLogMsg("Finished players");
	}
	
	public static void doContinent(boolean isTest, int limit, String filename, String continent, boolean skeleton) {
		printLogMsg("Starting to read continents");	
		new ContinentActioner().readObject(filename, isTest, limit, continent, skeleton);
		printLogMsg("Finished agreements");
	}
	
	public static void doAgreements(boolean isTest, int limit, String filename, boolean skeleton) {
		printLogMsg("Starting to read agreements");	
		new AgreementActioner().readObject(filename, isTest, limit, "", skeleton);
		printLogMsg("Finished agreements");
	}
	
	public static void doCreateNations(boolean isTest, int limit, String filename, String continent, boolean skeleton) {
		printLogMsg("Starting to read nations");	
		new NationActioner().readObject(filename, isTest, limit, continent, skeleton);
		printLogMsg("Finished nations");
	}
	
	public static void doCompetitions(boolean isTest, int limit, String filename, String nation, boolean skeleton) {
		printLogMsg("Starting to read competitions");
		new CompetitionActioner().readObject(filename, isTest, limit, nation, skeleton);
		printLogMsg("Finished competitions");
	}
	
	public static void doCities(boolean isTest, int limit, String filename, String nation, boolean skeleton) {
		printLogMsg("Starting to read cities");
		new CityActioner().readObject(filename, isTest, limit, nation, skeleton);
		printLogMsg("Finished cities");
	}
	
	public static void doClubs(boolean isTest, int limit, String filename, String nation, boolean skeleton) {
		printLogMsg("Starting to read clubs");
		new ClubActioner().readObject(filename, isTest, limit, nation, skeleton);
		printLogMsg("Finished clubs");
	}
	
	
	public static void doStadiums(boolean isTest, int limit, String filename, String nation, boolean skeleton) {
		printLogMsg("Starting to read stadiums");
		new StadiumActioner().readObject(filename, isTest, limit, nation, skeleton);
		printLogMsg("Finished stadiums");
	}
	
	public static void printLogMsg(String msg) {
		System.out.println("-- " + msg + " - " + getCurrentTimestamp());
	}
	
	
	public static String getCurrentTimestamp() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		return dateFormat.format(date); //2014/08/06 15:59:48
	}

	
}