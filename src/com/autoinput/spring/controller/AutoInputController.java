package com.autoinput.spring.controller;

import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.autoinput.beans.ReadData;
import com.autoinput.beans.WriteData;
import com.autoinput.helpers.AppHelper;
import com.autoinput.spring.service.AppService;

@Controller
public class AutoInputController {

	@ManagedProperty("#{appService}")
	private AppService appService;
	
	@RequestMapping("/welcome")
	public ModelAndView autoinputdata() {
		
		ReadData readData =  AppHelper.findBean("readData");
		
		appService.writeContinentData(readData.getContinentActioner().getObjects(), true);
		appService.writeNationData(readData.getNationActioner().getObjects(), true);
		appService.writeAgreementData(readData.getAgreementActioner().getObjects(), true);
		appService.writeCityData(readData.getCityActioner().getObjects(), true);
		appService.writeClubData(readData.getClubActioner().getObjects(), true);
		appService.writeStadiumData(readData.getStadiumActioner().getObjects(), true);
		appService.writeCompetitionData(readData.getCompetitionActioner().getObjects(), true);
		
		
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
