/**
 * 
 */
package ps.nutriserve.service.healthinfo;

import ps.nutriserve.model.Bmi;

/**
 * @author Rami
 *
 */
public interface HealthInfoService {

	/**
	 * Get Bmi
	 * @param Bmi
	 * @return
	 */
	public Bmi getBmi(int weight, int length);
	

}
