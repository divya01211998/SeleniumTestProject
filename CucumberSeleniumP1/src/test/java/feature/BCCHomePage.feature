
@tag
Feature: Launch BCC Website
  As a user
  I want to navigate to the BBC website
  I verify top navigation links

  
  #Scenario: 1.Launch and verify BCC Homepage
   #Given I navigate to the BCC website
   #When I see homepage is displayed correctly
   #Then I verify top navigation links are displayed
   
    
 
  #Scenario: 2.Navigate to News section and verify the url
  	#Given I navigate to the BCC website
  	#When I click on News section
  	#Then I verify the url
  	
  	
 @tag3
 #Scenario: 3.Perform search action for HMH and verify results
  #	Given I navigate to the BCC website
  	#When I click on search button
  	#Then I verify the search results for "Houghton Mifflin Harcourt"
  	
  @tag4
  Scenario: 4.Verify Homepage and Nav links
  	Given I navigate to the BCC website
 		When I see homepage is displayed correctly
  	And I click on News section
  	Then I verify the url
 
  	
  #	Scenario: 5.Verify error message for invalid user registration
  #	Given I navigate to the BCC website
  #	When I click on Sign In button with invalid email
  #	Then I verify error message displayed
  #	

 
