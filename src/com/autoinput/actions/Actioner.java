package com.autoinput.actions;

import java.awt.AWTException;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.autoinput.hibernate.objects.Agreement;
import com.autoinput.hibernate.objects.City;
import com.autoinput.hibernate.objects.Club;
import com.autoinput.hibernate.objects.Competition;
import com.autoinput.hibernate.objects.Continent;
import com.autoinput.hibernate.objects.Nation;
import com.autoinput.hibernate.objects.Player;
import com.autoinput.hibernate.objects.Stadium;

public class Actioner {

	EditRobot robot;
	private boolean playerBlocker = false;
	private boolean competitionBlocker = false;

	public Actioner() {
		try {
			robot = new EditRobot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}
	
	public void readEditNation(String filename, boolean test) {
		Long fails = 0L;
		Long passes = 0L;
		Path path = Paths.get(filename);
		try (Scanner scanner =  new Scanner(path, StandardCharsets.UTF_8.name())) {
			while (scanner.hasNextLine()){
				String nextLine = scanner.nextLine();
				String[] lineSplit = nextLine.split(",");
				for(int i = 0; i < lineSplit.length; i++) {
					System.out.print(lineSplit[i] + ",");
				}
				System.out.println("#");
				if(!test) {
					editNation(lineSplit);
				}
				passes++;
			}      
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			fails++;
		}
	}
	
	public void editNation(String[] data) {
		switch(Integer.valueOf(data[1])) {
		case 1:
			doNationEditActionFile("C:\\Users\\Chris\\Documents\\Coding\\auto-input\\src\\resources\\edit_nation_test.txt", data);
			break;
			
		}
	}

	public void doNationEditActionFile(String filename, String[] data) {
		Path path = Paths.get(filename);
		try (Scanner scanner =  new Scanner(path, StandardCharsets.UTF_8.name())){
			while (scanner.hasNextLine()){
				String nextLine = scanner.nextLine();
				String[] lineSplit = nextLine.split("\\t");
				readNationEditAction(lineSplit, data);
				robot.delay(200);
			}	
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void readNationEditAction(String[] lineData, String[] data) {
		for(int i = 0; i < lineData.length; i++) {
			System.out.print(lineData[i] + ",");	
		}
		System.out.println("#");
		if(lineData.length == 1) {
			System.out.println("BREAK");
		} else {
			switch(Integer.valueOf(lineData[0])) {
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
				robot.keyInput(data[0]);
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
			case 10:
				if(!data[2].isEmpty()) {
					robot.moveMouse(1572, 348);
					robot.clickMouse();
					robot.down();
					robot.pressEnter();
					robot.doSearchAndSelectBox(data[2]);
				} else {
					robot.moveMouse(1572, 348);
					robot.clickMouse();
					robot.down();
					robot.down();
					robot.pressEnter();
				}
				break;
			}
		}
	}

	public void readPlayers(String filename, boolean test, int numberToLoad) {
		List<Player> players = new ArrayList<Player>();
		Long fails = 0L;
		Long passes = 0L;
		Path path = Paths.get(filename);
		try (Scanner scanner =  new Scanner(path, StandardCharsets.UTF_8.name())) {
			while (scanner.hasNextLine()){
				String nextLine = scanner.nextLine();
				String[] lineSplit = nextLine.split(",");
				for(int i = 0; i < lineSplit.length; i++) {
					System.out.print(lineSplit[i] + ",");
				}
				System.out.println("#");
				Player player = new Player();
				player.setFirstName(lineSplit[0]);
				player.setSecondName(lineSplit[1]);
				player.setNation(lineSplit[2]);
				player.setCa(Long.valueOf(lineSplit[3]));
				player.setPa(Long.valueOf(lineSplit[4]));
				player.setDob(lineSplit[5]);
				player.setCurrentRep(Long.valueOf(lineSplit[6]));
				player.setHomeRep(Long.valueOf(lineSplit[7]));
				player.setWorldRep(Long.valueOf(lineSplit[8]));
				player.setHeight(Long.valueOf(lineSplit[9]));
				player.setWeight(Long.valueOf(lineSplit[10]));
				player.setLeftFoot(Long.valueOf(lineSplit[11]));
				player.setRightFoot(Long.valueOf(lineSplit[12]));   
				player.setCity(lineSplit[13]);
				player.setPersonType(Long.valueOf(lineSplit[14]));
				player.setEthnicity(Long.valueOf(lineSplit[15]));
				player.setHairColour(Long.valueOf(lineSplit[16]));
				player.setSkintone(Long.valueOf(lineSplit[17]));
				player.setAdaptibility(Long.valueOf(lineSplit[18]));
				player.setAmbition(Long.valueOf(lineSplit[19]));
				player.setControversy(Long.valueOf(lineSplit[20]));
				player.setLoyalty(Long.valueOf(lineSplit[21]));
				player.setPressure(Long.valueOf(lineSplit[22]));
				player.setProfessionalism(Long.valueOf(lineSplit[23]));
				player.setSportsmanship(Long.valueOf(lineSplit[24]));
				player.setTemperament(Long.valueOf(lineSplit[25]));
				player.setClub(lineSplit[26]);
				players.add(player);
				passes++;
			}      
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			fails++;
		}
		System.out.println("== Finished building players - " + passes + " passed / " + fails + " fails");
		if(!test) {
			int i = 0;
			for(Player p : players) {
				if(numberToLoad > i || numberToLoad == -1) {
					doPlayerActionFile("C:\\Users\\Chris\\Documents\\Coding\\auto-input\\src\\resources\\create_player_test.txt", p);
					i++;
				}
			}
		}
	}
	
	public void doPlayerActionFile(String filename, Player player) {
		Path path = Paths.get(filename);
		try (Scanner scanner =  new Scanner(path, StandardCharsets.UTF_8.name())){
			while (scanner.hasNextLine()){
				String nextLine = scanner.nextLine();
				String[] lineSplit = nextLine.split("\\t");
				readPlayerAction(lineSplit, player);
				robot.delay(100);
			}	
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void readPlayerAction(String[] lineData, Player p) {
		if(lineData.length == 1) {
			System.out.println("BREAK");
		} else {
			if(!playerBlocker || (34 == Integer.valueOf(lineData[0]))) {
				switch(Integer.valueOf(lineData[0])) {
				case 1:
					robot.moveMouse(Integer.valueOf(lineData[2]), Integer.valueOf(lineData[3]));
					break;
				case 2:
					robot.clickMouse();
					break;
				case 3:
					robot.keyInput(p.getFirstName());
					break;
				case 4:

					robot.keyPress(KeyEvent.VK_TAB);
					robot.keyRelease(KeyEvent.VK_TAB);
					break;
				case 5:
					robot.keyInput(p.getSecondName())
					;
					break;
				case 6:
					for(int i = 0; i < p.getPersonType(); i++) {
						robot.keyPress(
								KeyEvent.VK_DOWN);
						robot.keyRelease(KeyEvent.VK_DOWN);
					}
					break;
				case 7:
					robot.keyPress(KeyEvent.VK_ENTER);
					robot.keyRelease(KeyEvent.VK_ENTER);
					break;
				case 8:
					robot.keyInput(p.getDob().toString());
					break;
				case 9:	
					robot.keyInput(p.getNation());
					robot.keyPress(KeyEvent.VK_ENTER);
					robot.keyRelease(KeyEvent.VK_ENTER);
					robot.delay(500);
					break;
				case 10:
					robot.keyInput(p.getCa().toString());
					break;
				case 11:
					robot.keyInput(p.getPa().toString());
					break;
				case 12:
					robot.keyPress(KeyEvent.VK_CONTROL);
					robot.keyPress(KeyEvent.VK_A);
					robot.keyRelease(KeyEvent.VK_A);
					robot.keyRelease(KeyEvent.VK_CONTROL);
					break;
				case 13:
					robot.keyPress(KeyEvent.VK_DELETE);
					robot.keyRelease(KeyEvent.VK_DELETE);
					break;
				case 14:
					robot.keyInput(String.valueOf(p.getCurrentRep()));
					break;
				case 15:
					robot.keyInput(String.valueOf(p.getHomeRep()));
					break;
				case 16:
					robot.keyInput(String.valueOf(p.getWorldRep()));
					break;
				case 17:
					robot.keyInput(String.valueOf(p.getHeight()));
					break;
				case 18:
					robot.keyInput(String.valueOf(p.getWeight()));
					break;
				case 19:
					robot.keyInput(String.valueOf(p.getLeftFoot()));
					break;
				case 20:
					robot.keyInput(String.valueOf(p.getRightFoot()));
					break;
				case 21:
					robot.keyInput(p.getCity());
					robot.keyPress(KeyEvent.VK_ENTER);
					robot.keyRelease(KeyEvent.VK_ENTER);
					robot.delay(500);
					break;
				case 22:
					for(int i = 0; i < p.getEthnicity(); i++) {
						robot.keyPress(KeyEvent.VK_DOWN);
						robot.keyRelease(KeyEvent.VK_DOWN);
					}
					break;
				case 23:
					for(int i = 0; i < p.getHairColour(); i++) {
						robot.keyPress(KeyEvent.VK_DOWN);
						robot.keyRelease(KeyEvent.VK_DOWN);
					}
					break;
				case 24:
					for(int i = 0; i < p.getSkintone(); i++) {
						robot.keyPress(KeyEvent.VK_DOWN);
						robot.keyRelease(KeyEvent.VK_DOWN);
					}
					break;
				case 25:
					robot.keyInput(String.valueOf(p.getAdaptibility()));
					break;
				case 26:
					robot.keyInput(String.valueOf(p.getAmbition()));
					break;
				case 27:
					robot.keyInput(String.valueOf(p.getControversy()));
					break;
				case 28:
					robot.keyInput(String.valueOf(p.getLoyalty()));
					break;
				case 29:
					robot.keyInput(String.valueOf(p.getPressure()));
					break;
				case 30:
					robot.keyInput(String.valueOf(p.getProfessionalism()));
					break;
				case 31:
					robot.keyInput(String.valueOf(p.getSportsmanship()));
					break;
				case 32:
					robot.keyInput(String.valueOf(p.getTemperament()));
					break;
				case 33:
					robot.keyInput(String.valueOf(p.getClub()));
					robot.keyPress(KeyEvent.VK_ENTER);
					robot.keyRelease(KeyEvent.VK_ENTER);
					robot.delay(500);
					break;
				case 34:
					if(lineData[2].equals("ON") && p.getClub().isEmpty()) {
						playerBlocker = true;
					} else if(lineData[2].equals("OFF")) {
						playerBlocker = false;
					}
					break;
				case 35:
					for(int i = 0; i < Long.valueOf(lineData[2]); i++) {
						robot.keyPress(KeyEvent.VK_UP);
						robot.keyRelease(KeyEvent.VK_UP);
					}
					break;
				}
			}
		}
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
