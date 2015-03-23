package com.autoinput.beans;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.streaming.SXSSFRow.CellIterator;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.autoinput.actions.actioners.AgreementActioner;
import com.autoinput.actions.actioners.CityActioner;
import com.autoinput.actions.actioners.ClubActioner;
import com.autoinput.actions.actioners.CompetitionActioner;
import com.autoinput.actions.actioners.ContinentActioner;
import com.autoinput.actions.actioners.NationActioner;
import com.autoinput.actions.actioners.PlayerActioner;
import com.autoinput.actions.actioners.StadiumActioner;
import com.autoinput.helpers.AppHelper;


@ManagedBean(name="readData")
@SessionScoped
public class ReadData {
	
	private String filepath;
	private boolean test = true;
	
	private AgreementActioner agreementActioner;
	private CityActioner cityActioner;
	private ClubActioner clubActioner;
	private CompetitionActioner competitionActioner;
	private ContinentActioner continentActioner;
	private NationActioner nationActioner;
	private PlayerActioner playerActioner;
	private StadiumActioner stadiumActioner;
	
	public ReadData(String filepath) {
		this.filepath = filepath;
		this.agreementActioner = AppHelper.findBean("agreementActioner");
		this.cityActioner = AppHelper.findBean("cityActioner");
		this.clubActioner = AppHelper.findBean("clubActioner");
		this.competitionActioner = AppHelper.findBean("competitionActioner");
		this.continentActioner = AppHelper.findBean("continentActioner");
		this.nationActioner = AppHelper.findBean("nationActioner");
		this.playerActioner = AppHelper.findBean("playerActioner");
		this.stadiumActioner = AppHelper.findBean("stadiumActioner");
	}
	
	public ReadData() {
		this.filepath = "C:\\Users\\chris.wright\\Dropbox\\World v15.2 - Copy.xlsm";
		this.agreementActioner = AppHelper.findBean("agreementActioner");
		this.cityActioner = AppHelper.findBean("cityActioner");
		this.clubActioner = AppHelper.findBean("clubActioner");
		this.competitionActioner = AppHelper.findBean("competitionActioner");
		this.continentActioner = AppHelper.findBean("continentActioner");
		this.nationActioner = AppHelper.findBean("nationActioner");
		this.playerActioner = AppHelper.findBean("playerActioner");
		this.stadiumActioner = AppHelper.findBean("stadiumActioner");
	}
	
	public void doStuff() {
		File myFile = new File(filepath);
        FileInputStream fis;
		try {
			fis = new FileInputStream(myFile);
			OPCPackage pkg = OPCPackage.open(filepath);
			XSSFWorkbook myWorkBook = new XSSFWorkbook (pkg);
			
			XSSFWorkbook wb_template;
	        wb_template = new XSSFWorkbook(
	            pkg
	        );
	        SXSSFWorkbook wb = new SXSSFWorkbook(wb_template);

			readContinentSheet(wb_template);
	        System.out.println("readContinentSheet(wb_template);");
			readNationSheet(wb_template);
	        System.out.println("readNationSheet(wb_template);");
			readCitySheet(wb_template);
	        System.out.println("readCitySheet(wb_template);");
			readAgreementSheet(wb_template);
			System.out.println("readAgreementSheet(wb_template);");
			System.out.println("readCompetitionSheet(wb_template);");
			readCompetitionSheet(wb_template);
	        System.out.println("readClubSheet(wb_template);");
			readClubSheet(wb_template);
	        System.out.println("readStadiumSheet(wb_template);");
			readStadiumSheet(wb_template);
			
			System.out.println("Continents: " + continentActioner.getObjects().size());
			System.out.println("Nations: " + nationActioner.getObjects().size());
			System.out.println("Agreements: " + agreementActioner.getObjects().size());
			System.out.println("Competitions: " + competitionActioner.getObjects().size());
			System.out.println("Cities: " + cityActioner.getObjects().size());
			System.out.println("Clubs: " + clubActioner.getObjects().size());
			System.out.println("Stadiums: " + stadiumActioner.getObjects().size());
			
			//wb_template.close();
			FacesContext.getCurrentInstance().getExternalContext().redirect("welcome.xhtml");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		}
	}
	
