

/**
 * Objective: practice arithmetic operations, If statements, nested If statements 
 */
public class Lab1 {
	/**
	 * Takes an integer and calculates the next integer in the Collatz mathematica
	 * sequence
	 */
	public static int collatz(int n) {
		
		if (n < 0) { //If integer is not positive, return -1
			return -1;
		}
		
		else if (n%2 == 0) { //If integer is even
			return (n/2);
		}
		
		else { //If integer is odd
			return (3 * n) + 1;
		}
	}
	
	/**
	 * Takes an GPA and SAT score of a student and returns a string if "Accepted", "Rejected",
	 * or "ScoresTooLow"
	 */
	public static String yorkAdmit (double gpa, int sat) {
		
			if (gpa < 1.8 && sat < 900) { //If both scores are low
				return "ScoresTooLow";
			}
			else if (gpa > 1.8 && sat < 900) { //If gpa is high but sat is low
				return "Reject";
			}
			else if (gpa < 1.8 && sat > 900) { //If sat is high but gpa is low
				return "Reject";
			}
			else { //If both scores are high
				return "Accept";
			}
			
	}
		
	/**
	 * Takes coordinates of a points (x,y) and determines to which quadrant it belongs
	 */
	public static int quadrant (double x, double y) {
		int quad = 0;
		if (x > 0 && y > 0){ //If co-ordinates are in Quad 1
			quad = 1;
		}
		
		else if (x < 0 && y > 0){ //If co-ordinates are in Quad 2
			quad = 2;
		}
		
		else if (x < 0 && y < 0) { //If co-ordinatesa are in Quad 3
			quad = 3;
		}
		
		else if (x > 0 && y < 0) { //If co-ordinates are in Quad 4
			quad = 4;
		}
		
		else if (x == 0 || y == 0) {
			quad = 0; //If a point falls on the x or y axis the quadrant is 0
		}
		
		return quad;
	}
	
	/**
	 * Takes inputs of two clock times in hours and minutes and determines if there is enough
	 * time between them for lunch. This time has to be at least 45 minutes.
	 */
	public static boolean enoughLunchTime (int hour1, int min1, int hour2, int min2) {
			
			if (hour1 == hour2) { //If hours are the same, look at minutes
				if ((min2 - min1) >= 45) {
					return true; //Return true if there is a difference of 45 mins 
				}
				else { //If not, return false
					return false;
				}
			}
			
			else if (hour1 < hour2) { //If hour2 is more than hour1
				if ((hour2 - hour1) == 1) { //If hours have a difference of 1, consider the following possibilities:
					if ((60 + min2) - (min1) >= 45) {//Check if difference between mins of hour2 and mins of hour 1 is at least 45 mins
													//e.g time1 = 9:45, time2 = 10:05 (The +60 will make it easier to calculate difference between minutes)
						return true; //Return true
					}
					else {// If less than 45, return false
						return false;
					}
				}
				else { //If difference between hour2 and hour1 is more than 1, then that automatically implies there are more than 45 mins
					return true;
				}
			}
			
			else { //If hour1 is less than hour2, return false
				return false;
			}
	}
	
	/**
	 * Takes inputs as a credit card old balance and current month additional charges and 
	 * calculates the minimum payment owed 
	 */
	public static double computePayment (double oldBalance, double charges) {
		double newBalance, minPay = 0;
		
		if (oldBalance == 0) {
			newBalance = oldBalance + charges;
			if (newBalance < 50) { //If new balance is less than 50, minimum payment is new balance
				minPay = newBalance;
			}
			else if ((newBalance >= 50) && (newBalance <= 300)) { //If the new balance is between 50 and 300, the minimum payment is $50.0
				minPay = 50.0;
			}
			else if ((newBalance > 300)) { //If new balance is over 300, minimum payment is 20% of new balance
				minPay = 0.2 * newBalance;
			}
		}
		
		else if (oldBalance > 0) {
			newBalance = (oldBalance + charges) * 1.02; //Apply 2% interest if previous balance is > 0
			if (newBalance < 50) {
				minPay = newBalance;
			}
			else if ((newBalance >= 50) && (newBalance <= 300)) {
				minPay = 50.0;
			}
			else if ((newBalance > 300)) {
				minPay = 0.2 * newBalance;
			}
		}
		
		return minPay;
	}
}
