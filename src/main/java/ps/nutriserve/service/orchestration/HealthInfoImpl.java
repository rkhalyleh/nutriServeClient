/**
 * 
 */
package ps.nutriserve.service.orchestration;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import ps.nutriserve.model.Bmi;
import ps.nutriserve.model.Gym;
import ps.nutriserve.model.Health;
import ps.nutriserve.model.Recipe;
import ps.nutriserve.model.User;

/**
 * @author rkhalayl
 *
 */
public class HealthInfoImpl implements HealthInfo{

	final static Logger logger = Logger.getLogger(HealthInfoImpl.class);

	/**
	 * URIs for the external services to call
	 */
	public static String BASE_URL = "http://bzu-nutriserve.appspot.com";
	public static String HEALTH_STATUS_URL = "/healthstatus?userid={id}";
	public static String BMI_URL = "/bmi?weight={weight}&length={height}";
	public static String RECIPE_URL = "/recipe";
	public static String GYM_URL = "/gym";
	public static String USER_URL = "/user";

	/**
	 * Get user basic health info for the given employee
	 * @param <T>
	 * 
	 * @param userId
	 * @return
	 */
	public User getUserHealthInfo(String userId){
		RestTemplate restTemplate = new RestTemplate();
		
		/*
		 * This API collect data from more than one web services, so, it applies the services composition
		 */
		
		// Get user Recipe
		ResponseEntity<Recipe> rateResponse =
		        restTemplate.exchange(BASE_URL + RECIPE_URL + "/" + userId, HttpMethod.GET, 
		        		null, new ParameterizedTypeReference<Recipe>() {
		            });
		Recipe recipe = rateResponse.getBody();
		logger.debug("RECIPE Info :" + recipe);
		
		// Get user info
		ResponseEntity<User> userInfoResponse =
		        restTemplate.exchange(BASE_URL + USER_URL + "/" + userId, HttpMethod.GET, 
		        		null, new ParameterizedTypeReference<User>() {
		            });
		User user = userInfoResponse.getBody();
		logger.debug("User Info :" + user);
		
		user.setRecipe(recipe);
		
		
		// Get User health status info
		Health healthInfo = restTemplate.getForObject(BASE_URL + HEALTH_STATUS_URL, Health.class, userId);
		user.setHealth(healthInfo);
		logger.debug("User Info :" + healthInfo);
		
		return user;
	}
	/**
	 * Call an external service to get some health information about the employee
	 */
	@Override
	public Health getHealthInfo(String id) {
		 RestTemplate restTemplate = new RestTemplate();
		 
		 Health healthInfo = restTemplate.getForObject(BASE_URL + HEALTH_STATUS_URL, Health.class, id);
		 logger.debug("Employee Info :" + healthInfo);
		return healthInfo;
	}

	/**
	 * Call an external service to get the BMI value based on the weight and height
	 * @param weight
	 * @param height
	 */
	@Override
	public Bmi getBmi(int weight, float height) {
		 RestTemplate restTemplate = new RestTemplate();
		 
		 Bmi bmi = restTemplate.getForObject(BASE_URL + BMI_URL, Bmi.class, weight, height);
		 logger.debug("BMI Info :" + bmi);
		return bmi;
	}
	
	/**
	 * Call and external service to get Free Personal Recipes supported for NutreServe users
	 * @param id
	 */
	@Override
	public Recipe getRecipe(int id) {
		RestTemplate restTemplate = new RestTemplate();
		
		ResponseEntity<Recipe> rateResponse =
		        restTemplate.exchange(BASE_URL + RECIPE_URL + id, HttpMethod.GET, 
		        		null, new ParameterizedTypeReference<Recipe>() {
		            });
		Recipe recipe = rateResponse.getBody();
		logger.debug("RECIPE Info :" + recipe);
		return recipe;
	}
	
	/**
	 * Call and external service to get Free Personal Recipes supported for NutreServe users
	 * @param id
	 */
	@Override
	public List<Recipe> getAllRecipe() {
		RestTemplate restTemplate = new RestTemplate();
		
		ResponseEntity<List<Recipe>> rateResponse =
		        restTemplate.exchange(BASE_URL + RECIPE_URL, HttpMethod.GET, 
		        		null, new ParameterizedTypeReference<List<Recipe>>() {
		            });
		List<Recipe> recipeList = rateResponse.getBody();
		logger.debug("RECIPE Info :" + recipeList);
		return recipeList;
	}

	/**
	 * Get all gyms
	 */
	@Override
	public List<Gym> getAllGyms() {
		RestTemplate restTemplate = new RestTemplate();
		
		ResponseEntity<List<Gym>> rateResponse =
		        restTemplate.exchange(BASE_URL + GYM_URL, HttpMethod.GET, 
		        		null, new ParameterizedTypeReference<List<Gym>>() {
		            });
		List<Gym> gymList = rateResponse.getBody();
		logger.debug("Gym Info :" + gymList);
		return gymList;
	}
}
