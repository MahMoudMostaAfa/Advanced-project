package Course;

public class Quiz {
	
private int durationMinutes ; 
private String difficulty ; 
private boolean isOptional ; 
private int totalPassed ;   
private int allowedAttempts ; 

	 public void setDuration  (int mins)  throws IllegalArgumentException {
		 if (mins <= 0) {
			 throw new IllegalArgumentException ("Duration must be a positive number");
		 }
		 durationMinutes = mins ;  
	 }
	 public int getDuration () {
		return durationMinutes ;  
	 }
 
 
 
	 public void setDifficulty  (String diff)  throws IllegalArgumentException{
		 if (diff == null) {
			 throw new IllegalArgumentException ("Difficulty cannot be null");
		 }
		 for (int i=0 ; i<diff.length(); i++ ) {
			 char check ; 
			 check = diff.charAt(i) ; 
		 if (!Character.isLetter(check)) {
			 throw new IllegalArgumentException ("Difficulty must be letters only");
		 }
		
		 }
		 difficulty = diff ;  
	 }
	 public String getDifficulty () {
		return difficulty ;  
	 }
 
 
 
	 public void setOptionality (boolean opt)  throws IllegalArgumentException  {
		 if (opt || !opt) {
			 isOptional = opt ;			 
		 }
		 
		 else {
			 throw new IllegalArgumentException ("Optionality must be a boolean");
		 }
		 
		   
	 }
	 public boolean getOptionality () {
		return isOptional ;  
	 }
 
	 
	 public void setTotalPassed (int students)  throws IllegalArgumentException {
		 if (students < 0 ) {
			 throw new IllegalArgumentException ("Number of students cannot be negative");
		 }
		 totalPassed = students ;  
	 }
	 public int getTotalPassed () {
		return totalPassed ;  
	 }
	 
	 
	 public void setAttempts (int atm) throws IllegalArgumentException{
		 if (atm < 0 ) {
			 throw new IllegalArgumentException ("Number of attempts cannot be negative");
		 }
		 allowedAttempts = atm ;  
	 }
	 public int getAttempts () {
		return allowedAttempts ;  
	 }
	 
	 
	 public void displayInfo() {
		 System.out.println("Course.Quiz Duration : " + durationMinutes  );
		 System.out.println("Course.Quiz Difficulty : " + difficulty  );
		 System.out.println("Total Attempts Allowed : " + allowedAttempts  );
		 System.out.println("Is The Course.Quiz Optional : " + isOptional  );
		 System.out.println("Total User.Student Passed The Course.Quiz : " + totalPassed  );
	 }
}
	 
	 
 