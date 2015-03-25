package com.autoinput.actions.actioners;

import java.awt.AWTException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.CellEditEvent;

import com.autoinput.actions.EditRobot;
import com.autoinput.hibernate.objects.City;
import com.autoinput.spring.service.AppService;



@ManagedBean(name="cityActioner")
@SessionScoped
public class CityActioner extends ObjectActioner {
	
	@ManagedProperty("#{appService}")
	private AppService appService;

	EditRobot robot;
	private ArrayList<City> objects = new ArrayList<City>();
	
	public CityActioner() {
		try {
			robot = new EditRobot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}
	
	public void delete(City city) {
		appService.deleteCity(city);
	}

	@Override
	public void readObject(String filename, boolean test, int numberToLoad, String nation, boolean skeleton) {
		List<City> cities = new ArrayList<City>();
		Long fails = 0L;
		Long passes = 0L;
		Path path = Paths.get(filename);
		try (Scanner scanner =  new Scanner(path, StandardCharsets.UTF_8.name())) {
			while (scanner.hasNextLine()){
				String nextLine = scanner.nextLine();
				String[] lineSplit = nextLine.split(",");
				if(lineSplit[1].equals(nation) || nation.isEmpty()) {
					for(int i = 0; i < lineSplit.length; i++) {
						System.out.print(lineSplit[i] + ",");
					}
					System.out.println("#");
					City city = new City();
					city.setName(lineSplit[0]);
					city.setNation(lineSplit[1]);
					city.setLanguage(lineSplit[2]);
					city.setLocalRegion(lineSplit[3]);
					city.setAttraction(Long.valueOf(lineSplit[4]));
					city.setInhabitantsRange(Long.valueOf(lineSplit[5]));
					city.setCitizenDescription(lineSplit[6]);
					city.setLatitude(lineSplit[7]);
					city.setLongitude(lineSplit[8]);
					city.setAltitude(Long.valueOf(lineSplit[9]));
					city.setWeather(lineSplit[10]);
					cities.add(city);
					passes++;
				}
			}      
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			fails++;
		}
		printLogMsg("== Finished building cities - " + passes + " passed / " + fails + " fails");
		
		if(!test && fails == 0) {
			int i = 0;
			for(City c : cities) {
				if(numberToLoad > i || numberToLoad == -1) {
					doObjectActionFile("C:\\Users\\Chris\\Documents\\Coding\\auto-input\\src\\com\\autoinput\\resources\\create_city_test_new.txt", c);
					i++;		
					printLogMsg("Finished running for " + c.getName() + " (" + c.getNation() + ")");
				}
			}
		}
	}

	@Override
	public void doObjectActionFile(String filename, Object obj) {
		City city = (City)obj;
		Path path = Paths.get(filename);
		try (Scanner scanner =  new Scanner(path, StandardCharsets.UTF_8.name())){
			while (scanner.hasNextLine()){
				String nextLine = scanner.nextLine();
				String[] lineSplit = nextLine.split("\\t");
				readObjectAction(lineSplit, city);
				robot.delay(100);
			}	
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void readObjectAction(String[] lineData, Object obj) {
		City c = (City)obj;
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
				robot.moveMouse(68, 512);
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
				robot.keyInput(c.getName());
				break;
			case 5:
				if(!c.getNation().isEmpty()) {
					robot.moveMouse(1565, 220);
					robot.clickMouse();
					robot.down();
					robot.pressEnter();
					robot.doSearchAndSelectBox(c.getNation());
				}
				break;
			case 6:
				if(!c.getLanguage().isEmpty()) {
					robot.moveMouse(1565, 250);
					robot.clickMouse();
					robot.down();
					robot.pressEnter();
					robot.doSearchAndSelectBox(c.getLanguage());
				}
				break;
			case 7:
				if(!c.getLocalRegion().isEmpty()) {
					robot.moveMouse(1565, 280);
					robot.clickMouse();
					robot.down();
					robot.pressEnter();
					robot.doSearchAndSelectBox(c.getLocalRegion());
				}
				break;
			case 8:
				robot.moveMouse(971, 310);
				robot.clickMouse();
				robot.selectAll();
				robot.pressDelete();
				robot.keyInput(String.valueOf(c.getAttraction()));
				break;
			case 9:
				robot.moveMouse(1568, 340);
				robot.clickMouse();
				for(int i = 0; i < c.getInhabitantsRange(); i++) {
					robot.down();
				}
				robot.pressEnter();
				break;
			case 10:
				robot.moveMouse(971, 370);
				robot.clickMouse();
				robot.selectAll();
				robot.pressDelete();
				robot.keyInput(String.valueOf(c.getCitizenDescription()));
				break;
			case 11:
				robot.moveMouse(971, 400);
				robot.clickMouse();
				robot.selectAll();
				robot.pressDelete();
				robot.keyInput(String.valueOf(c.getLatitude()));
				break;
			case 12:
				robot.moveMouse(971, 430);
				robot.clickMouse();
				robot.selectAll();
				robot.pressDelete();
				robot.keyInput(String.valueOf(c.getLongitude()));
				break;
			case 13:
				robot.moveMouse(971, 460);
				robot.clickMouse();
				robot.selectAll();
				robot.pressDelete();
				robot.keyInput(String.valueOf(c.getAltitude()));
				break;
			case 14:
				if(!c.getWeather().isEmpty()) {
					robot.moveMouse(1565, 489);
					robot.clickMouse();
					robot.down();
					robot.pressEnter();
					robot.doSearchAndSelectBox(c.getWeather());
				}
				break;
			}
		}
	}

	@Override
	public void buildObject(String input, boolean test, String nation) {
		String[] lineSplit = input.split(",");
		if(lineSplit[1].equals(nation) || nation.isEmpty()) {
			for(int i = 0; i < lineSplit.length; i++) {
				System.out.print(lineSplit[i] + ",");
			}
			System.out.println("#");
			City city = new City();
			city.setName(lineSplit[0]);
			city.setNation(lineSplit[1]);
			city.setLanguage(lineSplit[2]);
			city.setLocalRegion(lineSplit[3]);
			city.setAttraction(Long.valueOf(lineSplit[4]));
			city.setInhabitantsRange(Long.valueOf(lineSplit[5]));
			city.setCitizenDescription(lineSplit[6]);
			city.setLatitude(lineSplit[7]);
			city.setLongitude(lineSplit[8]);
			city.setAltitude(Long.valueOf(lineSplit[9]));
			city.setWeather(lineSplit[10]);
			if(!test) {
				doObject(city);
			}
			objects.add(city);
		}
	}

	@Override
	public void doObject(Object obj) {
		City city = (City)obj;

		doObjectActionFile("C:\\Users\\Chris\\Documents\\Coding\\auto-input\\src\\com\\autoinput\\resources\\create_city_test_new.txt", city);	
		printLogMsg("Finished running for " + city.getName() + " (" + city.getNation() + ")");
	}

	public ArrayList<City> getObjects() {
		return objects;
	}

	public void setObjects(ArrayList<City> objects) {
		this.objects = objects;
	}

	public AppService getAppService() {
		return appService;
	}

	public void setAppService(AppService appService) {
		this.appService = appService;
	}
     
    public void onCellEdit(CellEditEvent event) {
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();
         
        if(newValue != null && !newValue.equals(oldValue)) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cell Changed", "Old: " + oldValue + ", New:" + newValue);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }

}
