package com.example.demo;

public class Quiz {
	
private int durationMinutes ; 
private String difficulty ; 
private boolean isOptional ; 
private int totalPassed ;   


	 public void setDuration (int mins) {
		 durationMinutes = mins ;  
	 }
	 public int getDuration () {
		return durationMinutes ;  
	 }
 
 
 
	 public void setDifficulty (String diff) {
		 difficulty = diff ;  
	 }
	 public String getDifficulty () {
		return difficulty ;  
	 }
 
 
 
	 public void setOptionality (boolean opt) {
		 isOptional = opt ;  
	 }
	 public boolean getOptionality () {
		return isOptional ;  
	 }
 
	 
	 public void setTotalPassed (int students) {
		 totalPassed = students ;  
	 }
	 public int getTotalPassed () {
		return totalPassed ;  
	 }
	 
	 public void displayInfo() {
		 System.out.println("Quiz Duration : " + durationMinutes  );
		 System.out.println("Quiz Difficulty : " + difficulty  );
		 System.out.println("Is The Quiz Optional : " + isOptional  );
		 System.out.println("Total Student Passed The Quiz : " + totalPassed  );
	 }
 
}
