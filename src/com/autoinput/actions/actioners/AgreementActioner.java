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
import com.autoinput.hibernate.objects.City;
import com.autoinput.spring.service.AppService;


@ManagedBean(name="agreementActioner")
@SessionScoped
public class AgreementActioner extends ObjectActioner {
	
	@ManagedProperty("#{appService}")
	private AppService appService;

	EditRobot robot;
	private ArrayList<Agreement> objects = new ArrayList<Agreement>();
	
	public AgreementActioner() {
		try {
			robot = new EditRobot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void doObjectActionFile(String filename, Object obj) {
		Agreement agreement = (Agreement)obj;
		Path path = Paths.get(filename);
		try (Scanner scanner =  new Scanner(path, StandardCharsets.UTF_8.name())){
			while (scanner.hasNextLine()){
				String nextLine = scanner.nextLine();
				String[] lineSplit = nextLine.split("\\t");
				readObjectAction(lineSplit, agreement);
				robot.delay(100);
			}	
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void readObjectAction(String[] lineSplit, Object obj) {
		Agreement a = (Agreement)obj;
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
				robot.moveMouse(82, 423);
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
				robot.moveMouse(971, 190);
				robot.clickMouse();
				robot.selectAll();
				robot.pressDelete();
				robot.keyInput(a.getName());
				break;
			case 5:
				int i = 0;
				for(String nation : a.getNations()) {
					if(!a.getNations().isEmpty()) {
						robot.moveMouse(1390, 277+(i*25));
						robot.clickMouse();
						robot.doSearchAndSelectBox(nation);
						i++;
					}
				}
				break;
			}
		}
	}

	@Override
	public void readObject(String filename, boolean test, int numberToLoad, String nation, boolean skeleton) {
		Long fails = 0L;
		Long passes = 0L;
		Path path = Paths.get(filename);
		List<Agreement> agreements = new ArrayList<Agreement>();
		try (Scanner scanner =  new Scanner(path, StandardCharsets.UTF_8.name())) {
			while (scanner.hasNextLine()){
				String nextLine = scanner.nextLine();
				String[] lineSplit = nextLine.split(",");
				for(int i = 0; i < lineSplit.length; i++) {
					System.out.print(lineSplit[i] + ",");
				}
				Agreement a = new Agreement();
				a.setName(lineSplit[0]);
				for(int j = 1; j < lineSplit.length; j++) {
					a.addNation(lineSplit[j]);
				}
				System.out.println("#");
				agreements.add(a);
				passes++;
			}      
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			fails++;
		}
		System.out.println("== Finished building agreements - " + passes + " passed / " + fails + " fails");
		if(!test) {
			int i = 0;
			for(Agreement a : agreements) {
				if(numberToLoad > i || numberToLoad == -1) {
					doObjectActionFile("C:\\Users\\Chris\\Documents\\Coding\\auto-input\\src\\com\\autoinput\\resources\\create_agreement.txt", a);
					i++;
					printLogMsg("Finished running for " + a.getName());
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
		Agreement a = new Agreement();
		a.setName(lineSplit[0]);
		for(int j = 1; j < lineSplit.length; j++) {
			a.addNation(lineSplit[j]);
		}
		System.out.println("#");
		if(!test) {
			doObject(a);
		}
		objects.add(a);
	}

	@Override
	public void doObject(Object obj) {
		Agreement agreement = (Agreement)obj;

		doObjectActionFile("C:\\Users\\Chris\\Documents\\Coding\\auto-input\\src\\com\\autoinput\\resources\\create_agreement.txt", agreement);
		printLogMsg("Finished running for " + agreement.getName());
	}

	public ArrayList<Agreement> getObjects() {
		return objects;
	}

	public void setObjects(ArrayList<Agreement> objects) {
		this.objects = objects;
	}

	public AppService getAppService() {
		return appService;
	}

	public void setAppService(AppService appService) {
		this.appService = appService;
	}
}
