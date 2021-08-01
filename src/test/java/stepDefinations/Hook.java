package stepDefinations;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hook {
	@Before("@DeletePlace")
	public void beforeScenario() throws IOException {
		stepDefination m = new stepDefination();
		if(m.place_id==null) {
			m.add_place_payload_with("Bapu","English","Vitthalwadi");
			m.user_calls_with_http_request("AddPlaceAPI","POST");
			m.verify_place_id_created_map_to_using("Bapu", "GetPlaceAPI");
		}
	}
}
