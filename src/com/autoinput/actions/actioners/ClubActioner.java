package com.autoinput.actions.actioners;

import java.awt.AWTException;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.autoinput.actions.EditRobot;
import com.autoinput.objects.Club;
import com.autoinput.objects.Competition;

public class ClubActioner extends ObjectActioner {

	EditRobot robot;
	String fullInputFile = "C:\\Users\\Chris\\Documents\\Coding\\auto-input\\src\\com\\autoinput\\resources\\create_club_test_new.txt";
	String skeletonInputFile = "C:\\Users\\Chris\\Documents\\Coding\\auto-input\\src\\com\\autoinput\\resources\\create_club_skeleton.txt";
	private ArrayList<Club> objects = new ArrayList<Club>();
	
	public ClubActioner() {
		try {
			robot = new EditRobot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void doObjectActionFile(String filename, Object obj) {
		Club club = (Club)obj;
		Path path = Paths.get(filename);
		try (Scanner scanner =  new Scanner(path, StandardCharsets.UTF_8.name())){
			while (scanner.hasNextLine()){
				String nextLine = scanner.nextLine();
				String[] lineSplit = nextLine.split("\\t");
				readObjectAction(lineSplit, club);
				robot.delay(100);
			}	
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void readObjectAction(String[] lineData, Object obj) {
		Club c = (Club)obj;
		if(lineData.length == 1) {
			System.out.println("BREAK");
		} else {
			System.out.println(lineData[0] + "	" + lineData[1]);
			switch(Integer.valueOf(lineData[0])) {
			case 0:
				robot.moveMouse(1449, 7);
				robot.clickMouse();
				robot.delay(25);
				break;
			case 1:
				// Clicking database at the top of the screen
				robot.moveMouse(46, 184);
				robot.clickMouse();
				robot.clickMouse();
				robot.clickMouse();
				robot.delay(25);
				break;
			case 2:
				// Clicking club
				robot.moveMouse(68, 484);
				robot.clickMouse();
				robot.clickMouse();
				robot.delay(25);
				break;
			case 3:
				// Clicking add
				robot.moveMouse(1288, 832);
				robot.clickMouse();
				robot.clickMouse();
				robot.delay(25);
				break;
			case 4:
				robot.moveMouse(980, 190);
				robot.clickMouse();
				robot.clickMouse();
				robot.selectAll();
				robot.pressDelete();
				robot.delay(25);
				robot.keyInput(c.getName());
				robot.delay(25);
				break;
			case 5:
				robot.moveMouse(980, 220);
				robot.clickMouse();
				robot.clickMouse();
				robot.selectAll();
				robot.pressDelete();
				robot.delay(25);
				robot.keyInput(c.getShortName());
				robot.delay(25);
				break;
			case 6:
				robot.moveMouse(980, 250);
				robot.clickMouse();
				robot.clickMouse();
				robot.selectAll();
				robot.pressDelete();
				robot.delay(25);
				robot.keyInput(c.getSixLetterName());
				robot.delay(25);
				break;
			case 7:
				robot.moveMouse(980, 280);
				robot.clickMouse();
				robot.clickMouse();
				robot.selectAll();
				robot.pressDelete();
				robot.delay(25);
				robot.keyInput(c.getNickname());
				robot.delay(25);
				break;
			case 8:
				robot.moveMouse(980, 310);
				robot.clickMouse();
				robot.clickMouse();
				robot.selectAll();
				robot.pressDelete();
				robot.delay(25);
				robot.keyInput(c.getSecondNickname());
				robot.delay(25);
				break;
			case 9:
				if(!c.getNation().isEmpty()) {
					robot.moveMouse(1565, 370);
					robot.clickMouse();
					robot.down();
					robot.pressEnter();
					robot.delay(25);
					robot.doSearchAndSelectBox(c.getNation());
					robot.delay(25);
				}
				break;
			case 10:
				if(!c.getNation().isEmpty()) {
					robot.moveMouse(1565, 400);
					robot.clickMouse();
					robot.down();
					robot.pressEnter();
					robot.delay(25);
					robot.doSearchAndSelectBox(c.getBasedNation());
					robot.delay(25);
				}
				break;
			case 11:
				if(!c.getNation().isEmpty()) {
					robot.moveMouse(1565, 430);
					robot.clickMouse();
					robot.down();
					robot.pressEnter();
					robot.delay(25);
					robot.doSearchAndSelectBox(c.getContinentalCupNation());
					robot.delay(25);
				}
				break;
			case 12:
				if(!c.getCity().isEmpty()) {
					robot.moveMouse(1565, 460);
					robot.clickMouse();
					robot.down();
					robot.pressEnter();
					robot.delay(25);
					robot.doSearchAndSelectBox(c.getCity());
					robot.delay(25);
				}
				break;
			case 13:
				robot.moveMouse(1561, 550);
				robot.clickMouse();
				for(int i = 0; i < c.getStatus(); i++) {
					robot.down();
				}
				robot.pressEnter();
				break;
			case 14:
				robot.moveMouse(980, 640);
				robot.clickMouse();
				robot.clickMouse();
				robot.selectAll();
				robot.pressDelete();
				robot.keyInput(String.valueOf(c.getMorale()));
				break;
			case 15:
				robot.moveMouse(980, 670);
				robot.clickMouse();
				robot.clickMouse();
				robot.selectAll();
				robot.pressDelete();
				robot.delay(25);
				robot.keyInput(String.valueOf(c.getRep()));
				robot.delay(25);
				break;
			case 16:
				int outcome = 0;
				if(c.getHasReserves() == 1L) {
					if(c.getHasUnder19s() == 1L) {
						outcome = 4;
					} else {
						outcome = 3;
					}
				} else {
					if(c.getHasUnder19s() == 1L) {
						outcome = 2;
					} else {
						outcome = 1;
					}
				}
			switch(outcome) {
			case 0:
				break;
			case 1:
				break;
			case 2:
				robot.moveMouse(1354, 808);
				robot.clickMouse();
				robot.moveMouse(419, 800);
				robot.clickMouse();
				robot.down(9);
				robot.pressEnter();
				break;
			case 3:
				robot.moveMouse(1354, 808);
				robot.clickMouse();
				robot.moveMouse(419, 800);
				robot.clickMouse();
				robot.down(7);
				robot.pressEnter();
				break;
			case 4:
				robot.moveMouse(1354, 808);
				robot.clickMouse();
				robot.moveMouse(1354, 835);
				robot.clickMouse();
				robot.moveMouse(419, 800);
				robot.clickMouse();
				robot.down(7);
				robot.pressEnter();
				robot.moveMouse(419, 824);
				robot.clickMouse();
				robot.down(9);
				robot.pressEnter();
				break;
			}
				break;
			case 17:
				robot.moveMouse(65, 670);
				robot.clickMouse();
				break;
			case 18:
				robot.moveMouse(75, 697);
				robot.clickMouse();
				break;
			case 19:
				robot.moveMouse(360, 160);
				robot.clickMouse();
				break;
			case 20:
				robot.doShirtSelection(
						c.getHomeShirtType(), 
						c.getR1(), 
						c.getG1(), 
						c.getB1(), 
						c.getR2(), 
						c.getG2(), 
						c.getB2(), 
						c.getR3(), 
						c.getG3(), 
						c.getB3());
				break;
			case 21:
				robot.moveMouse(360, 185);
				robot.clickMouse();
				break;
			case 22:
				robot.doIconSelection(
						c.getR1(), 
						c.getG1(), 
						c.getB1(), 
						c.getR2(), 
						c.getG2(), 
						c.getB2(), 
						c.getR3(), 
						c.getG3(), 
						c.getB3());
				break;
			case 23:
				robot.moveMouse(360, 210);
				robot.clickMouse();
				break;
			case 24:
				robot.doTextSelection(
						c.getR1(), 
						c.getG1(), 
						c.getB1(), 
						c.getR2(), 
						c.getG2(), 
						c.getB2(), 
						c.getR3(), 
						c.getG3(), 
						c.getB3());
				break;
			case 25:
				robot.moveMouse(360, 239);
				robot.clickMouse();
				break;
			case 26:
				robot.doShortsSelection(
						c.getHomeShortsType(), 
						c.getR1(), 
						c.getG1(), 
						c.getB1(), 
						c.getR2(), 
						c.getG2(), 
						c.getB2(), 
						c.getR3(), 
						c.getG3(), 
						c.getB3());
				break;
			case 27:
				robot.moveMouse(360, 265);
				robot.clickMouse();
				break;
			case 28:
				robot.doSocksSelection(
						c.getHomeSocksType(), 
						c.getR1(), 
						c.getG1(), 
						c.getB1(), 
						c.getR2(), 
						c.getG2(), 
						c.getB2(), 
						c.getR3(), 
						c.getG3(), 
						c.getB3());
				break;
			case 29:
				robot.moveMouse(75, 731);
				robot.clickMouse();
				break;
			case 30:
				robot.doShirtSelection(
						c.getAwayShirtType(), 
						c.getAr1(), 
						c.getAg1(), 
						c.getAb1(), 
						c.getAr2(), 
						c.getAg2(), 
						c.getAb2(), 
						c.getAr3(), 
						c.getAg3(), 
						c.getAb3());
				break;
			case 31:
				robot.doIconSelection(
						c.getAr1(), 
						c.getAg1(), 
						c.getAb1(), 
						c.getAr2(), 
						c.getAg2(), 
						c.getAb2(), 
						c.getAr3(), 
						c.getAg3(), 
						c.getAb3());
				break;
			case 32:
				robot.doTextSelection(
						c.getAr1(), 
						c.getAg1(), 
						c.getAb1(), 
						c.getAr2(), 
						c.getAg2(), 
						c.getAb2(), 
						c.getAr3(), 
						c.getAg3(), 
						c.getAb3());
				break;
			case 33:
				robot.doShortsSelection(
						c.getAwayShortsType(), 
						c.getAr1(), 
						c.getAg1(), 
						c.getAb1(), 
						c.getAr2(), 
						c.getAg2(), 
						c.getAb2(), 
						c.getAr3(), 
						c.getAg3(), 
						c.getAb3());
				break;
			case 34:
				robot.doSocksSelection(
						c.getAwaySocksType(), 
						c.getAr1(), 
						c.getAg1(), 
						c.getAb1(), 
						c.getAr2(), 
						c.getAg2(), 
						c.getAb2(), 
						c.getAr3(), 
						c.getAg3(), 
						c.getAb3());
				break;
			case 35:
				robot.moveMouse(27, 670);
				robot.clickMouse();
				break;
			case 36:
				robot.moveMouse(76, 544);
				robot.delay(50);
				robot.clickMouse();
				robot.delay(50);
				robot.clickMouse();
				robot.clickMouse();
				robot.delay(150);
				break;
			case 37:
				if(!c.getCompetition().isEmpty()) {
					robot.moveMouse(1565, 129);
					robot.clickMouse();
					robot.down();
					robot.pressEnter();
					robot.doSearchAndSelectBox(c.getCompetition());
				}
				break;
			case 38:
				robot.moveMouse(27, 544);
				robot.delay(50);
				robot.clickMouse();
				break;
			case 39:
				robot.moveMouse(1559, 470);
				robot.clickMouse();
				robot.clickMouse();
				break;
			case 40:
				robot.moveMouse(63, 422);
				robot.delay(50);
				robot.clickMouse();
				break;
			case 41:
				robot.moveMouse(75, 762);
				robot.delay(50);
				robot.clickMouse();
				break;
			case 42:
				robot.moveMouse(1557, 470);
				robot.delay(50);
				robot.clickMouse();
				break;
			case 43:
				robot.moveMouse(1367, 470);
				robot.delay(50);
				robot.clickMouse();
				break;
			case 44:
				robot.doShirtSelection(
						c.getThirdShirtType(), 
						c.getR1(), 
						c.getG1(), 
						c.getB1(), 
						c.getR3(), 
						c.getG3(), 
						c.getB3(), 
						c.getR2(), 
						c.getG2(), 
						c.getB2());
				break;
			case 47:
				robot.doIconSelection(
						c.getR1(), 
						c.getG1(), 
						c.getB1(), 
						c.getR3(), 
						c.getG3(), 
						c.getB3(), 
						c.getR2(), 
						c.getG2(), 
						c.getB2());
				break;
			case 48:
				robot.doTextSelection(
						c.getR1(), 
						c.getG1(), 
						c.getB1(), 
						c.getR3(), 
						c.getG3(), 
						c.getB3(), 
						c.getR2(), 
						c.getG2(), 
						c.getB2());
				break;
			case 45:
				robot.doShortsSelection(
						c.getThirdShortsType(), 
						c.getR1(), 
						c.getG1(), 
						c.getB1(), 
						c.getR3(), 
						c.getG3(), 
						c.getB3(), 
						c.getR2(), 
						c.getG2(), 
						c.getB2());
				break;
			case 46:
				robot.doSocksSelection(
						c.getThirdSocksType(),  
						c.getR1(), 
						c.getG1(), 
						c.getB1(), 
						c.getR3(), 
						c.getG3(), 
						c.getB3(), 
						c.getR2(), 
						c.getG2(), 
						c.getB2());
				break;
			case 49:
				robot.moveMouse(87, 610);
				robot.delay(50);
				robot.clickMouse();
				robot.delay(150);
				break;
			case 50:
				robot.moveMouse(969, 130);
				robot.delay(50);
				robot.clickMouse();
				robot.clickMouse();
				robot.selectAll();
				robot.pressDelete();
				robot.keyInput(String.valueOf(c.getFanLoyalty()));
				break;
			case 51:
				robot.moveMouse(969, 160);
				robot.delay(50);
				robot.clickMouse();
				robot.clickMouse();
				robot.selectAll();
				robot.pressDelete();
				robot.keyInput(String.valueOf(c.getFanPassion()));
				break;
			case 52:
				robot.moveMouse(969, 190);
				robot.delay(50);
				robot.clickMouse();
				robot.clickMouse();
				robot.selectAll();
				robot.pressDelete();
				robot.keyInput(String.valueOf(c.getFanPatience()));
				break;
			case 53:
				robot.moveMouse(969, 220);
				robot.delay(50);
				robot.clickMouse();
				robot.clickMouse();
				robot.selectAll();
				robot.pressDelete();
				robot.keyInput(String.valueOf(c.getFanAffluence()));
				break;
			case 54:
				robot.moveMouse(969, 250);
				robot.delay(50);
				robot.clickMouse();
				robot.clickMouse();
				robot.selectAll();
				robot.pressDelete();
				robot.keyInput(String.valueOf(c.getFanTemperament()));
				break;
			case 55:
				robot.moveMouse(72, 514);
				robot.delay(50);
				robot.clickMouse();
				robot.delay(50);
				robot.clickMouse();
				robot.delay(150);
				break;
			case 56:
				robot.moveMouse(979, 129);
				robot.delay(50);
				robot.clickMouse();
				robot.delay(50);
				robot.clickMouse();
				robot.delay(50);
				robot.selectAll();
				robot.delay(50);
				robot.pressDelete();
				robot.delay(50);
				robot.keyInput(String.valueOf(c.getBalance()));
				robot.delay(50);
				break;
			case 57:
				robot.moveMouse(335, 158);
				robot.delay(50);
				robot.clickMouse();
				robot.delay(50);
				robot.moveMouse(980, 160);
				robot.delay(50);
				robot.clickMouse();
				robot.delay(50);
				robot.clickMouse();
				robot.delay(50);
				robot.selectAll();
				robot.delay(50);
				robot.pressDelete();
				robot.delay(50);
				robot.keyInput(String.valueOf(c.getTransfer()));
				robot.delay(50);
				break;
			case 58:
				robot.moveMouse(979, 461);
				robot.delay(50);
				robot.clickMouse();
				robot.delay(50);
				robot.clickMouse();
				robot.delay(50);
				robot.selectAll();
				robot.delay(50);
				robot.pressDelete();
				robot.delay(50);
				robot.keyInput(String.valueOf(c.getSeasonTickets()));
				robot.delay(50);
				break;
			case 59:
				robot.moveMouse(27, 516);
				robot.delay(50);
				robot.clickMouse();
				robot.delay(50);
				robot.clickMouse();
				robot.delay(50);
				break;
			case 60:
				robot.moveMouse(1585, 112);
				robot.delay(50);
				robot.clickMouse();
				robot.clickMouse();
			case 61:
				if(c.isHasThirdKit()) {
					// Was 41
					robot.moveMouse(75, 762);
					robot.delay(50);
					robot.clickMouse();
					// Was 42
					robot.moveMouse(1557, 470);
					robot.delay(50);
					robot.clickMouse();
					// Was 43
					for(int i = 0; i < 5; i++) {
						robot.moveMouse(1367, 470);
						robot.delay(50);
						robot.clickMouse();
					}
					// Was 19
					robot.moveMouse(360, 160);
					robot.clickMouse();
					// Was 44
					robot.doShirtSelection(
							c.getThirdShirtType(), 
							c.getR1(), 
							c.getG1(), 
							c.getB1(), 
							c.getR3(), 
							c.getG3(), 
							c.getB3(), 
							c.getR2(), 
							c.getG2(), 
							c.getB2());
					// Was 21
					robot.moveMouse(360, 185);
					robot.clickMouse();
					// Was 45
					robot.doShortsSelection(
							c.getThirdShortsType(), 
							c.getR1(), 
							c.getG1(), 
							c.getB1(), 
							c.getR3(), 
							c.getG3(), 
							c.getB3(), 
							c.getR2(), 
							c.getG2(), 
							c.getB2());
					// Was 23
					robot.moveMouse(360, 210);
					robot.clickMouse();
					// Was 46
					robot.doSocksSelection(
							c.getThirdSocksType(),  
							c.getR1(), 
							c.getG1(), 
							c.getB1(), 
							c.getR3(), 
							c.getG3(), 
							c.getB3(), 
							c.getR2(), 
							c.getG2(), 
							c.getB2());
					// Was 25
					robot.moveMouse(360, 239);
					robot.clickMouse();
					// Was 47
					robot.doIconSelection(
							c.getR1(), 
							c.getG1(), 
							c.getB1(), 
							c.getR3(), 
							c.getG3(), 
							c.getB3(), 
							c.getR2(), 
							c.getG2(), 
							c.getB2());
					// Was 27
					robot.moveMouse(360, 265);
					robot.clickMouse();
					// Was 48
					robot.doTextSelection(
							c.getR1(), 
							c.getG1(), 
							c.getB1(), 
							c.getR3(), 
							c.getG3(), 
							c.getB3(), 
							c.getR2(), 
							c.getG2(), 
							c.getB2());
					break;
				}
			}
		}
	}
	
	

	@Override
	public void readObject(String filename, boolean test, int numberToLoad, String nation, boolean isSkeleton) {
		List<Club> clubs = new ArrayList<Club>();
		Long fails = 0L;
		Long passes = 0L;
		Path path = Paths.get(filename);
		try (Scanner scanner =  new Scanner(path, StandardCharsets.UTF_8.name())) {
			while (scanner.hasNextLine()){
				String nextLine = scanner.nextLine();
				String[] lineSplit = nextLine.split(",");
				if(lineSplit.length>1 && (lineSplit[6].equals(nation) || nation.isEmpty())) {
					for(int i = 0; i < lineSplit.length; i++) {
						System.out.print(lineSplit[i] + ",");
					}
					System.out.println("#");
					Club club = new Club();
					club.setName(lineSplit[0]);
					club.setShortName(lineSplit[1]);
					club.setSixLetterName(lineSplit[2]);
					club.setNickname(lineSplit[3]);
					club.setSecondNickname(lineSplit[4]);
					club.setNation(lineSplit[5]);
					club.setBasedNation(lineSplit[6]);
					club.setContinentalCupNation(lineSplit[7]);
					club.setCity(lineSplit[8]);
					club.setStatus(Long.valueOf(lineSplit[9]));
					club.setMorale(Long.valueOf(lineSplit[10]));
					club.setRep(Long.valueOf(lineSplit[11]));
					club.setStadium(lineSplit[12]);
					club.setTraining(Long.valueOf(lineSplit[13]));
					club.setYouthCoaching(Long.valueOf(lineSplit[14]));
					club.setYouthFacilities(Long.valueOf(lineSplit[15]));
					club.setYouthRecruitment(Long.valueOf(lineSplit[16]));
					club.setR1(Long.valueOf(lineSplit[17]));
					club.setG1(Long.valueOf(lineSplit[18]));
					club.setB1(Long.valueOf(lineSplit[19]));
					club.setR2(Long.valueOf(lineSplit[20]));
					club.setG2(Long.valueOf(lineSplit[21]));
					club.setB2(Long.valueOf(lineSplit[22]));
					club.setR3(Long.valueOf(lineSplit[23]));
					club.setG3(Long.valueOf(lineSplit[24]));
					club.setB3(Long.valueOf(lineSplit[25]));
					club.setHomeShirtType(Long.valueOf(lineSplit[26]));
					club.setHomeShortsType(Long.valueOf(lineSplit[27]));
					club.setHomeSocksType(Long.valueOf(lineSplit[28]));
					club.setAwayShirtType(Long.valueOf(lineSplit[29]));
					club.setAwayShortsType(Long.valueOf(lineSplit[30]));
					club.setAwaySocksType(Long.valueOf(lineSplit[31]));
					club.setThirdShirtType(Long.valueOf(lineSplit[32]));
					if(club.getThirdShirtType() == -1L) {
						club.setHasThirdKit(false);
					}
					club.setThirdShortsType(Long.valueOf(lineSplit[33]));
					club.setThirdSocksType(Long.valueOf(lineSplit[34]));
					club.setCompetition(lineSplit[36]);
					club.setHasReserves(Long.valueOf(lineSplit[37]));
					club.setHasUnder19s(Long.valueOf(lineSplit[38]));
					if(!lineSplit[39].isEmpty()) {
						club.setMinimumAge(Long.valueOf(lineSplit[39]));
					}
					if(!lineSplit[40].isEmpty()) {
						club.setMaximumAge(Long.valueOf(lineSplit[40]));
					}
					club.setBalance(new BigDecimal(lineSplit[41]));
					club.setTransfer(new BigDecimal(lineSplit[42]));
					//club.setWages(new BigDecimal(lineSplit[43]));
					club.setSeasonTickets(Long.valueOf(lineSplit[44]));
					club.setFanLoyalty(Long.valueOf(lineSplit[45]));
					club.setFanPassion(Long.valueOf(lineSplit[46]));
					club.setFanPatience(Long.valueOf(lineSplit[47]));
					club.setFanAffluence(Long.valueOf(lineSplit[48]));
					club.setFanTemperament(Long.valueOf(lineSplit[49]));
					club.setAr1(Long.valueOf(lineSplit[50]));
					club.setAb1(Long.valueOf(lineSplit[51]));
					club.setAg1(Long.valueOf(lineSplit[52]));
					club.setAr2(Long.valueOf(lineSplit[53]));
					club.setAb2(Long.valueOf(lineSplit[54]));
					club.setAg2(Long.valueOf(lineSplit[55]));
					club.setAr3(Long.valueOf(lineSplit[56]));
					club.setAb3(Long.valueOf(lineSplit[57]));
					club.setAg3(Long.valueOf(lineSplit[58]));
			
					clubs.add(club);
					passes++;
				}
			}      
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			fails++;
		}
		System.out.println("== Finished building clubs - " + passes + " passed / " + fails + " fails");
		if(!test) {
			int i = 0;
			if(numberToLoad == -2) {
				int random = (int) (Math.random()*(clubs.size()-1));
				if(isSkeleton) {
					doObjectActionFile("C:\\Users\\Chris\\Documents\\Coding\\auto-input\\src\\com\\autoinput\\resources\\create_club_skeleton.txt", clubs.get(random));
				} else {
					doObjectActionFile("C:\\Users\\Chris\\Documents\\Coding\\auto-input\\src\\com\\autoinput\\resources\\create_club_test_new.txt", clubs.get(random));
				}
				i++;
				printLogMsg("Finished running for " + clubs.get(random).getName());
			} else {
				for(Club c : clubs) {
					if(numberToLoad > i || numberToLoad == -1) {
						if(isSkeleton) {
							doObjectActionFile("C:\\Users\\Chris\\Documents\\Coding\\auto-input\\src\\com\\autoinput\\resources\\create_club_skeleton.txt", c);
						} else {
							doObjectActionFile("C:\\Users\\Chris\\Documents\\Coding\\auto-input\\src\\com\\autoinput\\resources\\create_club_test_new.txt", c);
						}
						i++;
						printLogMsg("Finished running for " + c.getName());
						robot.delay(5000);
					}
				}
			}
			robot.delay(5000);
		}
	}

	@Override
	public void buildObject(String input, boolean test, String nation) {
		String[] lineSplit = input.split(",");
		if(lineSplit.length>1 && (lineSplit[6].equals(nation) || nation.isEmpty())) {
			for(int i = 0; i < lineSplit.length; i++) {
				System.out.print(lineSplit[i] + ",");
			}
			System.out.println("#");
			Club club = new Club();
			club.setName(lineSplit[0]);
			club.setShortName(lineSplit[1]);
			club.setSixLetterName(lineSplit[2]);
			club.setNickname(lineSplit[3]);
			club.setSecondNickname(lineSplit[4]);
			club.setNation(lineSplit[5]);
			club.setBasedNation(lineSplit[6]);
			club.setContinentalCupNation(lineSplit[7]);
			club.setCity(lineSplit[8]);
			club.setStatus(Long.valueOf(lineSplit[9]));
			club.setMorale(Long.valueOf(lineSplit[10]));
			club.setRep(Long.valueOf(lineSplit[11]));
			club.setStadium(lineSplit[12]);
			club.setTraining(Long.valueOf(lineSplit[13]));
			club.setYouthCoaching(Long.valueOf(lineSplit[14]));
			club.setYouthFacilities(Long.valueOf(lineSplit[15]));
			club.setYouthRecruitment(Long.valueOf(lineSplit[16]));
			club.setR1(Long.valueOf(lineSplit[17]));
			club.setG1(Long.valueOf(lineSplit[18]));
			club.setB1(Long.valueOf(lineSplit[19]));
			club.setR2(Long.valueOf(lineSplit[20]));
			club.setG2(Long.valueOf(lineSplit[21]));
			club.setB2(Long.valueOf(lineSplit[22]));
			club.setR3(Long.valueOf(lineSplit[23]));
			club.setG3(Long.valueOf(lineSplit[24]));
			club.setB3(Long.valueOf(lineSplit[25]));
			club.setHomeShirtType(Long.valueOf(lineSplit[26]));
			club.setHomeShortsType(Long.valueOf(lineSplit[27]));
			club.setHomeSocksType(Long.valueOf(lineSplit[28]));
			club.setAwayShirtType(Long.valueOf(lineSplit[29]));
			club.setAwayShortsType(Long.valueOf(lineSplit[30]));
			club.setAwaySocksType(Long.valueOf(lineSplit[31]));
			club.setThirdShirtType(Long.valueOf(lineSplit[32]));
			if(club.getThirdShirtType() == -1L) {
				club.setHasThirdKit(false);
			}
			club.setThirdShortsType(Long.valueOf(lineSplit[33]));
			club.setThirdSocksType(Long.valueOf(lineSplit[34]));
			club.setCompetition(lineSplit[36]);
			club.setHasReserves(Long.valueOf(lineSplit[37]));
			club.setHasUnder19s(Long.valueOf(lineSplit[38]));
			if(!lineSplit[39].isEmpty()) {
				club.setMinimumAge(Long.valueOf(lineSplit[39]));
			}
			if(!lineSplit[40].isEmpty()) {
				club.setMaximumAge(Long.valueOf(lineSplit[40]));
			}
			club.setBalance(new BigDecimal(lineSplit[41]));
			club.setTransfer(new BigDecimal(lineSplit[42]));
			//club.setWages(new BigDecimal(lineSplit[43]));
			club.setSeasonTickets(Long.valueOf(lineSplit[44]));
			club.setFanLoyalty(Long.valueOf(lineSplit[45]));
			club.setFanPassion(Long.valueOf(lineSplit[46]));
			club.setFanPatience(Long.valueOf(lineSplit[47]));
			club.setFanAffluence(Long.valueOf(lineSplit[48]));
			club.setFanTemperament(Long.valueOf(lineSplit[49]));
			club.setAr1(Long.valueOf(lineSplit[50]));
			club.setAb1(Long.valueOf(lineSplit[51]));
			club.setAg1(Long.valueOf(lineSplit[52]));
			club.setAr2(Long.valueOf(lineSplit[53]));
			club.setAb2(Long.valueOf(lineSplit[54]));
			club.setAg2(Long.valueOf(lineSplit[55]));
			club.setAr3(Long.valueOf(lineSplit[56]));
			club.setAb3(Long.valueOf(lineSplit[57]));
			club.setAg3(Long.valueOf(lineSplit[58]));
			
			if(!test) {
				doObject(club);
			}
			objects.add(club);
		}
	}

	@Override
	public void doObject(Object obj) {
		Club club = (Club)obj;
		
		doObjectActionFile("C:\\Users\\Chris\\Documents\\Coding\\auto-input\\src\\com\\autoinput\\resources\\create_club_test_new.txt", club);
		printLogMsg("Finished running for " + club.getName());
		robot.delay(5000);
	}

	public ArrayList<Club> getObjects() {
		return objects;
	}

	public void setObjects(ArrayList<Club> objects) {
		this.objects = objects;
	}
}