	public XSSFSheet getAgreementSheet(XSSFWorkbook workbook) {
		for(int i = 0; i < workbook.getNumberOfSheets(); i++) {
			if(workbook.getSheetAt(i).getSheetName().equals("Agreements")) {
				return workbook.getSheetAt(i);
			}
		}
		return null;
	}
	
	public XSSFSheet getContinentSheet(XSSFWorkbook workbook) {
		for(int i = 0; i < workbook.getNumberOfSheets(); i++) {
			if(workbook.getSheetAt(i).getSheetName().equals("Continents")) {
				return workbook.getSheetAt(i);
			}
		}
		return null;
	}
	
	public XSSFSheet getNationSheet(XSSFWorkbook workbook) {
		for(int i = 0; i < workbook.getNumberOfSheets(); i++) {
			if(workbook.getSheetAt(i).getSheetName().equals("Nations")) {
				return workbook.getSheetAt(i);
			}
		}
		return null;
	}
	
	public XSSFSheet getCitySheet(XSSFWorkbook workbook) {
		for(int i = 0; i < workbook.getNumberOfSheets(); i++) {
			if(workbook.getSheetAt(i).getSheetName().equals("Cities")) {
				return workbook.getSheetAt(i);
			}
		}
		return null;
	}
	
	public XSSFSheet getStadiumSheet(XSSFWorkbook workbook) {
		for(int i = 0; i < workbook.getNumberOfSheets(); i++) {
			if(workbook.getSheetAt(i).getSheetName().equals("Stadiums Output")) {
				return workbook.getSheetAt(i);
			}
		}
		return null;
	}
	
	public XSSFSheet getClubsSheet(XSSFWorkbook workbook) {
		for(int i = 0; i < workbook.getNumberOfSheets(); i++) {
			if(workbook.getSheetAt(i).getSheetName().equals("Clubs")) {
				return workbook.getSheetAt(i);
			}
		}
		return null;
	}
	
	public XSSFSheet getCompetitionSheet(XSSFWorkbook workbook) {
		for(int i = 0; i < workbook.getNumberOfSheets(); i++) {
			if(workbook.getSheetAt(i).getSheetName().equals("Competitions")) {
				return workbook.getSheetAt(i);
			}
		}
		return null;
	}
	
	public int getColumnIdForRead(XSSFSheet sheet) {
		Row row = sheet.getRow(0);
		int id = 0;
		System.out.println(row.getLastCellNum());
		for(int i = 0; i < row.getLastCellNum(); i++) {
			
		}
        Iterator<Cell> cellIterator = row.cellIterator();
        while (cellIterator.hasNext()) {
            Cell cell = cellIterator.next();
            switch (cell.getCellType()) {
            case Cell.CELL_TYPE_STRING:
                if(cell.getStringCellValue().equals("READ")) {
                	return id;
                }
                break;
            case Cell.CELL_TYPE_NUMERIC:
                break;
            default :
            	break;
            }
            id++;
        }
        return -1;
	}
	
	public void readCompetitionSheet(XSSFWorkbook workbook) {
		XSSFSheet sheet = getCompetitionSheet(workbook);
		int columnIdToRead = getColumnIdForRead(sheet);
		int rowId = 0;
		if(sheet == null) {
			System.out.println("No competition sheet found");
		} else {
			Iterator<Row> rowIterator = sheet.iterator();
	        while (rowIterator.hasNext()) {
	            Row row = rowIterator.next();
	        	if(rowId > 0) {
		            for(int i = 0; i < row.getLastCellNum(); i++) {
		            	if(i == columnIdToRead) {
		            		Cell cell = row.getCell(row.getLastCellNum()-1);
			                switch (cell.getCellType()) {
			                case Cell.CELL_TYPE_FORMULA:
			                	switch(cell.getCachedFormulaResultType()) {
			                    case Cell.CELL_TYPE_STRING:
			                    	competitionActioner.buildObject(cell.getRichStringCellValue().getString(), test, "");
			                        break;
			                	}
			                    break;
			                default :
			                	break;
			            	}
		            	}
		            }
	        	}
	        	rowId++;
	        }
		}
	}
	
