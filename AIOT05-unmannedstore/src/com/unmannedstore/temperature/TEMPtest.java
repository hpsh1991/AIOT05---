package com.unmannedstore.temperature;

import java.sql.SQLException;
import java.text.DecimalFormat;

public class TEMPtest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int count=0;
		while(count<20) {
			try {
				Thread.sleep(1*1000);
				count++;
				System.out.println("[TEMP("+count+")]:");
				double indoor_temp=createTEMP(24.0,0.1);
				double humidity=createTEMP(40.0,5.0);
				double drink01_temp=createTEMP(6.0,0.1);
				double drink02_temp=createTEMP(6.0,0.1);
				double drink03_temp=createTEMP(6.0,0.1);
				double drink04_temp=createTEMP(6.0,0.1);
				String mQ_2="¥¿±`";
				//System.out.println(indoor_temp+","+ humidity+","+drink01_temp+","+drink02_temp+","+drink03_temp+","+drink04_temp+","+mQ_2);		
				temperatureDAO temperatureDAO=new temperatureDAO();
				temperature temperature=new temperature(indoor_temp, humidity, drink01_temp, drink02_temp, drink03_temp, drink04_temp, mQ_2);
				try {
					temperatureDAO.insertTemp(temperature);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
	
	static Double createTEMP(Double TEMP,Double tt) {
		double t=Math.random()*tt;
		int s=(int) (Math.random()*2);
		if(s==1) {
			TEMP+=t;
		}else {
			TEMP-=t;
		}
		DecimalFormat df = new DecimalFormat("##.00");
		TEMP = Double.parseDouble(df.format(TEMP));
		return TEMP;
	}

}
