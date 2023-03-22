package com.ospedale.GestionaleOspedale.utils;

import java.security.SecureRandom;

public class GeneraStringaUnivoca {
	
	private static String alfaLower = "abcdefghijklmnopqrstuvwxyz";
	private static String alfaUpper = alfaLower.toUpperCase();
	private static String digits = "0123456789";
	
	public static String generaStringaUnivoca(int passLength) {
        String random = alfaLower + alfaUpper + digits;	

        SecureRandom sr = new SecureRandom();
        StringBuilder sb = new StringBuilder(passLength);
        
        for (int i = 0; i < passLength; i++) {
            
        	char randomChar = random.charAt(sr.nextInt(random.length()));
            sb.append(randomChar);
        
        }
         
        return sb.toString();
	}
	
	
}
