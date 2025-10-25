package com.ui.pojo;

public class Environment {
	
	private String url;
	private int max_Attempts;
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	public void setMaxAttempts(int max_Attempts)
	{
		this.max_Attempts = max_Attempts;
	}
	
	public int getMaxAttempts()
	{
		return max_Attempts;
	}

	

}
