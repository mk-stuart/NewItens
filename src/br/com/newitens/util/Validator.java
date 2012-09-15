/**
 * 
 */
package br.com.newitens.util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;


/**
 * @author Felipe
 *
 */
public class Validator {

	
	public static boolean isValidDate(String dayMonthYear){
		//This method will works fine if, and only if the paremeter come in this format: "dd/mm/yyyy"
		int minimumAge = 15;
		
		boolean valid = false;
		
		Calendar gc = GregorianCalendar.getInstance();
		ArrayList<Integer> months31 = new ArrayList<Integer>(); //Months with 31 days
		ArrayList<Integer> months30 = new ArrayList<Integer>(); //Months with 30 days
		
		months31.add(1); //January
		months31.add(3); //March
		months31.add(5); //May
		months31.add(7); //July
		months31.add(8); //August
		months31.add(10);//October
		months31.add(12);//December
		
		months30.add(4); //April
		months30.add(6); //June
		months30.add(9); //September
		months30.add(11);//November
		
		if(dayMonthYear != null && dayMonthYear.contains("/")){
			
			String[] date = dayMonthYear.split("/");
			
			int day = Integer.parseInt(date[0]);
			int month = Integer.parseInt(date[1]);
			int year = Integer.parseInt(date[2]);
			
			boolean validDay = day > 0 && day < 32;
			boolean validMonth = month > 0 && month < 13;
			boolean validYear = year > 1900 && year < gc.get(Calendar.YEAR) - minimumAge;
			
			if(validDay && validMonth && validYear){
			
				if(months31.contains(month)){
					valid = day < 32;
				}else if(months30.contains(month)){
					valid = day < 31;
				}else{
					//Validating february
					valid = day < 30;
				}
			}
		}
		return valid;
	}
	
	
	public static boolean isValidCpf(String cpf){
		//This method will works fine if, and only if the paremeter come in this format: "999.999.999-99"
          boolean valid = false;

          if(cpf != null && cpf.length() > 11){
	          cpf = cpf.substring(0, 3) + cpf.substring(4, 7) + cpf.substring(8, 11) + cpf.substring(12);
	
	          cpf = cpf.trim();
	          
	           if (cpf.length() == 11)
	           {              
	               int firstDigit = Integer.parseInt(cpf.substring(0, 1));
	               for (int x = 1; x < 11; x++){
	                   if (firstDigit != Integer.parseInt(cpf.substring(x, x+1))){
	                	   valid = true;
	                       break;
	                   }else{
	                	   valid = false;
	                   }
	               }
	               if (valid){
	                   for (int j = 2; j > 0; j--){
	                       int digit = 0;
	                       int sum = 0;
	                       int multiplied = 0;
	
	                       for (int i = 0; i < 11 - j; i++){
	                    	   multiplied = Integer.parseInt(cpf.substring(i, i+1)) * ((11 - j + 1) - i);
	
	                           sum += multiplied;
	
	                       }
	                       digit = sum % 11;
	                       if (digit > 2){
	                    	   digit = 11 - digit;
	                       }else{
	                    	   digit = 0;
	                       }
	                       if (digit != Integer.parseInt(cpf.substring(cpf.length() - j, cpf.length() - j + 1))){
	                    	   valid = false;
	                           break;
	                       }
	                   }
	               }
	           }
          }
          return valid;
      }
}
