package stepDefinations;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.runner.RunWith;
import static org.junit.Assert.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.AddPlaceRequestBody;
import pojo.LocationRequestBody;
import resources.ApiResources;
import resources.TestDataBuild;
import resources.Utilis;

import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
public class stepDefination extends Utilis{
	RequestSpecification res;
	ResponseSpecification resSpec;
	Response response;
	static String place_id;
	int cnt=0;
	TestDataBuild data=new TestDataBuild();
	
	@Given("Add Place Payload with {string} {string} {string}")
	public void add_place_payload_with(String name, String language, String address) throws IOException{
	    // Write code here that turns the phrase above into concrete actions
		res=given().spec(requestSpecification()).body(data.addPlacePayloads(name,language,address));
	}
	
	@When("user calls {string} with {string} http request")
	public void user_calls_with_http_request(String resources, String method) {
	    // Write code here that turns the phrase above into concrete actions
		ApiResources resourceAPI=ApiResources.valueOf(resources);
		System.out.println(resourceAPI.getResources());
		//Response Specification
		 resSpec=new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		//Response Specification
		 if(method.equalsIgnoreCase("POST")) {
			 response=res.when().post(resourceAPI.getResources());
		 }
		 else if(method.equalsIgnoreCase("GET")) {
			 response=res.when().get(resourceAPI.getResources());
		 }
		else if(method.equalsIgnoreCase("PUT") & cnt ==1) {
			response=res.when().put(resourceAPI.getResources());
		}
			   
	} 
	
	@Then("the api call got success with status code {int}")
	public void the_api_call_got_success_with_status_code(Integer statusCode) {
	    // Write code here that turns the phrase above into concrete actions
	    assertEquals(response.getStatusCode(),200);
	}
	
	@Then("{string} in response body is {string}")
	public void in_response_body_is(String keyValue, String expectedValue) {
	    // Write code here that turns the phrase above into concrete actions
	    assertEquals(getJsonPath(response, keyValue), expectedValue);
	}
	
	@Then("Verify placeId created map to {string} using {string}")
	public void verify_place_id_created_map_to_using(String expectedName, String resource) throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		place_id=getJsonPath(response, "place_id");
		res=given().spec(requestSpecification()).queryParam("place_id", place_id);
		user_calls_with_http_request(resource, "GET");
		String actualName=getJsonPath(response, "name");
		assertEquals(expectedName, actualName);
	}
	
	@Given("UpdatePlace Payload")
	public void update_place_payload() throws IOException {
	    // Write code here that turns the phrase above into concrete actions
	    res=given().spec(requestSpecification()).body(data.updatePlacePayload(place_id));
	    user_calls_with_http_request("UpdatePlaceAPI", "PUT");
	    cnt++;
	}
	
	@Given("DeletePlace Payload")
	public void delete_place_payload() throws IOException {
	    // Write code here that turns the phrase above into concrete actions
	  res = given().spec(requestSpecification()).body(data.deletePlacePayload(place_id));
	}
}
