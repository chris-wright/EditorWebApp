package com.autoinput.objects;

import java.util.ArrayList;
import java.util.List;

public class Agreement extends EditorObject {
	
	private Long id;
	private List<String> nations = new ArrayList<String>();

	public List<String> getNations() {
		return nations;
	}
	
	public void setNations(List<String> nations) {
		this.nations = nations;
	}
	
	public void addNation(String nation) {
		getNations().add(nation);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
