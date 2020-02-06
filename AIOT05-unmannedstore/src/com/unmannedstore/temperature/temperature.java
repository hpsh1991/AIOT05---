package com.unmannedstore.temperature;

public class temperature {
	protected int id;
	protected double indoor_temp;
	protected double humidity;
	protected double drink01_temp;
	protected double drink02_temp;
	protected double drink03_temp;
	protected double drink04_temp;
	protected String MQ_2;
	protected String Record_time;
	
	public temperature() {
		super();
	}

	public temperature(double indoor_temp, double humidity, double drink01_temp, double drink02_temp,
			double drink03_temp, double drink04_temp, String mQ_2) {
		super();
		this.indoor_temp = indoor_temp;
		this.humidity = humidity;
		this.drink01_temp = drink01_temp;
		this.drink02_temp = drink02_temp;
		this.drink03_temp = drink03_temp;
		this.drink04_temp = drink04_temp;
		this.MQ_2 = mQ_2;
	}

	public temperature(int id, double indoor_temp, double humidity, double drink01_temp, double drink02_temp,
			double drink03_temp, double drink04_temp, String mQ_2, String record_time) {
		super();
		this.id = id;
		this.indoor_temp = indoor_temp;
		this.humidity = humidity;
		this.drink01_temp = drink01_temp;
		this.drink02_temp = drink02_temp;
		this.drink03_temp = drink03_temp;
		this.drink04_temp = drink04_temp;
		this.MQ_2 = mQ_2;
		this.Record_time = record_time;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getIndoor_temp() {
		return indoor_temp;
	}

	public void setIndoor_temp(double indoor_temp) {
		this.indoor_temp = indoor_temp;
	}

	public double getHumidity() {
		return humidity;
	}

	public void setHumidity(double humidity) {
		this.humidity = humidity;
	}

	public double getDrink01_temp() {
		return drink01_temp;
	}

	public void setDrink01_temp(double drink01_temp) {
		this.drink01_temp = drink01_temp;
	}

	public double getDrink02_temp() {
		return drink02_temp;
	}

	public void setDrink02_temp(double drink02_temp) {
		this.drink02_temp = drink02_temp;
	}

	public double getDrink03_temp() {
		return drink03_temp;
	}

	public void setDrink03_temp(double drink03_temp) {
		this.drink03_temp = drink03_temp;
	}

	public double getDrink04_temp() {
		return drink04_temp;
	}

	public void setDrink04_temp(double drink04_temp) {
		this.drink04_temp = drink04_temp;
	}

	public String getMQ_2() {
		return MQ_2;
	}

	public void setMQ_2(String mQ_2) {
		this.MQ_2 = mQ_2;
	}

	public String getRecord_time() {
		return Record_time;
	}

	public void setRecord_time(String record_time) {
		this.Record_time = record_time;
	}
	
	
	
	

}
