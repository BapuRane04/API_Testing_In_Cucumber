Feature: Validating Place API's

@AddPlace
Scenario Outline: Verify if place is being successfully added using AddPlaceAPI
     Given Add Place Payload with "<name>" "<language>" "<address>"
     When user calls "AddPlaceAPI" with "POST" http request
     Then the api call got success with status code 200
     And "status" in response body is "OK"
     And "scope" in response body is "APP"
     And Verify placeId created map to "<name>" using "GetPlaceAPI"
Examples: 
       |name  | language  | address            |
       |Kavya | English   | World across Center|  
 #      |Kishor| Spanish   | Sea across Center  |   
 
@UpdatePlace     
Scenario: Verify if update place functionality is working
	Given UpdatePlace Payload
	When user calls "UpdatePlaceAPI" with "PUT" http request
    Then the api call got success with status code 200
    
@DeletePlace   
Scenario: Verify if delete placce functionality is woking 
     Given DeletePlace Payload
     When user calls "DeletePlaceAPI" with "POST" http request
     Then the api call got success with status code 200
     And "status" in response body is "OK"     