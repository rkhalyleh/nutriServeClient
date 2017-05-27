/**
 * 
 */
package ps.nutriserve.exceptions;

/**
 * @author Rami Khalyleh
 * 
 *         General exception handling class, one day will expand it to cover
 *         more specific error to be informative to the user and logging.
 */
public class DAOException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final int INVALID_USER = 4004;

	public static int ADD_FAILED = 400;
	public static int UPDATE_FAILED = 401;
	public static int DELETE_FAILED = 402;
	public static int ALREADY_ADDED = 403;
	public static int SQL_ERROR = 404;
	public static int CUSTOMER_NAME_CONFLICT = 409;
	public static int USERS_LIMITED = 410;
	public static int EXPIRED_USER = 411;
	public static int USER_EXIST = 412;

	private int statusCode;

	public DAOException(int statusCode) {
		this.statusCode = statusCode;
	}

	/**
	 * @return the statusCode
	 */
	public int getStatusCode() {
		return statusCode;
	}

	/**
	 * @param statusCode
	 *            the statusCode to set
	 */
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

}
