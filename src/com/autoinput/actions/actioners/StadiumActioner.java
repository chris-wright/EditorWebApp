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
import com.autoinput.hibernate.objects.Player;
import com.autoinput.hibernate.objects.Stadium;
import com.autoinput.spring.service.AppService;

@ManagedBean(name="stadiumActioner")
@SessionScoped
public class StadiumActioner extends ObjectActioner {
	
	@ManagedProperty("#{appService}")
	private AppService appService;

	EditRobot robot;
	private ArrayList<Stadium> objects = new ArrayList<Stadium>();

	public StadiumActioner() {
		try {
			robot = new EditRobot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void doObjectActionFile(String filename, Object obj) {
		Stadium stadium = (Stadium)obj;
		Path path = Paths.get(filename);
		try (Scanner scanner =  new Scanner(path, StandardCharsets.UTF_8.name())){
			while (scanner.hasNextLine()){
				String nextLine = scanner.nextLine();
				String[] lineSplit = nextLine.split("\\t");
				readObjectAction(lineSplit, stadium);
				robot.delay(100);
			}	
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void readObjectAction(String[] lineData, Object obj) {
		Stadium s = (Stadium)obj;
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
				// Clicking stadium
				robot.moveMouse(76, 883);
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
				robot.moveMouse(981, 190);
				robot.clickMouse();
				robot.selectAll();
				robot.pressDelete();
				robot.keyInput(s.getName());
				break;
			case 5:
				robot.delay(100);
				if(!s.getCity().isEmpty()) {
					robot.moveMouse(1565, 220);
					robot.clickMouse();
					robot.delay(250);
					robot.down();
					robot.pressEnter();
					robot.doSearchAndSelectBox(s.getCity());
				}
				break;
			case 6:
				robot.delay(100);
				if(!s.getOwner().isEmpty()) {
					robot.moveMouse(1565, 280);
					robot.clickMouse();
					robot.delay(250);
					robot.down();
					robot.pressEnter();
					robot.doSearchAndSelectBox(s.getOwner());
				}
				break;
			case 7:
				robot.moveMouse(981, 371);
				robot.clickMouse();
				robot.selectAll();
				robot.pressDelete();
				robot.keyInput(String.valueOf(s.getCapacity()));
				break;
			case 8:
				robot.moveMouse(981, 400);
				robot.clickMouse();
				robot.selectAll();
				robot.pressDelete();
				robot.keyInput(String.valueOf(s.getSeatingCapacity()));
				break;
			case 9:
				robot.moveMouse(981, 460);
				robot.clickMouse();
				robot.selectAll();
				robot.pressDelete();
				robot.keyInput(String.valueOf(s.getExpansionCapacity()));
				break;
			case 10:
				robot.moveMouse(981, 490);
				robot.clickMouse();
				robot.selectAll();
				robot.pressDelete();
				robot.keyInput(String.valueOf(s.getUsedCapacity()));
				break;
			case 11:
				robot.moveMouse(1561, 520);
				robot.clickMouse();
				for(int i = 0; i < s.getPitchType(); i++) {
					robot.down();
				}
				robot.pressEnter();
				break;
			case 12:
				// Page down
				robot.moveMouse(1585, 848);
				robot.clickMouse();
				robot.clickMouse();
				break;
			case 13:
				robot.moveMouse(1561, 573);
				robot.clickMouse();
				for(int i = 0; i < s.getState(); i++) {
					robot.down();
				}
				robot.pressEnter();
				break;
			case 14:
				if(s.getIsCovered() == 1L) {
					robot.moveMouse(977, 750);
					robot.clickMouse();
				}
				break;
			case 15:
				if(s.getRetractRoof() == 1L) {
					robot.moveMouse(977, 780);
					robot.clickMouse();
				}
				break;
			case 16:
				if(s.getUndersoilHeating() == 1L) {
					robot.moveMouse(977, 810);
					robot.clickMouse();
				}
				break;
			case 17:
				// Page up
				robot.moveMouse(1585, 122);
				robot.clickMouse();
				robot.clickMouse();
				break;
			}
		}
	}

	@Override
	public void readObject(String filename, boolean test, int numberToLoad, String nation, boolean skeleton) {
		List<Stadium> stadiums = new ArrayList<Stadium>();
		Long fails = 0L;
		Long passes = 0L;
		Path path = Paths.get(filename);
		try (Scanner scanner =  new Scanner(path, StandardCharsets.UTF_8.name())) {
			while (scanner.hasNextLine()){
				String nextLine = scanner.nextLine();
				String[] lineSplit = nextLine.split(",");
				if(lineSplit[13].equals(nation) || nation.isEmpty()) {
					for(int i = 0; i < lineSplit.length; i++) {
						System.out.print(lineSplit[i] + ",");
					}
					System.out.println("#");
					Stadium stadium = new Stadium();
					stadium.setName(lineSplit[0]);
					stadium.setCity(lineSplit[1]);
					stadium.setCapacity(Long.valueOf(lineSplit[2]));
					stadium.setSeatingCapacity(Long.valueOf(lineSplit[3]));
					stadium.setExpansionCapacity(Long.valueOf(lineSplit[4]));
					stadium.setUsedCapacity(Long.valueOf(lineSplit[5]));
					stadium.setPitchType(Long.valueOf(lineSplit[6]));
					stadium.setPitchCondition(Long.valueOf(lineSplit[7]));
					stadium.setIsCovered(Long.valueOf(lineSplit[8]));
					stadium.setUndersoilHeating(Long.valueOf(lineSplit[9]));
					stadium.setRetractRoof(Long.valueOf(lineSplit[10]));
					stadium.setState(Long.valueOf(lineSplit[11]));
					if(lineSplit.length == 13) {
						stadium.setOwner(lineSplit[12]);
					} else {
						stadium.setOwner("");
					}

					stadiums.add(stadium);
					passes++;
				}
			}      
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			fails++;
		}
		System.out.println("== Finished building stadiums - " + passes + " passed / " + fails + " fails");
		if(!test) {
			int i = 0;
			for(Stadium s : stadiums) {
				if(numberToLoad > i || numberToLoad == -1) {
					doObjectActionFile("C:\\Users\\Chris\\Documents\\Coding\\auto-input\\src\\com\\autoinput\\resources\\create_stadium_test_new.txt", s);
					i++;
					printLogMsg("Finished running for " + s.getName());
				}
			}
		}
	}

	@Override
	public void buildObject(String input, boolean test, String nation) {
		String[] lineSplit = input.split(",");
		if(lineSplit[13].equals(nation) || nation.isEmpty()) {
			for(int i = 0; i < lineSplit.length; i++) {
				System.out.print(lineSplit[i] + ",");
			}
			System.out.println("#");
			Stadium stadium = new Stadium();
			stadium.setName(lineSplit[0]);
			stadium.setCity(lineSplit[1]);
			stadium.setCapacity(Long.valueOf(lineSplit[2]));
			stadium.setSeatingCapacity(Long.valueOf(lineSplit[3]));
			stadium.setExpansionCapacity(Long.valueOf(lineSplit[4]));
			stadium.setUsedCapacity(Long.valueOf(lineSplit[5]));
			stadium.setPitchType(Long.valueOf(lineSplit[6]));
			stadium.setPitchCondition(Long.valueOf(lineSplit[7]));
			stadium.setIsCovered(Long.valueOf(lineSplit[8]));
			stadium.setUndersoilHeating(Long.valueOf(lineSplit[9]));
			stadium.setRetractRoof(Long.valueOf(lineSplit[10]));
			stadium.setState(Long.valueOf(lineSplit[11]));
			if(lineSplit.length == 13) {
				stadium.setOwner(lineSplit[12]);
			} else {
				stadium.setOwner("");
			}
			if(!test){
				doObject(stadium);
			}
			objects.add(stadium);
		}
	}

	@Override
	public void doObject(Object obj) {
		Stadium stadium = (Stadium)obj;

		doObjectActionFile("C:\\Users\\Chris\\Documents\\Coding\\auto-input\\src\\com\\autoinput\\resources\\create_stadium_test_new.txt", stadium);
		printLogMsg("Finished running for " + stadium.getName());
	}

	public ArrayList<Stadium> getObjects() {
		return objects;
	}

	public void setObjects(ArrayList<Stadium> objects) {
		this.objects = objects;
	}

	public AppService getAppService() {
		return appService;
	}

	public void setAppService(AppService appService) {
		this.appService = appService;
	}

}
