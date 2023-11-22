

public class TestAnalytics {
	// ALREADY IMPLEMENTED; DO NOT MODIFY
	private final static int NUMOFQUESTIONs = 50;
	private final static int MARKFORQUESTION = 2;
	private final static int NUMOFQUESTIONCHOICES = 4;
	private final static String TESTCORRECTANSWER = "D,C,A,D,A,B,C,D,B,C,A,B,D,C,A,A,"
			+ "A,C,A,B,B,D,B,D,A,B,B,A,C,B,C,A,C,B,B,C,C,C," + "A,B,A,B,B,C,A,B,A,A,D,C";

	
	// TODO: Your implementation starts here
	
	// TODO: Your implementation starts here
	/*  Your implementation starts here
	 * Recall that :
	 * 1. No System.out.println statements should appear here.
	 * 	  Instead, you need to return the result.
	 * 2. No Scanner operations should appear here (e.g., input.nextInt()).
	 *    Instead, refer to the input parameters of this method.   
	 */
	private String studentName;
    private String studentID;
    private String[] studentAnswer;
	
    public TestAnalytics(String stdtest) {
        String[] data = stdtest.split(",");
        this.studentName = data[0];
        this.studentID = data[1];
        this.studentAnswer = new String[data.length - 2];
        
        for (int i = 2; i < data.length; i++) {
            this.studentAnswer[i - 2] = data[i];
        }
    }

    public Object getStudentName() {
		return studentName;
    }

    public Object getStudentID() {
        return studentID;
    }

    public Object getStudentAnswer() {
    	StringBuilder result = new StringBuilder("");
        for (int i = 0; i < studentAnswer.length; i++) {
            result.append(studentAnswer[i]);
            if (i < studentAnswer.length - 1) {
                result.append(",");
            }
        }
        return result.toString();
    }

    public double calculateStudentGrade() {
        int totalMarks = 0;
        int length = Math.min(NUMOFQUESTIONs, studentAnswer.length);
        for (int i = 0; i < length; i++) {
            char studentChoice = studentAnswer[i].charAt(0);
            char correctChoice = TESTCORRECTANSWER.charAt(i * 2);

            if (Character.toUpperCase(studentChoice) == Character.toUpperCase(correctChoice)) {
                totalMarks += MARKFORQUESTION;
            }
        }

        return totalMarks;
    }

    public String getStudentAnswerFrequency() {
        int[] frequency = new int[NUMOFQUESTIONCHOICES];

        for (int i = 0; i < NUMOFQUESTIONs; i++) {
            char studentChoice = studentAnswer[i].charAt(0);
            frequency[Character.toUpperCase(studentChoice) - 'A']++;
        }

        return "The frequency of the student(" + getStudentName() + ") answer is A(" + frequency[0] + "), B(" +
        frequency[1] + "), C(" + frequency[2] + ") and D(" + frequency[3] + ").";
    }
    


    public String toString() {
        if (calculateStudentGrade() < 50) {
        	return "Student(" + getStudentName() + ") failed the test. " + getStudentName() + " answered (" + String.format("%.0f", calculateStudentGrade()/2) + ") correct questions and scored ( " + String.format("%.2f", calculateStudentGrade()) + ") out of 100.";
        }
        else {
        	return "Student(" + getStudentName() + ") passed the test. " + getStudentName() + " answered (" + String.format("%.0f", calculateStudentGrade()/2) + ") correct questions and scored ( " + String.format("%.2f", calculateStudentGrade()) + ") out of 100.";
        }
    }
	
			

}
