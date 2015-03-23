package com.autoinput.helpers;

import javax.faces.context.FacesContext;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.autoinput.spring.service.AppService;

public class AppHelper {
	
	@SuppressWarnings("unchecked")
	public static <T> T findBean(String beanName) {
	    FacesContext context = FacesContext.getCurrentInstance();
	    return (T) context.getApplication().evaluateExpressionGet(context, "#{" + beanName + "}", Object.class);
	}
	
	public static AppService getService() {
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"applicationContext.xml"});
		return (AppService)context.getBean("appService");
	}
}
