package com.autoinput.actions.actioners;

import java.awt.AWTException;
import java.awt.event.KeyEvent;
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
import com.autoinput.hibernate.objects.Nation;
import com.autoinput.hibernate.objects.Player;
import com.autoinput.spring.service.AppService;


@ManagedBean(name="playerActioner")
@SessionScoped
public class PlayerActioner extends ObjectActioner {
	
	@ManagedProperty("#{appService}")
	private AppService appService;
	
	EditRobot robot;
	private ArrayList<Player> objects = new ArrayList<Player>();
	private boolean playerBlocker = false;

	public PlayerActioner() {
		try {
			robot = new EditRobot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void doObjectActionFile(String filename, Object obj) {
		Player player = (Player)obj;
		Path path = Paths.get(filename);
		try (Scanner scanner =  new Scanner(path, StandardCharsets.UTF_8.name())){
			while (scanner.hasNextLine()){
				String nextLine = scanner.nextLine();
				String[] lineSplit = nextLine.split("\\t");
				readObjectAction(lineSplit, player);
				robot.delay(100);
			}	
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void readObjectAction(String[] lineData, Object obj) {
		Player p = (Player)obj;
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

	@Override
	public void readObject(String filename, boolean test, int numberToLoad, String nation, boolean skeleton) {
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
					doObjectActionFile("C:\\Users\\Chris\\Documents\\Coding\\auto-input\\src\\resources\\create_player_test.txt", p);
					i++;
				}
			}
		}
	}

	@Override
	public void buildObject(String input, boolean test, String nation) {
		String[] lineSplit = input.split(",");
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
		if(!test) {
			doObject(player);
		}
		objects.add(player);
	}

	@Override
	public void doObject(Object obj) {
		Player player = (Player)obj;

		doObjectActionFile("C:\\Users\\Chris\\Documents\\Coding\\auto-input\\src\\resources\\create_player_test.txt", player);
	}

	public ArrayList<Player> getObjects() {
		return objects;
	}

	public void setObjects(ArrayList<Player> objects) {
		this.objects = objects;
	}

	public AppService getAppService() {
		return appService;
	}

	public void setAppService(AppService appService) {
		this.appService = appService;
	}

}
