/**
 * 
 */
package ps.nutriserve.services;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ps.nutriserve.exceptions.DAOException;
import ps.nutriserve.model.User;


/**
 * @author rkhalayl
 *
 */
@RestController
@RequestMapping("/login")
public class Login {
	
	final static Logger logger = Logger.getLogger(Login.class);

	
	@RequestMapping(value = "/auth" ,
			method = RequestMethod.POST,  
			consumes = "application/json",
            produces = "application/json")
	public ResponseEntity<User> addEmployee(@RequestBody  User user, 
			HttpServletRequest request) {
	
		if (user == null || user.getUsername() == null 
				|| user.getPassword() == null) {
			
			return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
		}
		if (user.getUsername().equals("soa") && 
				user.getPassword().equals("soa")) {
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			return new ResponseEntity<User>(user, HttpStatus.OK);
		}
		return new ResponseEntity<User>(user,HttpStatus.NOT_ACCEPTABLE);
	}
	
	@RequestMapping(value = "/authenticateUser/{username}" ,
			method = RequestMethod.GET,  
			consumes = "application/json",
            produces = "application/json")
	public ResponseEntity<User> authenticateUser(@PathVariable("username") String username, 
			HttpServletRequest request) throws DAOException {
		if (username == null) {
			return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
		}
		HttpSession session = request.getSession();

		// Check the user if exist in the session so will authenticated before
		if (session.getAttribute("user") != null) {
			User sUser = (User) session.getAttribute("user");
			if (sUser.getUsername().equals(username)) {
				return new ResponseEntity<User>(sUser, HttpStatus.OK);
			}
		}
		return new ResponseEntity<User>(HttpStatus.NOT_ACCEPTABLE);
	}
	
	@RequestMapping("/logout")
	public String logoutPage (Model model, HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("xxxxxx");
		HttpSession session = request.getSession();
		if (session.getAttribute("user") != null) {
			session.invalidate();
		}
		response.setHeader("Cache-Control","no-cache");
		response.setHeader("Cache-Control","no-store");
		response.setDateHeader("Expires", 0);
		response.setHeader("Pragma","no-cache");
//		String userName = (String) session.getAttribute("User");
//		System.out.println("-----------------------------------------");
//		if (null == userName) {
//		   RequestDispatcher rd = request.getRequestDispatcher("../login.html");
//		   rd.forward(request, response);
//		}
		//perform other required operation
				String URL = request.getContextPath() + "/login.html";
				response.setStatus(HttpStatus.OK.value());
				response.sendRedirect(URL);
	    return "redirect:/login.html";
	}
//	
//	public void executeSQL(String sql) {
//		logger.debug("Started create Users table -----sqllllllllllll--------exe---------------1---------");
//		try {
//			DBManager.initDatabase("invDB", "admin", "admin", false);
//			DBManager.executeUpdate(sql);
//			DBManager.logSql();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

}
