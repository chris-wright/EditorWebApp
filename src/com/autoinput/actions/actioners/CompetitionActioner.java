package com.autoinput.actions.actioners;

import java.awt.AWTException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.autoinput.actions.EditRobot;
import com.autoinput.objects.Competition;

public class CompetitionActioner extends ObjectActioner {

	
	EditRobot robot;
	private boolean competitionBlocker = false;
	private ArrayList<Competition> objects = new ArrayList<Competition>();

	public CompetitionActioner() {
		try {
			robot = new EditRobot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void doObjectActionFile(String filename, Object obj) {
		Competition competition = (Competition)obj;
		Path path = Paths.get(filename);
		try (Scanner scanner =  new Scanner(path, StandardCharsets.UTF_8.name())){
			while (scanner.hasNextLine()){
				String nextLine = scanner.nextLine();
				String[] lineSplit = nextLine.split("\\t");
				readObjectAction(lineSplit, competition);
				robot.delay(100);
			}	
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void readObjectAction(String[] lineData, Object obj) {
		Competition c = (Competition)obj;
		if(lineData.length == 1) {
			System.out.println("BREAK");
		} else {
			if(!competitionBlocker || (22 == Integer.valueOf(lineData[0]) || (23 == Integer.valueOf(lineData[0])))) {
				switch(Integer.valueOf(lineData[0])) {
				case 0:
					robot.moveMouse(1449, 7);
					robot.clickMouse();
					break;
				case 1:
					// Clicking database at the top of the screen
					robot.moveMouse(46, 184);
					robot.delay(50);
					robot.clickMouse();
					robot.delay(50);
					robot.clickMouse();
					robot.delay(50);
					robot.clickMouse();
					robot.delay(50);
					break;
				case 2:
					// Clicking competition
					robot.moveMouse(68, 545);
					robot.clickMouse();
					robot.clickMouse();
					break;
				case 3:
					// Clicking add
					robot.moveMouse(1288, 832);
					robot.clickMouse();
					robot.clickMouse();
					break;
				case 4:
					robot.moveMouse(980, 190);
					robot.clickMouse();
					robot.selectAll();
					robot.pressDelete();
					robot.keyInput(c.getName());
					break;
				case 5:
					robot.moveMouse(980, 220);
					robot.clickMouse();
					robot.selectAll();
					robot.pressDelete();
					robot.keyInput(c.getShortName());
					break;
				case 6:
					robot.moveMouse(980, 250);
					robot.clickMouse();
					robot.selectAll();
					robot.pressDelete();
					robot.keyInput(c.getThreeLetterName());
					break;
				case 7:
					robot.selectColour(c.getFgRed(), c.getFgGreen(), c.getFgBlue(), 980, 277);
					break;
				case 8:
					robot.selectColour(c.getBgRed(), c.getBgGreen(), c.getBgBlue(), 980, 307);
					break;
				case 9:
					robot.selectColour(c.gettRed(), c.gettGreen(), c.gettBlue(), 980, 337);
					break;
				case 10:
					if(!c.getNation().isEmpty()) {
						robot.moveMouse(1565, 370);
						robot.clickMouse();
						robot.down();
						robot.pressEnter();
						robot.doSearchAndSelectBox(c.getNation());
					}
					break;
				case 11:
					if(!c.getContinent().isEmpty()) {
						robot.moveMouse(1565, 400);
						robot.clickMouse();
						robot.down();
						robot.pressEnter();
						robot.doSearchAndSelectBox(c.getContinent());
					}
					break;
				case 12:
					robot.moveMouse(980, 490);
					robot.clickMouse();
					robot.selectAll();
					robot.pressDelete();
					robot.keyInput(String.valueOf(c.getRep()));
					break;
				case 13:
					if(c.getType() != null) {
						robot.moveMouse(335, 608);
						robot.delay(50);
						robot.clickMouse();
						robot.delay(50);
						robot.moveMouse(980, 608);
						robot.delay(50);
						robot.clickMouse();
						robot.delay(50);
						for(int i = 0; i < c.getType(); i++) {
							robot.down();
							robot.delay(50);
						}
						robot.pressEnter();
					}
					break;
				case 14:
					if(c.getLevel() != null) {
						robot.moveMouse(335, 638);
						robot.clickMouse();
						robot.moveMouse(980, 638);
						robot.clickMouse();
						robot.selectAll();
						robot.pressDelete();
						robot.keyInput(String.valueOf(c.getLevel()));
					}
					break;
				case 15:
					// Page up
					robot.moveMouse(1585, 122);
					robot.clickMouse();
					robot.clickMouse();
					break;
				}
			}
		}
	}

	@Override
	public void readObject(String filename, boolean test, int numberToLoad, String nation, boolean skeleton) {
		List<Competition> competitions = new ArrayList<Competition>();
		Long fails = 0L;
		Long passes = 0L;
		Path path = Paths.get(filename);
		try (Scanner scanner =  new Scanner(path, StandardCharsets.UTF_8.name())) {
			while (scanner.hasNextLine()){
				String nextLine = scanner.nextLine();
				String[] lineSplit = nextLine.split(",");
				if(lineSplit[12].equals(nation) || nation.isEmpty()) {
					for(int i = 0; i < lineSplit.length; i++) {
						System.out.print(lineSplit[i] + ",");
					}
					System.out.println("#");
					Competition competition = new Competition();
					competition.setName(lineSplit[0]);
					competition.setShortName(lineSplit[1]);
					competition.setThreeLetterName(lineSplit[2]);
					competition.setFgRed(Long.valueOf(lineSplit[3]));
					competition.setFgGreen(Long.valueOf(lineSplit[4]));
					competition.setFgBlue(Long.valueOf(lineSplit[5]));
					competition.setBgRed(Long.valueOf(lineSplit[6]));
					competition.setBgGreen(Long.valueOf(lineSplit[7]));
					competition.setBgBlue(Long.valueOf(lineSplit[8]));
					competition.settRed(Long.valueOf(lineSplit[9]));
					competition.settGreen(Long.valueOf(lineSplit[10]));
					competition.settBlue(Long.valueOf(lineSplit[11]));
					competition.setNation(lineSplit[12]);
					competition.setContinent(lineSplit[13]);
					competition.setRep(Long.valueOf(lineSplit[14]));
					competition.setType(Long.valueOf(lineSplit[15]));
					if(!lineSplit[16].isEmpty()) {
						competition.setLevel(Long.valueOf(lineSplit[16]));
					}
					competitions.add(competition);
					passes++;
				}
			}      
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			fails++;
		}
		System.out.println("== Finished building competitions - " + passes + " passed / " + fails + " fails");
		if(!test) {
			int i = 0;
			for(Competition c : competitions) {
				if(numberToLoad > i || numberToLoad == -1) {
					if(skeleton) {
						doObjectActionFile("C:\\Users\\Chris\\Documents\\Coding\\auto-input\\src\\com\\autoinput\\resources\\create_competition_skeleton.txt", c);
					} else {					
						doObjectActionFile("C:\\Users\\Chris\\Documents\\Coding\\auto-input\\src\\com\\autoinput\\resources\\create_competition_test_new.txt", c);
					}
					i++;
					printLogMsg("Finished running for " + c.getName());
				}
			}
		}
	}

	@Override
	public void buildObject(String input, boolean test, String nation) {
		String[] lineSplit = input.split(",");
		if(lineSplit[12].equals(nation) || nation.isEmpty()) {
			for(int i = 0; i < lineSplit.length; i++) {
				System.out.print(lineSplit[i] + ",");
			}
			System.out.println("#");
			Competition competition = new Competition();
			competition.setName(lineSplit[0]);
			competition.setShortName(lineSplit[1]);
			competition.setThreeLetterName(lineSplit[2]);
			competition.setFgRed(Long.valueOf(lineSplit[3]));
			competition.setFgGreen(Long.valueOf(lineSplit[4]));
			competition.setFgBlue(Long.valueOf(lineSplit[5]));
			competition.setBgRed(Long.valueOf(lineSplit[6]));
			competition.setBgGreen(Long.valueOf(lineSplit[7]));
			competition.setBgBlue(Long.valueOf(lineSplit[8]));
			competition.settRed(Long.valueOf(lineSplit[9]));
			competition.settGreen(Long.valueOf(lineSplit[10]));
			competition.settBlue(Long.valueOf(lineSplit[11]));
			competition.setNation(lineSplit[12]);
			competition.setContinent(lineSplit[13]);
			competition.setRep(Long.valueOf(lineSplit[14]));
			competition.setType(Long.valueOf(lineSplit[15]));
			if(!lineSplit[16].isEmpty()) {
				competition.setLevel(Long.valueOf(lineSplit[16]));
			}
			if(!test) {
				doObject(competition);
			}
			objects.add(competition);
		}
	}

	@Override
	public void doObject(Object obj) {
		Competition competition = (Competition)obj;
		doObjectActionFile("C:\\Users\\Chris\\Documents\\Coding\\auto-input\\src\\com\\autoinput\\resources\\create_competition_test_new.txt", competition);
		printLogMsg("Finished running for " + competition.getName());
	}

	public ArrayList<Competition> getObjects() {
		return objects;
	}

	public void setObjects(ArrayList<Competition> objects) {
		this.objects = objects;
	}

}
