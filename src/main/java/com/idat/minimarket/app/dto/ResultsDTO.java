package com.idat.minimarket.app.dto;

import java.io.Serializable;

public class ResultsDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String[] results;


	public ResultsDTO() {
		// TODO Auto-generated constructor stub
	}
	

	public ResultsDTO(String[] results) {
		super();
		this.results = results;
	}


	public String[] getResults() {
		return results;
	}

	public void setResults(String[] results) {
		this.results = results;
	}

}
