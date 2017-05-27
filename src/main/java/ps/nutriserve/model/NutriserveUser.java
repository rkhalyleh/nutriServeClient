/**
 * 
 */
package ps.nutriserve.model;

/**
 * @author Rami Khalyleh
 * 
 */
public class NutriserveUser {
	
	  private String activityStyle;
	  private String birthDate;
	  private String email;
	  private String gender;
	  private int height;
	  private long id;
	  private String name;
	  private String userName;
	  private int weight;
	  
	  public NutriserveUser() {
	  }
	  
	public String getActivityStyle() {
		return activityStyle;
	}
	public void setActivityStyle(String activityStyle) {
		this.activityStyle = activityStyle;
	}
	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	  
	  
}
