/**
 * 
 */
package ps.nutriserve.service.orchestration;

import java.util.List;

import ps.nutriserve.model.Bmi;
import ps.nutriserve.model.Gym;
import ps.nutriserve.model.Health;
import ps.nutriserve.model.Recipe;

/**
 * @author rkhalayl
 *
 */
public interface HealthInfo {
	
	public Health getEmployeeHealthInfo(String id);
	
	public Bmi getBmi(int weight, float height);
	
	public Recipe getRecipe(int id);
	
	public List<Recipe> getAllRecipe();
	
	public List<Gym> getAllGyms();
	
}
