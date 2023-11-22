
public class Lab4 {
	public static int longestSeq (int[] array) {
		int counter = 1;
		int longest = 1;
		if (array.length == 0) { //Check if array is empty, if so return 0
			return 0;
		}
		for (int x = 1; x < array.length; x++) {
			if (array[x] != array[x -1]) {
				if (array[x] == array[x-1] + 1 || array[x] == array[x-1] - 1) {
					counter++; //If a sequence is present, increase counter
				}
				else {
					longest = Math.max(longest, counter);
					counter = 1; 
				}
			}
		}

		return longest;
	}

	public static String countArray (int[] array) {
		if (array.length == 0) {
	        return "";
	    }

	    StringBuilder result = new StringBuilder();
	    boolean firstLine = true;

	    for (int i = 0; i < array.length; i++) {
	        if (array[i] >= 2 && array[i] < 100 && array[i] % 2 == 0) {
	            int count = 1; // Initialize count to 1 for the current number
	            for (int j = i + 1; j < array.length; j++) {
	                if (array[i] == array[j]) {
	                    count++;
	                }
	            }

	            // Append the result to the StringBuilder only if it's not already included
	            if (result.indexOf(array[i] + ":") == -1) {
	                if (!firstLine) {
	                    result.append("\n");
	                }
	                result.append(array[i]).append(": ").append(count);
	                firstLine = false;
	            }
	        }
	    }

	    return result.toString();

	}
	
	public static boolean validString (String str1, String str2) {
		int i = 0; // Initialize index for string 1
	    int j = 0; // Initialize index for string 2

	    while (i < str1.length() && j < str2.length()) {
	        if (str1.charAt(i) == str2.charAt(j)) {
	            j++; 
	        }
	        i++; 
	    }
	    return j == str2.length();
	}
	
	public static String arrayResult(int[][] array) {
		int resultEven = 0; int resultOdd = 1;
		
		if (array.length == 0) { 
			return ""; //print nothing if array is empty
		}
		else if(array.length == 1 && array[0].length == 1) { //If the array is 1x1, the sum will be calculated as usual however, 
															//the product will be 0 since the row and column won't add up to an odd number
			for (int r = 0; r < array.length; r++) {
				for (int c = 0; c < array[r].length; c++) {
					if ((r + c) % 2 == 0) {
						resultEven += array[r][c]; //Calculate sum
					}	
				}
			}
			resultOdd = 0; //Set product to 0 
		}
		else {
			for (int r = 0; r < array.length; r++) { //For loop to go through each row in the array
				for (int c = 0; c < array[r].length; c++) { //For loop to go through each element in the row
					if (((r) + (c)) % 2 == 0) { //Check if the rows and column of the current element adds up to an even number
						resultEven += array[r][c]; //If true, add the number in that position to the total sum
					}
					else { //If it's odd, determine product of numbers
						resultOdd *= array[r][c];
					}
				}
			}
		}						
		return "Sum:" + resultEven + ", Product:" + resultOdd;
	}
	
	public static boolean magicSquare(int[][] array) {
		int n = array.length;
	    int totalSum = n * (n * n + 1) / 2; // Total Sum for a magic square
	    int sumDiagonal1 = 0, sumDiagonal2 = 0;

	    // Calculate sum of diagonals
	    for (int i = 0; i < n; i++) {
	        sumDiagonal1 += array[i][i];
	        sumDiagonal2 += array[i][n - 1 - i];
	    }

	    // Check if the diagonals are equal
	    if (sumDiagonal1 != sumDiagonal2) {
	        return false;
	    }

	    // Check rows and columns
	    for (int i = 0; i < n; i++) {
	        int rowSum = 0, colSum = 0;
	        for (int j = 0; j < n; j++) {
	            rowSum += array[i][j];
	            colSum += array[j][i];
	        }

	        // Check if the row and column sums are equal to the total sum
	        if (rowSum != totalSum || colSum != totalSum) {
	            return false;
	        }
	    }

	    return true;
	}
	
}
