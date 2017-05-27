/**
 * 
 */
package ps.nutriserve.model;

import java.io.Serializable;


/**
 * @author Rami
 *
 */
public class Health implements Serializable{
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private String userId;
	
	private String bmi;

	private String healthStatus;

	public Health() {
		// TODO Auto-generated constructor stub
	}
	
	public String getBmi() {
		return bmi;
	}

	public void setBmi(String bmi) {
		this.bmi = bmi;
	}

	public String getHealthStatus() {
		return healthStatus;
	}

	public void setHealthStatus(String healthStatus) {
		this.healthStatus = healthStatus;
	}

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
}
