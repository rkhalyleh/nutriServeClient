/**
 * 
 */
package ps.nutriserve.model;

/**
 * @author rkhalayl
 *
 */
public class Gym {
	
	private int id;
	private String name;
	private String address;
	private String location;
	private int rating;
	private String nextGymApi;
	private String previousGymApi;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getNextGymApi() {
		return nextGymApi;
	}
	public void setNextGymApi(String nextGymApi) {
		this.nextGymApi = nextGymApi;
	}
	public String getPreviousGymApi() {
		return previousGymApi;
	}
	public void setPreviousGymApi(String previousGymApi) {
		this.previousGymApi = previousGymApi;
	}

}
