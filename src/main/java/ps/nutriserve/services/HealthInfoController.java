/**
 * 
 */
package ps.nutriserve.services;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import ps.nutriserve.model.Bmi;
import ps.nutriserve.model.Gym;
import ps.nutriserve.model.Health;
import ps.nutriserve.model.Recipe;
import ps.nutriserve.model.User;
import ps.nutriserve.service.orchestration.HealthInfo;

/**
 * @author Rami
 *
 */
@RestController
@RequestMapping("/healthInfo")
public class HealthInfoController {
	
	final static Logger logger = Logger.getLogger(HealthInfoController.class);
	
	@Autowired
	private HealthInfo healthInfo;
	
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	@ApiOperation(value = "Get the user health information",
		    notes = "This API calls an external web service to get the user basic info, health status, "
		    		+ "recipes information based on the user id",
		    response = Health.class,
		    responseContainer = "Entity")
	@RequestMapping(value = "/userHealthInfo/{id}",
		method = RequestMethod.GET)
	public ResponseEntity<User> getUserHealthInfo(@PathVariable("id") String userId) {
		
		User user = healthInfo.getUserHealthInfo(userId);
		
		return new ResponseEntity<User>(user, HttpStatus.OK);		
	}

	
	/**
	 * 
	 * @param weight
	 * @param length
	 * @return
	 */
	@ApiOperation(value = "Get the Bmi",
			    notes = "This API calls an external web service to get BMI information based on the weight and the length",
			    response = Health.class,
			    responseContainer = "Entity")
	@RequestMapping(value = "/bmi/{weight}/{length}",
		method = RequestMethod.GET)
    public ResponseEntity<Bmi> getBmi(@PathVariable("weight") int weight,
    		@PathVariable("length") int length) {
		
		Bmi bmi = healthInfo.getBmi(weight, length);
		
		return new ResponseEntity<Bmi>(bmi, HttpStatus.OK);		
    }

	/**
	 * 
	 * @param id
	 * @return
	 */
	@ApiOperation(value = "Get the recipe based on id",
		    notes = "This API calls an external web service to get recipe information based on the user id",
		    response = Health.class,
		    responseContainer = "Entity")
	@RequestMapping(value = "/recipe/{id}",
		method = RequestMethod.GET)
	public ResponseEntity<Recipe> getRecipe(@PathVariable("id") int id) {
		
		Recipe recipe = healthInfo.getRecipe(id);

		return new ResponseEntity<Recipe>(recipe, HttpStatus.OK);		
	}

	/**
	 * 
	 * @return
	 */
	@ApiOperation(value = "Get the recipe",
		    notes = "This API calls an external web service to get all recipe information",
		    response = Health.class,
		    responseContainer = "Entity")
	@RequestMapping(value = "/recipe",
		method = RequestMethod.GET)
	public ResponseEntity<List<Recipe>> getAllRecipe() {
		
		List<Recipe> recipeList = healthInfo.getAllRecipe();

		return new ResponseEntity<List<Recipe>>(recipeList, HttpStatus.OK);		
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	@ApiOperation(value = "Get the health status",
		    notes = "This API calls an external web service to get health status information based on the user id",
		    response = Health.class,
		    responseContainer = "Entity")
	@RequestMapping(value = "/healthStatus/{id}",
		method = RequestMethod.GET)
	public ResponseEntity<Health> getHealthStatus(@PathVariable("id") String id) {
		
		Health health = healthInfo.getHealthInfo(id);
		
		return new ResponseEntity<Health>(health, HttpStatus.OK);		
	}

	/**
	 * 
	 * @return
	 */
	@ApiOperation(value = "Get the Gyms",
		    notes = "This API calls an external web service to get all gyms information",
		    response = Health.class,
		    responseContainer = "Entity")
	@RequestMapping(value = "/gym",
		method = RequestMethod.GET)
	public ResponseEntity<List<Gym>> getAllGyms() {
		
		List<Gym> gymList = healthInfo.getAllGyms();

		return new ResponseEntity<List<Gym>>(gymList, HttpStatus.OK);		
	}


}
