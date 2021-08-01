package resources;
// enum is a special class in java which has collection of constant and method
public enum ApiResources {
 
	AddPlaceAPI("/maps/api/place/add/json"),
	GetPlaceAPI("/maps/api/place/get/json"),
	DeletePlaceAPI("/maps/api/place/delete/json"),
	UpdatePlaceAPI("/maps/api/place/update/json");
	private String resources;
	
	ApiResources(String resource){
		this.resources=resource;
	}
	public String getResources() {
		return resources;
	}
}
