package com.jawsmith.common;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GetDateAndTime {

	public static String getDate(){
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yy");
		Date date = new Date();
		return dateFormat.format(date);
	}
	
	public static String getTime(){
		DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		Date date = new Date();
		return dateFormat.format(date);
	}
	
	public static void main( String[] args ){
		System.out.println(getDate());
		System.out.println(getTime());
	}
}
