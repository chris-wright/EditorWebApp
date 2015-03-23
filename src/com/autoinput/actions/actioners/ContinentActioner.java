package com.autoinput.actions.actioners;

import java.awt.AWTException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import com.autoinput.actions.EditRobot;
import com.autoinput.hibernate.objects.Agreement;
import com.autoinput.hibernate.objects.Competition;
import com.autoinput.hibernate.objects.Continent;
import com.autoinput.spring.service.AppService;



@ManagedBean(name="continentActioner")
@SessionScoped
public class ContinentActioner extends ObjectActioner {

	
	@ManagedProperty("#{appService}")
	private AppService appService;
	
	EditRobot robot;
	private ArrayList<Continent> objects = new ArrayList<Continent>();

	public ContinentActioner() {
		try {
			robot = new EditRobot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}
	
	public void delete(Continent continent) {
		appService.deleteContinent(continent);
	}

	@Override
	public void doObjectActionFile(String filename, Object obj) {
		Continent continent = (Continent)obj;
		Path path = Paths.get(filename);
		try (Scanner scanner =  new Scanner(path, StandardCharsets.UTF_8.name())){
			while (scanner.hasNextLine()){
				String nextLine = scanner.nextLine();
				String[] lineSplit = nextLine.split("\\t");
				readObjectAction(lineSplit, continent);
				robot.delay(100);
			}	
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void readObjectAction(String[] lineSplit, Object obj) {
		Continent c = (Continent)obj;
		if(lineSplit.length == 1) {
			System.out.println("BREAK");
		} else {
			switch(Integer.valueOf(lineSplit[0])) {
			case 0:
				robot.moveMouse(1449, 7);
				robot.clickMouse();
				break;
			case 1:
				// Clicking database at the top of the screen
				robot.moveMouse(46, 184);
				robot.clickMouse();
				robot.clickMouse();
				robot.clickMouse();
				break;
			case 2:
				// Clicking continent
				robot.moveMouse(68, 576);
				robot.clickMouse();
				robot.clickMouse();
				break;
			case 3:
				// Enter the nation you want to replace and search for it
				robot.moveMouse(421, 135);
				robot.delay(50);
				robot.clickMouse();
				robot.delay(50);
				robot.selectAll();
				robot.delay(50);
				robot.pressDelete();
				robot.delay(50);
				robot.keyInput(c.getOldName());
				robot.delay(50);
				robot.pressEnter();
				robot.delay(50);
				break;
			case 4:
				// Select continent
				robot.moveMouse(521, 220);
				robot.clickMouse();
				robot.moveMouse(1541, 831);
				robot.clickMouse();
				break;
			case 5:
				robot.moveMouse(971, 159);
				robot.clickMouse();
				robot.selectAll();
				robot.pressDelete();
				robot.keyInput(String.valueOf(c.getName()));
				break;
			case 6:
				robot.moveMouse(971, 189);
				robot.clickMouse();
				robot.selectAll();
				robot.pressDelete();
				robot.keyInput(String.valueOf(c.getThreeLetterName()));
				break;
			case 7:
				robot.moveMouse(971, 219);
				robot.clickMouse();
				robot.selectAll();
				robot.pressDelete();
				robot.keyInput(String.valueOf(c.getContinentalityName()));
				break;
			case 8:
				robot.moveMouse(971, 249);
				robot.clickMouse();
				robot.selectAll();
				robot.pressDelete();
				robot.keyInput(String.valueOf(c.getFederationName()));
				break;
			case 9:
				robot.moveMouse(971, 279);
				robot.clickMouse();
				robot.selectAll();
				robot.pressDelete();
				robot.keyInput(String.valueOf(c.getShortFederationName()));
				break;
			case 10:
				robot.moveMouse(971, 309);
				robot.clickMouse();
				robot.selectAll();
				robot.pressDelete();
				robot.keyInput(String.valueOf(c.getRegionalStrength()));
				break;
			}
		}
	}

	@Override
	public void readObject(String filename, boolean test, int numberToLoad, String continentName, boolean isSkeleton) {
		List<Continent> continents = new ArrayList<Continent>();
		List<String> failures = new ArrayList<String>();
		Long fails = 0L;
		Long passes = 0L;
		Path path = Paths.get(filename);
		try (Scanner scanner =  new Scanner(path, StandardCharsets.UTF_8.name())) {
			while (scanner.hasNextLine()){
				String nextLine = scanner.nextLine();
				String[] lineSplit = nextLine.split(",");
				if(lineSplit[0].equals(continentName) || continentName.isEmpty()) {
					for(int i = 0; i < lineSplit.length; i++) {
						System.out.print(lineSplit[i] + ",");
					}
					System.out.println("#");
					Continent continent = new Continent();
					continent.setName(lineSplit[0]);
					continent.setOldName(lineSplit[1]);
					continent.setThreeLetterName(lineSplit[2]);
					continent.setContinentalityName(lineSplit[3]);
					continent.setFederationName(lineSplit[4]);
					continent.setShortFederationName(lineSplit[5]);
					continent.setRegionalStrength(Long.valueOf(lineSplit[6]));
					continents.add(continent);
					passes++;
				}
			}      
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			fails++;
		}
		System.out.println("== Finished building continents - " + passes + " passed / " + fails + " fails");
		if(!test && fails == 0) {
			int i = 0;
			for(Continent c : continents) {
				if(numberToLoad > i || numberToLoad == -1) {
					doObjectActionFile("C:\\Users\\Chris\\Documents\\Coding\\auto-input\\src\\com\\autoinput\\resources\\create_continent.txt", c);
					i++;
					printLogMsg("Finished running for " + c.getName());
				}
			}
		}
	}

	@Override
	public void buildObject(String input, boolean test, String continentName) {

		String[] lineSplit = input.split(",");
		if(lineSplit[0].equals(continentName) || continentName.isEmpty()) {
			for(int i = 0; i < lineSplit.length; i++) {
				System.out.print(lineSplit[i] + ",");
			}
			System.out.println("#");
			Continent continent = new Continent();
			continent.setName(lineSplit[0]);
			continent.setOldName(lineSplit[1]);
			continent.setThreeLetterName(lineSplit[2]);
			continent.setContinentalityName(lineSplit[3]);
			continent.setFederationName(lineSplit[4]);
			continent.setShortFederationName(lineSplit[5]);
			continent.setRegionalStrength(Long.valueOf(lineSplit[6]));
			if(!test) {
				doObject(continent);
			}
			objects.add(continent);
		}
	}

	@Override
	public void doObject(Object obj) {
		Continent continent = (Continent)obj;
		System.out.println(continent.getName() + " - " + continent.getContinentalityName());

		int i = 0;
		doObjectActionFile("C:\\Users\\Chris\\Documents\\Coding\\auto-input\\src\\com\\autoinput\\resources\\create_continent.txt", continent);
		i++;
		printLogMsg("Finished running for " + continent.getName());
	}

	public ArrayList<Continent> getObjects() {
		return objects;
	}

	public void setObjects(ArrayList<Continent> objects) {
		this.objects = objects;
	}

	public EditRobot getRobot() {
		return robot;
	}

	public void setRobot(EditRobot robot) {
		this.robot = robot;
	}

	public AppService getAppService() {
		return appService;
	}

	public void setAppService(AppService appService) {
		this.appService = appService;
	}
}
