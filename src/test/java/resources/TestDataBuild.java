package resources;

import java.util.ArrayList;
import java.util.List;

import pojo.AddPlaceRequestBody;
import pojo.DeletePlaceRequestBody;
import pojo.LocationRequestBody;
import pojo.UpdatePlaceRequestBody;

public class TestDataBuild {
	
	public AddPlaceRequestBody addPlacePayloads(String name,String language,String address) {
		AddPlaceRequestBody ap=new AddPlaceRequestBody();
		ap.setAccuracy(50);
		ap.setName(name);
		ap.setPhone_number("(+91) 983 893 3937");
		ap.setAddress(address);
		ap.setWebsite("http://google.com");
		ap.setLanguage(language);
		List<String> myType=new ArrayList<String>();
		myType.add("shoe park");
		myType.add("shop");
		ap.setTypes(myType);
		LocationRequestBody l=new LocationRequestBody();
		l.setLat(-38.383494);
		l.setLng(33.427362);
		ap.setLocation(l);
		return ap;
	}
	
	public String deletePlacePayload(String placeId) {
		return "{\r\n    \"place_id\" : \""+placeId+"\"\r\n}";
	
	}
	public UpdatePlaceRequestBody updatePlacePayload(String placeId) {
		UpdatePlaceRequestBody up=new UpdatePlaceRequestBody();
		up.setPlace_id(placeId);
		up.setAddress("70 winter walk, USA");
		up.setKey("qaclick123");
		return up;
	}
	
	
}
