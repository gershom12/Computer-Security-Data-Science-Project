
package EntityManagers;
import java.util.List;

/**
 *
 * @author Gershom
 */
public interface GenericModelDAO<T> {
    public void add(T entityClass);
    public void update(T entityClass);
    public void delete(T entityClass);
        
    
}