	public void readClubSheet(XSSFWorkbook workbook) {
		XSSFSheet sheet = getClubsSheet(workbook);
		int columnIdToRead = getColumnIdForRead(sheet);
		int rowId = 0;
		if(sheet == null) {
			System.out.println("No club sheet found");
		} else {
			Iterator<Row> rowIterator = sheet.iterator();
	        while (rowIterator.hasNext()) {
	            Row row = rowIterator.next();
	        	if(rowId > 0) {
		            for(int i = 0; i < row.getLastCellNum(); i++) {
		            	if(i == columnIdToRead) {
		            		Cell cell = row.getCell(row.getLastCellNum()-1);
			                switch (cell.getCellType()) {
			                case Cell.CELL_TYPE_FORMULA:
			                	switch(cell.getCachedFormulaResultType()) {
			                    case Cell.CELL_TYPE_STRING:
			                    	clubActioner.buildObject(cell.getRichStringCellValue().getString(), test, "");
			                        break;
			                	}
			                    break;
			                default :
			                	break;
			            	}
		            	}
		            }
	        	}
	        	rowId++;
	        }
		}
	}
	
	public void readCitySheet(XSSFWorkbook workbook) {
		XSSFSheet sheet = getCitySheet(workbook);
		int columnIdToRead = getColumnIdForRead(sheet);
		int rowId = 0;
		if(sheet == null) {
			System.out.println("No city sheet found");
		} else {
			Iterator<Row> rowIterator = sheet.iterator();
	        while (rowIterator.hasNext()) {
	            Row row = rowIterator.next();
	        	if(rowId > 0) {
		            for(int i = 0; i < row.getLastCellNum(); i++) {
		            	if(i == columnIdToRead) {
		            		Cell cell = row.getCell(row.getLastCellNum()-1);
			                switch (cell.getCellType()) {
			                case Cell.CELL_TYPE_FORMULA:
			                	switch(cell.getCachedFormulaResultType()) {
			                    case Cell.CELL_TYPE_STRING:
			                    	cityActioner.buildObject(cell.getRichStringCellValue().getString(), test, "");
			                        break;
			                	}
			                    break;
			                default :
			                	break;
			            	}
		            	}
		            }
	        	}
	        	rowId++;
	        }
		}
	}
	
	public void readStadiumSheet(XSSFWorkbook workbook) {
		XSSFSheet sheet = getStadiumSheet(workbook);
		int columnIdToRead = getColumnIdForRead(sheet);
		int rowId = 0;
		if(sheet == null) {
			System.out.println("No stadium sheet found");
		} else {
			Iterator<Row> rowIterator = sheet.iterator();
	        while (rowIterator.hasNext()) {
	            Row row = rowIterator.next();
	        	if(rowId > 0) {
		            for(int i = 0; i < row.getLastCellNum(); i++) {
		            	if(i == columnIdToRead) {
		            		Cell cell = row.getCell(row.getLastCellNum()-1);
			                switch (cell.getCellType()) {
			                case Cell.CELL_TYPE_FORMULA:
			                	switch(cell.getCachedFormulaResultType()) {
			                    case Cell.CELL_TYPE_STRING:
			                    	stadiumActioner.buildObject(cell.getRichStringCellValue().getString(), test, "");
			                        break;
			                	}
			                    break;
			                default :
			                	break;
			            	}
		            	}
		            }
	        	}
	        	rowId++;
	        }
		}
	}
	
	public void readNationSheet(XSSFWorkbook workbook) {
		XSSFSheet sheet = getNationSheet(workbook);
		int columnIdToRead = getColumnIdForRead(sheet);
		int rowId = 0;
		if(sheet == null) {
			System.out.println("No nation sheet found");
		} else {
			Iterator<Row> rowIterator = sheet.iterator();
	        while (rowIterator.hasNext()) {
	            Row row = rowIterator.next();
	        	if(rowId > 0) {
		            //for(int i = 0; i < row.getLastCellNum(); i++) {
		            //	if(i == columnIdToRead) {
		            		int x = 0;
		            		Cell cell = row.getCell(row.getLastCellNum()-1);
			                switch (cell.getCellType()) {
			                case Cell.CELL_TYPE_FORMULA:
			                	switch(cell.getCachedFormulaResultType()) {
			                    case Cell.CELL_TYPE_STRING:
			                    	nationActioner.buildObject(cell.getRichStringCellValue().getString(), test, "");
			                        break;
			                	}
			                    break;
			                default :
			                	break;
			            	}
		            //	}
		            //}
	        	}
	        	rowId++;
	        }
		}
	}
	
