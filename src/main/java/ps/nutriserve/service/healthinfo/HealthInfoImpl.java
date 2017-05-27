/**
 * 
 */
package ps.nutriserve.service.healthinfo;

import org.apache.log4j.Logger;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import ps.nutriserve.model.Bmi;

/**
 * @author Rami
 *
 */
public class HealthInfoImpl implements HealthInfoService {

	final static Logger logger = Logger.getLogger(HealthInfoImpl.class);
	
	/*
	 *  External service URI
	 */
	public static String URL = "http://bzu-nutriserve.appspot.com/bmi";
	
	/**
	 * Get the BMI
	 * @param weight
	 * @param length
	 * @return
	 */
	@Override
	public Bmi getBmi(int weight, int length) {
		RestTemplate restTemplate = new RestTemplate();
		
		// Call the external service
		ResponseEntity<Bmi> rateResponse =
		        restTemplate.exchange(URL, HttpMethod.GET, 
		        		null, new ParameterizedTypeReference<Bmi>() {
		            });
		Bmi bmi = rateResponse.getBody();
		
		return bmi;
	}

	
}
