/**
 * 
 */
package ps.nutriserve.service.users;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import ps.nutriserve.model.NutriserveUser;

/**
 * @author Rami
 *
 */
public class UserServiceImpl implements UserService {

	final static Logger logger = Logger.getLogger(UserServiceImpl.class);
	public static String URL = "http://bzu-nutriserve.appspot.com/user";

	@Override
	public NutriserveUser addNutriserveUser(NutriserveUser nutriserveUser) {
		 RestTemplate restTemplate = new RestTemplate();
		 HttpEntity<NutriserveUser> request = new HttpEntity<>(nutriserveUser);
		 ResponseEntity<NutriserveUser> response = restTemplate.exchange(URL, HttpMethod.POST, request, NutriserveUser.class);
		   
		 NutriserveUser nutriserveUserRes = response.getBody();
		 logger.debug("nutriserveUserRes: "+nutriserveUserRes);
		 logger.debug("response.getStatusCode(): "+response.getStatusCode());
		 if (!(response.getStatusCode().value() == 200 || 
				 response.getStatusCode().value() == 202)){
			 return null;
		 }
		 logger.debug("nutriserveUserRes Info :" + nutriserveUserRes);
		
		return nutriserveUserRes;
	}

	@Override
	public NutriserveUser updateNutriserveUser(NutriserveUser NutriserveUser) {
		return NutriserveUser;
	}

	@Override
	public List<NutriserveUser> getAllNutriserveUsers() {
		RestTemplate restTemplate = new RestTemplate();
		
		ResponseEntity<List<NutriserveUser>> response =
		        restTemplate.exchange(URL, HttpMethod.GET, 
		        		null, new ParameterizedTypeReference<List<NutriserveUser>>() {
		            });
		logger.debug("getAllNutriserveUsers: "+response.hasBody());
		List<NutriserveUser> nutriserveUsers = response.getBody();
		logger.debug("getAllNutriserveUsers number of Users: "+nutriserveUsers.size());
		
		return nutriserveUsers;
	}

	@Override
	public NutriserveUser getNutriserveUserById(String id) {
		// TODO: to be implemented
		return null;
	}

	@Override
	public boolean isExist(String id) {
		// TODO: to be implemented
		return true;
	}

	@Override
	public boolean delete(NutriserveUser NutriserveUser) {
		// TODO: to be implemented
		return true;
	}
	
}
