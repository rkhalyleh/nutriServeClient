/**
 * 
 */
package ps.nutriserve.services;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import ps.nutriserve.model.Health;
import ps.nutriserve.model.NutriserveUser;
import ps.nutriserve.service.users.UserService;
import ps.nutriserve.service.users.UserServiceImpl;

/**
 * @author Rami
 *
 */
@RestController
@RequestMapping("/user")
public class UserController {
	
	final static Logger logger = Logger.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(method = RequestMethod.POST,  
			consumes = "application/json",
            produces = "application/json")
	public ResponseEntity<NutriserveUser> addNutriserveUser(@RequestBody  NutriserveUser nutriserveUser, 
			HttpServletRequest request) {
		
		NutriserveUser nutriserveUserRes = userService.addNutriserveUser(nutriserveUser);
		return new ResponseEntity<NutriserveUser>(nutriserveUserRes, HttpStatus.OK);
	}


	@ApiOperation(value = "Get the users",
			    notes = "This API calls an external web service to get all users information",
			    response = Health.class,
			    responseContainer = "Entity")
	@RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<NutriserveUser>> getAllNutriserveUser() {
		List<NutriserveUser> users = userService.getAllNutriserveUsers();
		return new ResponseEntity<List<NutriserveUser>>(users, HttpStatus.OK);		
    }


}
