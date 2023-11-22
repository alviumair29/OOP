/**
 * Name: Umairuddin Alvi
 * Student #: 218137927
 */

/**
 * Objective: practice  If statements, nested If statements, Demorgan's Law, Data Comparison 
 *
 */
public class Lab2 {
	/**
	 * Takes an integer as the gender of a person, integer age, double weigh, 
	 * double height, and a boolean athlete 
	 * and calculates the needed daily calories for that person as a double.
	 */
	public static double getCalories(int gender,int age,double weight, double height, boolean athlete) 
	 {
		double totalCalories = 0;
		//If any of the parameters are invalid, return -1.0
		if (((gender != 1) && (gender != 2)) || (age <= 0) || (weight <= 0) || (height <= 0) || ((athlete != true) && (athlete != false))) {				
			return -1.0;				
		}
		
		else{//First check if person is male or female
			if (gender == 1) {  //If male
				if (athlete == true) { //If male is an athlete
					totalCalories = (10 * weight + 6.25 * height - 5 * age + 5) * 1.20; //Increase amount by 20% for male athlete		
				}
				else { //If male is not an athlete
					totalCalories = 10 * weight + 6.25 * height - 5 * age + 5; //Apply standard calculation for a non-athlete male
				}
				
			}
		
			else { //If female
				if (athlete == true) { //If female is an athlete
					totalCalories = (10 * weight + 6.25 * height - 5 * age - 161) * 1.15; //Increase amount by 15% for female athlete		
				}
				else { //If female is not an athlete
					totalCalories = 10 * weight + 6.25 * height - 5 * age - 161; //Apply standard calculation for a non-athlete female
				}
				
			}
			return totalCalories; //Return final result
		}
	 }

		
	/**
	 * Takes a salary as a double and calculates the tax owed for this salary
	 * returns a double value. 
	 * if the salary is an invalid amount it returns -1.
	 */
	public static double computeTax(double income) {
		double totalTax = 0.0;
	    if (income < 0) { //If there is a negative salary amount entered, return -1
	    	return -1.0;
	    }
	    else {
	    	//Check which row the income falls under 
	    	//Based on that, perform the appropriate calculations to compute the total tax
	    	if (0 < income && income <= 7150) { 
	    		totalTax = income * 0.10;
	    	}
	    	else if (7150 < income && income <= 29050) {
	    		totalTax = 715 + ((income - 7150) * 0.15);
	    	}
	    	else if (29050 < income && income <= 70350) {
	    		totalTax = 4000 + ((income - 29050) * 0.25);
	    	}
	    	else if (income > 70350) {
	    		totalTax = 14325 + ((income - 70350) * 0.28);
	    	}
	    	return totalTax; //Return the total tax owed
	    }
	}
	
	/**
	 * Takes a date as three integers:day, month, and year.
	 * The method returns a true if he date is valid and false otherwise.
	 * The method checks if the month is valid, and the year is after the year 1000.
	 * It checks if the day is valid according to the month. If the month is february, 
	 * it checks if the year is a leap year
	 */
	public static boolean validDate(int day, int month, int year) {
		//Declare boolean variable to validate the day, month, and year entered
		boolean monthValid = false, yearValid = false, dayValid = false;
		
		if (year < 1000) {
			yearValid = false;
		}
		else {
			yearValid = true;
			if (month == 1 || month == 3 || month == 5 || //If the month entered has 31 days
				month == 7 || month == 8 || month == 10 || 
				month == 12) {
				monthValid = true;
				
				if (1 < day && day <= 31) { //If day entered is within range
					dayValid = true;
				}
				else { //If day is invalid
					dayValid = false;
				}
				
			}
			else if (month == 4 || month == 6 || //If month has 30 days 
					 month == 9 || month == 11) {
					monthValid = true;
				
				if (1 < day && day <= 30) { //If day is within range
					dayValid = true;
				}
				else { //If day is invalid
					dayValid = false;
				}
				
			}
			else if (month == 2) { //If month is a February
				//Determine if it's a leap year
				monthValid = true;
				if ((year % 400 == 0) || (year % 4 == 0 && year % 100 != 0)) {
					if (1 < day && day <= 29) {
						dayValid = true;
					}
					else {
						dayValid = false;
					}
				}
				else { //It is not a leap year
					if (1 < day && day <= 28) {
						dayValid = true;
					}
					else {
						dayValid = false;
					}
				}				
			}
			else {
				monthValid = false;
			}
		}//Else
		
		//Determine whether date entered is true or false
		if ((dayValid == true) && (monthValid == true) && (yearValid == true)) {
			return true; //Return true if day, month, and year are all valid entries
		}
		else {
			return false; //Return false if one or all of the entries are invalid
		}
	}
}//Main