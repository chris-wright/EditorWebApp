package com.crunchify.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.autoinput.filereader.ReadData;

@Controller
public class AutoInputController {

	@RequestMapping("/welcome")
	public ModelAndView autoinputdata() {
		ReadData readData =  new ReadData("C:\\Users\\Chris\\Dropbox\\World v15.2 - Copy.xlsm");
		readData.doStuff();
		String message = "<br><div align='center'>" 
				+ "<h3>Number of Continents: " + readData.getContinentActioner().getObjects().size() +  "<br>"
				+ "<h3>Number of Competitions: " + readData.getCompetitionActioner().getObjects().size() +  "<br>"
				+ "<h3>Number of Cities: " + readData.getCityActioner().getObjects().size() +  "<br>"
				+ "<h3>Number of Clubs: " + readData.getClubActioner().getObjects().size() +  "<br>"
				+ "<h3>Number of Nations: " + readData.getNationActioner().getObjects().size() +  "<br>"
				+ "<h3>Number of Agreements: " + readData.getAgreementActioner().getObjects().size() +  "<br>"
				+ "<h3>Number of Players: " + readData.getPlayerActioner().getObjects().size() +  "<br>"
				+ "<h3>Number of Stadiums: " + readData.getStadiumActioner().getObjects().size() +  "<br><br>";
		return new ModelAndView("welcome", "message", message);
	}
}