	public void readAgreementSheet(XSSFWorkbook workbook) {
		XSSFSheet sheet = getAgreementSheet(workbook);
		int columnIdToRead = getColumnIdForRead(sheet);
		int rowId = 0;
		if(sheet == null) {
			System.out.println("No agreement sheet found");
		} else {
			Iterator<Row> rowIterator = sheet.iterator();
	        while (rowIterator.hasNext()) {
	            Row row = rowIterator.next();
	        	if(rowId > 0) {
		            for(int i = 0; i < row.getLastCellNum(); i++) {
		            	if(i == columnIdToRead) {
		            		Cell cell = row.getCell(columnIdToRead);
			                switch (cell.getCellType()) {
			                case Cell.CELL_TYPE_FORMULA:
			                	switch(cell.getCachedFormulaResultType()) {
			                    case Cell.CELL_TYPE_STRING:
			                    	agreementActioner.buildObject(cell.getRichStringCellValue().getString(), test, "");
			                        break;
			                	}
			                    break;
			                default :
			                	break;
			            	}
		            	}
		            }
	        	}
	        	rowId++;
	        }
		}
	}
	
	public void readContinentSheet(XSSFWorkbook workbook) {
		XSSFSheet sheet = getContinentSheet(workbook);
		int columnIdToRead = getColumnIdForRead(sheet);
		int rowId = 0;
		if(sheet == null) {
			System.out.println("No continent sheet found");
		} else {
			Iterator<Row> rowIterator = sheet.iterator();
	        while (rowIterator.hasNext()) {
	            Row row = rowIterator.next();
	        	if(rowId > 0) {
		            for(int i = 0; i < row.getLastCellNum(); i++) {
		            	if(i == columnIdToRead) {
		            		Cell cell = row.getCell(columnIdToRead+1);
		            		Iterator<Cell> cellIterator = row.cellIterator();
			                switch (cell.getCellType()) {
			                case Cell.CELL_TYPE_FORMULA:
			                	switch(cell.getCachedFormulaResultType()) {
			                    case Cell.CELL_TYPE_STRING:
			                    	continentActioner.buildObject(cell.getRichStringCellValue().getString(), test, "");
			                        break;
			                	}
			                    break;
			                default :
			                	break;
			            	}
		            	}
		            }
	        	}
	        	rowId++;
	        }
		}
	}

	public AgreementActioner getAgreementActioner() {
		return agreementActioner;
	}

	public void setAgreementActioner(AgreementActioner agreementActioner) {
		this.agreementActioner = agreementActioner;
	}

	public CityActioner getCityActioner() {
		return cityActioner;
	}

	public void setCityActioner(CityActioner cityActioner) {
		this.cityActioner = cityActioner;
	}

	public ClubActioner getClubActioner() {
		return clubActioner;
	}

	public void setClubActioner(ClubActioner clubActioner) {
		this.clubActioner = clubActioner;
	}

	public CompetitionActioner getCompetitionActioner() {
		return competitionActioner;
	}

	public void setCompetitionActioner(CompetitionActioner competitionActioner) {
		this.competitionActioner = competitionActioner;
	}

	public ContinentActioner getContinentActioner() {
		return continentActioner;
	}

	public void setContinentActioner(ContinentActioner continentActioner) {
		this.continentActioner = continentActioner;
	}

	public NationActioner getNationActioner() {
		return nationActioner;
	}

	public void setNationActioner(NationActioner nationActioner) {
		this.nationActioner = nationActioner;
	}

	public PlayerActioner getPlayerActioner() {
		return playerActioner;
	}

	public void setPlayerActioner(PlayerActioner playerActioner) {
		this.playerActioner = playerActioner;
	}

	public StadiumActioner getStadiumActioner() {
		return stadiumActioner;
	}

	public void setStadiumActioner(StadiumActioner stadiumActioner) {
		this.stadiumActioner = stadiumActioner;
	}
}
