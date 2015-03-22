package com.autoinput.actions.actioners;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.faces.bean.ManagedProperty;

import com.autoinput.hibernate.objects.City;
import com.autoinput.spring.service.AppService;

public abstract class ObjectActioner {

	public abstract void doObjectActionFile(String filename, Object obj);
	public abstract void readObjectAction(String[] lineSplit, Object obj);
	public abstract void readObject(String filename, boolean test, int numberToLoad, String nation, boolean isSkeleton);
	public abstract void buildObject(String input, boolean test, String nation);
	public abstract void doObject(Object obj);
	
	public static void printLogMsg(String msg) {
		System.out.println("-- " + msg + " - " + getCurrentTimestamp());
	}
	
	
	public static String getCurrentTimestamp() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		return dateFormat.format(date); //2014/08/06 15:59:48
	}
}
