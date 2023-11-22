/**
 * Name: Umairuddin Alvi
 * Student # 218137927
 */

public class Lab3 {

	public static String printStars(int n) { //TASK 1
		//declare variable for string
		String starString = "";
		
		for (int x = 1; x <= n; x++) { //Use this for loop to create n number of lines
			for (int j = 1; j < x; j++) { //Use this for loop to generate dashes
				starString += "-";
			}
			
			for (int i = 0; i <= (-1 * x + n); i++) {//Use this for loop to generate stars
				starString += '*';
			}
			
			if (x != n) { //Check if loop is still valid so that we don't add an extra line
				starString += "\n";
			}
								
		}
		return starString; //Return the string
	}
	
	public static String expand (int num, int d) { //TASK 2
		//Declare variable for expanded number
		String numExpand = "";
		
		//First, check for any negative number
		if (num < 0 || d < 0) {
			return "Invalid"; //Return invalid if negative
		}
		
		else { 
			String stringNum = Integer.toString(num); //We will convert the input number into a string to go through each digit in the number
											//Another method however would be to perform the %10 operation on the number then update the number using /10
			for (int x = 0; x < d; x++) { //Use a for loop to check the place of each digit, use charAt()
				if(x == d - 1) {
					numExpand += stringNum.charAt(x); //When loop reaches the last digit, just note down the digit instead of the "*1"
				}
				else {
					numExpand += stringNum.charAt(x) + "*" + (int)Math.pow(10, d-(x+1)); //Add to the expanded form, use math.pow to determine place value
				}
				
				if (x != d-1) { //Check if loop is still valid so we do not add an extra + sign at the end
					numExpand += " + ";
				}
			}
		}
		return numExpand; //Return the expanded form
	}
	
	public static String getSeqStat(int ft, int d, int n) {
	    StringBuilder result = new StringBuilder("{");

	    int sum = 0;
	    int product = 1;

	    // Loop through each term of the sequence
	    for (int i = 1; i <= n; i++) {
	        int ti = ft + (i - 1) * d; // Calculate the current term

	        sum += ti; // Add the current term to the sum
	        product *= ti; // Multiply the current term to the product

	        result.append("[<");

	        // Append terms of the sequence to the result
	        for (int j = 1; j <= i; j++) {
	            result.append(ft + (j - 1) * d);

	            if (j < i) {
	                result.append(", ");
	            }
	        }

	        // Append sum and product of the sequence to the result
	        result.append(">: ").append(sum).append(", ").append(product).append("]");

	        if (i < n) {
	            result.append("; ");
	        }
	    }
	    result.append("}");

	    return result.toString();
	}
	
	public static String seqInterleaving(int ft1, int d1, int n1, int ft2, int d2, int n2) {
	    StringBuilder result = new StringBuilder("<");

	    int i = 1;
	    int j = 1;

	    // Interleave terms from both sequences until either sequence is exhausted
	    while (i <= n1 || j <= n2) {
	        if (i <= n1) {
	            int term1 = ft1 + (i - 1) * d1;
	            result.append(term1);
	            i++;

	            if (i <= n1 || j <= n2) {
	                result.append(", ");
	            }
	        }

	        if (j <= n2) {
	            int term2 = ft2 + (j - 1) * d2;
	            result.append(term2);
	            j++;

	            if (j <= n2 && (i <= n1 || j <= n2)) {
	                result.append(", ");
	            } else if (j > n2 && i <= n1) {
	                result.append(", ");
	            }
	        }
	    }

	    result.append(">");
	    return result.toString();
	}

	
}
