/**
 * 
 */
package ps.nutriserve.service.users;

import java.util.List;

import ps.nutriserve.model.NutriserveUser;

/**
 * @author Rami
 *
 */
public interface UserService {

	/**
	 * Add new NutriserveUser
	 * @param NutriserveUser
	 * @return
	 */
	public NutriserveUser addNutriserveUser(NutriserveUser NutriserveUser);
	
	/**
	 * Update NutriserveUser
	 * @param NutriserveUser
	 * @return
	 */
	public NutriserveUser updateNutriserveUser(NutriserveUser NutriserveUser);
	
	/**
	 * Get all NutriserveUsers
	 * @return
	 */
    public List<NutriserveUser> getAllNutriserveUsers();
 
	/**
	 * Get NutriserveUser by Id
	 * @return
	 */
    public NutriserveUser getNutriserveUserById(String id);
 
	/**
	 * @return boolean
	 */
	public boolean isExist(String name);

	/**
	 * Delete NutriserveUser entity
	 * @param NutriserveUser
	 * @return boolean
	 */
	public boolean delete(NutriserveUser NutriserveUser);

}
