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
import com.autoinput.hibernate.objects.Competition;
import com.autoinput.hibernate.objects.Continent;
import com.autoinput.hibernate.objects.Nation;
import com.autoinput.spring.service.AppService;

@ManagedBean(name="nationActioner")
@SessionScoped
public class NationActioner extends ObjectActioner {
	
	@ManagedProperty("#{appService}")
	private AppService appService;

	EditRobot robot;
	private ArrayList<Nation> objects = new ArrayList<Nation>();
	String fullInputFile = "C:\\Users\\Chris\\Documents\\Coding\\auto-input\\src\\com\\autoinput\\resources\\create_nation_test.txt";
	String skeletonInputFile = "C:\\Users\\Chris\\Documents\\Coding\\auto-input\\src\\com\\autoinput\\resources\\create_nation_skeleton.txt";

	public NationActioner() {
		try {
			robot = new EditRobot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}
	
	public void delete(Nation nation) {
		appService.deleteNation(nation);
	}

	@Override
	public void doObjectActionFile(String filename, Object obj) {
		Nation nation = (Nation)obj;
		Path path = Paths.get(filename);
		try (Scanner scanner =  new Scanner(path, StandardCharsets.UTF_8.name())){
			while (scanner.hasNextLine()){
				String nextLine = scanner.nextLine();
				String[] lineSplit = nextLine.split("\\t");
				readObjectAction(lineSplit, nation);
				robot.delay(100);
			}	
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void readObjectAction(String[] lineSplit, Object obj) {		
		Nation n = (Nation)obj;
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
				// Clicking nation
				robot.moveMouse(68, 824);
				robot.delay(50);
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
				robot.keyInput(n.getReplaceNation());
				robot.delay(50);
				robot.pressEnter();
				robot.delay(50);
				break;
			case 4:
				// Select nation
				robot.moveMouse(521, 220);
				robot.clickMouse();
				robot.moveMouse(1541, 831);
				robot.clickMouse();
				break;
			case 5:
				robot.moveMouse(973, 160);
				robot.clickMouse();
				robot.selectAll();
				robot.pressDelete();
				robot.keyInput(n.getName());
				break;
			case 6:
				robot.moveMouse(973, 191);
				robot.clickMouse();
				robot.selectAll();
				robot.pressDelete();
				robot.keyInput(n.getShortName());
				break;
			case 7:
				robot.moveMouse(973, 222);
				robot.clickMouse();
				robot.selectAll();
				robot.pressDelete();
				robot.keyInput(n.getNickname());
				break;
			case 8:
				robot.moveMouse(973, 253);
				robot.clickMouse();
				robot.selectAll();
				robot.pressDelete();
				robot.keyInput(n.getThreeLetterName());
				break;
			case 9:
				robot.moveMouse(973, 284);
				robot.clickMouse();
				robot.selectAll();
				robot.pressDelete();
				robot.keyInput(n.getNationalityName());
				break;
			case 10:
				if(!n.getContinent().isEmpty()) {
					robot.moveMouse(1572, 348);
					robot.clickMouse();
					robot.down();
					robot.pressEnter();
					robot.doSearchAndSelectBox(n.getContinent());
				}
				break;
			case 11:
				if(!n.getRegion().isEmpty()) {
					robot.moveMouse(1572, 377);
					robot.clickMouse();
					robot.down();
					robot.pressEnter();
					robot.doSearchAndSelectBox(n.getRegion());
				}
				break;
			case 12:
				robot.moveMouse(973, 458);
				robot.clickMouse();
				robot.selectAll();
				robot.pressDelete();
				robot.keyInput(String.valueOf(n.getReputation()));
				break;
			case 13:
				robot.moveMouse(92, 545);
				robot.clickMouse();
				robot.clickMouse();
				robot.clickMouse();
				robot.clickMouse();
				robot.clickMouse();
				robot.moveMouse(92, 575);
				robot.clickMouse();
				robot.clickMouse();
				break;
			case 14:
				robot.moveMouse(26, 545);
				robot.clickMouse();
				robot.clickMouse();
				break;
			case 15:
				robot.moveMouse(1368, 470);
				robot.clickMouse();
				break;
			case 16:
				robot.moveMouse(358, 185);
				robot.clickMouse();
				robot.clickMouse();
				break;
			case 17:
				robot.doShortsSelection(
						n.getHomeShortsType(), 
						n.getR1(), 
						n.getG1(), 
						n.getB1(), 
						n.getR2(), 
						n.getG2(), 
						n.getB2(), 
						n.getR3(), 
						n.getG3(), 
						n.getB3());
				break;
			case 18:
				robot.moveMouse(358, 211);
				robot.clickMouse();
				robot.clickMouse();
				break;
			case 19:
				robot.doSocksSelection(
						n.getHomeSocksType(), 
						n.getR1(), 
						n.getG1(), 
						n.getB1(), 
						n.getR2(), 
						n.getG2(), 
						n.getB2(), 
						n.getR3(), 
						n.getG3(), 
						n.getB3());
				break;
			case 20:
				robot.moveMouse(358, 237);
				robot.clickMouse();
				robot.clickMouse();
				break;
			case 21:
				robot.doIconSelection(
						n.getR1(), 
						n.getG1(), 
						n.getB1(), 
						n.getR2(), 
						n.getG2(), 
						n.getB2(), 
						n.getR3(), 
						n.getG3(), 
						n.getB3());
				break;
			case 22:
				robot.moveMouse(358, 264);
				robot.clickMouse();
				robot.clickMouse();
				break;
			case 23:
				robot.doTextSelection(
						n.getR1(), 
						n.getG1(), 
						n.getB1(), 
						n.getR2(), 
						n.getG2(), 
						n.getB2(), 
						n.getR3(), 
						n.getG3(), 
						n.getB3());
				break;
			case 24:
				robot.moveMouse(92, 608);
				robot.clickMouse();
				robot.clickMouse();
				break;
			case 26:
				robot.doShortsSelection(
						n.getAwayShortsType(), 
						n.getR2(), 
						n.getG2(), 
						n.getB2(), 
						n.getR1(), 
						n.getG1(), 
						n.getB1(), 
						n.getR3(), 
						n.getG3(), 
						n.getB3());
				break;
			case 27:
				robot.doSocksSelection(
						n.getAwaySocksType(), 
						n.getR2(), 
						n.getG2(), 
						n.getB2(), 
						n.getR1(), 
						n.getG1(), 
						n.getB1(), 
						n.getR3(), 
						n.getG3(), 
						n.getB3());
				break;
			case 28:
				robot.doIconSelection(
						n.getR2(), 
						n.getG2(), 
						n.getB2(), 
						n.getR1(), 
						n.getG1(), 
						n.getB1(), 
						n.getR3(), 
						n.getG3(), 
						n.getB3());
				break;
			case 29:
				robot.doTextSelection(
						n.getR2(), 
						n.getG2(), 
						n.getB2(), 
						n.getR1(), 
						n.getG1(), 
						n.getB1(), 
						n.getR3(), 
						n.getG3(), 
						n.getB3());
				break;
			case 30:
				robot.moveMouse(358, 160);
				robot.clickMouse();
				break;
			case 31:
				robot.doShirtSelection(
						n.getHomeShirtType(), 
						n.getR1(), 
						n.getG1(), 
						n.getB1(), 
						n.getR2(), 
						n.getG2(), 
						n.getB2(), 
						n.getR3(), 
						n.getG3(), 
						n.getB3());
				break;
			case 32:
				robot.doShirtSelection(
						n.getAwayShirtType(), 
						n.getR2(), 
						n.getG2(), 
						n.getB2(), 
						n.getR1(), 
						n.getG1(), 
						n.getB1(), 
						n.getR3(), 
						n.getG3(), 
						n.getB3());
				break;
			case 33:
				robot.moveMouse(1559, 470);
				robot.clickMouse();
				break;
			case 34:
				robot.moveMouse(77, 593);
				robot.clickMouse();
				break;
			case 35:
				robot.moveMouse(1561, 470);
				robot.clickMouse();
				break;
			case 36:
				for(int i = 0; i < n.getLanguageNames().size(); i++) {
					int searchPos = 161 + (i * 26);
					robot.moveMouse(1368, 470);
					robot.clickMouse();
					robot.moveMouse(988, searchPos);
					robot.clickMouse();
					robot.down();
					robot.pressEnter();
					robot.doSearchAndSelectBox(n.getLanguageNames().get(i));
					robot.moveMouse(1024, searchPos);
					robot.clickMouse();
					robot.selectAll();
					robot.pressDelete();
					robot.keyInput(String.valueOf(n.getLanguageStrengths().get(i)));
				}
				break;
			case 37:
				if(!n.getCurrency().isEmpty()) {
					robot.moveMouse(1564, 400);
					robot.clickMouse();
					robot.down();
					robot.pressEnter();
					robot.doSearchAndSelectBoxWithContains(n.getCurrency());
				}
				break;
			case 38:
				// Page down
				robot.moveMouse(300, 860);
				robot.clickMouse();
				robot.clickMouse();
				break;
			case 39:
				// Page up
				robot.moveMouse(300, 415);
				robot.clickMouse();
				robot.clickMouse();
				break;
			}
		}
	}

	@Override
	public void readObject(String filename, boolean test, int numberToLoad, String continentString, boolean isSkeleton) {
		List<Nation> nations = new ArrayList<Nation>();
		List<String> failures = new ArrayList<String>();
		Long fails = 0L;
		Long passes = 0L;
		Path path = Paths.get(filename);
		try (Scanner scanner =  new Scanner(path, StandardCharsets.UTF_8.name())) {
			while (scanner.hasNextLine()){
				String nextLine = scanner.nextLine();
				String[] lineSplit = nextLine.split(",");
				if(lineSplit[7].equals(continentString) || continentString.isEmpty()) {

					for(int i = 0; i < lineSplit.length; i++) {
						System.out.print(lineSplit[i] + ",");
					}
					System.out.println("#");
					Nation nation = new Nation();
					nation.setName(lineSplit[0]);
					nation.setReplaceNation(lineSplit[1]);
					nation.setShortName(lineSplit[2]);
					nation.setNickname(lineSplit[3]);
					nation.setThreeLetterName(lineSplit[4]);
					nation.setNationalityName(lineSplit[5]);
					nation.setCapital(lineSplit[6]);
					nation.setContinent(lineSplit[7]);
					nation.setRegion(lineSplit[8]);
					nation.setReputation(Long.valueOf(lineSplit[9]));
					nation.setR1(Long.valueOf(lineSplit[10]));
					nation.setG1(Long.valueOf(lineSplit[11]));
					nation.setB1(Long.valueOf(lineSplit[12]));
					nation.setR2(Long.valueOf(lineSplit[13]));
					nation.setG2(Long.valueOf(lineSplit[14]));
					nation.setB2(Long.valueOf(lineSplit[15]));
					nation.setR3(Long.valueOf(lineSplit[16]));
					nation.setG3(Long.valueOf(lineSplit[17]));
					nation.setB3(Long.valueOf(lineSplit[18]));
					nation.setHomeShirtType(Long.valueOf(lineSplit[19]));
					nation.setHomeShortsType(Long.valueOf(lineSplit[20]));
					nation.setHomeSocksType(Long.valueOf(lineSplit[21]));
					nation.setAwayShirtType(Long.valueOf(lineSplit[22]));
					nation.setAwayShortsType(Long.valueOf(lineSplit[23]));
					nation.setAwaySocksType(Long.valueOf(lineSplit[24]));
					nation.setCurrency(lineSplit[25]);
					nation.setLanguages(lineSplit[26]);
					String[] split = lineSplit[26].split(" ");
					for(int i = 0; i < split.length; i++) {
						if(i%2==1) {
							nation.getLanguageStrengths().add(Integer.valueOf(split[i]));
						} else {
							nation.getLanguageNames().add(split[i]);
						}
					}
					nations.add(nation);
					passes++;
				}
			}      
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			fails++;
		}
		System.out.println("== Finished building nations - " + passes + " passed / " + fails + " fails");
		if(!test && fails == 0) {
			int i = 0;
			for(Nation n : nations) {
				if(numberToLoad > i || numberToLoad == -1) {
					if(isSkeleton) {
						doObjectActionFile(skeletonInputFile, n);
					} else {
						doObjectActionFile(fullInputFile, n);
						robot.delay(5000);
					}
					i++;
					printLogMsg("Finished running for " + n.getName());
				}
			}
		}
	}

	@Override
	public void buildObject(String input, boolean test, String continentString) {
		String[] lineSplit = input.split(",");
		if(lineSplit[7].equals(continentString) || continentString.isEmpty()) {

			for(int i = 0; i < lineSplit.length; i++) {
				System.out.print(lineSplit[i] + ",");
			}
			System.out.println("#");
			Nation nation = new Nation();
			nation.setName(lineSplit[0]);
			nation.setReplaceNation(lineSplit[1]);
			nation.setShortName(lineSplit[2]);
			nation.setNickname(lineSplit[3]);
			nation.setThreeLetterName(lineSplit[4]);
			nation.setNationalityName(lineSplit[5]);
			nation.setCapital(lineSplit[6]);
			nation.setContinent(lineSplit[7]);
			nation.setRegion(lineSplit[8]);
			nation.setReputation(Long.valueOf(lineSplit[9]));
			nation.setR1(Long.valueOf(lineSplit[10]));
			nation.setG1(Long.valueOf(lineSplit[11]));
			nation.setB1(Long.valueOf(lineSplit[12]));
			nation.setR2(Long.valueOf(lineSplit[13]));
			nation.setG2(Long.valueOf(lineSplit[14]));
			nation.setB2(Long.valueOf(lineSplit[15]));
			nation.setR3(Long.valueOf(lineSplit[16]));
			nation.setG3(Long.valueOf(lineSplit[17]));
			nation.setB3(Long.valueOf(lineSplit[18]));
			nation.setHomeShirtType(Long.valueOf(lineSplit[19]));
			nation.setHomeShortsType(Long.valueOf(lineSplit[20]));
			nation.setHomeSocksType(Long.valueOf(lineSplit[21]));
			nation.setAwayShirtType(Long.valueOf(lineSplit[22]));
			nation.setAwayShortsType(Long.valueOf(lineSplit[23]));
			nation.setAwaySocksType(Long.valueOf(lineSplit[24]));
			nation.setCurrency(lineSplit[25]);
			nation.setLanguages(lineSplit[26]);
			String[] split = lineSplit[26].split(" ");
			for(int i = 0; i < split.length; i++) {
				if(i%2==1) {
					nation.getLanguageStrengths().add(Integer.valueOf(split[i]));
				} else {
					nation.getLanguageNames().add(split[i]);
				}
			}
			if(!test) {
				doObject(nation);
			}
			objects.add(nation);
		}
	}

	@Override
	public void doObject(Object obj) {
		Nation nation = (Nation)obj;

			doObjectActionFile(fullInputFile, nation);
			robot.delay(5000);
			printLogMsg("Finished running for " + nation.getName());
	}

	public ArrayList<Nation> getObjects() {
		return objects;
	}

	public void setObjects(ArrayList<Nation> objects) {
		this.objects = objects;
	}

	public AppService getAppService() {
		return appService;
	}

	public void setAppService(AppService appService) {
		this.appService = appService;
	}

}
