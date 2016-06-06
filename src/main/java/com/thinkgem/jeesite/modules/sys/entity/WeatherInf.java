/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.sys.entity;


/**
 * 天气Entity
 * @author songJian
 * @version 2013-05-15
 */
public class WeatherInf   {

	 	private OneDayWeatherInf[] weatherInfs;  
	    private String dressAdvise;//穿衣建议  
	    private String washCarAdvise;//洗车建议  
	    private String coldAdvise;//感冒建议  
	    private String sportsAdvise;//运动建议  
	    private String ultravioletRaysAdvise;//紫外线建议  
	      
	      
	    public WeatherInf(){  
	        dressAdvise = "";  
	        washCarAdvise = "";  
	        coldAdvise = "";  
	        sportsAdvise = "";  
	        ultravioletRaysAdvise = "";  
	    }  
	      
	    public OneDayWeatherInf[] getWeatherInfs() {  
	        return weatherInfs;  
	    }  
	  
	  
	    public void setWeatherInfs(OneDayWeatherInf[] weatherInfs) {  
	        this.weatherInfs = weatherInfs;  
	    }  
	  
	  
	    public String getDressAdvise() {  
	        return dressAdvise;  
	    }  
	  
	  
	    public void setDressAdvise(String dressAdvise) {  
	        this.dressAdvise = dressAdvise;  
	    }  
	  
	  
	    public String getWashCarAdvise() {  
	        return washCarAdvise;  
	    }  
	  
	  
	    public void setWashCarAdvise(String washCarAdvise) {  
	        this.washCarAdvise = washCarAdvise;  
	    }  
	  
	  
	    public String getColdAdvise() {  
	        return coldAdvise;  
	    }  
	  
	  
	    public void setColdAdvise(String coldAdvise) {  
	        this.coldAdvise = coldAdvise;  
	    }  
	  
	  
	    public String getSportsAdvise() {  
	        return sportsAdvise;  
	    }  
	  
	  
	    public void setSportsAdvise(String sportsAdvise) {  
	        this.sportsAdvise = sportsAdvise;  
	    }  
	  
	  
	    public String getUltravioletRaysAdvise() {  
	        return ultravioletRaysAdvise;  
	    }  
	  
	  
	    public void setUltravioletRaysAdvise(String ultravioletRaysAdvise) {  
	        this.ultravioletRaysAdvise = ultravioletRaysAdvise;  
	    }  
}