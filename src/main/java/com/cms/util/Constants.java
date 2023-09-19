/**
@Developed By Anil Kumar
*/

package com.cms.util;

import java.util.ArrayList;

public class Constants {
	
	public final static String success = "success";
	public final static String already = "already";
	public final static String fail = "fail";
	public final static String register_success_msg= "success register";
	public final static String no_exist = "no exist";
	
	public final static String Utahtruckdrivingschool = "Utahtruckdrivingschool";
	public final static String truckcity = "truckcity";
	public final static String towing = "towing";
	public final static String ors = "ors";
	public final static String nflfreight = "nflfreight";
	public final static String itruckdispatch = "itruckdispatch";
	public final static String cdl = "cdl";
	public final static String ecdl = "ecdl";
	public final static String paultruckline = "paultruckline";
	public final static String fresnotruckline = "fresnotruckline";
	
	public static final String COOKIE_NAME="Authorization";
	public static final String HEADER_AUTHORIZATION="Authorization";
	public static final String HEADER_PREFIX="Bearer ";
	public final static int activeUser=1;
	public static final int limitResult=9; 
	
	public static final String ShareMessageSubject="Share Ad Location | www.nearbyroadservice.com";
	public static final String ShareMessage="Hi,\n\nName: <name>\nAddress: <address>\nContact: <msisdn>\nWebsite: <website>\n\nThanks,\nNearbyroadservices Team";
	public static final String ShareMobileMessage="Name: <name>, Address: <address>, Contact: <msisdn>, Website: <website>";
	
	
	public enum TRANSACTION{
		INTIATE(0),
	    SUCCESS(1),
	    PENDING(2),
	    FAILED(3),
		CANCELED(4),
		CAPTURED_Pending(5),
	    ERROR(6),
	    Deleted(7),
	    EXPIRED(8),
	    DEFAULT_TRANSACTION(10),
	    TERMINATED(9);
		private final int value;
	    	TRANSACTION(final int newValue) {
	            value = newValue;
	        }
	    public int getValue() { return value; }
	}
}	
