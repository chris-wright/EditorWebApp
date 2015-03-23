package com.autoinput.beans;

import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name="redirect")
@SessionScoped
public class RedirectBean {
	
	public void redirectToInfoScreen() {
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("welcome.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void redirectToClubs() {
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("ClubView.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void redirectToCompetitions() {
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("CompetitionView.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void redirectToStadiums() {
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("StadiumView.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void redirectToCities() {
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("CityView.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void redirectToContinents() {
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("ContinentView.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void redirectToAgreements() {
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("AgreementView.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void redirectToNations() {
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("NationView.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
